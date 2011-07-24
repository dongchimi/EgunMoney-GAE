package com.appspot.egun.money.comp.domain;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.domain.asset.EgunUserAsset;

/**
 * 가계부 item
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

	/** 수입/지출/이체 구분 */
	@Persistent
	private InOutTransfer inOutTransfer;

	/** 지출/수입 날짜 yyyyMMdd */
	@Persistent
	private String useDate;

	/** 내용 */
	@Persistent
	private String content;

	/** 금액 */
	@Persistent
	private long amount;

	/** 분류 */
	@Persistent
	private Long categoryOid;

	/** 자산 */
	@Persistent
	private EgunUserAsset relatedAsset;

	/** 메모 */
	@Persistent
	private String description;

	/** 가계부 id */
	@Persistent
	private long accountBookId;

	/** 관련어 */
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
