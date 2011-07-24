package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.Asset;
import com.appspot.egun.money.comp.domain.AssetType;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AssetServiceLogic implements AssetService {

    /** ·Î°Å */
    private final Logger logger = Logger.getLogger( AssetServiceLogic.class.getSimpleName() );

	private PersistenceManager pm = null;
	
	@Override
	public long registerDefaultUserAssetTypes(List<AssetType> assetTypes) {
		pm = PMFProvider.getPersistenceManager();
		try {
			for (AssetType type : assetTypes) {
				pm.makePersistent(type);
			}
		} catch (JDOFatalUserException e) {
			e.printStackTrace();
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

		return assetTypes.size();
	}
	
	@Override
	public boolean registerDefaultUserAsset(List<AssetType> assetType) {
		return false;
	}

	@Override
	public List<Asset> getAssetsByUserEmail(String userEmail) {
		return null;
	}
}
