describe('AnotherCtrl', function() {

	beforeEach(module('myModule'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('AnotherCtrl', {$scope: scope});
    }));

    it('should have a AnotherCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

	it('should ...', inject(function() {

		expect(1).toEqual(1);
		
	}));

});