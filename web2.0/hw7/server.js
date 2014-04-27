var http = require("http");
var lg = require("./logic");

http.createServer(lg.app).listen(8888);
console.log("Server has started.");