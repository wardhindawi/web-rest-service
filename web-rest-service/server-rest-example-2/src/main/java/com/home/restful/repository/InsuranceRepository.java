package com.home.restful.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.home.restful.entity.Insurance;
import com.home.restful.mockDB.MockDatabase;

/**
 * @author preetham
 */
public class InsuranceRepository
{

   private MockDatabase mockDatabase = MockDatabase.getInstance();

   public InsuranceRepository()
   {
      System.out.println( "Insurance repository called" );
   }

   public List<Insurance> getInsurances( long personId )
   {
      List<Insurance> insuranceList = null;
      Map<Long, Insurance> insurances = mockDatabase.getInsurances( personId );
      if ( insurances != null )
      {
         insuranceList = new ArrayList<Insurance>( insurances.values() );
      }
      return insuranceList;
   }

   public Insurance getInsurance( long personId, long insuranceId )
   {
      return mockDatabase.getInsurance( personId, insuranceId );
   }

   public Insurance addInsurance( long personId, Insurance insurance )
   {
      return mockDatabase.addInsurance( personId, insurance );
   }

   public void deleteInsurance( long personId, long insuranceId )
   {
      mockDatabase.deleteInsurance( personId, insuranceId );

   }

   public Insurance updateInsurance( long personId, Insurance insurance )
   {
      return mockDatabase.updateInsurance( personId, insurance );

   }
}
