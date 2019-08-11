package com.specification.specification_springBoot.datafilter;

/**
 * Filter operands supported by UCBOS Filter framework
 * 
 * @author bipin.n@itorizon.com
 *
 */

public enum FilterOperator {

    FILTER_OPERATOR_AND("and", "AND"),
    FILTER_OPERATOR_OR("or", "OR"),
    FILTER_OPERATOR_GREATER_THAN(">", "GREATER_THAN"),
    FILTER_OPERATOR_LESSER_THAN("<", "LESSER_THAN"),
    FILTER_OPERATOR_GREATER_THAN_OR_EQUALS(">=", "GREATER_THAN_OR_EQUALS"),
    FILTER_OPERATOR_LESSER_THAN_OR_EQUALS("<=", "LESSER_THAN_OR_EQUALS"),
    FILTER_OPERATOR_EQUALS("=", "EQUALS"),
    FILTER_OPERATOR_NOT_EQUALS("!=", "NOT_EQUALS"),
    FILTER_OPERATOR_STARTS_WITH("fn:starts-with", "StartsWith"),
    FILTER_OPERATOR_ENDS_WITH("fn:ends-with", "EndsWith");

    private final String filterCode;

    private final String filterDesc;

    /**
     * Default Constructor
     * 
     * @param filterCode Code acting as Message Key
     * @param filterDesc Default Message for Message Key
     */
    FilterOperator(String filterCode, String filterDesc) {
        this.filterCode = filterCode;
        this.filterDesc = filterDesc;
    }

    /**
     * Returns the Filter Operator Code
     * 
     * @return String Filter Code
     */
    public String getFilterCode() {
        return filterCode;
    }

    /**
     * Returns the Filter Operator Description
     * 
     * @return String Filter Description
     */
    public String getFilterDesc() {
        return filterDesc;
    }

}
