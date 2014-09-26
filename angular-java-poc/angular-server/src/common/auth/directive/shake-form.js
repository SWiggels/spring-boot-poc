angular.module('auth').directive('shakeForm', function($animate) {
	return {
    require: '^form', 
    scope: {
      submit: '&',
      submitted: '='
    },
    link: function(scope, element, attrs, form) {

      element.on('submit', function() {

        // tell angular to update scope
        scope.$apply(function() {

          if (form.$valid) {
            return scope.submit();
          }
          $animate.addClass(element, 'shake', function() {
            $animate.removeClass(element, 'shake');
          });

        });

      });

    }
  };
});