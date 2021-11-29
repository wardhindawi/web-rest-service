#This project contains RESTful web services example built using Jersey 2.17


### Adheres to Level 3 of Richardson Maturity Model(Fully RESTful API)
### Topics Covered

1)GET,POST,PUT,DELETE operations  
2)Sub resources GET,PUT,POST,DELETE operations  
3)HATEOAS support    
4)Exception mapper support  
5)Covers @PathParam, @Path, @Consumes, @Produces, @BeanParam, @Context, @QueryParam, @CookieParam, @HeaderParam etc  

*Note: Go through the java docs. Each method has request response example. Use Advanced REST client or Postman plugins for the broswer*  


##### URI's

* http://localhost:8080/RESTfulWebServicesSample/rest/persons
* http://localhost:8080/RESTfulWebServicesSample/rest/person/{personId}
* http://localhost:8080/RESTfulWebServicesSample/rest/person/{personId}/insurances
* http://localhost:8080/RESTfulWebServicesSample/rest/person/{personId}/insurances/{insuranceId}
* http://localhost:8080/RESTfulWebServicesSample/rest/test/testQueryParam?param1=somevalue&param2=someothervalue
* http://localhost:8080/RESTfulWebServicesSample/rest/test/testHeaderParam  -> add headers param1 and param2
* http://localhost:8080/RESTfulWebServicesSample/rest/test/testCookieParam
* http://localhost:8080/RESTfulWebServicesSample/rest/test/testContextHttpHeader
* http://localhost:8080/RESTfulWebServicesSample/rest/test/testBeanParam?year=2016&start=3&size=8

*Note: This project needs to be refactored to use best practices which will be done later. As of now this code should be used only for understanding purposes.*

##### Response sample

```html

[
    {
        "firstName": "Forest",
        "id": 1,
        "joinedDate": "2016-03-16T16:58:18.186",
        "lastName": "Gump",
        "links": [
            {
                "rel": "self",
                "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1"
            },
            {
                "rel": "insurance",
                "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/1/insurances/"
            }
        ]
    },
    {
        "firstName": "James",
        "id": 2,
        "joinedDate": "2016-03-16T16:58:32.164",
        "lastName": "Bond",
        "links": [
            {
                "rel": "self",
                "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2"
            },
            {
                "rel": "insurance",
                "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/"
            }
        ]
    }
]
```
