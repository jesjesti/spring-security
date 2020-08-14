#!/bin/bash

echo create auth user

authUserResult=`curl --location --request POST 'localhost:83/user/signup' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
    "userName":"Super Admin",
    "password":"admin"
}'`

echo Generating Token

token=`curl --location --request POST 'localhost:83/auth/authenticate' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
    "userName":"Super Admin",
    "password":"admin"
}'`

echo token is $token

echo Creating user for comments

userDetails=`curl --location --request POST 'localhost:82/comments/user/create' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
    "id":null,
    "name":"User First"
}'`

echo List all users for comments

`curl --location --request GET 'localhost:82/comments/user/find/all' \
--header 'Authorization: Bearer $token' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0'`



echo Creating comments

commentResult=`curl --location --request POST 'localhost:82/comments/create' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
    "id": null,
    "title": "Comment First",
    "content":"Comment Contenet",
    "createdOn":"2020-08-14",
	"createdBy":$userDetails
}'`

echo List all comments

listCommentResult=`curl --location --request GET 'localhost:82/comments/find/all' \
--header 'Authorization: Bearer $token' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0'`


echo Creating Next comment

commentResultSecond=`curl --location --request POST 'localhost:82/comments/create' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
    "id": null,
    "title": "Comment First",
    "content":"Comment Contenet",
    "createdOn":"2020-08-14",
	"createdBy":$userDetails
}'`

echo Removing Comment

commentRemoveResult=`curl --location --request POST 'localhost:82/comments/remove' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '$commentResultSecond
}'`


echo Creating User

newUserFirst=`curl --location --request POST 'localhost:84/user/create' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
   "id":null,
   "name":"Test User 3",
   "age":33,
   "gender":"Male",
   "mobileNumber":"865745645"
}'`

newUserSecond=`curl --location --request POST 'localhost:84/user/create' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '{
   "id":null,
   "name":"Test User 4",
   "age":33,
   "gender":"Female",
   "mobileNumber":"865745645"
}'`

echo List all users

`curl --location --request GET 'localhost:84/user/find/all' \
--header 'Authorization: Bearer $token' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0'`

echo Removing User

deletedUser=`curl --location --request POST 'localhost:84/user/remove' \
--header 'Authorization: Bearer $token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=node01gaj527tpye2m123thzcgdyghk0.node0' \
--data-raw '$newUserSecond'`

echo Completed exicution






