##Tutorial 6 : MongoDB - MapReduce
------------------------
All the data is generated from files of previous tutorial

[Source code](https://github.com/xserjjx/cvut-labs/blob/master/ddw/tut6/tutorial.js)

###1 Task
- We have collection of orders, each costumer id and an array of bought books
- The task is to rotate the data - generate a list of books with an array of costumers (who everybody bought each book).
- Implement it using mapReduce functions


<b>Map function</b>
```
map1 = function() {
    for (var i = 0; i < this.items.length; i++) {
        emit({"book": this.items[i].label}, {"customers": [this.customerid]});
    }
}
```
<b>Reduce function</b>
```
reduce1 = function(key, values) {
    var res = [];
    for (var i = 0; i < values.length; i++) {
        res.push(values[i].customers[0]);
    }
    return {"customers": res};
}
```
Result of the first task <br />
![Alt text](http://i.imgur.com/OcLI4xz.png)

###2 Task 
- For each order we have an array of books with an array of assigned tags for the book
- The task is to rotate the data - generate a list of tags with an array of books that are tagged with those tags
- Implement it using mapReduce functions

<b>Map function</b>
```
map2 = function() {
    for (var i = 0; i < this.items.length; i++) {
        for (var j = 0; j < this.items[i].tags.length; j++) {
            emit(this.items[i].tags[j], {"books": [this.items[i].label]})
        }
    }
}
```
<b>Reduce function</b>
```
reduce2 = function(key, values) {
    var res = [];
    for (var i = 0; i < values.length; i++) {
        res.push(values[i].books[0]);
    }
    return {"books": res};
}

```

Result of the second task <br />
![Alt text](http://i.imgur.com/x98Tnag.png)

###3 Task
- We have a collection of documents with some textual content
- Create an inverted index term-document
- Work with the “documents” collection
- Implement it using mapReduce functions

<b>Map function</b>
```
map3 = function() {
    var elements = this.content.split(" ");
    for (var i = 0; i < elements.length; i++) {
        emit({"term": elements[i]}, {"doc": [this.docid]});
    }
}
```
<b>Reduce function</b>
```
reduce3 = function(key, values) {
    var docs = [];
    for (var i = 0; i < values.length; i++) {
        docs.push(values[i].doc[0]);
    }
    return {"docs": docs};
}

```

Result of the third task <br />
![Alt text](http://i.imgur.com/9nUKry3.png)

