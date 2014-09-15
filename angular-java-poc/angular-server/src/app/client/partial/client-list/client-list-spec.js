describe('ClientListCtrl', function() {

	beforeEach(module('clientModule'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
		scope = $rootScope.$new();
		ctrl = $controller;
    }));

    it('should have a ClientListCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

	it('should ...', inject(function() {

		expect(1).toEqual(1);
		
	}));

});