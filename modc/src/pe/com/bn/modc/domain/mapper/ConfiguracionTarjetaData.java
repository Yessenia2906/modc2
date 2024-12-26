package pe.com.bn.modc.domain.mapper;




public class ConfiguracionTarjetaData{
private String fechaOperacion;
private String tipoTarjeta;
private String nroTarjeta;

private ConfigPTransferencia configTransferencia;
private ConfigPDisposicionEfectivo configDisposicionEfectivo;
private ConfigPComprasInternet configComprasInternet;
private ConfigPNotificacion configNotificacion;
private ConfigPConsumoExtranjero configConsumoExtranjero;


public String getFechaOperacion() {
	return fechaOperacion;
}
public void setFechaOperacion(String fechaOperacion) {
	this.fechaOperacion = fechaOperacion;
}
public String getTipoTarjeta() {
	return tipoTarjeta;
}
public void setTipoTarjeta(String tipoTarjeta) {
	this.tipoTarjeta = tipoTarjeta;
}
public String getNroTarjeta() {
	return nroTarjeta;
}
public void setNroTarjeta(String nroTarjeta) {
	this.nroTarjeta = nroTarjeta;
}
public ConfigPTransferencia getConfigTransferencia() {
	return configTransferencia;
}
public void setConfigTransferencia(ConfigPTransferencia configTransferencia) {
	this.configTransferencia = configTransferencia;
}
public ConfigPComprasInternet getConfigComprasInternet() {
	return configComprasInternet;
}
public void setConfigComprasInternet(
		ConfigPComprasInternet configComprasInternet) {
	this.configComprasInternet = configComprasInternet;
}
public ConfigPNotificacion getConfigNotificacion() {
	return configNotificacion;
}
public void setConfigNotificacion(ConfigPNotificacion configNotificacion) {
	this.configNotificacion = configNotificacion;
}
public ConfigPConsumoExtranjero getConfigConsumoExtranjero() {
	return configConsumoExtranjero;
}
public void setConfigConsumoExtranjero(
		ConfigPConsumoExtranjero configConsumoExtranjero) {
	this.configConsumoExtranjero = configConsumoExtranjero;
}
public ConfigPDisposicionEfectivo getConfigDisposicionEfectivo() {
	return configDisposicionEfectivo;
}
public void setConfigDisposicionEfectivo(ConfigPDisposicionEfectivo configDisposicionEfectivo) {
	this.configDisposicionEfectivo = configDisposicionEfectivo;
}


}
