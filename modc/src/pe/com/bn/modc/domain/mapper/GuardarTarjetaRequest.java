package pe.com.bn.modc.domain.mapper;
//hiro
public class GuardarTarjetaRequest {
	
	private String typeCard;
	private String typeClient;
	private String numberCard ;
	
	private String typeDocument ;
	private String numberDocument;
	
	private String email;
	private String operatorType;
	private String cellNumber;

	private CashDispositionSettings cashDispositionSettings  ;//cuenta con los atributos solicitados
	private ComprasInternet shoppingInternetSettings  ;
	private Notificacion notificationSettings  ;
	private ComprasExtranjero shoppingAbroadSettings  ;
	
	
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument.trim();
	}
	
	
	public String getTypeCard() {
		return typeCard;
	}
	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
	}
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	public String getNumberCard() {
		return numberCard;
	}
	public void setNumberCard(String numberCard) {
		this.numberCard = numberCard;
	}
	public String getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	
	
	public CashDispositionSettings getCashDispositionSettings() {
		return cashDispositionSettings;
	}
	public void setCashDispositionSettings(
			CashDispositionSettings cashDispositionSettings) {
		this.cashDispositionSettings = cashDispositionSettings;
	}
	public ComprasInternet getShoppingInternetSettings() {
		return shoppingInternetSettings;
	}
	public void setShoppingInternetSettings(ComprasInternet shoppingInternetSettings) {
		this.shoppingInternetSettings = shoppingInternetSettings;
	}
	public Notificacion getNotificationSettings() {
		return notificationSettings;
	}
	public void setNotificationSettings(Notificacion notificationSettings) {
		this.notificationSettings = notificationSettings;
	}
	public ComprasExtranjero getShoppingAbroadSettings() {
		return shoppingAbroadSettings;
	}
	public void setShoppingAbroadSettings(ComprasExtranjero shoppingAbroadSettings) {
		this.shoppingAbroadSettings = shoppingAbroadSettings;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	
	

}
