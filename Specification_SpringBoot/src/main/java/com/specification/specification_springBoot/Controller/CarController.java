package com.specification.specification_springBoot.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.specification.specification_springBoot.Model.Car;
import com.specification.specification_springBoot.Repository.CarRepository;
import com.specification.specification_springBoot.Specification.CarFilterSpecification;
import com.specification.specification_springBoot.SpecificationBuilder.UserSpecificationsBuilder;
import com.specification.specification_springBoot.UIWrapper.UIWrapper;
import com.specification.specification_springBoot.Utils.SearchCriteria;
import com.specification.specification_springBoot.datafilter.UIParam;
import com.specification.specification_springBoot.service.CarServiceImpl;

/**
 * Class for Car Controller
 * 
 * @author Avinash Mahadeva
 *
 */
@RestController
@RequestMapping(path = "car-api/")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarServiceImpl carServiceImpl;

    /**
     * Method to Create Car Record
     * 
     * @param car Car
     * @return saves the car record
     */
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public Car saveCarDetails(@RequestBody Car car) {
        return carRepository.save(car);
    }

    /**
     * Method to Update Car Record
     * 
     * @param car
     * @return updated car record
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Car updateCarDetails(@RequestBody Car car) {
        return carRepository.save(car);
    }

    /**
     * Method to Delete Car Record
     * 
     * @param id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void deleteCarDetails(@RequestParam Car id) {
        carRepository.delete(id);
    }

    /**
     * Method to Get Users
     * 
     * @return list of all the users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    /**
     * Method to Search User By Model Name
     * 
     * @param model model name
     * @return list of matched models
     */
    @RequestMapping(method = RequestMethod.GET, value = "/searchByModel")
    public List<Car> searchUserByModelname(@RequestParam String model) {
        return carRepository.findByModel(model);
    }

    /**
     * Method to Find All By user Name
     * 
     * @param name User Name
     * @return List of Matched User Names
     */
    @RequestMapping(method = RequestMethod.GET, value = "/get/user")
    public List<Car> findAllByUserName(@RequestParam String name) {
        return carRepository.getUserByName(name);
    }

    /**
     * Method to Find All By Date
     * 
     * @param date Date
     * @return list of matched records with Specific Date Of Purchase
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search/purchaseDate")
    public List<Car> findAllByDate(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        return carRepository.getRecordWithSpecificDateOfPurchase(localDate);
    }

    /**
     * Method to find All By Date
     * 
     * @param purchaseStartDate
     * @param purchaseEndDate
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public List<Car> findAllByDate(@RequestParam String purchaseStartDate, @RequestParam String purchaseEndDate) {
        LocalDate date1 = LocalDate.parse(purchaseStartDate);
        LocalDate date2 = LocalDate.parse(purchaseEndDate);
        return carRepository.getAllByDate(date1, date2);
    }

    /**
     * Method to Find All Dates Between Start And End
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/search/startAndEndDates")
    public List<Car> findAllDatesBetweenStartAndEnd(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate date1 = LocalDate.parse(startDate);
        LocalDate date2 = LocalDate.parse(endDate);
        return carRepository.getDurationBetweenStartAndEndDates(date1, date2);
    }

    /**
     * Method to Sort By Any Field
     * 
     * @param page Page Number
     * @param elementSize Element Size
     * @param fieldName Name of the Field
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/sortByField")
    public Page<Car> sortByAnyField(@RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "20") int elementSize,
        @RequestParam(required = true, defaultValue = "") String fieldName) {
        return carRepository.findAll(PageRequest.of(page, elementSize, Sort.by(Sort.Direction.ASC, fieldName)));
    }

    /**
     * Method to Filter Data
     * 
     * @param name User Name
     * @param age Age
     * @param cost Cost
     * @param address Address
     * @param model Model Name
     * @param pageNum Page Number
     * @param pageSize Page Size
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/filter")
    public @ResponseBody Iterable<Car> getFilterData(@RequestParam(required = false, defaultValue = "") String name,
        @RequestParam(required = false, defaultValue = "") String age,
        @RequestParam(required = false) Float cost,
        @RequestParam(required = false, defaultValue = "") String address,
        @RequestParam(required = false, defaultValue = "") String model,
        @RequestParam(required = false, defaultValue = "0") int pageNum,
        @RequestParam(required = false, defaultValue = "20") int pageSize) {

        CarFilterSpecification spec1 = new CarFilterSpecification(new SearchCriteria("name", ":", "%" + name + "%"));

        CarFilterSpecification spec2 = new CarFilterSpecification(new SearchCriteria("age", ":", age));

        CarFilterSpecification spec3 = new CarFilterSpecification(new SearchCriteria("address", ":", address));

        CarFilterSpecification spec4 = new CarFilterSpecification(new SearchCriteria("model", ":", model));

        Specification<Car> specGroup = Specification.where(spec1).and(spec2).and(spec3).and(spec4);

        if (cost != null) {
            CarFilterSpecification spec5 = new CarFilterSpecification(new SearchCriteria("cost", ":", cost));
            specGroup = specGroup.and(spec5);
        }

        Page<Car> findAll = carRepository.findAll(specGroup, PageRequest.of(pageNum, pageSize));
        System.err.println("Result Response= " + findAll.toString());

        return findAll;
    }

    /**
     * Search through pattern
     * 
     * @param search Search Element
     * @return list of matched data
     */
    @RequestMapping(method = RequestMethod.GET, value = "/filters")
    public List<Car> search(@RequestParam(value = "search") String search,
        @RequestParam(value = "or", required = false) String or,
        @RequestParam(value = "and", required = false) String and) {
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");

//        List<String> dataList1 = new ArrayList<String>(Arrays.asList(StringUtils.split(search, ",")));
//
//        Map<String, List<String>> dataMap = new HashMap<String, List<String>>();
//        for (String data2 : dataList1) {
//            String[] testDaStrings = data2.split(":");
//            if (dataMap.containsKey(testDaStrings[0])) {
//                dataMap.get(testDaStrings[0]).add(testDaStrings[1]);
//            } else {
//                List<String> newDataList = new ArrayList<String>();
//                newDataList.add(testDaStrings[1]);
//                dataMap.put(testDaStrings[0], newDataList);
//            }
//        }
 

        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Car> spec = builder.build();
        return carRepository.findAll(spec);
    }

    @RequestMapping(method = RequestMethod.POST, value = "advancedFilters")
    public UIWrapper getAllEntity(@RequestBody(required = false) UIParam uiParam) throws Exception {
        return carServiceImpl.filterAll(uiParam);
    }

}
