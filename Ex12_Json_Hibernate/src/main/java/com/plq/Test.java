package com.plq;

import java.util.List;

import org.hibernate.SessionFactory;

import com.plq.model.Car;
import com.plq.model.Insurance;
import com.plq.model.Insurance_Car;
import com.plq.service.CarService;
import com.plq.service.CarServiceImpl;
import com.plq.service.InsuranceService;
import com.plq.service.InsuranceServiceImpl;
import com.plq.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println(sessionFactory);
		
		CarService carsService = new CarServiceImpl();
		InsuranceService insService = new InsuranceServiceImpl();
//		List<Insurance>  listIns = insService.getAllInsurance();
//		System.out.println("Size of ins list: "+ listIns.size());
//		
//		List<Insurance> avaiInsList = insService.getAvaiInsurance();
//		System.out.println("Size of available ins list: "+ avaiInsList.size());
//		
//		List<Insurance_Car> insCarList = insService.getAllIns_Car();
//		System.out.println("Size of insCarList: "+insCarList.size());
//		
//		List<Insurance> avaiInsListForSelling = insService.getInsByType("B");
//		int amount = avaiInsListForSelling.size();
//		System.out.println("Amount: "+amount);
		
		List<Car> list = carsService.getAvaiCars();
		System.out.println(list.size()+" size of list");
		
//		Insurance insurance = new Insurance("Quang ham", "B");
		
//		insService.addIns(insurance);
		
//		insService.editIns("pack5", "C");
//		insService.delete("pack5");
		
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		System.out.println(sessionFactory);
//		CarService carService = new CarServiceImpl();
//
//		List<Car> listAllCars = carService.getAllCars();
//		System.out.println("--------------List of all cars: ");
//		for (int i = 0; i < listAllCars.size(); i++) {
//			System.out.println(listAllCars.get(i).getName());
//
//		}
//
//		System.out.println("------------Get car by car name: ");
//		List<Car> carList = carService.getCarByName("carD");
//
//		System.out.println(carList.get(0));
//
//		List<Car> listAvaiCars = carService.getAvaiCars();
//		System.out.println("---------------List of all available cars: ");
//		for (int i = 0; i < listAvaiCars.size(); i++) {
//			System.out.println(listAllCars.get(i).getName());
//
//		}
//		try {
//			String t = carService.addCar(new Car("CarDuong", 12345, 1990, "Honda", "Yes", "Yes", 10));
//			System.out.println("------------Đã Thêm: ");
//			System.out.println(t);
//		} catch (Exception ex) {
//			System.out.println("------------Đã tồn tại ô tô này!");
//		}
//
//		try {
//
//			Car car = carService.editCar("CarQuynh", 2018, 1990, "PLQ", "Yes", "No", 29);
//			System.out.println("------------Thông tin ô tô sau khi sửa: ");
//			System.out.println(car);
//
//		} catch (Exception ex) {
//			System.out.println("------------Lỗi sửa");
//		}
//
//		List<Car> listAllCarsAfter = carService.getAllCars();
//		System.out.println("--------------List of all cars After Updating: ");
//		for (int i = 0; i < listAllCarsAfter.size(); i++) {
//			System.out.println(listAllCars.get(i).getName());
//
//		}
//
//		System.out.println("------------Get car by car name: ");
//		List<Car> carList1 = carService.getCarByName("carD");
//		Car car = carList1.get(0);
//		System.out.println(car);

//		try {
//			Car carbuy = new Car();
//			carbuy.setName("carS");
//			Insurance insurancebuy = new Insurance("pack13", "A");
//			carService.buyInsurance(carbuy, insurancebuy);
//
//			System.out.println("---------------Mua bảo hiểm: ");
//			System.out.println("Success");
//
//		} catch (Exception ex) {
//			System.out.println("Lỗi mua bảo hiểm---------------");
//			ex.printStackTrace();
//
//		}
//
//		try {
//			Car cardeleted = carService.deleteCar("car1111");
//			System.out.println("------------------Thông tin ô tô bị xóa");
//			System.out.println(cardeleted);
//
//		} catch (Exception ex) {
//
//		}


	}

}
