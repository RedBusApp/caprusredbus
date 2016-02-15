<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="caprus_redbus">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" type="image/x-icon" href="./icons/bus.png" />
<title>RedBus</title>

<link rel="stylesheet" type="text/css" href="CSS/modalstyle.css">

     <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-animate.js"></script>
    <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.1.2.js"></script>
    <script src="JS/app.js"></script>
    <script src="JS/ModalJs.js"></script>
    <script src="JS/controller/BusStopAutoComplete.js"></script>
    <script src="JS/service/MyService.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body class="container" id="body" ng-controller="ModalDemoCtrl">
<div class="row" id="signin_div">
<a href="#" id="home_link">Home</a>
<a href="#" id="signInLink"  ng-click="open()"><span>Sign Up / Sign In</span></a>

<!-- Modal -->
 
  <script type="text/ng-template" id="myModalContent.html">
      <!-- Modal content-->
      <div class="row">
      <div class="col-sm-6" id="image_content">
      <img src="./icons/redbus-logo.png" width="200" height="250">
      </div>
      <div class="col-sm-6" id="main_content" >
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" ng-click="cancel()"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h3 class="form-inTime-heading">Sign Up</h3>
        </div>
        <div class="modal-body">
           <!-- textBox for employee current Password -->
			<div id="email_div" class="input-group">
			<span><i class="glyphicon glyphicon-envelope"></i></span>&nbsp;&nbsp;&nbsp;
                <input type="email" placeholder="Enter your email id" id="email_id" required ><br /><br />
            </div>
            <!-- textBox for employee new  Password -->
			<div  id="password_div"  class="input-group">
			<span><i class="glyphicon glyphicon-lock "></i></span>&nbsp;&nbsp;&nbsp;
                <input type="password" placeholder="Enter your password" id="password_id" required ><br /><br />
            </div>
               By signing up, you agree to our <a href="#">terms and conditions.</a><br /><br />
			<button class="btn btn-danger" type="submit" id="continue_button">Continue</button><br />
			Already have an account?                 <a href="#" id="signin_action">Sign In</a><br /><br />
		
        </div>
        </div>
        </div>
      </div>
   </script>
   </div>
   <div class="row ads_div">
   <hr>
   </div>
   <div class="row search_bus_div">
   <hr>
   <div class="col-sm-4">
   </div>
   <div class="col-sm-8">
   <h3>Book Your Bus Tickets In Online</h3><br />
   <div id="from_date_div">
   <label >From</label>
   <input type="text" placeholder="Enter a city" id="search_id" ng-model="from_city_id" 
       uib-typeahead="stop[1] for stop in busstopids |filter:$viewValue" typeahead-no-results="noResults" typeahead-input-formatter="formatSourceStopName()"  typeahead-select-on-blur="true" typeahead-select-on-exact="true" typeahead-on-select="selectedSourceBusStop($item)">  <!-- ng-model="from_city_id" -->
   <div ng-show="noResults"><i class="glyphicon glyphicon-remove"></i> No Results Found</div>
    
   <br /><br /><label >Date of Journey</label>
<input type="date" id="search_id" ng-model="data_of_journey_id" >
</div>
<div id="direction_div">
<span><i class="glyphicon glyphicon-resize-horizontal"></i></span>
</div>
<div id="to_date_div">
<label>To</label><input type="text" placeholder="Enter a city" id="search_id" ng-model="to_city_id" 
   uib-typeahead="stop[1] for stop in busstopids |filter:$viewValue" typeahead-no-results="noResults" typeahead-input-formatter="formatDestinationStopName()"  typeahead-select-on-blur="true" typeahead-select-on-exact="true" typeahead-on-select="selectedDestinationBusStop($item)">
<br /><br /><label>Date of Return (Optional)</label>
<input type="date" id="search_id" ng-model="data_of_return_id">
<br /><br /> <button ng-model="search_bus_button" id="search_button" ng-click="searchBusses()" class="btn btn-danger">Search Buses</button>
   </div>

   </div>
   </div>
   
   <div class="row buses_result_div">
   <hr>
   <p >bus ids aftr for each:  {{busstopids}}</p>
   <p>from city : {{from_city_id}}</p>
   <p>Destination city : {{to_city_id}}</p>
   <p>validation msg: {{message}}</p>
   <p>Data returned from server : {{serverData}}</p>
   </div>
</body>
</html>






