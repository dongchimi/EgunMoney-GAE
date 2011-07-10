package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.egun.money.comp.constant.EgunMoneyConstant;
import com.appspot.egun.money.comp.utility.StringU;

/**
 * �̰ǸӴ� �����
 * @author dklee
 * @since 2010.09.01
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MoneyBook implements Serializable
{

    /** UID */
    private static final long serialVersionUID = 1760777222231794180L;

    /** ������Ʈ id */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long oid;

    /** ����� �� */
    @Persistent
    private String moneyBookName;

    /** ������ */
    @Persistent
    private String baseDay;

    @Persistent
    private String ownerId;

    /** �⺻ �� ���� */
    @Persistent
    private boolean defaultBook;

    // method ------------------------------------------------------------------
    public MoneyBook( EgunUser user )
    {
        initialize( user, null );
    }

    public MoneyBook( EgunUser user, String bookName )
    {
        initialize( user, bookName );
    }

    private void initialize( EgunUser user, String bookName )
    {
        ownerId = user.getUserEmail();
        if ( StringU.isEmptyOrNull( bookName ) )
        {
            moneyBookName = user.getNickName() + "���� �����";
        }
        else
        {
        	moneyBookName = bookName;
        }
        baseDay = EgunMoneyConstant.INITIAL_BASE_DATE;

        // �̹��� ������ ����
        //budgetBook = new BudgetBook(baseDay);
    }

    public String getBaseDay()
    {
        return baseDay;
    }

    public void setBaseDay( String baseDay )
    {
        DecimalFormat df = new DecimalFormat( "00" );
        this.baseDay = df.format( baseDay );
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid( Long oid )
    {
        this.oid = oid;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public void setOwnerId( String ownerId )
    {
        this.ownerId = ownerId;
    }

    public boolean isDefaultBook()
    {
        return defaultBook;
    }

    public void setDefaultBook( boolean defaultBook )
    {
        this.defaultBook = defaultBook;
    }

	public String getMoneyBookName() {
		return moneyBookName;
	}

	public void setMoneyBookName(String moneyBookName) {
		this.moneyBookName = moneyBookName;
	}
}
