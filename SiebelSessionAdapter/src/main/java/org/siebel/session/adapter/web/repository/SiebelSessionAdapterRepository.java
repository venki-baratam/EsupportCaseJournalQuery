package org.siebel.session.adapter.web.repository;

import org.siebel.session.adapter.domain.model.request.IspCaseHistoryGetActivityInServiceRunInput;
import org.siebel.session.adapter.domain.model.response.Action;
import org.siebel.session.adapter.domain.model.response.IspCaseHistoryGetActivityInServiceRunOutput;
import org.siebel.session.adapter.domain.model.response.ListOfIspCaseHistoryGetActivityResponse;
import org.springframework.stereotype.Service;

@Service
public class SiebelSessionAdapterRepository {

	public IspCaseHistoryGetActivityInServiceRunOutput getResponse(IspCaseHistoryGetActivityInServiceRunInput input) {

		IspCaseHistoryGetActivityInServiceRunOutput output = new IspCaseHistoryGetActivityInServiceRunOutput();

		Action action = new Action();

		action.setCustomerFirstName("customerFirstName");
		action.setCustomerLastName("customerLastName");
		action.setCustomerNumber("customerNumber");
		action.setCustomerPriConPhn("customerPriConPhn");
		action.setExpressServiceCode("expressServiceCode");
		action.setServiceTag("serviceTag");
		action.setSrNumber("srNumber");
		action.setSrTitle("srTitle");
		output.setListOfIspCaseHistoryGetActivityResponse(new ListOfIspCaseHistoryGetActivityResponse());
		output.getListOfIspCaseHistoryGetActivityResponse().setAction(action);

		return output;
	}

}
