package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * ����� ����
 * @author dklee
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AccountBookAuthorize implements Serializable
{

    /** UID */
    private static final long serialVersionUID = 7386273159244945057L;

    /** ������Ʈ id */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long oid;

    /** ����� id */
    @Persistent
    private Long accountBookOid;

    /** ����� e-���� */
    @Persistent
    private String userEmail;

    /** ����� ���� */
    @Persistent
    private EgunAuthorize authorize;

    // method ------------------------------------------------------------------
    public AccountBookAuthorize( String userEmail, Long accountBookOid )
    {
        this.userEmail = userEmail;
        this.accountBookOid = accountBookOid;

        authorize = EgunAuthorize.READ_WRITE;
    }

    public AccountBookAuthorize( String userEmail, Long accountBookOid, EgunAuthorize authorize )
    {
        this.userEmail = userEmail;
        this.accountBookOid = accountBookOid;
        this.authorize = authorize;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail( String userEmail )
    {
        this.userEmail = userEmail;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid( Long oid )
    {
        this.oid = oid;
    }

    public Long getAccountBookOid()
    {
        return accountBookOid;
    }

    public void setAccountBookOid( Long accountBookOid )
    {
        this.accountBookOid = accountBookOid;
    }

    public EgunAuthorize getAuthorize()
    {
        return authorize;
    }

    public void setAuthorize( EgunAuthorize authorize )
    {
        this.authorize = authorize;
    }

}
