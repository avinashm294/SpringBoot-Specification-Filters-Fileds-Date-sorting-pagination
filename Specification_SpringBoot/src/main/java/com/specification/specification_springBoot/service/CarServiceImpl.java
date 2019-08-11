package com.specification.specification_springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.specification.specification_springBoot.UIWrapper.UIWrapper;
import com.specification.specification_springBoot.datafilter.UIParam;

@Component
public class CarServiceImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UIWrapper filterAll(UIParam uiParam) {

        // jdbcTemplate.execute("select* from car_data");

        String str = jdbcTemplate.queryForObject(
            "select cost from car_data where " + uiParam.getUbFilter().getUbFilterDetails().get(0).getFilterField() +
                "=" + "'" + uiParam.getUbFilter().getUbFilterDetails().get(0).getFilterValue() + "'",
            String.class);
        List<Object> list = new ArrayList<>();
        list.add(str);

        UIWrapper uiWrapper = new UIWrapper();
        uiWrapper.setObjects(list);

        System.err.println("resultant query" + str);
        
        System.err.println("resultant query" + uiParam.getUbFilter().getUbFilterDetails());

        System.err.println("uiParam.getUbFilter().getUbFilterDetails()=" + uiParam.getUbFilter().getUbFilterDetails().get(0).getFilterField());

        return uiWrapper;
    }
}
