describe('Client services', function() {

	var $httpBackend, clientService;

	beforeEach(module('clientModule'));

	beforeEach(inject(function(_$httpBackend_, clientService) {
     // $httpBackend = _$httpBackend_;
      //clientService = clientService;
      //$httpBackend.expectGET('http://localhost:8080/api/clients').
       //   respond([{name: '1'}, {name: '2'}]);

    }));
	

	it('should call crudListMethods', function() {
		//clientService.findAll();
		//$httpBackend.flush();

	});

 
});