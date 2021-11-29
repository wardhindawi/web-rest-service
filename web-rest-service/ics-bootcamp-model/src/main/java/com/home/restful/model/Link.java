package com.home.restful.model;

/**
 * @author preetham
 */
public class Link
{

   private String url;
   private String rel;

   public String getUrl()
   {
      return url;
   }

   public void setUrl( String url )
   {
      this.url = url;
   }

   public String getRel()
   {
      return rel;
   }

   public void setRel( String rel )
   {
      this.rel = rel;
   }

   public Link()
   {
      System.out.println( "No arg Link constructor" );
   }

   public Link( String url, String rel )
   {
      this.url = url;
      this.rel = rel;
      System.out.println( "Link parameterized constructor url= " + url + " and rel= " + rel );
   }

   @Override
   public String toString()
   {
      return "Link [url=" + url + ", rel=" + rel + "]";
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ( ( rel == null ) ? 0 : rel.hashCode() );
      result = prime * result + ( ( url == null ) ? 0 : url.hashCode() );
      return result;
   }

   @Override
   public boolean equals( Object obj )
   {
      if ( this == obj )
         return true;
      if ( obj == null )
         return false;
      if ( getClass() != obj.getClass() )
         return false;
      Link other = (Link) obj;
      if ( rel == null )
      {
         if ( other.rel != null )
            return false;
      }
      else if ( !rel.equals( other.rel ) )
         return false;
      if ( url == null )
      {
         if ( other.url != null )
            return false;
      }
      else if ( !url.equals( other.url ) )
         return false;
      return true;
   }

}
