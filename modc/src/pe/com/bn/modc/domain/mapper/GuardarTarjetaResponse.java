package pe.com.bn.modc.domain.mapper;
//hiro
public class GuardarTarjetaResponse {

	private String codResult;
	private String msgError;
	private String msg;
	private GuardarTarjetaRequest data;
	
	
	public String getCodResult() {
		return codResult;
	}
	public void setCodResult(String codResult) {
		this.codResult = codResult;
	}
	public String getMsgError() {
		return msgError;
	}
	public void setMsgError(String msgError) {
		this.msgError = msgError;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public GuardarTarjetaRequest getData() {
		return data;
	}
	public void setData(GuardarTarjetaRequest data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "GuardarTarjetaResponse [codResult=" + codResult + ", msgError="
				+ msgError + ", msg=" + msg + ", data=" + data + "]";
	}
	
	

}
