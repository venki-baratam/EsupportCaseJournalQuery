package org.esupport.web.repository;

import org.esupport.domain.model.request.BillRequest;
import org.esupport.domain.model.request.GetCaseRequest;
import org.esupport.domain.model.response.GetCaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SiebelSessionAdapterRepository {

	@Autowired
	private RestTemplate restTemplate;

	public GetCaseResponse getData(BillRequest billRequest) {

		GetCaseRequest targetRequest = null;

		if (validate(billRequest))
			targetRequest = mapBillRequestToTagetRequest(billRequest);

		String url = "";
		
		url = "http://www.mocky.io/v2/597c376a0f0000ba02f4dbc7";
		
		//Remove above url assignment and un-comment below code to cal target service.
		
		// url = "http://svc4-osb-sit.us.dell.com/3_7/SiebelSessionAdapter_SIT4";
		// return restTemplate.postForObject(url, targetRequest,
		// GetCaseResponse.class);

		return restTemplate.getForObject(url, GetCaseResponse.class);
	}

	private GetCaseRequest mapBillRequestToTagetRequest(BillRequest billRequest) {
		GetCaseRequest targetRequest = new GetCaseRequest();
		targetRequest.setCaseHeader(billRequest.getCaseObj().getCaseHeader());
		return targetRequest;
	}

	private boolean validate(BillRequest billRequest) {

		// Implement this API
		// Write all ur validations in this api

		return true;
	}
}
