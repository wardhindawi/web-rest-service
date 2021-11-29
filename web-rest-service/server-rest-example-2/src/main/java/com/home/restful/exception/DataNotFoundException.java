package com.home.restful.exception;

/**
 * @author preetham
 */
public class DataNotFoundException extends RuntimeException
{

   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;

   public DataNotFoundException( String message )
   {
      super( message );
   }

}
