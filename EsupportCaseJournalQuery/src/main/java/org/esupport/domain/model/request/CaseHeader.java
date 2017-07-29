package org.esupport.domain.model.request;

public class CaseHeader {
	private String id;

	private String dataSource;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSource() {
		return this.dataSource;
	}
}