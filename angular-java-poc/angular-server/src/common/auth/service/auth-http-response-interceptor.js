angular.module('auth')
	.factory('authHttpResponseInterceptor',
		function($q, $location) { 

	return {
		responseError: function(rejection) {
			if (rejection.status === 401) {
               $location.path('/login').search('returnTo', $location.path());
            }
			return $q.reject(rejection);
		}
	};
});