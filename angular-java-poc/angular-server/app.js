angular.module('golden', [
    'ui.bootstrap', 
    'ui.utils', 
    'ui.router', 
    'ngAnimate', 
    'clientModule',
    'baseModule', 
    'ngCookies', 
    'auth'
]);

angular.module('golden').config(function ($httpProvider, $stateProvider, $urlRouterProvider) {
    $httpProvider.interceptors.push('authHttpResponseInterceptor');
    $urlRouterProvider.otherwise('/base');
});

angular.module('golden').run(function ($rootScope, $http, $cookies) {

    $rootScope.safeApply = function (fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof (fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };
});