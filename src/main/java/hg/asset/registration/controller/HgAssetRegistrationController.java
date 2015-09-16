package hg.asset.registration.controller;

import javax.validation.Valid;

import hg.asset.data.AssetDetailRequest;
import hg.asset.data.AssetDetailResponse;
import hg.asset.data.AssetRegistrationRequest;
import hg.asset.data.GenericErrorResponse;
import hg.asset.domain.Asset;
import hg.asset.exception.NoDataException;
import hg.asset.service.AssetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HgAssetRegistrationController {

	@Autowired
	private AssetService assetService;
	
	@RequestMapping(value="assetRegistrationRequest", method=RequestMethod.POST)
	public HttpEntity<?> registerAsset(@Valid @RequestBody AssetRegistrationRequest assetRegistrationRequest) {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="getAssetDetails", method=RequestMethod.POST)
	public HttpEntity<?> getAssetDetails(@Valid @RequestBody AssetDetailRequest assetDetailRequest) throws NoDataException {
		String assetId = assetDetailRequest.getAssetId();
		Asset asset = new Asset();
		try {
			asset = assetService.getDetailsByAssetId(assetId);
			AssetDetailResponse response = new AssetDetailResponse();
			response.setFirstName(asset.getFirstName());
			response.setMiddleName(asset.getMiddleName());
			response.setLastName(asset.getLastName());
			response.setMobileNumber(asset.getMobileNumber());
			response.setAddress(asset.getAddress());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			GenericErrorResponse errorResponse = new GenericErrorResponse();
			errorResponse.setResponseId("1");
			errorResponse.setResponseMessage("Service Unavailable.");
			return new ResponseEntity<>(errorResponse, HttpStatus.OK);
		}
		
		
	}
	
}
