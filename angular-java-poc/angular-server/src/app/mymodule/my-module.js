angular.module('myModule', ['ui.bootstrap','ui.utils','ui.router','ngAnimate']);

angular.module('myModule').config(function($stateProvider) {

	$stateProvider.state('main', {
        url: '/main',
        controller: 'MainCtrl',
        templateUrl: 'src/app/mymodule/partial/main/main.html'
    });
    $stateProvider.state('main.first', {
        url: '/first',
        controller: 'FirstCtrl',
        templateUrl: 'src/app/mymodule/partial/first/first.html'
    });
    $stateProvider.state('main.second', {
        url: '/second/:id',
        templateUrl: 'src/app/mymodule/partial/second/second.html',
        controller: 'SecondCtrl',
        resolve: {
		    myObject: function($stateParams) {
				var id = $stateParams.id;
				if (id) {
					return {value: 'there is an id:' + id};
					
				} else {
					return {value: 'none: ' + id};
				}	
			}
		}
    });    
    $stateProvider.state('another', {
        url: '/another',
        views: {

            // the main template will be placed here (relatively named)
            '': { templateUrl: 'src/app/mymodule/partial/another/another.html' },

            // the child views will be defined here (absolutely named)
            'columnOne@another': { template: 'Look I am a column!' },

            // for column two, we'll define a separate controller 
            'columnTwo@another': { 
                templateUrl: 'src/app/client/partial/clientMain/clientMain.html'
            }
        }
    });
    /* Add New States Above */

});

