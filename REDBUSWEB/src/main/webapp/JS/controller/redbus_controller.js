'use strict';
 
App.controller('UserController', ['$scope', 'UserService','$uibModal','$log', function($scope,UserService,$uibModal,$log) {
	      
	      $scope.showForm=false;
          var self = this;
          self.user ={customerId:null,themeId:null,uniqueId:null,active:false,email:'',language:'',webUrl:'',country:'',
      			location:'',profileImageUrl:'',encryptKey:'',businessType:null,businessSegment:'',
    			platformsDevices:'',socialMediasMarkets:'',externalMediasMarkets:'',firstName:'',
    			lastName:'',displayName:'',dob:'',mobile:null,landmarks:null,city:null,gender:'',
    			password:'',selfDescription:'',userName:''};
          self.users=[];
               $scope.colName=Object.keys(self.user);
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
                               function(d) {
                                    self.users = d;
                                    
                               },
                                function(errResponse){
                                    console.error('Error while fetching Currencies');
                                }
                       );
          };
          
         
            
          self.createUser = function(user){
              UserService.createUser(user)
                      .then(
                      self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while creating User.');
                              } 
                  );
          };
 
         self.updateUser = function(user, customerId){
        	
              UserService.updateUser(user, customerId)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while updating User.');
                              } 
                  );
          };
 
         self.deleteUser = function(customerId){
              UserService.deleteUser(customerId)
                      .then(
                              self.fetchAllUsers, 
                              function(errResponse){
                                   console.error('Error while deleting User.');
                              } 
                  );
          };
 
          self.fetchAllUsers();
 
          function editUser(user) {
        	 
                  self.updateUser(user, user.customerId);
                  console.log('User updated with customerId ', user.customerId+" new user name   "+user.userName);
              
              //self.reset();
          };
               
          self.edit = function(customerId){
        	  
              console.log('customerId to be edited', customerId);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].customerId === customerId) {
                     self.user = angular.copy(self.users[i]);
                     break;
                  }
              }
              
              var modalInstance = $uibModal.open({
                  animation: $scope.animationsEnabled,
                  templateUrl: 'myModalContent.html',
                  controller: 'ModalInstanceCtrl',
                  size: 'lg',
                  resolve: {
                    editUser: function () {
                      return self.user;
                    }
                  }
                });
              
              modalInstance.result.then(function (userObj) {
            	  editUser(userObj);
                }, function () {
                  $log.info('Modal dismissed at: ' + new Date());
                });
          };
               
          self.remove = function(customerId){
              console.log('customerId to be deleted', customerId);
              if(self.user.customerId === customerId) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteUser(customerId);
          };
 
           
          self.reset = function(){
        	  self.user ={customerId:null,themeId:null,uniqueId:null,active:false,email:'',language:'',webUrl:'',country:'',
            			location:'',profileImageUrl:'',encryptKey:'',businessType:null,businessSegment:'',
          			platformsDevices:'',socialMediasMarkets:'',externalMediasMarkets:'',firstName:'',
          			lastName:'',displayName:'',dob:'',mobile:null,landmarks:null,city:null,gender:'',
          			password:'',selfDescription:'',userName:''};
              $scope.myForm.$setPristine(); //reset Form
          };
 
      }]);


/*
App.controller('ModalDemoCtrl', function ($scope, $uibModal, $log) {



  $scope.animationsEnabled = true;

  $scope.open = function (size) {

    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl',
      size: size,
      resolve: {
        items: function () {
          return $scope.items;
        }
      }
    });

 
  };

  

});*/

// Please note that $modalInstance represents a modal window (instance) dependency.
// It is not the same as the $uibModal service used above.

App.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance,editUser) {

  console.log("user data: "+JSON.stringify(editUser));
  $scope.user=editUser;
  $scope.ok = function () {
    $uibModalInstance.close();
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
  
  $scope.submitEditForm=function(){
	  console.log("edit from submitting..");
	  console.log("updated user object: "+JSON.stringify($scope.user));
	  $uibModalInstance.close($scope.user);
	  $scope.user ={customerId:null,themeId:null,uniqueId:null,active:false,email:'',language:'',webUrl:'',country:'',
  			location:'',profileImageUrl:'',encryptKey:'',businessType:null,businessSegment:'',
			platformsDevices:'',socialMediasMarkets:'',externalMediasMarkets:'',firstName:'',
			lastName:'',displayName:'',dob:'',mobile:null,landmarks:null,city:null,gender:'',
			password:'',selfDescription:'',userName:''};
  };
  
  
  
  
  
});

