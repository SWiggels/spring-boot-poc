describe('LoginFormCtrl', function() {  

	beforeEach(module('auth'));

	var scope,ctrl, httpBackend, stateMock, mockHttp;
	var currentState = "No State Set";

	beforeEach(function(){

		mockHttp = {
			defaults:{
				headers:{
					common:{
						Authorization: ""
					}
				}
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

    beforeEach(inject(function($rootScope, $controller, $httpBackend) {
		scope = $rootScope.$new();
		scope.email = "bob@bob.com";
		scope.password = "password";
		ctrl = $controller('LoginFormCtrl', {$http:mockHttp, $scope:scope, $state:stateMock });
	}));	

	it('should submit set the header and redirect to the landing page', inject(function() {
		expect(stateMock.current()).toBe("No State Set");
		scope.submit();
		expect(stateMock.current()).toBe("base");
		expect(mockHttp.defaults.headers.common['Authorization']).toBe('Basic ' + btoa(scope.email + ":" + scope.password));
	}));
});