package com.specification.specification_springBoot.datafilter;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for filtering documents from NoSQL DB.
 * 
 * @author bipin.n@itorizon.com
 *
 */
@XmlRootElement(name = "filterdetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class UbFilterDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Filter field
     */
    @NotNull(message = "100")
    @Size(min = 1, message = "100")
    private String filterField;

    /**
     * Filter operator
     */
    @NotNull(message = "100")
    @Size(min = 1, message = "100")
    private FilterOperator filterOperator;

    /**
     * Filter field value
     */
    @NotNull(message = "100")
    @Size(min = 1, message = "100")
    private String filterValue;

    /**
     * Default constructor
     */
    public UbFilterDetail() {
        super();
    }

    /**
     * 
     * @return Return the filter field
     */
    public String getFilterField() {
        return filterField;
    }

    /**
     * 
     * @param filterField Set the field for filtering
     */
    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    /**
     * 
     * @return Return the value of the filter field
     */
    public String getFilterValue() {
        return filterValue;
    }

    /**
     * 
     * @param filterValue Set value for filtering
     */
    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    /**
     * Returns the filer operator
     * 
     * @return filterOperator
     */
    public FilterOperator getFilterOperator() {
        return filterOperator;
    }

    /**
     * Sets the filter operator
     * 
     * @param filterOperator Filter Operator
     */
    public void setFilterOperator(FilterOperator filterOperator) {
        this.filterOperator = filterOperator;
    }

    @Override
    public String toString() {
        return "UbFilterDetail [filterField=" + filterField + ", filterOperator=" + filterOperator + ", filterValue="
            + filterValue + "]";
    }
}
