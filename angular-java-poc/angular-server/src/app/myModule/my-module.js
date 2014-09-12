angular.module('myModule', [ 
	'ui.bootstrap', 
	'ui.utils', 
	'ui.router', 
	'ngAnimate' ]);

angular.module('myModule').config(function($stateProvider) {

	$stateProvider.state('base.main', {
		url : '/main',
		controller : 'MainCtrl',
		views : {
			'' : {
				templateUrl : 'src/app/mymodule/partial/main/main.html'
			},
			'@main' : {
				templateUrl : 'src/app/mymodule/partial/first/first.html'
			}
		}
	});
	$stateProvider.state('base.another', {
		url : '/another',
		views : {
			'' : {
				templateUrl : 'src/app/mymodule/partial/another/another.html'
			},
			'columnOne@base.another' : {
				template : 'Some content -1'
			},
			'columnTwo@base.another' : {
				template : 'Some content -2'
			},
		}
	});
	$stateProvider.state('base.main.first', {
		url : '/first',
		controller : 'FirstCtrl',
		templateUrl : 'src/app/mymodule/partial/first/first.html'
	});
	$stateProvider.state('base.main.second', {
		url : '/second/:id',
		templateUrl : 'src/app/mymodule/partial/second/second.html',
		controller : 'SecondCtrl',
		resolve : {
			myObject : function($stateParams) {
				var id = $stateParams.id;
				if (id) {
					return {
						value : 'there is an id:' + id
					};

				} else {
					return {
						value : 'none: ' + id
					};
				}
			}
		}
	});
});