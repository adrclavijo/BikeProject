# BikeProject
Short Spring Boot demo project

# How to run

First compile the application with
```
 ./mvnw clean package -DskipTests
```
then copy the jar to the docker folder
```
 cp .\target\bike-0.0.1-SNAPSHOT.jar src/main/docker
```
move to that folder
```
cd src/main/docker          
```
and then run the container
```
docker-compose up
```

The docker container will be listening on port 8081.<br>
The postgres DB is also available on port 5432.

# How to use

The endpoints in this project are secured and require a valid JWT Token.
You can get this token by POST on _/login_ endpoint with this body:

```
{
    "username": "bike",
    "password": "b1k3."
}
```
## Get a bike by ID

You can return an existing bike if you GET /bike/{ID}. If the bike isn't present, it will return an error.
This endpoint is cached.

```
{
    "name": "bike",
    "description: "has two wheels",
    "price": 99.2,
    "manufacturer": "bike company",
    "items" : [
        {
            "model": "wheel",
            "type": "wheel",
            "description: "it's round"
        }
    ]
}
```

## Store a bike

You can store bike and its items if you POST /bike with this body:

```
{
    "name": "",
    "description: "",
    "price": 0,
    "manufacturer": "",
    "items" : [
        {
            "model": "",
            "type": "",
            "description: ""
        }
    ]
}
```
On _bike_, field **name** is mandatory.
On _items_, **model** and **type** are mandatory.


## Find a bike

You can find a bike by its name, manufacturer or its item types by POST /bike/find with this body:

```
{
    "searchString": "string to search",
    "order": "asc",
    "size": 1,
    "page": 0
}
```
