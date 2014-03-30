var ordersIndex = 0;
var orders = new Array();

function processInput(socket, data) {
	data = data.split(" ");
	switch(data[0]) {
		case 'open':
			openOrder(socket);
			break;
		case 'add':
			addItem(socket, data[1], data.slice(2).join(" "));
			break;
		case 'process':
			processOrder(socket, data[1]);
			break;
		default:
			socket.write("Incorrect command\n");
	}
}

function openOrder(socket) {
	orders[ordersIndex.toString()] = new Array();
	socket.write("Order " + ordersIndex + " added successfully\n");
	ordersIndex++;
}

function addItem(socket, index, item) {
	if (!(index in orders)) {
		socket.write("Order " + index + " not opened\n");
		return;
	}
	if (typeof item === 'undefined') {
		socket.write("No item to add\n");
		return;
	}
	orders[index].push(item);
	socket.write("Item \"" + item + "\" added to order " + index + "\n");
}

function processOrder(socket, index) {
	if (!(index in orders)) {
		socket.write("Order " + index + " not opened\n");
		return;
	}
	if (orders[index].length == 0) {
		socket.write("No item to process\n");
		return;		
	}
	socket.write("Process order " + index +". . .\n");
	for (var i = 0; i < orders[index].length; i++) {
		socket.write("Item \"" + orders[index][i] + "\" processed\n");
	}
	delete orders[index];
}

exports.processInput = processInput;