
var express = require('express');
var httpProxy = require('http-proxy');

var app = express();

app.use(express.static(__dirname + '/'));

httpProxy.createProxyServer({target:'http://localhost:8080'}).listen(8000);

app.listen(process.env.PORT || 3000);	