angular.module('auth', ['ui.bootstrap','ui.utils','ui.router','ngAnimate']);

angular.module('auth').config(function($stateProvider) {

    $stateProvider.state('login-form', {
        url: '/login',
        templateUrl: 'src/common/auth/partial/login-form/login-form.html',
        controller: 'LoginFormCtrl'
    });
    /* Add New States Above */

});

