angular.module('myModule', [ 'ui.bootstrap', 'ui.utils', 'ui.router', 'ngAnimate' ]);

angular.module('myModule').config(function($stateProvider) {

	$stateProvider.state('main', {
		url : '/main',
		controller : 'MainCtrl',
		views : {
			// the main template will be placed here (relatively named)
			'' : {
				templateUrl : 'src/app/mymodule/partial/main/main.html'
			},
			'@main' : {
				templateUrl : 'src/app/mymodule/partial/first/first.html'
			},
			'menu@main' : {
				templateUrl : 'src/app/menuModule/partial/menu/menu.html'
			}
		}
	});
	$stateProvider.state('another', {
		url : '/another',
		views : {
			// the main template will be placed here (relatively named)
			'' : {
				templateUrl : 'src/app/mymodule/partial/another/another.html'
			},
			'columnOne@another' : {
				template : 'Some content -1'
			},
			'columnTwo@another' : {
				template : 'Some content -2'
			},
			'menu@another' : {
				templateUrl : 'src/app/menuModule/partial/menu/menu.html'
			}
		}
	});
	$stateProvider.state('main.first', {
		url : '/first',
		controller : 'FirstCtrl',
		templateUrl : 'src/app/mymodule/partial/first/first.html'
	});
	$stateProvider.state('main.second', {
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
	/* Add New States Above */

});