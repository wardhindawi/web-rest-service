package com.home.restful.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.home.restful.model.ErrorMessage;

//All DataNotFoundException will be caught and sent as response from here
/**
 * @author preetham
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

   @Override
   public Response toResponse( DataNotFoundException ex )
   {
      System.out.println( "Exception mapper" );
      ErrorMessage error = new ErrorMessage( "404", ex.getMessage() );
      return Response.status( Status.NOT_FOUND ).entity( error ).build();

   }

}
