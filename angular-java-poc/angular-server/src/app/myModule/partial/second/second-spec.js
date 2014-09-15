describe('SecondCtrl', function() {

	beforeEach(module('myModule'));

	var scope,ctrl;

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('SecondCtrl', {$scope: scope, myObject: {}});
    }));

    it('should have a SecondCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

	it('should ...', inject(function() {

		expect(1).toEqual(1);
		
	}));

});