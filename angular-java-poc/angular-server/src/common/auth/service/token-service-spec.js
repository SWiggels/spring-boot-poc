describe('tokenService', function() { 

	beforeEach(module('appConfig','auth'));
	var httpBackend,config;

	beforeEach(inject(function($httpBackend, configService) {
		httpBackend = $httpBackend;
		config = configService;
    }));

    afterEach (function () {
		httpBackend.verifyNoOutstandingExpectation ();
		httpBackend.verifyNoOutstandingRequest ();
	});

	it('should first call the get, for the token, then post for the record', inject(function(tokenService) {

		httpBackend.whenGET(config.prepend_rest_endpoint('/api/token')).respond(
			{
				response:"X-CSRF-HEADER"
			}
		);
		httpBackend.whenPOST(config.prepend_rest_endpoint('/post/url'), {}).respond(201, {message:'success'});
		var promise = tokenService.wrap_csrf_post(config.prepend_rest_endpoint('/post/url', {}));
		promise.then(function(rdata) {
			expect(rdata.message).toBe('success');
		});
		httpBackend.flush();
	}));
});