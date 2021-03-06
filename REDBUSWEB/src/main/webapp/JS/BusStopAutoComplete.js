
'use strict';

App.controller('ModalDemoCtrl'['$scope', 'MyService','$log',function($scope){
	
	 $scope.busstopids=[];
	 
	 //$scope.from_city_id="";
	 var sourceBusStopName="";
	 var destinationBusStopName="";
	 var sourceBusStopId;
	 var destinationBusStopId;
	 
	 /*function call to getAllBusStops*/
	 getAllBusStopsThroughHttp();
	 
	 
	 function getAllBusStopsThroughHttp(){
		 
		 MyService.getAllBusStopsForAuocomplete()
         .then(
                      function(d) {
                    	    console.log("in controller (retuirned from service: )"+d);
                           self.users = d;
                           
                      },
                       function(errResponse){
                           console.error('Error while fetching Currencies');
                       }
              );
		 
		 
		/* $http({
             method : 'POST',
             url : 'getAllStopsForAutoComplete.do',
                  
          }).success(function(data, status, headers, config) {
    	         console.log("data eturned: "+data);
    	         $scope.busstopids=data;
    	        
          }).error(function(data, status, headers, config) {
	            $scope.result ="error occured due to internal proble please try again id auto" ;
	      });*/
		 
	  }; // END -- getAllBusStops()
	  
	  /**
	   * This function executes when user selected item from list
	   * of source busStops
	   */
	  $scope.selectedSourceBusStop=function(item){
		  
		  //console.log("type ahead is selected");
		  console.log("from city id: "+item[0]);
		  sourceBusStopName=item[1];
		  sourceBusStopId=item[0];
		  
	  };
	  
	  /**
	   * This function executes when user selected item from list
	   * of destination busStops
	   */
	  $scope.selectedDestinationBusStop=function(item){
		  
		  destinationBusStopName=item[1];
		  destinationBusStopId=item[0];
	  };
	  
	  /**
	   * This function is to format source bus stop name
	   */
	  $scope.formatSourceStopName=function(){
		  
		  //console.log("input formatter ..");
		  return sourceBusStopName;
	  };
	  
	  /**
	   * This function is to format destination bus stop name
	   */
	  $scope.formatDestinationStopName=function(){
		  return destinationBusStopName;
	  };
	  
	  /**
	   * This function executes when user clicks on search busses button
	   */
	  $scope.searchBusses=function(){
		  
		  console.log("source stop id: "+sourceBusStopId);
		  console.log("destination stop id: "+destinationBusStopId);
		  console.log("source stop name(scope ): "+$scope.from_city_id);
		  console.log("destination stop name(scope ): "+$scope.to_city_id);
		  console.log("source stop name(stored ): "+sourceBusStopName);	
		  console.log("destination stop name(stored ): "+destinationBusStopName);
		  
		  /*function call to validate user inputs*/
		  valiateUserInputs();
	  };
	  
	  /**
	   * This function is to validate user inputs
	   */
	  function valiateUserInputs(){
		  
		  var validationMessage="ok";
		  var invalidInputFlag=false;
		  
		  var shortSource_msg="Source city is short";
		  var shortDestination_msg="Destination city is short";
		  var invalidSource_msg="Source city is not available";
		  var invaliddestination_msg="Destination city is not available";
		  var sourceDestinationNotSame_msg="Source and destination Must be different";
		  
		  if($scope.from_city_id.length < 4){
			  console.log(""+shortSource_msg);	
			  validationMessage=shortSource_msg;
			  invalidInputFlag=true;
		  }
		  else if($scope.to_city_id.length <4){
			  console.log(" "+shortDestination_msg);	
			  validationMessage=shortDestination_msg;
			  invalidInputFlag=true;
		  }
	      else if($scope.from_city_id !=sourceBusStopName){
	    	  console.log(" "+invalidSource_msg);	
	    	  validationMessage=invalidSource_msg;
	    	  invalidInputFlag=true;
		  }
		  else if($scope.to_city_id != destinationBusStopName){
			  console.log(" "+invaliddestination_msg);
			  validationMessage=invaliddestination_msg;
			  invalidInputFlag=true;
		  }
		  else if( destinationBusStopName == sourceBusStopName){
			  
			  console.log(" "+sourceDestinationNotSame_msg);
			  validationMessage=sourceDestinationNotSame_msg;
			  invalidInputFlag=true;
		  }
		  
		  $scope.message=validationMessage;
		  if(!invalidInputFlag){
			  console.log("making http call for search busses");
			  makeHttpCallToSearchForBusses(sourceBusStopId,destinationBusStopId);
		  }
	  };
	  
	  /**
	   * This function is to make HTTP call
	   * for searching bus based on bustop Ids
	   */
	  function makeHttpCallToSearchForBusses(sourceStopId,destinationStopId){
		  
		  var object={sourceId:sourceStopId,destinationId:destinationStopId};
		  
		  $http({
	             method : 'POST',
	             url : 'searchBusBasedOnSourceAndDestinationStopIds.do?sourceId='+sourceStopId+'&destinationId='+destinationStopId,
	             //data:object
	                  
	          }).success(function(data, status, headers, config) {
	    	         console.log("data eturned: "+data);
	    	         var result;
	    	         if(data.length <5)
	    	        	 result="No busses found!!";
	    	         else
	    	        	 result=data;
	    	         $scope.serverData=result;
	    	        
	    	 
	          }).error(function(data, status, headers, config) {
		           // $scope.result ="error occured due to internal proble please try again id auto" ;
		      });
	  
	  };// END -- makeHttpCallToSearchForBusses(sourceStopId,destinationStopId)
	  
	 
		  
}]);