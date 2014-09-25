angular.module('auth')
	.factory('authHttpResponseInterceptor',
		function($q, $location, $injector,$cookies) {


	return {
		response: function(response) {
			return response || $q.when(response);
		},
		responseError: function(rejection) {
			if (rejection.status === 401) {
                console.log("Response Error 401",rejection);
                $location.path('/login').search('returnTo', $location.path());
            }
			return $q.reject(rejection);
		}
	};
});