
'use strict';

App.controller('ModalDemoCtrl',['$scope','MyService','$log',function($scope,MyService){
	
	 $scope.busstopids=[];
	 
	 //$scope.from_city_id="";
	 var sourceBusStopName="";
	 var destinationBusStopName="";
	 var sourceBusStopId;
	 var destinationBusStopId;
	 
	 /*function call to getAllBusStops*/
	 getAllBusStopsThroughHttp();
	 
	 /**
	  * This function is to get all busstops from
	  * database
	  */
	 function getAllBusStopsThroughHttp(){
		 
		 console.log("getAllBusStopsThroughHttp    executing");
		 
		 MyService.getAllBusStopsForAuocomplete()
                .then(
                      function(data) {
                    	    console.log("in controller (retuirned from service: )"+data);
                    	    $scope.busstopids= data;                          
                      },
                       function(errResponse){
                           console.error('Error while fetching Currencies');
                       }
                 );
		 
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
		  
		  MyService.searchBusBasedOnSourceAndDestination(sourceStopId,destinationStopId).then(
				 function(successData){
					 console.log("data--+"+successData.length +" type: "+ typeof successData+"  value: "+successData);
					 var result;
	    	         if(successData.length == 0)
	    	        	 result="No busses found!!";
	    	         else
	    	        	 result=successData;
	    	         $scope.serverData=result;
				 },
				 function(error){
					 console.log("error -- MyService.searchBusBasedOnSourceAndDestination(sourceStopId,destinationStopId)");
				 }
		  );
		  
	  
	  };// END -- makeHttpCallToSearchForBusses(sourceStopId,destinationStopId)
	  
	 
		  
}]);