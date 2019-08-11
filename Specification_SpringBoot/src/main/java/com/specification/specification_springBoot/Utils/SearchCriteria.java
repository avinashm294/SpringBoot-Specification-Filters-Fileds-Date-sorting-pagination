package com.specification.specification_springBoot.Utils;

import lombok.Data;

/**
 * Class for Search Criteria
 * 
 * @author Avinash Mahadeva
 *
 */
@Data
public class SearchCriteria {
	private String key;
	private String operation;
	private Object value;

	public SearchCriteria(String key, String operation, Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isOrPredicate() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean isAndPredicate() {
        // TODO Auto-generated method stub
        return false;
    }

}
