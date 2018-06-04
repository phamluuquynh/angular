package com.plq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plq.model.Insurance;
import com.plq.model.Insurance_Car;
import com.plq.service.InsuranceService;

@RestController
@RequestMapping(value = "/api/insurance/")
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;
	@CrossOrigin
	@GetMapping(value = { "/insuranceList" })
	public List<Insurance> getInsuranceList() {
		List<Insurance> insuranceList = insuranceService.getAllInsurance();
		return insuranceList;

	}
	@CrossOrigin
	@GetMapping(value={"/avaiInsList"})
	public List<Insurance> getAvaiInsList(){
		List<Insurance> avaiInsList = insuranceService.getAvaiInsurance();
		return avaiInsList;
	}
	@CrossOrigin
	@PostMapping(value={"/addInsurance"})
	public String addInsurance(@RequestBody Insurance insurance){
		String t = insuranceService.addIns(insurance);
		
		return t;
	}
	@CrossOrigin
	@PutMapping(value={"/editInsurance/{insName}/{insType}"})
	public Insurance editInsurance(@PathVariable String insName, @PathVariable String insType){
		Insurance insurance = insuranceService.editIns(insName, insType);
				return insurance;
	}
	@CrossOrigin
	@DeleteMapping(value={"/deleteInsurance/{insName}"})
	public Insurance deleteInsurance(@PathVariable String insName){
		Insurance insurance = insuranceService.delete(insName);
		return insurance;
	}
	@CrossOrigin
	@GetMapping(value={"/insCarList"})
	public List<Insurance_Car> getInsCarList(){
		List<Insurance_Car> insCarList = insuranceService.getAllIns_Car();
		return insCarList;
	}
	@CrossOrigin
	@GetMapping(value={"/insListForSelling/{type}"})
	public List<Insurance> insListForSelling(@PathVariable String type){
		return insuranceService.getInsByType(type);

	}

}
