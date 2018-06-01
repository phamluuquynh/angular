var myInsuranceApp = angular.module('myInsuranceModule', []);
myInsuranceApp.controller('myInsuranceController', function($scope, $http) {


// Hiển thị danh sách insurance hiện có:
	$http.get("http://localhost:8080//api/insurance/insuranceList").then(function (response) {
		$scope.listInsurance = response.data;
	});

// Chức năng delete insurance:
$scope.deleteIns=function(insurance){
     if(insurance.bought==true){
     	alert("Không thể xóa bảo hiểm đã được bán");
			return;
     }

  //    $http({
		// 	method:"GET",
		// 	url:'http://localhost:8081/EX09_JSON_DAY14_M5/DeleteInsurance?insName='+insurance.insuranceName+''
		// }).then(function(response){
		// 	alert(response.data);
		// 	location.reload();
		// });

		$http({
			method:"DELETE",
			url:'http://localhost:8080//api/insurance/deleteInsurance/'+insurance.name+''
		}).then(function(){
			location.reload();
		});
		

}

// Chọn gói bảo hiểm cần edit
$scope.chooseIns= function(insurance){
	if(insurance.bought==true){
		alert("Không thể sửa đổi thông tin gói bảo hiểm đã bán");
		return;
	}

	    $scope.insName= insurance.name;
		$scope.insType= insurance.type;
		document.getElementById("insName").disabled = true;
	
}

//Chức năng edit gói bảo hiểm:
$scope.editIns=function(insName,insType){
	if(insType != "A" && insType !="B" && insType !="C"){
			alert("Loại bảo hiểm phải là A hoặc B hoặc C");
			return;
		}

		// $http(
		// {
		// 	method : "GET",
		// 	url : 'http://localhost:8081/EX09_JSON_DAY14_M5/EditInsurance?insuranceName='+insName+'&insuranceType='+insType
		// }).then(function(response){
		// 	alert(response.data);
		// 	location.reload();
		// });

		$http({
			method:"PUT",
			url:'http://localhost:8080//api/insurance/editInsurance/'+insName+'/'+insType+''
		}).then(function(){
			location.reload();
		});
		

}


// Chức năng insert new insurance:
$scope.insertIns = function(insName, insType){

		if(!insName){
			alert("Tên bảo hiểm không được để trống");
			return;
		}
		if(insType != "A" && insType !="B" && insType !="C"){
			alert("Loại bảo hiểm phải là A hoặc B hoặc C");
			return;
		}
		// $http(
		// {
		// 	method : "GET",
		// 	url : 'http://localhost:8081/EX09_JSON_DAY14_M5/addNewInsurance?nameinsurance='+insName+'&typeinsurance='+insType
		// }).then(function(response){
		// 	alert(response.data);
		// 	location.reload();
		// });

		// var newIns ={
		// 	 name: insName,
  //            type: insType
		// };

		$http({
			method:"POST",
			url:'http://localhost:8080/api/insurance/addInsurance',
			data: {
			 "name": "p12345",
             "type": "A"
			},
			headers: {
				'Content-Type':'application/json'
			}
		}).then(function(){
          location.reload();
         }).catch(function(error) {
         	console.log(error.message);
         });
		
	}

});


function myFunction(){
	document.getElementById("addBtn").disabled = true;
	document.getElementById("edtBtn").disabled = false;
}

