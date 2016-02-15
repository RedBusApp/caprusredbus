'use strict';
 
App.factory('MyService', ['$http', '$q', function($http, $q){

	  /*storing all requests in variables*/
	  var urlPettern=".do";
	  var getAllBusStopsRequest="getAllStopsForAutoComplete";	  
	  var searchBusBasedOnSourceAndDestination="searchBusBasedOnSourceAndDestinationStopIds";
	  
	  console.log("in my service");

      return {
    	  
    	  /**
    	   * This function is to make HTTP call
    	   * for getting all bustop Ids and names
    	   */
    	  getAllBusStopsForAuocomplete: function() {
    		  //'http://localhost:8080/CustomerRegistration/api/customer/create'
    		  return $http.post(getAllBusStopsRequest + urlPettern)
              .then(
                      function(response){
                    	  //console.log("get busstops response.data: "+response.data);
                          return response.data;
                      }, 
                      function(errResponse){
                          console.error('Error while getAllBusStopsForAuocomplete() in service');
                          return $q.reject(errResponse);
                      }
              );    		  
    		  
    	  }// END  -- getAllBusStopsForAuocomplete: function()
          ,
          /**
    	   * This function is to make HTTP call
    	   * for searching bus based on bustop Ids
    	   */
          searchBusBasedOnSourceAndDestination:function(sourceStopId,destinationStopId){
        	  
        	  return $http.post(searchBusBasedOnSourceAndDestination + urlPettern +'?sourceId='+sourceStopId+'&destinationId='+destinationStopId)
              .then(
                      function(response){
                    	  //console.log("get busstops response.data: "+response.data);
                          return response.data;
                      }, 
                      function(errResponse){
                          console.error('Error while getAllBusStopsForAuocomplete() in service');
                          return $q.reject(errResponse);
                      }
              );
        	  
        	  
          }// END -- searchBusBasedOnSourceAndDestination:function()
      
      }; // END  -- return


 }]); // END -- App.factory('MyService', ['$http', '$q', function($http, $q)