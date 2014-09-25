describe('BaseCtrl', function() {

	beforeEach(module('baseModule'));

	var scope,ctrl;
    var clientServiceMock, stateMock;
    var currentState = "No State Set";

    beforeEach(function(){
        
        clientServiceMock = {
            save: function(record, callback){
                callback();
            }
        };

        stateMock = {
          go: function(newstate){
            currentState = newstate;
          },
          current: function(){
            return currentState;
          }
        };
    });

    beforeEach(inject(function($rootScope, $controller) {
      scope = $rootScope.$new();
      ctrl = $controller('BaseCtrl', {$scope: scope, $state:stateMock});
    }));

    it('should have a BaseCtrl controller',  function() {
        expect(ctrl).toBeDefined();
    });

    it('should change state to go to clients list.', function() {
        expect(stateMock.current()).toBe('base.clients');
    });
});