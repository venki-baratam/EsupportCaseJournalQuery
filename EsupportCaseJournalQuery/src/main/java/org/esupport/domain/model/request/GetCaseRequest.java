package org.esupport.domain.model.request;

public class GetCaseRequest {
	
	private MessageHeader messageHeader;

	private CaseHeader caseHeader;

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public MessageHeader getMessageHeader() {
		return this.messageHeader;
	}

	public void setCaseHeader(CaseHeader CaseHeader) {
		this.caseHeader = CaseHeader;
	}

	public CaseHeader getCaseHeader() {
		return this.caseHeader;
	}
}