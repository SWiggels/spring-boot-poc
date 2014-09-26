describe('Client services', function() { 
 
 	beforeEach(module('clientModule'));

	var httpBackend, service, config;	

	beforeEach(inject(function($httpBackend, clientService, configService) {
		httpBackend = $httpBackend;
		service = clientService;
		config = configService;
    }));

    afterEach (function () {
		httpBackend.verifyNoOutstandingExpectation ();
		httpBackend.verifyNoOutstandingRequest ();
	});
	

	it('should get 2 objects from the "Productlist" service ', inject(function($rootScope){

		httpBackend.whenGET(config.prepend_rest_endpoint('/api/clients')).respond(
			[{"id":1,"name":"Me"},{"id":2,"name":"You"}]
		);

		var resolvedValue = [];
		var rvar = service.findAll();

		rvar.then(function(data) {
			resolvedValue = data;
		}, function() {
			console.log('error');
		});

		httpBackend.flush();
		$rootScope.$apply();
		expect(resolvedValue.length).toBe(2);
		expect(resolvedValue[0].id).toBe(1);
		expect(resolvedValue[0].name).toBe("Me");
		expect(resolvedValue[1].id).toBe(2);
		expect(resolvedValue[1].name).toBe("You");
	}));

	it('should find a client by id', inject(function($rootScope){

		httpBackend.whenGET(config.prepend_rest_endpoint('/api/client?id=2')).respond(
			{"id":2,"name":"You"}
		);

		var resolvedValue = [];
		var rvar = service.findById(2);

		rvar.then(function(data) {
			resolvedValue = data;
		}, function() {
			console.log('error');
		});

		httpBackend.flush();
		$rootScope.$apply();
		expect(resolvedValue.id).toBe(2);
		expect(resolvedValue.name).toBe("You");
	}));

	it('should save the object to the backend data store', inject(function($rootScope) {
		

		httpBackend.whenGET(config.prepend_rest_endpoint('/api/token')).respond(
			{response:"bef6263f-8a94-4b03-83be-46723e21a00d"}
		);

		
		httpBackend.whenPOST(config.prepend_rest_endpoint('/api/client/save'), {}).respond(201, '');

		var msg = 'No Callback';

		service.save({}, function(){
			msg = 'Success';
		});
		expect(msg).toBe('No Callback');
		httpBackend.flush();
		expect(msg).toBe('Success');
	}));
});