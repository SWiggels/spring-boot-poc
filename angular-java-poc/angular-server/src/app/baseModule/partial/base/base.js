angular.module('baseModule').controller('BaseCtrl', function($scope) {

    $scope.test = function() {
        return {test: 'TestValue'}
    };

});