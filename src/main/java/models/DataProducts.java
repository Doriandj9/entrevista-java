package models;

import com.fasterxml.jackson.databind.JsonNode;

public class DataProducts {
	private String _identifier;
	private String _entityName;
	private String $ref;
	private String product;
	private String product$_identifier;
	private String storageBin;
	private String storageBin$_identifier;
	private String attributeSetValue;
	private String attributeSetValue$_identifier;
	private String uOM;
	private String uOM$_identifier;
	private String orderUOM;
	private int quantityOnHand;
	private String onHandOrderQuanity;
	private String lastInventoryCountDate;
	private int quantityInDraftTransactions;
	private int quantityOrderInDraftTransactions;
	private String client;
	private String client$_identifier;
	private String organization;
	private String organization$_identifier;
	private Boolean active;
	private String creationDate;
	private String createdBy;
	private String createdBy$_identifier;
	private String updated;
	private String updatedBy;
	private String updatedBy$_identifier;
	private String id;
	private int greservedQty;
	private int Quantity;
	private int recordTime;
	
	public DataProducts(JsonNode data) {
		// TODO Auto-generated constructor stub
		this.set_identifier(data.get("_identifier").asText());
		this.set_entityName(data.get("_entityName").asText());
		this.set$ref(data.get("$ref").asText());
		this.setProduct(data.get("product").asText());
		this.setProduct$_identifier(data.get("product$_identifier").asText());
		this.setStorageBin(data.get("storageBin").asText());
		this.setStorageBin$_identifier(data.get("storageBin$_identifier").asText());
		this.setAttributeSetValue(data.get("attributeSetValue").asText());
		this.setAttributeSetValue$_identifier(data.get("attributeSetValue$_identifier").asText());
		this.setuOM(data.get("uOM").asText());
		this.setuOM$_identifier(data.get("uOM$_identifier").asText());
		this.setQuantityOnHand(data.get("quantityOnHand").asInt());
		this.setId(data.get("id").asText());
	}
	
	public String get_identifier() {
		return _identifier;
	}
	public void set_identifier(String _identifier) {
		this._identifier = _identifier;
	}
	public String get_entityName() {
		return _entityName;
	}
	public void set_entityName(String _entityName) {
		this._entityName = _entityName;
	}
	public String get$ref() {
		return $ref;
	}
	public void set$ref(String $ref) {
		this.$ref = $ref;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProduct$_identifier() {
		return product$_identifier;
	}
	public void setProduct$_identifier(String product$_identifier) {
		this.product$_identifier = product$_identifier;
	}
	public String getStorageBin() {
		return storageBin;
	}
	public void setStorageBin(String storageBin) {
		this.storageBin = storageBin;
	}
	public String getStorageBin$_identifier() {
		return storageBin$_identifier;
	}
	public void setStorageBin$_identifier(String storageBin$_identifier) {
		this.storageBin$_identifier = storageBin$_identifier;
	}
	public String getAttributeSetValue() {
		return attributeSetValue;
	}
	public void setAttributeSetValue(String attributeSetValue) {
		this.attributeSetValue = attributeSetValue;
	}
	public String getAttributeSetValue$_identifier() {
		return attributeSetValue$_identifier;
	}
	public void setAttributeSetValue$_identifier(String attributeSetValue$_identifier) {
		this.attributeSetValue$_identifier = attributeSetValue$_identifier;
	}
	public String getuOM() {
		return uOM;
	}
	public void setuOM(String uOM) {
		this.uOM = uOM;
	}
	public String getuOM$_identifier() {
		return uOM$_identifier;
	}
	public void setuOM$_identifier(String uOM$_identifier) {
		this.uOM$_identifier = uOM$_identifier;
	}
	public String getOrderUOM() {
		return orderUOM;
	}
	public void setOrderUOM(String orderUOM) {
		this.orderUOM = orderUOM;
	}
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	public String getOnHandOrderQuanity() {
		return onHandOrderQuanity;
	}
	public void setOnHandOrderQuanity(String onHandOrderQuanity) {
		this.onHandOrderQuanity = onHandOrderQuanity;
	}
	public String getLastInventoryCountDate() {
		return lastInventoryCountDate;
	}
	public void setLastInventoryCountDate(String lastInventoryCountDate) {
		this.lastInventoryCountDate = lastInventoryCountDate;
	}
	public int getQuantityInDraftTransactions() {
		return quantityInDraftTransactions;
	}
	public void setQuantityInDraftTransactions(int quantityInDraftTransactions) {
		this.quantityInDraftTransactions = quantityInDraftTransactions;
	}
	public int getQuantityOrderInDraftTransactions() {
		return quantityOrderInDraftTransactions;
	}
	public void setQuantityOrderInDraftTransactions(int quantityOrderInDraftTransactions) {
		this.quantityOrderInDraftTransactions = quantityOrderInDraftTransactions;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getClient$_identifier() {
		return client$_identifier;
	}
	public void setClient$_identifier(String client$_identifier) {
		this.client$_identifier = client$_identifier;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getOrganization$_identifier() {
		return organization$_identifier;
	}
	public void setOrganization$_identifier(String organization$_identifier) {
		this.organization$_identifier = organization$_identifier;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedBy$_identifier() {
		return createdBy$_identifier;
	}
	public void setCreatedBy$_identifier(String createdBy$_identifier) {
		this.createdBy$_identifier = createdBy$_identifier;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedBy$_identifier() {
		return updatedBy$_identifier;
	}
	public void setUpdatedBy$_identifier(String updatedBy$_identifier) {
		this.updatedBy$_identifier = updatedBy$_identifier;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGreservedQty() {
		return greservedQty;
	}
	public void setGreservedQty(int greservedQty) {
		this.greservedQty = greservedQty;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}
	
	
}
