package org.esupport.web.repository;

import org.esupport.domain.model.request.GetCaseRequest;
import org.esupport.domain.model.response.GetCaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SiebelSessionAdapterRepository {

	@Autowired
	private RestTemplate restTemplate;

	public GetCaseResponse getData(GetCaseRequest request) {
		String url = "";
		// url =
		// "http://svc4-osb-sit.us.dell.com/3_7/SiebelSessionAdapter_SIT4";
		url = "http://www.mocky.io/v2/597c376a0f0000ba02f4dbc7";
		// .return restTemplate.postForObject(url, request,
		// GetCaseResponse.class);

		return restTemplate.getForObject(url, GetCaseResponse.class);
	}
}
