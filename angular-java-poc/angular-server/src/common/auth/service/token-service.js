angular.module('auth').factory('tokenService',function($http, $q,configService) {

	var tokenService = {
		wrap_csrf_post: function(posturl,postdata) {
			var deferred = $q.defer();
			$http.get(configService.prepend_rest_endpoint('/api/token')). 
				success(function(data) {
					$http.defaults.headers.common['X-CSRF-HEADER'] = data.response;
					deferred.resolve(data);
			});

			var postpromise = $q.defer();
			deferred.promise.then(function(tokendata){
				$http.post(posturl, postdata).
					success(function(data) {
						$http.defaults.headers.common['X-CSRF-HEADER'] = null;
						postpromise.resolve(data);
				});
			});
			
			return postpromise.promise; 
		}
	};

	return tokenService;
});