package com.specification.specification_springBoot.datafilter;

/**
 * Class contains parameters for Filtering/sorting and pagination.
 * 
 * @author bipin.n@itorizon.com
 *
 */
public class UIParam {

    /**
     * UI Pagination parameter: Page length to control number of records to show
     */
    private String pageLength;

    /**
     * Field to be sorted on
     */
    private String sortField;

    /**
     * Order of sorting: Ascending/Descending
     */
    private String sortOrder;

    /**
     * Filter object on which the data needs to be filtered
     */

    private UbFilter ubFilter;

    /**
     * Default constructor
     */
    public UIParam() {
        super();
    }

    /**
     * 
     * @return pageLength
     */
    public String getPageLength() {
        return pageLength;
    }

    /**
     * 
     * @param pageLength Set pageLength
     */
    public void setPageLength(String pageLength) {
        this.pageLength = pageLength;
    }

    /**
     * 
     * @return sortField: The field to be sorted
     */
    public String getSortField() {
        return sortField;
    }

    /**
     * 
     * @param sortField set the field to be sorted on
     */
    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    /**
     * 
     * @return sortOrder/direction
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * 
     * @param sortOrder Set sorting order/direction
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Returns the UbFilter
     * 
     * @return ubFilter used for filtering records
     */
    public UbFilter getUbFilter() {
        return ubFilter;
    }

    /**
     * Sets the UbFilter
     * 
     * @param ubFilter UbFilter for Filtering Records
     */
    public void setUbFilter(UbFilter ubFilter) {
        this.ubFilter = ubFilter;
    }

    @Override
    public String toString() {
        return "UIParam [pageLength=" + pageLength
            + ", sortField=" + sortField + ", sortOrder=" + sortOrder + ", ubFilter=" + ubFilter + "]";
    }

}
