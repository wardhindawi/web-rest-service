package com.home.restful.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.home.restful.entity.TestBean;

//This class is just to understand different ways of getting the values from the request
/**
 * @author preetham
 */
@Path( "/test" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class TestResource
{

   /**
    * This method gets the query paramters sent in the URL
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/test/testQueryParam?param1=somevalue&param2=someothervalue
    * HTTP method: GET
    * Response: Query paramter recieved is param1= somevalue and param2= someothervalue
    * 
    * @param param1
    * @param param2
    * @return
    */
   @GET
   @Path( "/testQueryParam" )
   public String testQueryString( @QueryParam( "param1" ) String param1, @QueryParam( "param2" ) String param2 )
   {
      System.out.println( "Inside testQueryString " );
      return "Query paramter recieved is param1= " + param1 + " and param2= " + param2;
   }

   /**
    * This method gets the header paramters sent in the request
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/test/testHeaderParam
    * Header:
    * param1 -> somevalue
    * param2 -> someothervalue
    * Response:Header paramter recieved is param1= somevalue and param2= someothervalue
    * 
    * @param param1
    * @param param2
    * @return
    */
   @GET
   @Path( "/testHeaderParam" )
   public String testHeaderParam( @HeaderParam( "param1" ) String param1, @HeaderParam( "param2" ) String param2 )
   {
      System.out.println( "Inside testHeaderParam " );
      return "Header paramter recieved is param1= " + param1 + " and param2= " + param2;
   }

   /**
    * This method gets the cookie paramter sent in the request
    * URL: http://localhost:8080/RESTfulWebServicesSample/rest/test/testCookieParam
    * Response:Cookie paramter recieved is JSESSIONID= 846EE4FEEA9EA3F9BE5DFED91A9C2F79
    * 
    * @param param1
    * @return
    */
   @GET
   @Path( "/testCookieParam" )
   public String testCookieParam( @CookieParam( "JSESSIONID" ) String param1 )
   {
      System.out.println( "Inside testCookieParam " );
      return "Cookie paramter recieved is JSESSIONID= " + param1;
   }

   /**
    * This method gets the http header paramters sent in the request
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/test/testContextHttpHeader
    * Response:context http header paramter recieved is = {JSESSIONID=$Version=0;JSESSIONID=846EE4FEEA9EA3F9BE5DFED91A9C2F79}
    * 
    * @param httpHeaders
    * @return
    */
   @GET
   @Path( "/testContextHttpHeader" )
   public String testContextHttpHeaders( @Context HttpHeaders httpHeaders )
   {
      System.out.println( "Inside testContextHttpHeaders " );
      return "context http header paramter recieved is = " + httpHeaders.getCookies().toString();
   }

   /**
    * This method creates the TestBean and inject query params inside the bean and injects to this method
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/test/testBeanParam?year=2016&start=3&size=8
    * Response:bean paramter recieved is = TestBean [year=2016, start=3, size=8]
    * 
    * @param bean
    * @return
    */
   @GET
   @Path( "/testBeanParam" )
   public String testBeanParams( @BeanParam TestBean bean )
   {
      System.out.println( "Inside testBeanParams " );
      return "bean paramter recieved is = " + bean;
   }

}
