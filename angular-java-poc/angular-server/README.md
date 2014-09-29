# Web Project

> Template set up in order to develop angularjs applications using node as a proxy server.

![Simple](/angular-java-poc/angular-server/docs/imgs/simple.jpg?raw=true "Simple Image")

Some additional docs
![SomeAdditionalDocs](/angular-java-poc/angular-server/docs/INTRO.md "Simple MD")

https://github.com/tasconline/spring-boot-poc/blob/master/angular-java-poc/angular-server/docs/INTRO.md

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

## Configure server and maven to run this with Jenkins

### Pre-requisites

Install protractor
```shell
sudo npm install -g protractor
```


### Install Xvfb

We need to use Xvfb to run headless browsers for Karma and Protractor tests

```shell
sudo apt-get install xvfb
```

Place this inside  /etc/init.d/xvfb

```shell
!/bin/bash
#
# Xvfb init script for Debian-based distros.
#
# The display number used must match the DISPLAY environment variable used
# for other applications that will use Xvfb. e.g. ':10'.
#
# From: https://github.com/gmonfort/xvfb-init/blob/master/Xvfb
#
### BEGIN INIT INFO
# Provides:          xvfb
# Required-Start:    $remote_fs $syslog
# Required-Stop:     $remote_fs $syslog
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Start/stop custom Xvfb
# Description:       Enable service provided by xvfb
### END INIT INFO
 
NAME=Xvfb
DESC="$NAME - X Virtual Frame Buffer"
SCRIPTNAME=/etc/init.d/$NAME
XVFB=/usr/bin/Xvfb
PIDFILE=/var/run/${NAME}.pid
 
# Using -extension RANDR doesn't seem to work anymore. Firefox complains
# about not finding extension RANDR whether or not you include it here.
# Fortunately this is a non-fatal warning and doesn't stop Firefox from working.
XVFB_ARGS=":10 -extension RANDR -noreset -ac -screen 10 1024x768x16"
 
set -e
 
if [ `id -u` -ne 0 ]; then
  echo "You need root privileges to run this script"
  exit 1
fi
 
[ -x $XVFB ] || exit 0
 
. /lib/lsb/init-functions
 
[ -r /etc/default/Xvfb ] && . /etc/default/Xvfb
 
case "$1" in
  start)
    log_daemon_msg "Starting $DESC" "$NAME"
    if start-stop-daemon --start --quiet --oknodo --pidfile $PIDFILE \
          --background --make-pidfile --exec $XVFB -- $XVFB_ARGS ; then
      log_end_msg 0
    else
      log_end_msg 1
    fi
    log_end_msg $?
    ;;
 
  stop)
    log_daemon_msg "Stopping $DESC" "$NAME"
    start-stop-daemon --stop --quiet --oknodo --pidfile $PIDFILE --retry 5
    if [ $? -eq 0 ] && [ -f $PIDFILE ]; then
      /bin/rm -rf $PIDFILE
    fi
    log_end_msg $?
    ;;
 
  restart|force-reload)
    log_daemon_msg "Restarting $DESC" "$NAME"
    $0 stop && sleep 2 && $0 start
    ;;
 
  status)
    status_of_proc -p $PIDFILE $XVFB $NAME && exit 0 || exit $?
    ;;
 
  *)
    log_action_msg "Usage: ${SCRIPTNAME} {start|stop|status|restart|force-reload}"
    exit 2
    ;;
esac
exit 0
```

Install the service

```shell
sudo chown root:root /etc/init.d/xvfb
sudo chmod a+x /etc/init.d/xvfb
sudo update-rc.d  /etc/init.d/xvfb defaults
```

Install Packages required for browser
```shell
sudo apt-get install x11-xkb-utils xfonts-100dpi xfonts-75dpi
sudo apt-get install xfonts-scalable xserver-xorg-core
sudo apt-get install dbus-x11
sudo apt-get install libfontconfig1-dev
```
Install Chrome and Firefox

```shell
sudo apt-get install google-chrome-stable
sudo apt-get install firefox 

```

Modify .profile and add the following line

```shell
export DISPLAY=localhost:10.0
```

## Run maven for the jvascript passage.

```shell
maven grunt:grunt -Dtarget=test
`l

