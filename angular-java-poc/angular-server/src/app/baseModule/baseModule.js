angular.module('baseModule', [ 
	'ui.bootstrap', 
	'ui.utils', 
	'ui.router', 
	'ngAnimate' 
]);

angular.module('baseModule').config(function($stateProvider) {

	$stateProvider.state('base', {
		url : '/base',
		controller : 'BaseCtrl',
		templateUrl : 'src/app/baseModule/partial/base/base.html'
	});
});