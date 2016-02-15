'use strict';

App.controller('ModalDemoCtrl', function ($scope, $uibModal, $log) {


  $scope.open = function () {

    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
       backdrop : 'static',
      templateUrl: 'myModalContent.html',
      controller: 'ModalInstanceCtrl',
      windowClass: 'app-modal-window'
    });

  };
});

App.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance) {

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
});