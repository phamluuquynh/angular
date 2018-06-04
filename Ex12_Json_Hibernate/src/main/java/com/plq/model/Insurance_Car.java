package com.plq.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CAR_INSURANCE")
public class Insurance_Car implements Serializable {
	@Id
	@OneToOne
	@JoinColumn(name="NAMECAR")
	private Car car;
	
	@Id
	@OneToOne
	@JoinColumn(name="NAMEINSURANCE")
	private Insurance insurance;
	
	public Insurance_Car(Car car, Insurance insurance) {
		super();
		this.car = car;
		this.insurance = insurance;
	}
	public Insurance_Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	
	
}
