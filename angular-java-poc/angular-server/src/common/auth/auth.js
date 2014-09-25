angular.module('auth', ['ui.bootstrap','ui.utils','ui.router','ngAnimate', 'appConfig']);

angular.module('auth').config(function($stateProvider) {

    $stateProvider.state('login-form', {
        url: '/login',
        templateUrl: 'src/common/auth/partial/login-form/login-form.html',
        controller: 'LoginFormCtrl'
    });
});

