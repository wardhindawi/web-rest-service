package com.home.restful.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.home.restful.entity.Insurance;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author preetham
 */
public class InsuranceRepository {

    String connectString = "jdbc:oracle:thin:@10.100.102.5:1521:hobank";
    Connection conn = null;

    public InsuranceRepository() {

        System.out.println("Insurance repository called");
    }

    public Map<Integer, Insurance> getInsurance() {
        Map<Integer, Insurance> insuranceResult = new HashMap<>();
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn.prepareStatement("select id , name , createdDate from Insurance");
            ResultSet rs = stmnt.executeQuery();
            InsuranceRepository insuranceRep = new InsuranceRepository();
            Insurance insurance = new Insurance();
            int key = 1;
            while (rs.next()) {
                insurance = new Insurance();
                insurance.setId(rs.getInt("id"));
                insuranceResult.put(key, insuranceRep.getInsurances(insurance));
                key++;
            }
            stmnt.close();
            conn.close();

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();

        }
        return insuranceResult;
    }

    public Insurance getInsurances(Insurance insurance) {

        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn
                    .prepareStatement("select id , name , createdDate from Insurance where id = ?");
            stmnt.setInt(1, insurance.getId());
            ResultSet rs = stmnt.executeQuery();

            while (rs.next()) {

                insurance.setId(rs.getInt("id"));
                insurance.setName(rs.getString("name"));
                insurance.setCreatedDate(rs.getDate("createdDate"));

            }
            stmnt.close();
            conn.close();

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();

        }
        return insurance;
    }

    public Insurance addInsurance(Insurance insurance) throws ParseException {
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn
                    .prepareStatement("insert into Insurance(id , name , createdDate) values (?,?,?) ");

            java.util.Date createdDate = insurance.getCreatedDate();

            stmnt.setInt(1, insurance.getId());
            stmnt.setString(2, insurance.getName());
            stmnt.setDate(3, new java.sql.Date(createdDate.getTime()));
            stmnt.execute();
            stmnt.close();
            conn.close();

            InsuranceRepository insuranceRep = new InsuranceRepository();
            insurance = insuranceRep.getInsurances(insurance);

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();

        }
        return insurance;

    }

    public void deleteInsurance(Insurance insurance) {

        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn.prepareStatement("delete from Insurance where id=?");
            stmnt.setInt(1, insurance.getId());
            int row = stmnt.executeUpdate();
            System.out.println(row);
            stmnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Insurance updateInsurance(int personId, Insurance insurance) throws ParseException {
        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");

            PreparedStatement stmnt4 = conn
                    .prepareStatement(" Update Insurance Set name = ?, createdDate = ? Where id = ?");
            // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date createdDate = insurance.getCreatedDate();

            stmnt4.setString(1, insurance.getName());
            stmnt4.setDate(2, new java.sql.Date(createdDate.getTime()));
            stmnt4.setInt(3, insurance.getId());
            int row = stmnt4.executeUpdate();
            System.out.println(row);

            InsuranceRepository insuranceRep = new InsuranceRepository();
            insurance = insuranceRep.getInsurances(insurance);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return insurance;
    }

    /* private MockDatabase mockDatabase = MockDatabase.getInstance();
     *
     *
     * public List<Insurance> getInsurances(long personId) {
     * List<Insurance> insuranceList = null;
     * Map<Long, Insurance> insurances = mockDatabase.getInsurances(personId);
     * if (insurances != null) {
     * insuranceList = new ArrayList<Insurance>(insurances.values());
     * }
     * return insuranceList;
     * }
     *
     * public Insurance getInsurance(long personId, long insuranceId) {
     * return mockDatabase.getInsurance(personId, insuranceId);
     * }
     *
     * public Insurance addInsurance(long personId, Insurance insurance) {
     * return mockDatabase.addInsurance(personId, insurance);
     * }
     *
     * public void deleteInsurance(long personId, long insuranceId) {
     * mockDatabase.deleteInsurance(personId, insuranceId);
     *
     * }
     *
     * public Insurance updateInsurance(long personId, Insurance insurance) {
     * return mockDatabase.updateInsurance(personId, insurance);
     *
     * } */
}
