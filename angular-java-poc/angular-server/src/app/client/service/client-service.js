angular.module('clientModule').factory('clientService',function() {

	var clientService = {};

	clientService.findAll = function() {
		console.log("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		return [
			{name:'bob'},
			{name:'Steve'}
		];
	}

	return clientService;
});