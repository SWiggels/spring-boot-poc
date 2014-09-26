describe('authHttpResponseInterceptor', function() {

	beforeEach(module('auth')); 

	var q_mock, authHttpResponseInterceptor, rejected;

	beforeEach(function($provide, $injector) {
		rejected = false;
		q_mock = {
			reject: function(rejection){
				rejected=true;
			}
		};

		module(function($provide) {
			$provide.value('$q', q_mock);
		});

		inject(function($injector) {
			authHttpResponseInterceptor = $injector.get('authHttpResponseInterceptor');
		});
	});

	it('should change location to login as error is 401 and q reject is called', inject(function($location) {
		spyOn($location, 'search');
		expect(rejected).toBe(false);
		authHttpResponseInterceptor.responseError({status:401, responseError:"Unauthorized"});
		expect(rejected).toBe(true);
		expect($location.search).toHaveBeenCalled();
	}));

	it('should not change location to login as error is not 401 but q reject is called', inject(function($location) {
		spyOn($location, 'search');
		expect(rejected).toBe(false);
		authHttpResponseInterceptor.responseError({status:403, responseError:"Unauthorized"});
		expect(rejected).toBe(true);
		expect($location.search).not.toHaveBeenCalled();
	}));
});