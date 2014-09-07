Web Project
===============
You will need to install node/npm to run this example.

You will also need to install GIT on your machine in order to use the CLI of git since their is a dependency on the git libs.

Once this is installed you wiill also want to add Yoeman: npm install -g yo

Now to add the cli for the project: npm install -g grunt-cli yo bower

Finally, add the required angular enterprise package and development tooling: npm install -g generator-cg-angular

This is from (at the time of writing) the git hub: https://github.com/cgross/generator-cg-angular

yo cg-angular

Note that this version of the app uses  AngularUI Router (https://github.com/angular-ui/ui-router), as a result it is recommended that you use the cli for adding purpose to the app.

bower install & npm install

create .bowerrc
create .editorconfig
create .jshintrc
create .npmignore
create Gruntfile.js
create app.js
create app.less
create bower.json
create gulpfile.js
create index.html
create package.json