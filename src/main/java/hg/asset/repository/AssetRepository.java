package hg.asset.repository;

import hg.asset.domain.Asset;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset, String>{
	
	Asset findAssetByAssetId(String assetId);
	
}
