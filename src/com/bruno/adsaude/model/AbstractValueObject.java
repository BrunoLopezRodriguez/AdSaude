package com.bruno.adsaude.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractValueObject implements ValueObject {

	public AbstractValueObject() {
	}

	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}