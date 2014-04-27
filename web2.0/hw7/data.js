var orders = [{id:"0", name:"Order nr 1", date:"September 9 2005", customer_id:"1"},
			  {id:"1", name:"Order nr 2", date:"November 11 2005", customer_id:"2"},
			  {id:"2", name:"Order nr 3", date:"August 27 2005", customer_id:"3"},
			  {id:"3", name:"Order nr 4", date:"September 2 2005", customer_id:"4"},
			  {id:"4", name:"Order nr 5", date:"September 3 2005", customer_id:"5"},
			  {id:"5", name:"Order nr 6", date:"September 4 2005", customer_id:"6"},
			  {id:"6", name:"Order nr 7", date:"September 12 2005", customer_id:"7"},
			  {id:"7", name:"Order nr 8", date:"September 30 2005", customer_id:"8"},
			  {id:"8", name:"Order nr 9", date:"October 14 2005", customer_id:"9"},
			  {id:"9", name:"Order nr 10", date:"October 25 2005", customer_id:"10"},
			  {id:"10", name:"Order nr 11", date:"November 8 2005", customer_id:"11"},
			  {id:"11", name:"Order nr 12", date:"November 11 2005", customer_id:"12"},
			  {id:"12", name:"Order nr 13", date:"November 13 2005", customer_id:"13"},
			  {id:"13", name:"Order nr 14", date:"November 18 2005", customer_id:"14"},
			  {id:"14", name:"Order nr 15", date:"November 22 2005", customer_id:"15"},
			  {id:"15", name:"Order nr 16", date:"November 29 2005", customer_id:"16"},
			  {id:"16", name:"Order nr 17", date:"December 9 2005", customer_id:"17"},
			  {id:"17", name:"Order nr 18", date:"December 10 2005", customer_id:"18"},
			  {id:"18", name:"Order nr 19", date:"December 20 2005", customer_id:"19"},
			  {id:"19", name:"Order nr 20", date:"January 6 2005", customer_id:"20"},
			  {id:"20", name:"Order nr 21", date:"January 27 2005", customer_id:"21"},
			  {id:"21", name:"Order nr 22", date:"January 31 2005", customer_id:"22"},
			  {id:"22", name:"Order nr 23", date:"February 3 2005", customer_id:"23"},
			  {id:"23", name:"Order nr 24", date:"February 14 2005", customer_id:"24"},
			  {id:"24", name:"Order nr 25", date:"February 21 2005", customer_id:"25"},
			  {id:"25", name:"Order nr 26", date:"February 28 2005", customer_id:"26"},
			  {id:"26", name:"Order nr 27", date:"March 10 2005", customer_id:"27"},
			  {id:"27", name:"Order nr 28", date:"March 21 2005", customer_id:"28"},
			  {id:"28", name:"Order nr 29", date:"March 31 2005", customer_id:"29"},
			  {id:"29", name:"Order nr 30", date:"April 1 2005", customer_id:"30"},
			  {id:"30", name:"Order nr 31", date:"April 18 2005", customer_id:"31"},
			  {id:"31", name:"Order nr 32", date:"April 21 2005", customer_id:"32"},
			  {id:"32", name:"Order nr 33", date:"April 30 2005", customer_id:"33"},
			  {id:"33", name:"Order nr 34", date:"May 16 2005", customer_id:"34"},
			  {id:"34", name:"Order nr 35", date:"May 19 2005", customer_id:"35"},
			  {id:"35", name:"Order nr 36", date:"June 18 2005", customer_id:"36"},
			  {id:"36", name:"Order nr 37", date:"June 26  2005", customer_id:"37"},
			  {id:"37", name:"Order nr 38", date:"June 27 2005", customer_id:"38"},
			  {id:"38", name:"Order nr 39", date:"April 6 2005", customer_id:"39"},
			  {id:"39", name:"Order nr 40", date:"February 1 2005", customer_id:"40"},
			  {id:"40", name:"Order nr 41", date:"December 9 2005", customer_id:"41"},
			 ];


getOrders  = function(index, size) {
	if (index > orders.length)
		return [];

	var last = parseInt(index) + parseInt(size);
	console.log(index);
	console.log(last);

	console.log(orders.slice(index, last));
	return orders.slice(index, last);
}

exports.getOrders = getOrders;
