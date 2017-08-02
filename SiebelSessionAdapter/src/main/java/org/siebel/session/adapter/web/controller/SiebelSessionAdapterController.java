package org.siebel.session.adapter.web.controller;

import org.siebel.session.adapter.domain.model.request.IspCaseHistoryGetActivityInServiceRunInput;
import org.siebel.session.adapter.domain.model.response.IspCaseHistoryGetActivityInServiceRunOutput;
import org.siebel.session.adapter.web.repository.SiebelSessionAdapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SiebelSessionAdapter")
public class SiebelSessionAdapterController {

	@Autowired
	private SiebelSessionAdapterRepository siebelSessionAdapterRepository;

	@PostMapping("/SIT4")
	public IspCaseHistoryGetActivityInServiceRunOutput create(
			@RequestBody IspCaseHistoryGetActivityInServiceRunInput input, BindingResult errors) {

		return siebelSessionAdapterRepository.getResponse(input);
	}

}