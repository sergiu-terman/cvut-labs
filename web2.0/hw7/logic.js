var express = require("express");
var data = require("./data");
var app = express();

app.use(express.json());
app.use(express.urlencoded());

function setResponse(result, res) {
	if (!result || typeof(result) === 'undefined') {
		res.writeHead(404, {'Content-Type': 'text/html'});
		res.end("404 NOT FOUND !");
	} else {
		res.writeHead(200, {'Content-Type': 'application/json'});
		res.end(JSON.stringify(result));
	}
}

app.get("/orders", function(req, res) {
	setResponse(data.getOrders(req.query.place, req.query.size), res);
});


exports.app = app;