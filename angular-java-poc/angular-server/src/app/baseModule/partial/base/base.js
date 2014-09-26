angular.module('baseModule').controller('BaseCtrl', function($scope, $state) {
	$state.go('base.clients');
}); 