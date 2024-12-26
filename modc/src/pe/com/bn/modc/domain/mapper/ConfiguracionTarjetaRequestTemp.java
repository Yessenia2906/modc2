package pe.com.bn.modc.domain.mapper;




public class ConfiguracionTarjetaRequestTemp {

	private String typeCard;
    private String numberCard;
    private String typeDocument;
    private String numberDocument;
    private String typeClient;
    private String typeToken;
    
    private String email;
    private String cellNumber;
    private String operatorType;

    private TransferSettings          transferSettings;
    private ShoppingInternetSettings  shoppingInternetSettings;
    private NotificationSettings      notificationSettings;
    private ShoppingAbroadSettings    shoppingAbroadSettings;
    private CashDispositionSettings	  cashDispositionSettings;
    
    
	public String getTypeCard() {
		return typeCard;
	}
	public void setTypeCard(String typeCard) {
		this.typeCard = typeCard;
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
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
	
	public String getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}
	
	
	public String getTypeToken() {
		return typeToken;
	}
	public void setTypeToken(String typeToken) {
		this.typeToken = typeToken;
	}
	public ShoppingInternetSettings getShoppingInternetSettings() {
		return shoppingInternetSettings;
	}
	public void setShoppingInternetSettings(
			ShoppingInternetSettings shoppingInternetSettings) {
		this.shoppingInternetSettings = shoppingInternetSettings;
	}
	
	public CashDispositionSettings getCashDispositionSettings() {
		return cashDispositionSettings;
	}
	public void setCashDispositionSettings(CashDispositionSettings cashDispositionSettings) {
		this.cashDispositionSettings = cashDispositionSettings;
	}
	

	public NotificationSettings getNotificationSettings() {
		return notificationSettings;
	}
	public void setNotificationSettings(NotificationSettings notificationSettings) {
		this.notificationSettings = notificationSettings;
	}
	public ShoppingAbroadSettings getShoppingAbroadSettings() {
		return shoppingAbroadSettings;
	}
	public void setShoppingAbroadSettings(
			ShoppingAbroadSettings shoppingAbroadSettings) {
		this.shoppingAbroadSettings = shoppingAbroadSettings;
	}
	
	public TransferSettings getTransferSettings() {
		return transferSettings;
	}
	public void setTransferSettings(TransferSettings transferSettings) {
		this.transferSettings = transferSettings;
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
