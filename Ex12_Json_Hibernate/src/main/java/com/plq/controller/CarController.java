package com.plq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.plq.model.Car;
import com.plq.model.Insurance_Car;
import com.plq.service.CarService;

@RestController
@RequestMapping(value = "/api/cars/")
public class CarController {

	@Autowired
	CarService carService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hi!";
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = { "/listCars" })
	public List<Car> carsList() {

		List<Car> listAllCars = carService.getAllCars();

		return listAllCars;

	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = { "/listAvaiCars" })

	public List<Car> avaiCarsList() {
		List<Car> listAvaiCars = carService.getAvaiCars();
		return listAvaiCars;
	}

	@CrossOrigin
	@PostMapping(value = { "/addCar" })
	public String addCar(@RequestBody Car car) {
		String t = carService.addCar(car);
		boolean check = carService.checkCarExisted(car.getName());
		if (check == true) {
			t = "Existed!";
		}

		return t;
	}

	@CrossOrigin
	@DeleteMapping(value = { "/deleteCar/{carName}" })
	public void delete(@PathVariable String carName) {
		carService.deleteCar(carName);

	}

	@CrossOrigin
	@PutMapping(value = {
			"/updateCar/{carName}/{numberPlate}/{yearOfM}/{brand}/{havePositionDevice}/{havePowerSteering}/{actionDuration}" })
	public void edit(@PathVariable String carName, @PathVariable int numberPlate, @PathVariable int yearOfM,
			@PathVariable String brand, @PathVariable String havePositionDevice, @PathVariable String havePowerSteering,
			@PathVariable int actionDuration) {
		carService.editCar(carName, numberPlate, yearOfM, brand, havePositionDevice, havePowerSteering, actionDuration);

	}

	@CrossOrigin
	@PostMapping(value = { "/buyInsurance" })
	public void buyInsurance(@RequestBody Insurance_Car insurance_car) {
		carService.buyInsurance(insurance_car);
	}

}
