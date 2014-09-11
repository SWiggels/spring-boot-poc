angular.module('golden', ['ui.bootstrap', 'ui.utils', 'ui.router', 'ngAnimate', 'clientModule', 'participantModule', 'myModule']);

angular.element(document).ready(function() {
    // once golden loads mods, then config
    angular.module('myModule').config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/main');
    });
    angular.module('clientModule').config(function($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/clients');
    });
    // manual bootstrap to the page
    angular.bootstrap(document.getElementById("app1"), ['myModule']);
    angular.bootstrap(document.getElementById("app2"), ['clientModule']);
});

angular.module('golden').run(function($rootScope) {

    $rootScope.safeApply = function(fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof(fn) === 'function')) {
                 fn();
            }
        } else {
            this.$apply(fn);
        } 
    };
    
});