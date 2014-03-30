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

app.get("/customers", function(req, res) {
	setResponse(data.getCustomers(), res);
});

app.del("/customers/:id", function(req, res) {
	setTimeout(function(){
		data.delCustomer(req.params.id);	
	}, 10 * 1000);
	
	res.writeHead(200, {'Content-Type': 'text/plain'});
	res.end("The customer will soon de deleted");
});

exports.app = app;