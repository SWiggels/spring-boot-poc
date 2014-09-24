angular.module('golden', [
    'ui.bootstrap',
    'ui.utils',
    'ui.router',
    'ngAnimate',
    'clientModule',
    'myModule',
    'baseModule',
    'ngCookies',
    'spring-security-csrf-token-interceptor'
]);

angular.module('golden').config(function ($httpProvider, $stateProvider, $urlRouterProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    // /dXNlcjpwYXNzd29yZA==
    var auth = 'Basic ' + btoa("user:password");
    
    
    $httpProvider.defaults.headers.common['Authorization'] = auth;
    //$httpProvider.defaults.headers.common['X-CSRF-TOKEN'] = '863bd83e-0dd0-44eb-8dac-120942e4466f';

    //$httpProvider.defaults.headers.common = {'Authorization':'Basic ' + btoa("user:password")};
    $urlRouterProvider.otherwise('/base');
});

angular.module('golden').run(function ($rootScope, $http, $cookies) {

    //$http.defaults.headers.common['X-CSRF-TOKEN'] = $cookies['_csrf'];

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