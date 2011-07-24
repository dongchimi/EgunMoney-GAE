package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.AbstractAssetType;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AssetServiceLogic implements AssetService {

    /** ·Î°Å */
    private final Logger logger = Logger.getLogger( AssetServiceLogic.class.getSimpleName() );

	private PersistenceManager pm = null;
	
	@Override
	public long registerUserAssetTypes(List<AbstractAssetType> assetTypes) {
		pm = PMFProvider.getPersistenceManager();
		try {
			for(AbstractAssetType type : assetTypes) {
				pm.makePersistent(type);
			}
		} catch (JDOFatalUserException e) {
			throw e;
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

		return assetTypes.size();
	}
	
	@Override
	public long registerUserAsset(EgunUserAsset userAsset) {
		pm = PMFProvider.getPersistenceManager();
		try {
			pm.makePersistent(userAsset);
		} catch (JDOFatalUserException e) {
			throw e;
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		
		return userAsset.getOid();
	}

	@Override
	public List<EgunUserAsset> getAssetsByUserEmail(String userEmail) {
		return null;
	}
}
