package org.esupport.domain.model.request;

public class CaseHeader {
	
	private String id;

	private String title;

	private String dataSource;

	private Asset asset;

	private Customer customer;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}