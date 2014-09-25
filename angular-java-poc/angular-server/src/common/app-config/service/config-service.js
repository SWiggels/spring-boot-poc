angular.module('appConfig').factory('configService',function() {

	
	var configService = {
		rest_endpoint: function() {
			return "http://localhost:8080";
		},
		prepend_rest_endpoint: function(path) {
			return this.rest_endpoint() + path;
		}
	};

	return configService;
}); 
