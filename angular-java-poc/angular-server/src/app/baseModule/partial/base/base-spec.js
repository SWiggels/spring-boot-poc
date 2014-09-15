describe('BaseCtrl', function() {

	beforeEach(module('baseModule'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('BaseCtrl', {$scope: scope});
    }));

    it('should have a BaseCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

    it('should ...', inject(function() {

		expect(1).toEqual(1);
		
	}));

    it('should ...return TestValue', inject(function() {

        expect(scope.test().test).toEqual('TestValue');

    }));

});