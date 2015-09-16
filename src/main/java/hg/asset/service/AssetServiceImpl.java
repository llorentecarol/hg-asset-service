package hg.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hg.asset.domain.Asset;
import hg.asset.repository.AssetRepository;

@Component("assetService")
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetRepository assetRepository;
	
	@Override
	public Asset getDetailsByAssetId(String assetId) {
		return assetRepository.findAssetByAssetId(assetId);
	}

}
