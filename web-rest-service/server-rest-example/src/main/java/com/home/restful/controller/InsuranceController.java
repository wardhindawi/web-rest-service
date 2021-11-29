package com.home.restful.controller;

import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.home.restful.entity.Insurance;
import com.home.restful.service.InsuranceService;

//URL: http://localhost:8080/RESTfulWebServicesSample/rest/persons/{personID}/insurances
/**
 * @author preetham
 */
@Path( "/" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class InsuranceController
{

   private InsuranceService service = new InsuranceService();

   public InsuranceController()
   {
      System.out.println( "Person resource constructor" );
   }

   /**
    * This method is used to get all the insurance resources for a particular person resource
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/
    * HTTP Method: GET
    * Response:
    * [
    * {
    * "createdDate": "2016-03-16T17:19:15.831",
    * "id": 1,
    * "links": [
    * {
    * "rel": "self",
    * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/1"
    * }
    * ],
    * "name": "medical"
    * },
    * {
    * "createdDate": "2016-03-16T17:19:25.221",
    * "id": 2,
    * "links": [
    * {
    * "rel": "self",
    * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/2"
    * }
    * ],
    * "name": "vehicle"
    * }
    * ]
    * 
    * @param personId
    * @param uriInfo
    * @return
    */
   @GET
   public Response getInsurances( @PathParam( "personId" ) int personId, @Context UriInfo uriInfo )
   {
	   Map<Integer, Insurance> insurances = service.getAllInsurances();
      GenericEntity<Map<Integer, Insurance>> entity = new GenericEntity<Map<Integer, Insurance>>( insurances )
      {
      };
      
   
      
      for (Entry<Integer, Insurance> entry : insurances.entrySet()) {
		System.out.println("Key:"+entry.getKey() + " " + entry.getValue());
		entry.getValue().addLink( getUriForSelf( entry.getValue(), uriInfo, personId ), "self" );
	}
      
      
      return Response.status( Status.OK ).entity( entity ).build();
   }

   /**
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/1
    * HTTP method: GET
    * Response:
    * {
    * "createdDate": "2016-03-16T17:19:15.831",
    * "id": 1,
    * "links": [
    * {
    * "rel": "self",
    * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/1"
    * }
    * ],
    * "name": "medical"
    * }
    * 
    * @param personId
    * @param insuranceId
    * @param uriInfo
    * @return
    */
   @GET
   @Path( "/{insuranceId}" )
   public Response getInsurance( @PathParam( "personId" ) int personId/*, @PathParam( "insuranceId" ) int insuranceId*/, @Context UriInfo uriInfo )
   {
      
      Insurance insurance = service.getInsurance(personId);
      insurance.addLink( getUriForSelf( insurance, uriInfo, personId ), "self" );
      return Response.status( Status.OK ).entity( insurance ).build();

   }

   /**
    * This method is used to create insurance resource for a particular person resource
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances
    * HTTP Method: POST
    * Content-Type: application/json
    * Request:
    * {
    * "name": "medical"
    * }
    * Response:
    * {
    * "createdDate": "2016-03-16T17:15:50.515",
    * "id": 1,
    * "links": [
    * {
    * "rel": "self",
    * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/1"
    * }
    * ],
    * "name": "medical"
    * }
    * 
    * @param personId
    * @param insurance
    * @param uriInfo
    * @return
 * @throws ParseException 
    */
   @POST
   public Response addInsurance( @PathParam( "personId" ) int personId, Insurance insurance, @Context UriInfo uriInfo ) throws ParseException
   {
      insurance.setCreatedDate(new Date());
      
       service.addInsurance(personId, insurance );
      insurance.addLink( getUriForSelf( insurance, uriInfo, personId ), "self" );
      URI uri = uriInfo.getAbsolutePathBuilder().path( Integer.toString( insurance.getId() ) ).build();
      return Response.created( uri ).entity( insurance ).build();
      
   }

   /**
    * This method is used to update the particular insurance for a particular resource
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/2
    * HTTP Method: PUT
    * Content-Type: application/json
    * Request:
    * {
    * "name": "family"
    * }
    * Response:
    * {
    * "createdDate": "2016-03-16T17:19:25.221",
    * "id": 2,
    * "links": [
    * {
    * "rel": "self",
    * "url": "http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/2"
    * }
    * ],
    * "name": "family"
    * }
    * 
    * @param personId
    * @param insuranceId
    * @param insurance
    * @param uriInfo
    * @return
 * @throws ParseException 
    */
   @PUT
   @Path( "/{insuranceId}" )
   public Response updateInsurance( @PathParam( "personId" ) int personId, @PathParam( "insuranceId" ) int insuranceId, Insurance insurance, @Context UriInfo uriInfo ) throws ParseException
   {
      insurance.setId( insuranceId );
      service.updateInsurance( personId, insurance );
      insurance.addLink( getUriForSelf( insurance, uriInfo, personId ), "self" );
      return Response.status( Status.OK ).entity( insurance ).build();

   }

   /**
    * This method is used to delete the particular insurance for a particular person resource
    * URL:http://localhost:8080/RESTfulWebServicesSample/rest/persons/2/insurances/1
    * HTTP method: DELETE
    * 
    * @param personId
    * @param insuranceId
    */
   @DELETE
   @Path( "/{insuranceId}" )
   public void deleteInsurance( @PathParam( "personId" ) int personId, @PathParam( "insuranceId" ) int insuranceId )
   {
      service.deleteInsurance(insuranceId );
   }

   /**
    * This method is used to create a self link to insurance resource(HATEOAS)
    * 
    * @param insurance
    * @param uriInfo
    * @param personId
    * @return
    */
   private String getUriForSelf( Insurance insurance, UriInfo uriInfo, int personId )
   {
      String uri = uriInfo.getBaseUriBuilder().path( PersonController.class ).path( PersonController.class,
    		  "getInsuranceResource" ).path( InsuranceController.class ).resolveTemplate( "personId", personId ).path( Integer.toString( insurance.getId() ) ).build()
               .toString();
      return uri;

   }

}
