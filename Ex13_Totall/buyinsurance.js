var myBuyApp = angular.module("buyApp",[]);


myBuyApp.controller("buyController",function($scope,$http){
	$scope.displayInsForSell="none";
	$http.get("http://localhost:8080//api/cars/listAvaiCars").then(function (response) {
		$scope.listCars = response.data;
	});

	$scope.chooseCar = function(car){
		$scope.displayInsForSell="block";
		$scope.carbuy= "Your "+car.name +" will buy:";

		var type='';
		if(car.yearOfManufacture<=1995){
			type='C';
		}else if(car.yearOfManufacture<2005){
			type='B';
		}else{
			type='A';
		}

		$http.get("http://localhost:8080/api/insurance/insListForSelling/"+type).then(function(response){
			$scope.listIns=response.data;
		});


		$scope.chooseIns=function(ins){

			var newPack = {
				"car": {
					"name": car.name
					

				},
				"insurance":{
					"name":ins.name,
					"type":ins.type
				}

			};


			$http({
				method:"POST",
				url:'http://localhost:8080//api/cars/buyInsurance',
				data:angular.toJson(newPack),
				headers: {
					'Content-Type':'application/json'
				}
			}).then();
			location.reload();
			alert("Success!")

		}



	}


	
	
});