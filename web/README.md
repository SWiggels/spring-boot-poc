# Web Project

> Template set up in order to develop angularjs applications using node as a proxy server.

## A Few Notes

Note that this version of the app uses  AngularUI Router [ui-router](https://github.com/angular-ui/ui-router), as a result it is recommended that you use the cli for adding purpose to the app.

Also note that [http-proxy](https://github.com/nodejitsu/node-http-proxy) has been installed in this package.

## Install Base Requirements 

If you have not already, install [Git](http://http://git-scm.com/downloads) on your machine. You will need to use the Git Bash shell for running the server.

Additionally, you will need to install [node.js/npm](http://nodejs.org/) to run this example.

## Project Specific Intall Requirements

Add [Yeoman and Bower](http://yeoman.io/)

```shell
npm install -g grunt-cli yo bower
```

Add the [enterprise package development generator](https://github.com/cgross/generator-cg-angular) for angular.
```shell
npm install -g generator-cg-angular
```

## Install Dependancies

You will need to now install the projects dependencies.
```shell
bower install & npm install
```

## Run The Server

In order to run the server, as grunt has been extended to support the proxy pass through
```shell
grunt run
```
