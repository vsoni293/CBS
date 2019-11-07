package com.cg.cabbookingsystem.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cabbookingsystem.dto.Booking;
import com.cg.cabbookingsystem.dto.Customer;
import com.cg.cabbookingsystem.dto.CustomerRequest;
import com.cg.cabbookingsystem.dto.Location;
import com.cg.cabbookingsystem.dto.Vehicle;
import com.cg.cabbookingsystem.repo.CustomerRepo;
 
/**
 * Implementation of the service layer for the cab allocation microservice
 * @author Vishal
 * @version 1.0
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo repo;
	@Autowired
	public CustomerServiceImpl(CustomerRepo repo) {
		this.repo = repo;
	}
	
	/**
	 * List the vehicles that are within the 3KM radius of the customer pickup location
	 * @param CustomerRequest
	 * 			Contains source, destination and vehicle type as requested by the customer
	 * @return List<Vehicle>
	 * 			List of available vehicles that close to the pickup location 
	 */
	@Override
	public List<Vehicle> getNearByVehicles(CustomerRequest req) {

		List<Vehicle> availableVehicles = repo.getAvailableVehicles(req);
		Location location;
		Location source;
		List<Vehicle> nearByVehicles = new ArrayList<Vehicle>();
		for (Vehicle vehicle : availableVehicles) {
			source = repo.getLocationByName(req.getSource());
			location = repo.getLocationByName(req.getDestination());
			double distance = Math.hypot((source.getxCoordinate()-location.getxCoordinate()), (source.getyCoordinate()-location.getyCoordinate()));
			if(distance <= 3)
				nearByVehicles.add(vehicle);
		}
		return nearByVehicles;
		
	}

	/**
	 * Get the booking details to the database
	 * @param Booking
	 * 			Contains the details to be saved to the database
	 * @return Booking
	 * 			
	 */
	@Override
	public Booking bookACab(Booking booking) {
		return repo.bookACab(booking);
	}

	/**
	 * Fetches the list of past trips for a particular customer
	 * @param Customer
	 * 			Details of the customers whos past trips we need to retrieve
	 * @return List<Booking>
	 * 			List of past trips for a particular customer
	 */
	@Override
	public List<Booking> pastTrips(Customer customer) {
		return repo.pastTrips(customer);
	}

}
