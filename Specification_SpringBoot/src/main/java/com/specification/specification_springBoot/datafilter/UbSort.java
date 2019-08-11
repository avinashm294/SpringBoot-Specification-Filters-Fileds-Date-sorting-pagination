package com.specification.specification_springBoot.datafilter;

import org.springframework.stereotype.Component;

/**
 * Class which handles Sorting part in UCBOS web.
 * 
 * @author bipin.n@itorizon.com
 *
 */
@Component
public class UbSort {

	private String sortField;
	private String sortOrder;
	private String collation;
	private String namespace;
	private String scalarType;
	private String sortObject;

	/**
	 *  
	 * @param sortField
	 *            Field to be Sorted
	 * @param sortOrder
	 *            Order to be Sorted
	 * @param collation
	 *            Collation to be used
	 * @param namespace
	 *            Namespace to be used
	 * @param sortFieldtype
	 *            Sort Field Type used
	 * @param sortObject
	 *            Sort Object to be used
	 */
	public UbSort(String sortField, String sortOrder, String collation,
			String namespace, String sortFieldtype, String sortObject) {
		super();
		this.sortField = sortField;
		this.sortOrder = sortOrder;
		this.collation = collation;
		this.namespace = namespace;
		this.scalarType = sortFieldtype;
		this.sortObject = sortObject;
	}

	/**
	 * Default Constructor
	 */
	public UbSort() {
		super();
	}

	/**
	 * Retrieve the Sort Field
	 * 
	 * @return sortField Field to be Sorted
	 */
	public String getSortField() {
		return sortField;
	}

	/**
	 * Sets the Sort Field
	 * 
	 * @param sortField
	 *            Field to be Sorted
	 */
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	/**
	 * Retrieve the Sort Order
	 * 
	 * @return sortOrder Order to be used
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the Sort Order
	 * 
	 * @param sortOrder
	 *            Order to be Sorted
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/**
	 * Retrieves the Collation
	 * 
	 * @return collation used for Sorting
	 */
	public String getCollation() {
		return collation;
	}

	/**
	 * Sets the Collation
	 * 
	 * @param collation
	 *            Used for Sorting
	 */
	public void setCollation(String collation) {
		this.collation = collation;
	}

	/**
	 * Retrieve the name space
	 * 
	 * @return namespace for Sorting
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * Sets the name space
	 * 
	 * @param namespace
	 *            to be used for Sorting
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	/**
	 * Retrieves the Scaler Type
	 * 
	 * @return Scaler Type to be used for Sorting Field
	 */
	public String getScalarType() {
		return scalarType;
	}

	/**
	 * Sets the Scaler Type
	 * 
	 * @param scalarType
	 *            Scaler Type to be used for Sorting Field
	 */
	public void setScalarType(String scalarType) {
		this.scalarType = scalarType;
	}

	/**
	 * Retrieves the Sort Object
	 * 
	 * @return sortObject to be used for Sorting
	 */
	public String getSortObject() {
		return sortObject;
	}

	/**
	 * Sets the Sort Object
	 * 
	 * @param sortObject
	 *            to be used for Sorting
	 */
	public void setSortObject(String sortObject) {
		this.sortObject = sortObject;
	}

	@Override
	public String toString() {
		return "UbSort [sortField=" + sortField + ", sortOrder=" + sortOrder
				+ ", collation=" + collation + ", namespace=" + namespace
				+ ", sortFieldtype=" + scalarType + ", sortObject="
				+ sortObject + "]";
	}

}
