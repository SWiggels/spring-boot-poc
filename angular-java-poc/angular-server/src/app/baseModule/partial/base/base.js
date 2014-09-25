angular.module('baseModule').controller('BaseCtrl', function($scope, $state) {

    $scope.test = function() {
        return {test: 'TestValue'};
    };

    $state.go('base.clients');

});