package com.plq.service;

import java.util.List;

import com.plq.model.Car;
import com.plq.model.Insurance;
import com.plq.model.Insurance_Car;

public interface InsuranceService {

	List<Insurance> getAllInsurance();

	List<Insurance> getAvaiInsurance();

	String addIns(Insurance insurance);

	Insurance editIns(String insName, String insType);
	
	Insurance delete(String insName);
	
	List<Insurance_Car> getAllIns_Car();
	List<Insurance> getInsByType(String type);

}
