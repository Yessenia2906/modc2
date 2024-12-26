package pe.com.bn.modc.dao.pool;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.exceptions.ExternalException;
 import pe.com.bn.modc.model.SftpConnection;

public class SftpConnectionPool {
    private static SftpConnectionPool instance;
    private BlockingQueue<SftpConnection> pool;
    private String host;
    private int port;
    private String username;
    private String password;
	private LoggerEECC log = LoggerEECC.getInstance(SftpConnectionPool.class.getName());

    private SftpConnectionPool(int poolSize, String host, int port, String username, String password) throws ExternalException  {
        this.pool = new LinkedBlockingQueue<>(poolSize);
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;

        for (int i = 0; i < poolSize; i++) {
            pool.add(createNewConnection(i));
        }

        // Iniciar un hilo para gestionar conexiones ociosas
        startIdleConnectionValidator();
    }

    public static synchronized SftpConnectionPool getInstance() {
        if (instance == null) {
            throw new IllegalStateException("SftpConnectionPool is not initialized.");
        }
        return instance;
    }

    public static synchronized void initialize(int poolSize, String host, int port, String username, String password) throws ExternalException  {
        if (instance == null) {
            instance = new SftpConnectionPool(poolSize, host, port, username, password);
        }
    }

    private SftpConnection createNewConnection(int id) throws ExternalException  {
        return new SftpConnection(id, host, port, username, password);
    }

    public SftpConnection getConnection() throws InterruptedException, ExternalException {
        SftpConnection connection = pool.take();
        if (!connection.isValid()) {
            // Si la conexión no es válida, crear una nueva
            try {
				connection = createNewConnection(connection.getId());
			} catch (Exception e) {
				log.error(e, Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
				throw new ExternalException(Constante.CT_ERR_FTP, e);
			}
        }
        log.debug("Conexión " + connection.getId() + " obtenida del pool.","1");
        return connection;
    }

    public void releaseConnection(SftpConnection connection) {
        pool.offer(connection);
        log.debug("Conexión " + connection.getId() + " devuelta al pool.","1");
    }

    public void shutdown() {
        for (SftpConnection connection : pool) {
            connection.disconnect();
        }
        log.debug("Todas las conexiones en el pool han sido cerradas.","1");
    }

    private void startIdleConnectionValidator() {
        Thread validatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(30);
                        Iterator<SftpConnection> iterator = pool.iterator();
                        while (iterator.hasNext()) {
                            SftpConnection connection = iterator.next();
                            if (!connection.isValid()) {
                                iterator.remove();
                                connection.disconnect();
                                pool.add(createNewConnection(connection.getId()));
                            }
                        }
                    } catch (  Exception  e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        validatorThread.setDaemon(true);
        validatorThread.start();
    }
}
