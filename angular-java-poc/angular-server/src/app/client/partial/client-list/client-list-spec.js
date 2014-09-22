describe('ClientListCtrl', function() {

	beforeEach(module('clientModule'));

	var scope,ctrl, clients;

    beforeEach(inject(function($rootScope, $controller) {
		scope = $rootScope.$new();
		clients = [];
		ctrl = $controller('ClientListCtrl', {$scope: scope, clients:clients});
    }));

    it('should have a ClientListCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

	it('should inject the clients into the controller and bind to scope', inject(function() { 
		expect(scope.clients).not.toBe(null);
	}));

});