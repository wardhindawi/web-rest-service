package com.home.restful.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.home.restful.model.ErrorMessage;

//All generic exceptions other than DataNotFoundException will be caught here and sent as JSON response
/**
 * @author preetham
 */
@Provider
public class GenricExceptionMapper implements ExceptionMapper<Exception>
{

   private static final String HTTP_UNSUPPORTED_MEDIA_TYPE = "415";
   private static final String HTTP_METHOD_NOT_ALLOWED     = "405";
   private static final String HTTP_BAD_REQUEST            = "400";
   private static final String HTTP_INTERNAL_SERVER_ERROR  = "500";

   @Override
   public Response toResponse( Exception e )
   {
      System.out.println( "Generic expection mapper " + e.getMessage() );
      Response response = null;
      ErrorMessage error = new ErrorMessage( HTTP_INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR" );
      if ( e.getMessage() != null && e.getMessage().contains( HTTP_UNSUPPORTED_MEDIA_TYPE ) )
      {
         error.setErrorCode( HTTP_UNSUPPORTED_MEDIA_TYPE );
         error.setErrorMessage( "HTTP_UNSUPPORTED_MEDIA_TYPE" );
         response = Response.status( Status.UNSUPPORTED_MEDIA_TYPE ).entity( error ).type( MediaType.APPLICATION_JSON ).build();
      }
      else if ( e.getMessage() != null && e.getMessage().contains( HTTP_METHOD_NOT_ALLOWED ) )
      {
         error.setErrorCode( HTTP_METHOD_NOT_ALLOWED );
         error.setErrorMessage( "HTTP_METHOD_NOT_ALLOWED" );
         response = Response.status( Status.METHOD_NOT_ALLOWED ).entity( error ).type( MediaType.APPLICATION_JSON ).build();
      }
      else if ( e.getMessage() != null && e.getMessage().contains( HTTP_BAD_REQUEST ) )
      {
         error.setErrorCode( HTTP_BAD_REQUEST );
         error.setErrorMessage( "HTTP_BAD_REQUEST" );
         response = Response.status( Status.BAD_REQUEST ).entity( error ).type( MediaType.APPLICATION_JSON ).build();
      }
      else
      {
         response = Response.status( Status.INTERNAL_SERVER_ERROR ).entity( error ).type( MediaType.APPLICATION_JSON ).build();
      }

      return response;

   }

}
