package com.specification.specification_springBoot.UIWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Generic Object
 * 
 * @author Avinash
 *
 */
public class UIWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private long totalRecords;

    private List<Object> objects = new ArrayList<>();

    /**
     * @return the object
     */
    public List<Object> getObjects() {
        return objects;
    }

    /**
     * @param objects the object to set
     */
    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    /**
     * Method to retrieve Total Records
     * 
     * @return totalRecords Number of Total Records
     */
    public long getTotalRecords() {
        return totalRecords;
    }

    /**
     * Method to set Total Records
     * 
     * @param totalRecords Number of Total Records
     */
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
}

