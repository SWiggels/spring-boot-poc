angular.module('clientModule').factory('clientService',function($http, $q, $cookies) {

	var clientService = {};
	//$http.defaults.headers.common.Authorization = "Basic bGV0c25vc2g6QkFEUEFTU1dPUkQ=";

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
	};

	clientService.save = function(data, callback) {
		$http.post('http://localhost:8080/api/client/save', data).
			success(function() {
				callback();		
		});
	};

	return clientService;
});