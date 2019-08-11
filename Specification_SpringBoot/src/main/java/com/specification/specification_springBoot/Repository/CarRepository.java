package com.specification.specification_springBoot.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.specification.specification_springBoot.Model.Car;

/**
 * Class for Car Repository
 * 
 * @author Avinash Mahadeva
 *
 */
public interface CarRepository
    extends PagingAndSortingRepository<Car, Long>, JpaSpecificationExecutor<Car>, JpaRepository<Car, Long> {

    /**
     * Find List of Cars By Model Name
     * 
     * @param model Model Name
     * @return Matched Car Model
     */
    public List<Car> findByModel(String model);

    /** Get User By Name
     * 
     * @param name User Name
     * @return Matched User Names
     */
//    @Query(value = "select * from car_data where name=?1", nativeQuery = true)
    public List<Car> getUserByName(String name);

    /** Get Duration Between Start And EndDates
     * 
     * @param start_date Start Date
     * @param end_date End Date
     * @return 
     */
    @Query(value = "SELECT * FROM car_data where (start_date=?1 AND end_date=?2)", nativeQuery = true)
    public List<Car> getDurationBetweenStartAndEndDates(LocalDate start_date, LocalDate end_date);

    /** Get All Car Record By Date
     * @param localDate1 Date1
     * @param localDate2 Date2
     * @return
     */
    @Query(value = "SELECT * FROM car_data where (date_of_purchase BETWEEN ?1 AND ?2)", nativeQuery = true)
    public List<Car> getAllByDate(LocalDate localDate1, LocalDate localDate2);

    /** Get Record With Specific Date Of Purchase
     * 
     * @param date_of_purchase Date of purchase
     * @return list of matched records with specific date of purchase
     */
    @Query(value = "SELECT * FROM car_data where (date_of_purchase=?1)", nativeQuery = true)
    public List<Car> getRecordWithSpecificDateOfPurchase(LocalDate date_of_purchase);
    
  
    
}
