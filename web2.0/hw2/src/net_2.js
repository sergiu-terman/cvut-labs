var net = require('net');
var ps = require('./logic_2')

function start() {
	var server = net.createServer(function(socket) {
	  console.log('server connected');

	  socket.setEncoding('utf8');
	  socket.on('data', function(input) {
	  	ps.processInput(socket, input.trim());
	  });
	  
	  socket.on('end', function() {
	  	console.log('server disconnected');
	  });
	});

	server.listen(8124, function() {
		console.log('server bound');
	});	
}

start();



