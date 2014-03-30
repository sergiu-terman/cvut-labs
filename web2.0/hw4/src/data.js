var customers = [{id:"0", first_name:"Eugeniu", last_name:"Ungureanu"},
			  	 {id:"1", first_name:"Sergiu", last_name:"Terman"},
			  	 {id:"2", first_name:"Mihai", last_name:"Iachimovschi"},
			  	 {id:"3", first_name:"Maxim", last_name:"Chetrusca"},
			  	 {id:"4", first_name:"Dorin", last_name:"Chirtoaca"},
			  	 {id:"5", first_name:"Irina", last_name:"Cojanu"},
			  	 {id:"6", first_name:"Viorel", last_name:"Bostan"},
			  	 {id:"7", first_name:"Cristian", last_name:"Besliu"},
			  	 {id:"8", first_name:"Vlad", last_name:"Tribusean"},
			  	 {id:"9", first_name:"Alexandra", last_name:"Plesco"}];


function getCustomers() {
	return customers;
}

function delCustomer(id) {
	for (var i = 0; i < customers.length; i++) {
		if (customers[i].id == id) {
			customers.splice(i, 1);
			break;
		}
	}
}

exports.getCustomers = getCustomers;
exports.delCustomer = delCustomer;
