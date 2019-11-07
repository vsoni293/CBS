package com.cg.cabbookingsystem.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.CustomerRepo;
import com.cg.cabbookingsystem.service.CustomerService;

/**
 * Rest Controller for the cab allocation microservice
 * @author Vishal
 *
 */
@RestController
@RequestMapping(value = "/customer")
//http://localhost:8082/customer
public class CustomerController {

	private CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	/**
	 * List the vehicles that are within the 3KM radius of the customer pickup location
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of available vehicles that close to the pickup location 
	 */
	//http://localhost:8082/customer/nearByVehicle
	@PostMapping(value = "/nearByVehicle", consumes = "application/json", produces = "application/json")
	public List<Vehicle> getNearByVehicle(@RequestBody CustomerRequest req){
		return service.getNearByVehicles(req);
	}
	
	/**
	 * Get the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	//http://localhost:8082/customer/bookACab
	@PostMapping(value = "/bookACab", consumes = "application/json")
	public Booking bookACab(@RequestBody Booking booking) {
		return service.bookACab(booking);
	}
	
	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers who's past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	//http://localhost:8082/customer/pastTrips
	@PostMapping(value = "/pastTrips")
	public List<Booking> pastTrips(@RequestBody Customer customer){
		return service.pastTrips(customer);
	}
}
