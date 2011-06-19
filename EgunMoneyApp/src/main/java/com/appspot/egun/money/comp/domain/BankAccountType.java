package com.appspot.egun.money.comp.domain;

import java.io.Serializable;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

/**
 * 은행 계좌 타입
 * @author dklee
 * @since 2011.06.12
 */
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class BankAccountType implements Serializable {

	/** UID */
	private static final long serialVersionUID = 7745666216324768169L;
	
}