package org.esupport.domain.model.response;

public class GetCaseResponse
{
    private MessageHeader messageHeader;

    private Case caseObj;

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public Case getCaseObj() {
		return caseObj;
	}

	public void setCaseObj(Case caseObj) {
		this.caseObj = caseObj;
	}

    	
}