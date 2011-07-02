package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * ����� item
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType = IdentityType.DATASTORE)
public class AccountItem implements Serializable
{

    /** UID */
    private static final long serialVersionUID = 8590762381001509903L;

    /** id*/
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long oid;

    /** ����/���� ���� */
    private AccountItemDivistion moneyDivsition;

    /** ����/���� ��¥ yyyyMMdd */
    @Persistent
    private String useDate;

    /** ���� */
    private String because;

    /** �ݾ� */
    @Persistent
    private long amount;

    /** ī�װ� */
    @Persistent
    private Long categoryOid;

    /** �ŷ�ó */
    @Persistent
    private Long targetOid;

    /** �ڻ� */
    @Persistent
    private Long assetOid;

    /** �޸� */
    @Persistent
    private String description;

    /** ����  */
    @Persistent
    private byte[] photo;

    /** 
     * �Һ� 
     * */
    @Persistent
    private int installmentPlan;

    /** ����� id */
    @Persistent
    private long accountBookId;

    @Persistent
    private List<Long> tagOids;

    // method ------------------------------------------------------------------
    public long getAmount()
    {
        return amount;
    }

    public void setAmount( long amount )
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public String getUseDate()
    {
        return useDate;
    }

    public void setUseDate( String useDate )
    {
        this.useDate = useDate;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid( Long oid )
    {
        this.oid = oid;
    }

    public Long getCategoryOid()
    {
        return categoryOid;
    }

    public void setCategoryOid( Long categoryOid )
    {
        this.categoryOid = categoryOid;
    }

    public Long getTargetOid()
    {
        return targetOid;
    }

    public void setTargetOid( Long targetOid )
    {
        this.targetOid = targetOid;
    }

    public Long getAssetOid()
    {
        return assetOid;
    }

    public void setAssetOid( Long assetOid )
    {
        this.assetOid = assetOid;
    }

    public byte[] getPhoto()
    {
        return photo;
    }

    public void setPhoto( byte[] photo )
    {
        this.photo = photo;
    }

    public int getInstallmentPlan()
    {
        return installmentPlan;
    }

    public void setInstallmentPlan( int installmentPlan )
    {
        this.installmentPlan = installmentPlan;
    }

    public long getAccountBookId()
    {
        return accountBookId;
    }

    public void setAccountBookId( long accountBookId )
    {
        this.accountBookId = accountBookId;
    }

    public String getBecause()
    {
        return because;
    }

    public void setBecause( String because )
    {
        this.because = because;
    }

    public AccountItemDivistion getMoneyDivsition()
    {
        return moneyDivsition;
    }

    public void setMoneyDivsition( AccountItemDivistion moneyDivsition )
    {
        this.moneyDivsition = moneyDivsition;
    }

    public List<Long> getTagOids()
    {
        return tagOids;
    }

    public void setTagOids( List<Long> tagOids )
    {
        this.tagOids = tagOids;
    }
}
