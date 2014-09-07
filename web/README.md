# Web Project

> Template set up in order to develop angularjs applications using node as a proxy server.

## Before You Begin 

You will need to install node/npm to run this example.

You will also need to install GIT on your machine in order to use the CLI of git since their is a dependency on the git libs.

Once this is installed you will also want to add Yoeman:

```shell
npm install -g grunt-cli yo bower
```

Add the enterprise package development generator for angular.
```shell
npm install -g generator-cg-angular
```

## Building The Project


Finally, add the required angular enterprise package and development tooling: npm install -g generator-cg-angular

This is from (at the time of writing) the git hub: https://github.com/cgross/generator-cg-angular

Note that this version of the app uses  AngularUI Router [ui-router](https://github.com/angular-ui/ui-router), as a result it is recommended that you use the cli for adding purpose to the app.

bower install & npm install

Also note that http-proxy has been installed in this package.

In order to run the server, as grunt has been extended to support the proxy pass through: 
grunt run

