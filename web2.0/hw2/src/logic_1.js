var orderOpen = false;
var items = new Array();

function processInput(socket, input) {
	console.log(input);
	if (input == "open") {
		openOrder(socket);
		return;
	}
		
	if (input == "process") {
		processOrder(socket);
		return;
	}

	input = input.split(" ");
	if (input[0] == "add") {
		addItem(socket, input.slice(1).join(" "))
	} else {
		socket.write("Command not understood . . .\n");
	}
}

function processOrder(socket) {
	if (!orderOpen) {
		socket.write("No opened order . . .\n");
		return;
	}
	if (items.length == 0) {
		socket.write("No items in order . . .\n");
		return;
	}
	socket.write("Order is processing . . .\n");
	for (var i = 0; i < items.length; i++) {
		socket.write("Item " + (i + 1) + " " + items[i] + "\n");
	}
	socket.write("Order processed !!!\n");
	items = new Array();
	orderOpen = false;
}

function openOrder(socket) {
	socket.write("An order was opened !!! Add your items to order . . .\n");
	orderOpen = true;
	items = new Array();
}

function addItem(socket, item) {
	if (!orderOpen) {
		socket.write("No opened order . . .\n");
		return;
	}
	if (!item) {
		socket.write("No item present . . .\n");
		return;
	}
	items.push(item);
	socket.write("Item added : " + item + "\n");
}

exports.processInput = processInput;