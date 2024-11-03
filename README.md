# Getting Started
* Code Repository https://github.com/shreyasri006/social-media-project.git

## Prerequisite
* Java 21 should be installed
* Maven should be installed (for build)
* Install MongoSH (In case we want to create/edit collections)
  * brew install mongosh




## Setup
* Clone the Repository
* Open the project in IntelliJ (pom.xml)
* Use Maven in IntelliJ for building the code (clean and package)

## Start Server
* 


#### Reference Documentation
* Springboot Tutorial https://www.youtube.com/watch?app=desktop&v=vtPkZShrvXQ
* MongoDB Java Tutorial https://www.youtube.com/watch?v=reYPUvu2Giw
* Springboot with MongoDB integration https://www.youtube.com/watch?v=rm9_h2nIJD8
* Springboot starter project https://start.spring.io/




### MongoDB commands
Login to MongoDB server from Terminal:
mongosh "mongodb+srv://smp.nm81j.mongodb.net/" --apiVersion 1 --username shreyasri006
    Enter password 529Qx4MHrBFQhWMB
* show dbs  (It will list all databases)
* use smp   (connect to our database named smp)
* show collections   (List all the collections in the smp database)
* db.createCollection("user")       (Create a collection named 'user')
* db.createCollection("friend")     (Create a collection named 'friend')
* db.createCollection("message")    (Create a collection named 'message')
