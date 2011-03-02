package com.appspot.egun.money.comp.domain;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * ����� item
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class AccountItem {
	
	/** id*/
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key oid;
	
	/** ����/���� ��¥ */
	@Persistent
	private String useDate;

	/** �ݾ� */
	@Persistent
	private long amount;
	
	/** ī�װ� */
	@Persistent
	private Key categoryOid;
	
	/** �ŷ�ó */
	@Persistent
	private Key targetOid; 
	
	/** �ڻ� */
	@Persistent
	private Key assetOid;

	/** �޸� */
	@Persistent
	private String description;
	
	/** �±׸�� */
	@Persistent(mappedBy="accountItem")
	private List<ContentTag> tags;
	
	/** ����  */
	@Persistent
	private byte[] photo;

	/** ī�� �Һ� */
	@Persistent
	private int installmentPlan;
	
	@Persistent(defaultFetchGroup="false")
	private AccountBook egunAccountBook;
	
	
	// method ------------------------------------------------------------------
	public void setTagString(String tagString) {
		if (tagString == null || tagString.length() < 1) return;
		
		String[] tagStrings = tagString.split("/,");
		for(String tag : tagStrings) {
			ContentTag contentTag = new ContentTag(tag);
			tags.add(contentTag);
		}
	}
	
	public String getTagString() {
		if (tags == null || tags.size() == 0) return "";
		
		StringBuilder tagBuilder = new StringBuilder();
		for(ContentTag tag : tags) {
			tagBuilder.append(tag.getName()).append(", ");
		}
		
		return tagBuilder.toString();
	}
	
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

	public List<ContentTag> getTags() {
		return tags;
	}

	public void setTags(List<ContentTag> tags) {
		this.tags = tags;
	}
	
	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public Key getOid() {
		return oid;
	}

	public void setOid(Key oid) {
		this.oid = oid;
	}

	public AccountBook getEgunAccountBook() {
		return egunAccountBook;
	}

	public void setEgunAccountBook(AccountBook egunAccountBook) {
		this.egunAccountBook = egunAccountBook;
	}

	public Key getCategoryOid() {
		return categoryOid;
	}

	public void setCategoryOid(Key categoryOid) {
		this.categoryOid = categoryOid;
	}
	
	public Key getTargetOid() {
		return targetOid;
	}

	public void setTargetOid(Key targetOid) {
		this.targetOid = targetOid;
	}

	public Key getAssetOid() {
		return assetOid;
	}

	public void setAssetOid(Key assetOid) {
		this.assetOid = assetOid;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public int getInstallmentPlan() {
		return installmentPlan;
	}

	public void setInstallmentPlan(int installmentPlan) {
		this.installmentPlan = installmentPlan;
	}
}
