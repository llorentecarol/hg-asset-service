package hg.asset.service;

import hg.asset.domain.Asset;

public interface AssetService {
	
	Asset getDetailsByAssetId(String assetId);
	
}
