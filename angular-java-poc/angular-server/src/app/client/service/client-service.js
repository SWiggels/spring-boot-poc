angular.module('clientModule').factory('clientService',function($http, $q) {

	var clientService = {};

	clientService.findAll = function() {
		var deferred = $q.defer();
		$http.get('http://localhost:8080/api/clients').
			success(function(data) {
				deferred.resolve(data);
		});

		return deferred.promise;
	};

	clientService.findById = function(id) {
		var deferred = $q.defer();
		$http.get('http://localhost:8080/api/client?id='+id).
			success(function(data) {
				deferred.resolve(data);
		});

		return deferred.promise;
	}

	return clientService;
});