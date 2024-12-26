package pe.com.bn.modc.model;

import java.util.Properties;

import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.exceptions.ExternalException;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SftpConnection {
    private Session session;
    private ChannelSftp channel;
    private int id;
	private static LoggerEECC log = LoggerEECC
			.getInstance(SftpConnection.class.getName());
    public SftpConnection(int id, String host, int port, String username, String password) throws ExternalException  {
        this.id = id;
        JSch jsch = new JSch();
        try {
			session = jsch.getSession(username, host, port);
		} catch (JSchException e) {
			// 
			e.printStackTrace();
		}
    	session.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		config.put("PreferredAuthentications", "keyboard-interactive");
		session.setConfig(config);
        try {
			session.connect();
		} catch (JSchException e) {
		    // log.error(e,Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
	        throw new ExternalException(Constante.CT_ERR_FTP, e);
		}

        try {
			channel = (ChannelSftp) session.openChannel("sftp");
		} catch (JSchException e1) {
		    // log.error(e1,Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
	        throw new ExternalException(Constante.CT_ERR_FTP, e1);
		}
        try {
			channel.connect();
		} catch (JSchException e) {
		   // log.error(e,Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
	        throw new ExternalException(Constante.CT_ERR_FTP, e);
		}
        log.debug("Conexión " + id + " creada.","1");
    }

    public ChannelSftp getChannel() {
        return channel;
    }

    public int getId() {
        return id;
    }

    public void disconnect() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
        log.debug("Conexión " + id + " desconectada.","1");
    }

    public boolean isValid() {
        try {
            channel.ls(".");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
