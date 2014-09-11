angular.module('clientModule', [
	'ui.bootstrap',
	'ui.utils',
	'ui.router',
	'ngAnimate']);

angular.module('clientModule').config(function($stateProvider, $urlRouterProvider) {

    $stateProvider.state('clientMain.client-list', {
        url: '/clients',
        templateUrl: 'src/app/client/partial/client-list/client-list.html',
        controller: 'ClientListCtrl',
        resolve: {
		    clients: function($stateParams, clientService) {
				return clientService.findAll();
		    }
		}
    });
    $stateProvider.state('clientMain.client-edit', {
        url: '/client/:id',
        templateUrl: 'src/app/client/partial/client-edit/client-edit.html',
        controller: 'ClientEditCtrl',
        resolve: {
		    client: function($stateParams, clientService) {
				if ($stateParams.id < 0) {
					return {};
				} else {
					return clientService.findById($stateParams.id);
				}	
			}
		}
	});

});

