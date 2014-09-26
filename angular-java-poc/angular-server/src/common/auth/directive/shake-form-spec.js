ddescribe('shakeForm', function() {

  beforeEach(module('auth'));

  var scope,compile, form, submit_button;

  beforeEach(inject(function($rootScope,$compile) {
    scope = $rootScope.$new();
    scope.submit = function(){console.log('submitted&&&&&&&&&&&&')};
    compile = $compile;
  }));

  function compileTemplate() {
    var tpl = 
      '<form name="form" autocomplete="off" novalidate shake-form submitted="submitted" submit="submit()">' +
        '<input type="email" class="form-control" id="email" name="email" placeholder="Email" ng-model="email" required>'+
        '<button type="submit" class="btn btn-primary btn-block">Login</button>'+
      '</form>';

    inject(function($compile){
      form = $compile(tpl)(scope);
    }); 

    scope.$digest();
  }

  it('should fail submission as no email exists', function() {

    compileTemplate();
    expect(scope.email).not.toBeDefined();  
    expect( scope.form.$valid).toBe(false);
  });

  it('should fail submission as invalid email', function() {

    compileTemplate();
    expect(scope.email).not.toBeDefined(); 
    expect( scope.form.$valid).toBe(false);
    
    scope.email = "bob#bob.com";
    scope.$digest();
    expect( scope.form.$valid).toBe(false);
  });

  it('should fail submission as invalid email', function() {

    compileTemplate();
    expect(scope.email).not.toBeDefined(); 
    expect( scope.form.$valid).toBe(false);
    
    scope.email = "bob@bob.com";
    scope.$digest();
    expect( scope.form.$valid).toBe(true);
  });

});