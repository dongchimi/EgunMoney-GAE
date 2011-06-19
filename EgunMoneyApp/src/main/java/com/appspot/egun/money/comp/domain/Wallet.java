package com.appspot.egun.money.comp.domain;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * ¡ˆ∞©
 * @author dklee
 * @since 2011.06.12
 */
@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class Wallet implements Serializable {
	/** UID */
	private static final long serialVersionUID = -3494499835825400514L;

	/** ø¿∫Í¡ß∆Æ id */
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long oid;
	
	/**
	 * µ∑ ≈∏¿‘
	 */
	private List<Type>	moneyTypes;
}
