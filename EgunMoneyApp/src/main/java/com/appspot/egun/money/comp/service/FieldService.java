package com.appspot.egun.money.comp.service;

import java.util.List;

import com.appspot.egun.money.comp.domain.Field;

public interface FieldService {
	
	/**
	 * �ʵ带 ����Ѵ�.
	 * @param fields
	 * @return
	 */
	public long registerField(Field fields);
	
	/**
	 * ���ο� �ʵ� ����� ����Ѵ�.
	 * @param fields	�ʵ� ���
	 * @return
	 */
	public List<Long> registerFields(List<Field> fields);
}
