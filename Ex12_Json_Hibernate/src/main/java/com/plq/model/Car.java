package com.plq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CAR")
public class Car {
	@Id
	@Column(name = "NAMECAR")
	private String name;
	@Column(name="NUMBERPLATE")
	private int numberPlate;
	@Column(name="YEAROFMANUFACTURE")
	private int yearOfManufacture;
	@Column(name="BRAND")
	private String brand;
	@Column(name="HAVEPOSITIONDEVICE")
	private String havePositionDevice;
	@Column(name="HAVEPOWERSTEERING")
	private String havePowerSteering;
	@Column(name="ACTIONDURATION")
	private int actionDuration;
	
	@Transient
	private String otherFeature;

	public Car(String name, int numberPlate, int yearOfManufacture, String brand, String havePositionDevice,
			String havePowerSteering, int actionDuration) {
		super();
		this.name = name;
		this.numberPlate = numberPlate;
		this.yearOfManufacture = yearOfManufacture;
		this.brand = brand;
		this.havePositionDevice = havePositionDevice;
		this.havePowerSteering = havePowerSteering;
		this.actionDuration = actionDuration;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(int numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getHavePositionDevice() {
		return havePositionDevice;
	}

	public void setHavePositionDevice(String havePositionDevice) {
		this.havePositionDevice = havePositionDevice;
	}

	public String getHavePowerSteering() {
		return havePowerSteering;
	}

	public void setHavePowerSteering(String havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}

	public int getActionDuration() {
		return actionDuration;
	}

	public void setActionDuration(int actionDuration) {
		this.actionDuration = actionDuration;
	}
	
	

	public String getOtherFeature() {
		if(yearOfManufacture<=1995){
			return this.otherFeature = "actionDuration: "+actionDuration +" years";
		}else if(yearOfManufacture<2005){
			return this.otherFeature="havePowerSteering: " + havePowerSteering;
		}else{
			return this.otherFeature="havePositionDevice: " + havePositionDevice;
		}
		 
	}



	@Override
	public String toString() {
		return "Car [name=" + name + ", numberPlate=" + numberPlate + ", yearOfManufacture=" + yearOfManufacture
				+ ", brand=" + brand + ", havePositionDevice=" + havePositionDevice + ", havePowerSteering="
				+ havePowerSteering + ", actionDuration=" + actionDuration + "]";
	}
	
	

}
