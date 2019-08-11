package com.specification.specification_springBoot.datafilter;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Filter for UCBOS
 * 
 * @author bipin.n@itorizon.com
 *
 */
@XmlRootElement(name = "filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class UbFilter implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "100")
    @Size(min = 1, message = "100")
    private String filterName;

    private String filterObjectName;

    /**
     * List of expressions which will be used for filtering data
     */
    @XmlElementWrapper(name = "filterdetails")
    @XmlElement(name = "filterdetail")
    private List<UbFilterDetail> ubFilterDetails;

    /**
     * Operator to apply if there are more then one filter detail. By default FILTER_OPERATOR_AND is applied
     */
    private FilterOperator filterOperator;

    /**
     * Default constructor
     */
    public UbFilter() {
        super();
    }

    /**
     * @return List of UBFilterDetails
     */
    public List<UbFilterDetail> getUbFilterDetails() {
        return ubFilterDetails;
    }

    /**
     * 
     * @param ubFilterDetails set the Filter Details
     */
    public void setUbFilterDetails(List<UbFilterDetail> ubFilterDetails) {
        this.ubFilterDetails = ubFilterDetails;
    }

    /**
     * 
     * @param filteroperator set filter operand
     */
    public void setFilterOperand(FilterOperator filteroperator) {
        this.filterOperator = filteroperator;
    }

    /**
     * Returns the Name of the Filter
     * 
     * @return filterName Name of the Filter
     */
    public String getFilterName() {
        return filterName;
    }

    /**
     * Sets the Name of the Filter
     * 
     * @param filterName Name of the Filter
     */
    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    /**
     * Returns the Filter Operator
     * 
     * @return Filter Operator for Filter
     */
    public FilterOperator getFilterOperator() {
        return filterOperator;
    }

    /**
     * Sets the Filter Operator
     * 
     * @param filterOperator Filter Operator for Filter
     */
    public void setFilterOperator(FilterOperator filterOperator) {
        this.filterOperator = filterOperator;
    }

    /**
     * @return the filterObjectName
     */
    public String getFilterObjectName() {
        return filterObjectName;
    }

    /**
     * @param filterObjectName the filterObjectName to set
     */
    public void setFilterObjectName(String filterObjectName) {
        this.filterObjectName = filterObjectName;
    }

    @Override
    public String toString() {
        return "UbFilter [filterName=" + filterName + ", filterObjectName=" + filterObjectName 
            + ", ubFilterDetails=" + ubFilterDetails + ", filterOperator=" + filterOperator + "]";
    }

}
