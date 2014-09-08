/* jshint ignore:start */
var express = require('express'); 
var httpProxy = require('http-proxy');
var cors = require('cors');

var app = express();

app.use(cors());

app.use(express.static(__dirname + '/'));

httpProxy.createProxyServer({target:'http://localhost:8080'}).listen(8000);

app.listen(process.env.PORT || 3000);	

/* jshint ignore:end */