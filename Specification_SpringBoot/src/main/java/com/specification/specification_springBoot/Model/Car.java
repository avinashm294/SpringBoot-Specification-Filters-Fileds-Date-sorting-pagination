package com.specification.specification_springBoot.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.persistence.*;

/**
 * Car entity
 * 
 * @author Avinash Mahadeva
 *
 */
@Data
@Component
@NoArgsConstructor
@Entity
@Table(name = "car_data")
public class Car {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private String age;

	@Column(name = "cost")
	private Float cost;

	@Column(name = "address")
	private String address;

	@Column(name = "model")
	private String model;

	@Column(name = "date_of_purchase")
	private Date date_of_purchase;

	@Column(name = "start_date")
	private Date start_date;

	@Column(name = "end_date")
	private Date end_date;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id set the id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name set the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age set the age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the cost
	 */
	public Float getCost() {
		return cost;
	}

	/**
	 * @param cost Set the cost
	 */
	public void setCost(Float cost) {
		this.cost = cost;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address Set the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return model the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model Set Model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the date_of_purchase
	 */
	public Date getDate_of_purchase() {
		return date_of_purchase;
	}

	/**
	 * @param date_of_purchase
	 */
	public void setDate_of_purchase(Date date_of_purchase) {
		this.date_of_purchase = date_of_purchase;
	}

	/**
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param start_date set the start date
	 */
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date Set the End Date
	 */
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	/**
	 * Default Constructor
	 */
	public Car() {
	}

	/** 
	 * Parameterized Constructor
	 * 
	 * @param id id of the User
	 * @param name User Name
	 * @param age Age
	 * @param cost Cost
	 * @param address Address
	 * @param model Model Name
	 * @param date_of_purchase Date of Purchase
	 * @param start_date Start Date
	 * @param end_date End Date
	 */
	public Car(Long id, String name, String age, Float cost, String address, String model, Date date_of_purchase,
			Date start_date, Date end_date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.cost = cost;
		this.address = address;
		this.model = model;
		this.date_of_purchase = date_of_purchase;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	@Override
    public String toString() {
        return "Car [id=" + id + ", name=" + name + ", age=" + age + ", cost=" + cost + ", address=" + address
                + ", model=" + model + ", date_of_purchase=" + date_of_purchase + ", start_date=" + start_date
                + ", end_date=" + end_date + "]";
    }


}
