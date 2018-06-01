

var myCarApp = angular.module('carApp', []);


myCarApp.controller('carController', function($scope, $http) {

	$scope.displayInfor = "none";
	$http.get("http://localhost:8080//api/cars/listCars").then(function (response) {
		$scope.listCars = response.data;
	});

// Tạo chức năng cho các phần chọn add newcar
$scope.carNewFunction=function(){
	alert("Enter new car information:");
	$scope.displayInfor = "block";
	$scope.steering=null;
	$scope.duration=null;
	document.getElementById("btnAddCar").style.display="block";
	document.getElementById("btnEditCar").style.display="none";
	document.getElementById("newCarInfor").disabled = false;
	document.getElementById("mediumCarInfor").disabled = true;
	document.getElementById("mediumCarInfor").value = null;
	document.getElementById("oldCarInfor").disabled = true;
	document.getElementById("oldCarInfor").value = null;
}
//Tạo chức năng cho các phần chọn add medium car
$scope.carMeFunction=function(){
	alert("Enter medium car information:");
	$scope.displayInfor = "block";
	$scope.duration=null;
	$scope.position=null;
	document.getElementById("btnAddCar").style.display="block";
	document.getElementById("btnEditCar").style.display="none";
	document.getElementById("newCarInfor").disabled = true;
	document.getElementById("newCarInfor").value = null;
	document.getElementById("mediumCarInfor").disabled = false;
	document.getElementById("oldCarInfor").disabled = true;
	document.getElementById("oldCarInfor").value = null;
}
// Tạo chức năng cho các phần chọn add oldcar
$scope.carOldFunction=function(){
	$scope.position = null;
	$scope.steering = null;
	alert("Enter old car information:");
	$scope.displayInfor = "block";
	document.getElementById("btnAddCar").style.display="block";
	document.getElementById("btnEditCar").style.display="none";
	document.getElementById("newCarInfor").disabled = true;
	document.getElementById("newCarInfor").value = null;
	document.getElementById("mediumCarInfor").disabled = true;
	document.getElementById("mediumCarInfor").value = null;
	document.getElementById("oldCarInfor").disabled = false;
}
// Chức năng chọn car cần edit
$scope.chooseCar=function(car){
	alert("Edit this car:")
	$scope.displayInfor = "block";
	document.getElementById("btnAddCar").style.display="none";
	document.getElementById("btnEditCar").style.display="block";
	document.getElementById("newCarInfor").disabled = false;
	document.getElementById("oldCarInfor").disabled = false;
	document.getElementById("mediumCarInfor").disabled = false;
	document.getElementById("carName").disabled=true;

	$scope.carName=car.name;
	$scope.plateNumber=car.numberPlate;
	$scope.yearOfM=car.yearOfManufacture;
	$scope.brand=car.brand;

	if($scope.yearOfM>=2005){
		$scope.position=car.otherFeature;
		$scope.steering=null;
		$scope.duration=null;
	}else if($scope.yearOfM>=1996){
		$scope.steering=car.otherFeature;
		$scope.position=null;
		$scope.duration=null;
	}else{
		$scope.duration=car.otherFeature;
		$scope.position=null;
		$scope.steering=null;
	}
	
	
	
}

// Chức năng edit:

$scope.editCar=function(carName,plateNumber,yearOfM,brand,position,steering,duration){
	if(carName==null||plateNumber==null||yearOfM==null||brand==null){
		alert("empty!");
		return;
	}

	if((!position)&&(!steering)&&(!duration)){
		alert("empty!");
		return;
	}

	if(duration&&yearOfM>1995){
	//	debugger;
	alert("Fill yearOfM <=1995");
	return;
}

if(position&&yearOfM<2005){
	//	debugger;
	alert("Fill yearOfM>=2005");
	return;
}

if(steering&&yearOfM>2004||steering&&yearOfM<1996){
		//debugger;
		alert("Fill yearOfM from 1996 - 2004");
		return;
	}

	
	// $http(
	// {
	// 	method : "GET",
	// 	url : 'http://localhost:8081/EX09_JSON_DAY14_M5/EditCar?carName='+carName+'&numberPlate='+plateNumber+'&yearOfM='+yearOfM+'&brand='+brand+'&position='+position+'&steering='+steering+'&duration='+duration+''
	// }).then(function(response){
	// 	alert(response.data);
	// 	location.reload();
	// });

	$http({
		method:"PUT",
		url:'http://localhost:8080//api/cars/updateCar/'+carName+'/'+plateNumber+'/'+yearOfM+'/'+brand+'/'+position+'/'+steering+'/'+duration+''
	}).then(function(){
        alert("Success!");
        location.reload();
	});
}


// Add Car:

$scope.insertCar=function(carName,plateNumber,yearOfM,brand,position,steering,duration){
	// // alert("test");

	if((!carName)||(!plateNumber)||(!yearOfM)||(!brand)||(carName.includes('#'||'@'||'!'||'$'||'%'||'^'||'&'))){
		alert("empty! or includes ký tự đặc biệt!");
		return;
	}

	if((!position)&&(!steering)&&(!duration)){
		alert("empty!");
		return;
	}

	if(duration&&yearOfM>1995){
	//	debugger;
	alert("Fill yearOfM <=1995");
	return;
}

if(position&&yearOfM<2005){
	//	debugger;
	alert("Fill yearOfM>=2005");
	return;
}

if(steering&&yearOfM>2004||steering&&yearOfM<1996){
		//debugger;
		alert("Fill yearOfM from 1996 - 2004");
		return;
	}


	// $http(
	// {
	// 	method : "GET",
	// 	url : 'http://localhost:8081/EX09_JSON_DAY14_M5/AddNewCar?carName='+carName+'&numberPlate='+plateNumber+'&yearOfM='+yearOfM+'&brand='+brand+'&position='+position+'&steering='+steering+'&duration='+duration+''
	// }).then(function(response){
	// 	alert(response.data);
	// 	location.reload();
	// });

	var newcar = {
		"name":carName ,
        "numberPlate": plateNumber,
        "yearOfManufacture":yearOfM,
        "brand": brand,
        "havePositionDevice": position,
        "havePowerSteering": steering,
        "actionDuration": duration
	};

	$http(
	{
		method : "POST",
		url : 'http://localhost:8080//api/cars/addCar',
		data:angular.toJson(newcar),
		headers: {
			'Content-Type':'application/json'
		}

	}).then(function(){
		location.reload();

	}).catch(function(){
		location.reload();
	});
	

}

//Delete Car

$scope.deleteCar=function(car){
   if(car.haveInsurance){
	  alert("You can not delete car having insurance!");
	  return;
    }

    
    var r = confirm("You really want to delete this car?");
    if (r == true) {
 //        $http(
	// {
	// 	method : "GET",
	// 	url : 'http://localhost:8081/EX09_JSON_DAY14_M5/DeleteCar?carName='+car.carName+''
	// }).then(function(response){
	// 	alert(response.data);
	// 	location.reload();
	// });

	$http({
       method:"DELETE",
       url:'http://localhost:8080//api/cars/deleteCar/'+car.name+''
	}).then(function(){
		alert("Success!")
		location.reload();
	});

    }

	
}

	// $scope.insertCar1 = function(){

	// 	var newcar = {
	// 	name: "Quang",
 //        numberPlate: 123,
 //        yearOfManufacture: 1990,
 //        brand: "Honda",
 //        havePositionDevice: null,
 //        havePowerSteering: null,
 //        actionDuration: 20
	// };
	// 	$http({
	// 		method: "POST",
	// 		url : 'http://localhost:8080//api/cars/addCar',
	// 		data:angular.toJson(newcar),
	// 		headers: {
	// 			'Content-Type':'application/json'
	// 		}
	// 	}).then();
	// 	location.reload();
	// }

});

