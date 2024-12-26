package pe.com.bn.modc.domain.mapper;



public class BnwsParametro implements java.io.Serializable {

	ParamSimm       paramSimm;	
	
	public ParamSimm getParamSimm() {
		return paramSimm;
	}


	public void setParamSimm(ParamSimm paramSimm) {
		this.paramSimm = paramSimm;
	}

	 public class ParamSimm implements java.io.Serializable {
			
			private String ParamSimmUrl;
			private String ParamGuardarTarjeta;
			private String ParamConsultaTarjerta;

			public String getParamSimmUrl() {
				return ParamSimmUrl;
			}

			public void setParamSimmUrl(String paramSimmUrl) {
				ParamSimmUrl = paramSimmUrl;
			}

			public String getParamGuardarTarjeta() {
				return ParamGuardarTarjeta;
			}

			public void setParamGuardarTarjeta(String paramGuardarTarjeta) {
				ParamGuardarTarjeta = paramGuardarTarjeta;
			}

			public String getParamConsultaTarjerta() {
				return ParamConsultaTarjerta;
			}

			public void setParamConsultaTarjerta(String paramConsultaTarjerta) {
				ParamConsultaTarjerta = paramConsultaTarjerta;
			}
			
		}
}
