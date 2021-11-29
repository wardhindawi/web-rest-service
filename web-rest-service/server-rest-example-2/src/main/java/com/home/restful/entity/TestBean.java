package com.home.restful.entity;

import javax.ws.rs.QueryParam;

/**
 * @author preetham
 */
public class TestBean
{
   private @QueryParam( "year" ) String  year;
   private @QueryParam( "start" ) String start;
   private @QueryParam( "size" ) String  size;

   public String getYear()
   {
      return year;
   }

   public void setYear( String year )
   {
      this.year = year;
   }

   public String getStart()
   {
      return start;
   }

   public void setStart( String start )
   {
      this.start = start;
   }

   public String getSize()
   {
      return size;
   }

   public void setSize( String size )
   {
      this.size = size;
   }

   @Override
   public String toString()
   {
      return "TestBean [year=" + year + ", start=" + start + ", size=" + size + "]";
   }

}
