angular.module('golden', [
    'ui.bootstrap', 
    'ui.utils', 
    'ui.router', 
    'ngAnimate', 
    'clientModule', 
    'participantModule']);

angular.module('golden').config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/clients');
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
