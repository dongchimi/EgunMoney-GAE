package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Field;

public interface FieldService {
	
	/**
	 * 필드를 등록한다.
	 * @param fields
	 * @return
	 */
	public long registerField(Field fields);
	
	/**
	 * 새로운 필드 목록을 등록한다.
	 * @param fields	필드 목록
	 * @return
	 */
	public List<Long> registerFields(List<Field> fields);
}
