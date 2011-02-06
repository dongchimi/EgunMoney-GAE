package com.appspot.egun.money.service;

import java.util.List;

import com.appspot.egun.money.domain.Target;
import com.google.appengine.api.datastore.Key;

public interface TargetService {
	
	/**
	 * 거래처 등록
	 * @param target 거래처
	 * @return
	 */
	public Key registerTarget(Target target);
	
	/**
	 * 거래처 목록 조회
	 * @param userEmail 사용자 email
	 * @return
	 */
	public List<Target> findTargetByUserEmail(String userEmail);
	
	/**
	 * 거래처 조회
	 * @param key
	 * @return
	 */
	public Target getTargetByKey(Key key);
}
