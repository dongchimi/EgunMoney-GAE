package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Target;
import com.google.appengine.api.datastore.Key;

public interface TargetService {
	
	/**
	 * �ŷ�ó ���
	 * @param target �ŷ�ó
	 * @return
	 */
	public Key registerTarget(Target target);
	
	/**
	 * �ŷ�ó ��� ��ȸ
	 * @param userEmail ����� email
	 * @return
	 */
	public List<Target> findTargetByUserEmail(String userEmail);
	
	/**
	 * �ŷ�ó ��ȸ
	 * @param key
	 * @return
	 */
	public Target getTargetByKey(Key key);
}