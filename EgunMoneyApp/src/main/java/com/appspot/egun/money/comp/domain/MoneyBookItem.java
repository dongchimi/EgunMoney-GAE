package com.appspot.egun.money.comp.domain;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

/**
 * ����� item
 * 
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
public class MoneyBookItem {

	/** id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;

	/** ����/����/��ü ���� */
	@Persistent
	private InOutTransfer inOutTransfer;

	/** ����/���� ��¥ yyyyMMdd */
	@Persistent
	private String useDate;

	/** ���� */
	@Persistent
	private String content;

	/** �ݾ� */
	@Persistent
	private long amount;

	/** �з� */
	@Persistent
	private Long categoryOid;

	/** �ڻ� */
	@Persistent
	private EgunUserAsset relatedAsset;

	/** �޸� */
	@Persistent
	private String description;

	/** ����� id */
	@Persistent
	private long accountBookId;

	/** ���þ� */
	@Persistent
	private List<EgunTag> relatedTags;

	// method ------------------------------------------------------------------
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Long getCategoryOid() {
		return categoryOid;
	}

	public void setCategoryOid(Long categoryOid) {
		this.categoryOid = categoryOid;
	}

	public long getAccountBookId() {
		return accountBookId;
	}

	public void setAccountBookId(long accountBookId) {
		this.accountBookId = accountBookId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public EgunUserAsset getRelatedAsset() {
		return relatedAsset;
	}

	public void setRelatedAsset(EgunUserAsset relatedAsset) {
		this.relatedAsset = relatedAsset;
	}

	public List<EgunTag> getRelatedTags() {
		return relatedTags;
	}

	public void setRelatedTags(List<EgunTag> relatedTags) {
		this.relatedTags = relatedTags;
	}

	public InOutTransfer getInOutTransfer() {
		return inOutTransfer;
	}

	public void setInOutTransfer(InOutTransfer inOutTransfer) {
		this.inOutTransfer = inOutTransfer;
	}
}
