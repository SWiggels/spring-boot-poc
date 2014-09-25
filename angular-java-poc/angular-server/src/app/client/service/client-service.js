angular.module('clientModule').factory('clientService',function($http, $q, tokenService,configService) {

	var clientService = {};

	clientService.findAll = function() {
		var deferred = $q.defer();
		$http.get(configService.prepend_rest_endpoint('/api/clients')). 
			success(function(data) {
				deferred.resolve(data);
		});
		return deferred.promise; 
	};

	clientService.findById = function(id) {
		var deferred = $q.defer();
		$http.get(configService.prepend_rest_endpoint('/api/client?id='+id)).
			success(function(data) {
				deferred.resolve(data);
		});
		return deferred.promise;
	};

	clientService.save = function(data, callback) {
		tokenService.wrap_csrf_post(configService.prepend_rest_endpoint('/api/client/save'), data).then(function(tokendata) {
			callback();
		});
	};
	return clientService;
});