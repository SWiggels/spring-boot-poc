describe('Client services', function() { 

	var httpBackend, service;

	beforeEach(module('clientModule'));

	beforeEach(inject(function($httpBackend, clientService) {
		httpBackend = $httpBackend;
		service = clientService;
		//ctrl = $controller('ClientEditCtrl', {$scope: scope, client: {}, $state: stateMock, clientService:clientServiceMock});
    }));

    afterEach (function () {
		httpBackend.verifyNoOutstandingExpectation ();
		httpBackend.verifyNoOutstandingRequest ();
	});
	

	xit('should get 2 objects from the "Productlist" service ', inject(function($rootScope){
		httpBackend.whenGET("http://localhost:8080/api/clients").respond(
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

	xit('should find a client by id', inject(function($rootScope){
		httpBackend.whenGET("http://localhost:8080/api/client?id=2").respond(
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

	xit('should save the object to the backend data store', inject(function($rootScope){
		httpBackend.whenPOST("http://localhost:8080/api/client/save", {}).respond(201, '');

		var msg = 'No Callback';

		service.save({}, function(){
			msg = 'Success';
		});
		expect(msg).toBe('No Callback');
		httpBackend.flush();
		expect(msg).toBe('Success');
	}));
});