exports.config = {
         chromeOnly: true,
         chromeDriver: '/usr/lib/node_modules/protractor/selenium/chromedriver',
         
         specs: [
           './src/**/*-e2e-spec.js'
         ],
         capabilities: {
           'browserName': 'chrome'
         },

         // ----- Options to be passed to minijasminenode -----
         jasmineNodeOpts: {
             isVerbose: false,
             showColors: true,
             includeStackTrace: true,
             defaultTimeoutInterval: 10000
         }
};
