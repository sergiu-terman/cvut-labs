#Homework 3
-------------

####View of data model
-------------
![Alt text](http://i.imgur.com/TpY49dF.png)



####URI description 
-----------------
"/owners" - the most importan hierarchichal entity<br />
"/owners/id" - specific owner identified by "id" property<br />
"/owners?name=query" - owners filtering by name property ( could be also other properties )

"/cars" - cars of the owners<br />
"/cars/id" - specific car identified by "id" property

"/plates" - plate of the car<br />
"/plates/id" - specific plate identified by "id" property

"/places" - places of the owners<br />
"/places/id" - specific place identified by "id" property

<br />
<br />
##Operations
--------------------
#### Owners

"/owners" - get all the owners <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/owners" - insert new owner <br />
HTTP method: POST <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/owners/id" - get a specific owner by id <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/owners/id" - update a specific owner by id <br />
HTTP method: PUT <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/owners/id" - delete a specific owner by id <br />
HTTP method: DELETE <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

----------------
#### Plates
"/plates" - get all the plates <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/plates" - insert new plate <br />
HTTP method: POST <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/plates/id" - get a specific plate by id <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/plates/id" - update a specific plate by id <br />
HTTP method: PUT <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/plates/id" - delete a specific plate by id <br />
HTTP method: DELETE <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

----------------
#### Places
"/places" - get all the places <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/places" - insert new place <br />
HTTP method: POST <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/places/id" - get a specific place by id <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/places/id" - update a specific place by id <br />
HTTP method: PUT <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/places/id" - delete a specific place by id <br />
HTTP method: DELETE <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

----------------
#### Cars

"/cars" - get all the cars <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/cars" - insert new car <br />
HTTP method: POST <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/cars/id" - get a specific car by id <br />
HTTP method: GET <br />
Status codes: 200 - ok, 400 - bad request, 404 - not found

"/cars/id" - update a specific car by id <br />
HTTP method: PUT <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed

"/cars/id" - delete a specific car by id <br />
HTTP method: DELETE <br />
Status codes: 200 - ok, 400 - bad request, 405 - not allowed



