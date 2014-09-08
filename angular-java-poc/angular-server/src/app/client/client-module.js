angular.module('clientModule', [
	'ui.bootstrap',
	'ui.utils',
	'ui.router',
	'ngAnimate']);

angular.module('clientModule').config(function($stateProvider) {

	

    $stateProvider.state('client-list', {
        url: '/clients',
        templateUrl: 'src/app/client/partial/client-list/client-list.html',
        controller: 'ClientListCtrl',
        resolve: {
		    clients: function($stateParams, clientService) {
		    	return clientService.findAll();
		    }
		}
    });
    /* Add New States Above
,
		controller: 'ClientListCtrl',
		




     */

});

