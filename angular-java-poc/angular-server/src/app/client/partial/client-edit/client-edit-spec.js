describe('ClientEditCtrl', function() {  

	beforeEach(module('clientModule')); 

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
    ctrl = $controller('ClientEditCtrl', {$scope: scope, client: {}, $state: stateMock, clientService:clientServiceMock});
  }));

  it('should have a ClientEditCtrl controller',  function() {
    expect(ctrl).toBeDefined();
  });

	it('should paas through the data and bind it to the scope', inject(function() {
		expect(scope.client).not.toBe(null);
	}));

  it('should save the object and change its state the base.clients list', inject(function($rootScope) {
    expect(stateMock.current()).toBe("No State Set");
    scope.submit();
    expect(stateMock.current()).toBe("base.clients");
  }));
});