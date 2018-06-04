package com.plq.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import com.plq.model.Car;
import com.plq.model.Insurance_Car;
import com.plq.util.HibernateUtil;

@Service
public class CarServiceImpl implements CarService {
	SessionFactory sessionFactory;

	public CarServiceImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Override
	public List<Car> getAllCars() {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		String hql = "from Car";
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Car> result = (List<Car>) query.list();

		currentSession.getTransaction().commit();
		currentSession.close();
		return result;
	}

	@Override
	public List<Car> getAvaiCars() {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		String hql = "from Car where name not in (select ci.car.name from Insurance_Car ci inner join ci.car)";
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Car> result = (List<Car>) query.list();

		currentSession.getTransaction().commit();
		currentSession.close();

		return result;
	}

	@Override
	public String addCar(Car car) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		String t = (String) currentSession.save(car);

		currentSession.getTransaction().commit();
		currentSession.close();
		return t;
	}

	@Override
	public Car editCar(String carName, int numberPlate, int yearOfManufacture, String brand, String havePositionDevice,
			String havePowerSteering, int actionDuration) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		Car currentCar = currentSession.find(Car.class, carName);
		currentCar.setNumberPlate(numberPlate);
		currentCar.setYearOfManufacture(yearOfManufacture);
		currentCar.setBrand(brand);
		currentCar.setHavePositionDevice(havePositionDevice);
		currentCar.setHavePowerSteering(havePowerSteering);
		currentCar.setActionDuration(actionDuration);
		currentSession.update(currentCar);

		currentSession.getTransaction().commit();
		currentSession.close();

		return currentCar;

	}

	@Override
	public Car deleteCar(String carName) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		Car currentCar = currentSession.find(Car.class, carName);
		currentCar.setName(carName);
		currentSession.remove(currentCar);

		currentSession.getTransaction().commit();
		currentSession.close();

		return currentCar;
	}

	@Override
	public void buyInsurance(Insurance_Car insurance_car) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		// Insurance_Car insurance_Car = new Insurance_Car();
		// insurance_Car.setCar(car);
		// insurance_Car.setInsurance(insurance);

		currentSession.save(insurance_car);
		currentSession.getTransaction().commit();
		currentSession.close();

	}

	@Override
	public List<Car> getCarByName(String name) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		String hql = "from Car c where c.name='" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Car> result = (List<Car>) query.list();

		currentSession.getTransaction().commit();
		currentSession.close();
		return result;

	}

	@Override
	public boolean checkCarExisted(String name) {
		boolean check = false;

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		String hql = "from Car c Where c.name ='" + name + "'";
		@SuppressWarnings("rawtypes")
		Query query = currentSession.createQuery(hql);
		@SuppressWarnings("rawtypes")
		List listCheck = query.list();

		if (listCheck != null) {
			check = true;
		} else {
			check = false;
		}

		currentSession.getTransaction().commit();
		currentSession.close();
		return check;
	}

}
