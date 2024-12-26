package pe.com.bn.modc.domain.mapper;

public class ConsultarTarjetaResponse {
	private String codResult;
	private GuardarTarjetaRequest data;
	private String msg;
	
	
	
	public String getCodResult() {
		return codResult;
	}



	public void setCodResult(String codResult) {
		this.codResult = codResult;
	}



	public GuardarTarjetaRequest getData() {
		return data;
	}



	public void setData(GuardarTarjetaRequest data) {
		this.data = data;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public ConsultarTarjetaResponse() {
		// 
	}

}
