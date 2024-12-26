package pe.com.bn.modc.domain.mapper;

public class BnIndicador {
	
	private static final long serialVersionUID = 1L;
	   
    private String TOPERACION;   
    private String NPRESTAMO;  
    private String CERROR;                                    
    private String MSJ;
	public String getTOPERACION() {
		return TOPERACION;
	}
	public void setTOPERACION(String tOPERACION) {
		TOPERACION = tOPERACION;
	}
	public String getNPRESTAMO() {
		return NPRESTAMO;
	}
	public void setNPRESTAMO(String nPRESTAMO) {
		NPRESTAMO = nPRESTAMO;
	}
	public String getCERROR() {
		return CERROR;
	}
	public void setCERROR(String cERROR) {
		CERROR = cERROR;
	}
	public String getMSJ() {
		return MSJ;
	}
	public void setMSJ(String mSJ) {
		MSJ = mSJ;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    
}
