package com.appspot.egun.money.comp.domain.asset;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.domain.Field;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class AbstractAssetType {
	
	/** ������Ʈ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/** �ڻ�� */
	@Persistent
	private String name;
	
	/** �ڻ� ���� ���� �ʵ� oid */
	@Persistent
	private List<Long> fieldOids = new ArrayList<Long>(10);
	
	/** �ڻ� ���� ���� �ʵ�  */
	@NotPersistent
	private List<Field> fields = new ArrayList<Field>(10);
	
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getFieldOids() {
		return fieldOids;
	}
	public void setFieldOids(List<Long> fieldOids) {
		this.fieldOids = fieldOids;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
}
