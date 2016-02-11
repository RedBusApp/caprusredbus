var app1=angular.module('myApp', ['ngAnimate', 'ui.bootstrap']);
app1.controller('ModalDemoCtrl',function($scope,$http){
	 $scope.busstopids=[];
		   /* autocomplete to get employee ids or names */
		   $scope.getCheck=function()
			{
			   if($scope.from_city_id.length==0)
				   {
				   $scope.busstopids=[];
				   }
		  if($scope.from_city_id.length==1 && $scope.busstopids.length==0)
			    {
				$http({
			             method : 'POST',
			             url : 'getAllStopsForAutoComplete.do',
			                  
			     }).success(function(data, status, headers, config) {
			    	 console.log("data eturned: "+typeof data);
			    	var arr=[];
			    	var i=0;
			    	//for(v)
			    	 angular.forEach(data, function(value, key){
			    		  $scope.busstopids.push(value+"");
			    		 arr.push(value);
			    	 });
			    	 
			    	 console.log("arr : "+arr);
			    	 /*alert($scope.employeeids);*/
			    /*	$scope.complete1();*/
		  }).error(function(data, status, headers, config) {
		 	 $scope.result ="error occured due to internal proble please try again id auto" ;
		 	 });
			
				}
			};
});