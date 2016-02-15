'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
         
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8080/CustomerRegistration/api/customer/list')
                            .then(
                                    function(response){    
                                   /* var users=[];
                                    for(var i=0;i<response.data.length;i++){
                                    	var user ={id:null,themeId:null,uniqueId:null,active:false,email:'',language:'',webUrl:'',country:'',
                                    			location:'',profileImageUrl:'',encryptKey:'',businessType:null,businessSegment:'',
                                    			platformsDevices:'',socialMediasMarkets:'',externalMediasMarkets:'',firstName:'',
                                    			lastName:'',displayName:'',dob:'',mobile:null,landmarks:null,city:null,gender:'',
                                    			password:'',selfDescription:'',userName:''};
                                    	
                                    	user.id=response.data[i].customerId;
                                    	user.themeId=response.data[i].themeId;
                                    	user.uniqueId=response.data[i].uniqueId;
                                    	user.active=response.data[i].active;
                                    	user.email=response.data[i].email;
                                    	user.language=response.data[i].language;
                                    	user.webUrl=response.data[i].webUrl;
                                    	user.country=response.data[i].country;
                                    	user.location=response.data[i].location;
                                    	user.profileImageUrl=response.data[i].profileImageUrl;
                                    	user.encryptKey=response.data[i].encryptKey;
                                    	user.businessType=response.data[i].businessType;
                                    	user.businessSegment=response.data[i].businessSegment;
                                    	user.platformsDevices=response.data[i].platformsDevices;
                                    	user.socialMediasMarkets=response.data[i].socialMediasMarkets;
                                    	user.externalMediasMarkets=response.data[i].externalMediasMarkets;
                                    	user.firstName=response.data[i].firstName;
                                    	user.lastName=response.data[i].lastName;
                                    	user.displayName=response.data[i].displayName;
                                    	user.dob=response.data[i].dob;
                                    	user.mobile=response.data[i].mobile;
                                    	user.landmarks=response.data[i].landmarks;
                                    	user.city=response.data[i].city;
                                    	user.gender=response.data[i].gender;
                                    	user.password=response.data[i].password;
                                    	user.selfDescription=response.data[i].selfDescription;
                                    	user.userName=response.data[i].userName;
                                    	
                                    	
                                    	  
                                    	
                                    	  console.log(user.id);	  
                                    	 	
                                    	  console.log(user.email);	
                                    	
                                    	users.push(user);
                                    	 user ={id:null,themeId:null,uniqueId:null,active:false,email:'',language:'',webUrl:'',country:'',
                                    			location:'',profileImageUrl:'',encryptKey:'',businessType:null,businessSegment:'',
                                    			platformsDevices:'',socialMediasMarkets:'',externalMediasMarkets:'',firstName:'',
                                    			lastName:'',displayName:'',dob:'',mobile:null,landmarks:null,city:null,gender:'',
                                    			password:'',selfDescription:'',userName:''};
                                    	
                                    }
                                    	
                                    
                                    console.log(JSON.stringify(users[0]) );*/
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createUser: function(user){
                    return $http.post('http://localhost:8080/CustomerRegistration/api/customer/create', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateUser: function(user, id){
            	user.theme={"themeId":402,"description":"theme2","name":"theme2","customers":null,"themeCategory":null,"categoryId":301};
                    return $http.post('http://localhost:8080/CustomerRegistration/api/customer/update', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            deleteUser: function(id){
                    return $http.get('http://localhost:8080/CustomerRegistration/api/customer/delete/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }
         
    };
 
}]);