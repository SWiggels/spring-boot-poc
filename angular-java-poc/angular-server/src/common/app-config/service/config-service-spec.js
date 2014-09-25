describe('configService', function() {

  beforeEach(module('appConfig','auth'));

	it('should attach http endpoint to the request', inject(function(configService) {
		expect(configService.prepend_rest_endpoint('/api/nothing')).toBe(configService.rest_endpoint() + '/api/nothing');
	}));
});

