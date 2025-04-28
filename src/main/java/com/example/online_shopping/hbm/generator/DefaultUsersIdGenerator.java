package com.example.online_shopping.hbm.generator;

import org.hibernate.id.IdentifierGenerator;

import com.example.online_shopping.hbm.AbstractStringIDGenerator;

public class DefaultUsersIdGenerator extends AbstractStringIDGenerator implements IdentifierGenerator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String defaultsSequencePrefix = ENTITY_KEY_CODE.USER;
	public static final String defaultSsequenceIncrement = "1";
	public static final String stringFormat = "%010d";

	public DefaultUsersIdGenerator() {
		super();
	}

	@Override
	public String defaultEntityIdentifierPrefix() {
		return defaultsSequencePrefix;
	}

	@Override
	public boolean isStringFormatDecimal() {
		return false;
	}

	@Override
	public String getStringFormat() {
		// --String.format("%010d", nextValue);
		return stringFormat;
	}

	@Override
	public boolean isAssignedSequence() {
		return false;
	}

}
