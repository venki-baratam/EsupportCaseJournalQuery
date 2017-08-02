package org.esupport.web.controller;

import org.esupport.domain.model.request.sieble.GetCaseRequest;
import org.esupport.domain.model.response.sieble.GetCaseResponse;
import org.esupport.web.repository.SiebelSessionAdapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Case/Query")
public class EsupportCaseJournalQueryController {

	@Autowired
	private SiebelSessionAdapterRepository siebelSessionAdapterRepository;

	@PostMapping("/EsupportCaseJournalQuery")
	public GetCaseResponse create(@RequestBody GetCaseRequest getCaseRequest, BindingResult errors) {

		return siebelSessionAdapterRepository.getData(getCaseRequest);
	}

}