package com.plq.service;

import java.util.List;

import com.plq.model.Car;
import com.plq.model.Insurance;
import com.plq.model.Insurance_Car;

public interface CarService {

	List<Car> getAllCars();
	List<Car> getAvaiCars();
	String addCar(Car car);
	Car editCar(String carName, int numberPlate,int yearOfManufacture,String brand,String havePositionDevice,String havePowerSteering,int actionDuration);
	Car deleteCar(String carName);
	void buyInsurance(Insurance_Car insurance_Car);
	List<Car> getCarByName(String name);
	boolean checkCarExisted(String name);
}
