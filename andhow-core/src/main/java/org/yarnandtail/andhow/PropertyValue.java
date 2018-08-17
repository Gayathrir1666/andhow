package org.yarnandtail.andhow;

import org.yarnandtail.andhow.api.Property;

/**
 * Simple class to bundle a Property and value.
 * 
 * @author eeverman
 */
 public class PropertyValue<T> {

	private final Property<T> property;
	private final T value;
	
	/**
	 * New instance
	 * 
	 * @param prop A non-null Property
	 * @param value A value which may be null
	 */
	public PropertyValue(Property<T> prop, T value) {
		
		this.property = prop;
		this.value = value;
		
		if (this.property == null) {
			throw new RuntimeException("Cannot assign a null property as a PropertyValue instance.");
		}
	}

	/**
	 * Overrides standard equals to return true if the Property is the same
	 * class instance and the values are equal.
	 * 
	 * @param obj
	 * @return true or false based on same Property instance and equal value.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean basicPropsEq = false;
		
		if (obj instanceof PropertyValue) {
			PropertyValue other = (PropertyValue)obj;
			if (property == other.property) {
				if (value != null && other.value != null) {
					basicPropsEq = (value.equals(other.value));
				} else if (value == null && other.value == null) {
					basicPropsEq = true;
				}
			} 
			
		}
		
		return basicPropsEq;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		if (property != null) hash*=property.hashCode();
		if (value != null) hash*=value.hashCode();
		
		//Ignore the transient Problem state
		
		return hash;
	}

	public Property<T> getProperty() {
		return property;
	}

	public T getValue() {
		return value;
	}
	
}
