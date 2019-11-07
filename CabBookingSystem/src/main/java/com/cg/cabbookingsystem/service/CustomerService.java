package com.cg.cabbookingsystem.service;

import java.util.List;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Vehicle;

public interface CustomerService {

	/**
	 * List the vehicles that are within the 3KM radius of the customer pickup location
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of available vehicles that close to the pickup location 
	 */
	public List<Vehicle> getNearByVehicles(CustomerRequest req) ;
	
	/**
	 * Get the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	public Booking bookACab(Booking booking);
	
	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers whos past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	public List<Booking> pastTrips(Customer customer);
}
