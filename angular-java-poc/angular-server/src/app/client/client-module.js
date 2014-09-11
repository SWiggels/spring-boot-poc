angular.module('clientModule', [ 'ui.bootstrap', 'ui.utils', 'ui.router', 'ngAnimate' ]);

angular.module('clientModule').config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state('client-list', {
		url : '/clients',
		views : {
			// the main template will be placed here (relatively named)
			'' : {
				templateUrl : 'src/app/client/partial/client-list/client-list.html',
				controller : 'ClientListCtrl',
				resolve : {
					clients : function($stateParams, clientService) {
						return clientService.findAll();
					}
				}
			},
			'menu@client-list' : {
				templateUrl : 'src/app/menuModule/partial/menu/menu.html'
			}
		}
		
	});
	$stateProvider.state('client-edit', {
		url : '/client/:id',
		views : {
			// the main template will be placed here (relatively named)
			'' : {
				templateUrl : 'src/app/client/partial/client-edit/client-edit.html',
				controller : 'ClientEditCtrl',
				resolve : {
					client : function($stateParams, clientService) {
						if ($stateParams.id < 0) {
							return {};
						} else {
							return clientService.findById($stateParams.id);
						}
					}
				}
			},
			'menu@client-edit' : {
				templateUrl : 'src/app/menuModule/partial/menu/menu.html'
			}
		}		
	});

});
