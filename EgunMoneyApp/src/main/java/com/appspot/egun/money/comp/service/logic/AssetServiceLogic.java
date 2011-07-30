package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.AbstractAssetType;
import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AssetServiceLogic implements AssetService {

	/** 로거 */
	private final Logger logger = Logger.getLogger(AssetServiceLogic.class.getSimpleName());

	private PersistenceManager pm = null;

	@Override
	public long registerUserAssetTypes(List<AbstractAssetType> assetTypes) {
		pm = PMFProvider.getPersistenceManager();
		try {
			for (AbstractAssetType type : assetTypes) {
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
	@SuppressWarnings("unchecked")
	public EgunUserAsset getUserAssetsByUserEmail(String userEmail) {
		EgunUserAsset userAsset = null;

		pm = PMFProvider.getPersistenceManager();
		try {
			Query getUserQuery = pm.newQuery(EgunUserAsset.class, "userEmail == userEmailParam");
			getUserQuery.declareParameters("String userEmailParam");

			List<EgunUserAsset> founUserAssets = (List<EgunUserAsset>) getUserQuery.execute(userEmail);
			if (!founUserAssets.isEmpty()) {
				userAsset = founUserAssets.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		
		if (userAsset != null) {
			this.setAssets(userAsset);
		}
		
		return userAsset;
	}
	
	@SuppressWarnings("unchecked")
	private void setAssets(EgunUserAsset userAsset) {
		pm = PMFProvider.getPersistenceManager();
		logger.log(Level.FINEST, "시작");
		try {
			Query getUserQuery = pm.newQuery(AbstractAssetType.class, ":p.contains(oid)");

			List<AbstractAssetType> foundAssets = (List<AbstractAssetType>) getUserQuery.execute(userAsset.getAssetOids());
			userAsset.setAssets(foundAssets);
		} catch (Exception e) {
			logger.log( Level.ALL, e.toString());
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
	}
}
