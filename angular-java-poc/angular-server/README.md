# Web Project

> Template set up in order to develop angularjs applications using node as a proxy server.

(Intro){/docs/INTRO.md}

## A Few Notes

Note that this version of the app uses  AngularUI Router [ui-router](https://github.com/angular-ui/ui-router), as a result it is recommended that you use the cli for adding purpose to the app.

Also note that [http-proxy](https://github.com/nodejitsu/node-http-proxy) has been installed in this package.

## Modules????

This doc does not intent to go over all the reasons for modules, the preceding link does a good job of that. As you know, modules are coming in ES6.

Angular modules are covered [here](https://docs.angularjs.org/guide/module)

Finally, as a high level understanding of modules the following is provided.
```Shell
A module for each feature
A module for each reusable component (especially directives and filters)
And an application level module which depends on the above modules and contains any initialization code.
```

## More Reading

[Begin here](https://medium.com/@dickeyxxx/best-practices-for-building-angular-js-apps-266c1a4a6917)

[Next]https://medium.com/opinionated-angularjs/scalable-code-organization-in-angularjs-9f01b594bf06

[Then](https://medium.com/opinionated-angularjs/a2fcbf874a1c)

[ng-boilerplate](https://github.com/ngbp/ngbp#readme)

[Font Awesome](http://fortawesome.github.io/Font-Awesome/)

[Placeholders](http://joshdmiller.github.io/angular-placeholders/)

[Google best practices](https://docs.google.com/document/d/1XXMvReO8-Awi1EZXAXS4PzDzdNvV6pGcuaF4Q9821Es/pub)

[Google style guide](https://google-styleguide.googlecode.com/svn/trunk/angularjs-google-style.html)

[angular-app]{https://github.com/angular-app/angular-app/}

Read the [book](https://www.packtpub.com/web-development/mastering-web-application-development-angularjs)

## Finally... Install Base Requirements 

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
