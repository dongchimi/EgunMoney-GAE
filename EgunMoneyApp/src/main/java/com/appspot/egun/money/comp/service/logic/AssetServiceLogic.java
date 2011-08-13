package com.appspot.egun.money.comp.service.logic;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;
import com.appspot.egun.money.comp.service.AssetService;
import com.appspot.egun.money.comp.utility.PMFProvider;

@Component
public class AssetServiceLogic implements AssetService {

	/** ·Î°Å */
	private static final Logger logger = Logger.getLogger(AssetServiceLogic.class.getSimpleName());

	private PersistenceManager pm = null;

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
				userAsset.getWalletAssets();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}
		
		return userAsset;
	}
}
