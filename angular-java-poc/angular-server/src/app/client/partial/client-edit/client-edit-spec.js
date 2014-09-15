describe('ClientEditCtrl', function() {

	beforeEach(module('clientModule'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('ClientEditCtrl', {$scope: scope, client: {}});
    }));

    it('should have a ClientEditCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

	it('should ...', inject(function() {

		expect(1).toEqual(1);
		
	}));

});