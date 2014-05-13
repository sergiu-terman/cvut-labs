// Task 1
map1 = function() {
    for (var i = 0; i < this.items.length; i++) {
        emit({"book": this.items[i].label}, {"customers": [this.customerid]});
    }
}

reduce1 = function(key, values) {
    var res = [];
    for (var i = 0; i < values.length; i++) {
        res.push(values[i].customers[0]);
    }
    return {"customers": res};
}

invert1 = db.orders.mapReduce(map1, reduce1, {out: "invert1"});

// Task 2
map2 = function() {
    for (var i = 0; i < this.items.length; i++) {
        for (var j = 0; j < this.items[i].tags.length; j++) {
            emit(this.items[i].tags[j], {"books": [this.items[i].label]})
        }
    }
}

reduce2 = function(key, values) {
    var res = [];
    for (var i = 0; i < values.length; i++) {
        res.push(values[i].books[0]);
    }
    return {"books": res};
}

invert2 = db.orders.mapReduce(map2, reduce2, {out: "invert2"});

// Task 3

map3 = function() {
    var elements = this.content.split(" ");
    for (var i = 0; i < elements.length; i++) {
        emit({"term": elements[i]}, {"doc": [this.docid]});
    }
}

reduce3 = function(key, values) {
    var docs = [];
    for (var i = 0; i < values.length; i++) {
        docs.push(values[i].doc[0]);
    }
    return {"docs": docs};
}

invert3 = db.documents.mapReduce(map3, reduce3, {out: "invert3"});