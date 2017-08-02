package org.esupport.web.repository;

import org.esupport.domain.model.request.sieble.GetCaseRequest;
import org.esupport.domain.model.request.target.Action;
import org.esupport.domain.model.request.target.IspCaseHistoryGetActivityInServiceRunInput;
import org.esupport.domain.model.request.target.ListOfIspCaseHistoryGetActivityRequest;
import org.esupport.domain.model.response.sieble.Asset;
import org.esupport.domain.model.response.sieble.Case;
import org.esupport.domain.model.response.sieble.CaseHeader;
import org.esupport.domain.model.response.sieble.Customer;
import org.esupport.domain.model.response.sieble.GetCaseResponse;
import org.esupport.domain.model.response.tagret.IspCaseHistoryGetActivityInServiceRunOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SiebelSessionAdapterRepository {

	@Autowired
	private RestTemplate restTemplate;

	public GetCaseResponse getData(GetCaseRequest getCaseRequest) {

		IspCaseHistoryGetActivityInServiceRunInput targetInput = new IspCaseHistoryGetActivityInServiceRunInput();

		targetInput = mapGetCaseRequestToTagetRequest(getCaseRequest);

		String url = "http://localhost:9090/SiebelSessionAdapter/SIT4";

		IspCaseHistoryGetActivityInServiceRunOutput outPut = restTemplate.postForObject(url, targetInput,
				IspCaseHistoryGetActivityInServiceRunOutput.class);

		return mapTargetOutputToGetCaseResponse(outPut);
	}

	private GetCaseResponse mapTargetOutputToGetCaseResponse(IspCaseHistoryGetActivityInServiceRunOutput outPut) {

		GetCaseResponse getCaseResponse = new GetCaseResponse();
		getCaseResponse.setCaseObj(new Case());
		getCaseResponse.getCaseObj().setCaseHeader(new CaseHeader());
		getCaseResponse.getCaseObj().getCaseHeader().setAsset(new Asset());
		getCaseResponse.getCaseObj().getCaseHeader().setCustomer(new Customer());
		getCaseResponse.getCaseObj().getCaseHeader()
				.setId(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getSrNumber());
		getCaseResponse.getCaseObj().getCaseHeader()
				.setTitle(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getSrTitle());
		getCaseResponse.getCaseObj().getCaseHeader().setDataSource("DELTA");
		getCaseResponse.getCaseObj().getCaseHeader().getAsset()
				.setServiceTag(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getServiceTag());
		getCaseResponse.getCaseObj().getCaseHeader().getAsset().setExpressServiceCode(
				outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getExpressServiceCode());
		getCaseResponse.getCaseObj().getCaseHeader().getCustomer()
				.setId(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getCustomerNumber());
		getCaseResponse.getCaseObj().getCaseHeader().getCustomer()
				.setName(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getCustomerLastName());
		getCaseResponse.getCaseObj().getCaseHeader().getCustomer().setPrimaryPhone(
				outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getCustomerPriConPhn());
		getCaseResponse.getCaseObj().getCaseHeader().getCustomer()
				.setQtcId(outPut.getListOfIspCaseHistoryGetActivityResponse().getAction().getiSPQTCCutomerNumber());

		return getCaseResponse;
	}

	private IspCaseHistoryGetActivityInServiceRunInput mapGetCaseRequestToTagetRequest(GetCaseRequest getCaseRequest) {

		IspCaseHistoryGetActivityInServiceRunInput targetInput = new IspCaseHistoryGetActivityInServiceRunInput();
		targetInput.setListOfIspCaseHistoryGetActivityRequest(new ListOfIspCaseHistoryGetActivityRequest());
		targetInput.getListOfIspCaseHistoryGetActivityRequest().setAction(new Action());
		targetInput.getListOfIspCaseHistoryGetActivityRequest().getAction().setId(
				getCaseRequest.getCaseHeader().getInteractions().getInteraction().getInteractionHeader().getId());

		targetInput.getListOfIspCaseHistoryGetActivityRequest().getAction()
				.setSrNumber(getCaseRequest.getCaseHeader().getId());

		return targetInput;
	}

}
