var http = require('http');
var fs = require('fs');

http.createServer(function(req, res) {
    if (req.headers.accept && req.headers.accept == 'text/event-stream') {
        if (req.url == '/events') {
            sse(req, res);
        } else {
        res.writeHead(404);
        res.end();
    }
    } else {
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(fs.readFileSync(__dirname + '/index.html'));
        res.end();
    }
}).listen(8000);


function sse(req, res) {
    res.writeHead(200, {
        'Content-Type': 'text/event-stream',
        'Cache-Control': 'no-cache',
        'Connection': 'keep-alive'
    });

    setInterval(function() {
        res.write("data: " + (new Date()).toLocaleTimeString() + '\n\n');
    }, 2000);
    res.write("data: " + (new Date()).toLocaleTimeString() + '\n\n');
}