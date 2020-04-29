# learn-online
# learn-online

#Adding student with following Json Request.
URL:- http://localhost:8080/learn-online/learn
METHOD:- POST

JSON REQUEST

{
 "firstName":"Farhan",
 "lastName":"Quazi",
 "email":"Farhan@gmail.com",
 "password":"somepassword",
 "phone":"999999999",
 "country":"India",
 "state":"KA"
}

#Adding the courses with following JSON request. 
URL:- http://localhost:8080/learn-online/learn/buy
METHOD:- POST

JSON REQUEST

{
"studentEmail":"farhan@gmail.com",
"courseKeys":["d483bf6fad787dd0210d1ebd8dc8cd17651d673996f561f1173a578e4e6a9a4e",
			  "67a7b6e00304c3605df81c1d578ff6f7f8ce63bc5b9acb",
			  "67a7b6e00304c3605df81c1d578ff6f7f8ce63bc5b9acb"]
}	

#Getting the perticular Student details using his email

URL:- http://localhost:8080/learn-online/learn/search/farhan@gmail.com
METHOD:- GET


#Deleting the the student by email
URL:- http://localhost:8080/learn-online/learn/cancel
METHOD:- DELETE

JSON REQUEST 
{
"studentEmail":"farhan@gmail.com",
"courseKeys":["42dd3bcccabb9cff12b1ec5a92330f110443259db4c4ef92c8b6054e09a1442d"]
}	
