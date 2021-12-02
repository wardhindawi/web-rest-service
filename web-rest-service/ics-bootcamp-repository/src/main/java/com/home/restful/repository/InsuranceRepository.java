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

    public InsuranceRepository() {

        System.out.println("Insurance repository called");
    }

    public Map<Integer, Insurance> getInsurance() {
        Map<Integer, Insurance> insuranceResult = new HashMap<>();
        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            stmnt = conn.prepareStatement("select id , name , createdDate from Insurance");
            rs = stmnt.executeQuery();
            InsuranceRepository insuranceRep = new InsuranceRepository();
            Insurance insurance = new Insurance();
            int key = 1;
            while (rs.next()) {
                insurance = new Insurance();
                insurance.setId(rs.getInt("id"));
                insuranceResult.put(key, insuranceRep.getInsurances(insurance));
                key++;
            }

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) { // ignore
            }

            try {
                if (stmnt != null && !stmnt.isClosed()) {
                    stmnt.close();
                }
            } catch (SQLException e) { // ignore
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return insuranceResult;
    }

    public Insurance getInsurances(Insurance insurance) {

        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            stmnt = conn.prepareStatement("select id , name , createdDate from Insurance where id = ?");
            stmnt.setInt(1, insurance.getId());
            rs = stmnt.executeQuery();

            while (rs.next()) {

                insurance.setId(rs.getInt("id"));
                insurance.setName(rs.getString("name"));
                insurance.setCreatedDate(rs.getDate("createdDate"));

            }

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();

        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) { // ignore
            }

            try {
                if (stmnt != null && !stmnt.isClosed()) {
                    stmnt.close();
                }
            } catch (SQLException e) { // ignore
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) { // ignore
            }
        }
        return insurance;
    }

    public Insurance addInsurance(Insurance insurance) throws ParseException {
        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            stmnt = conn.prepareStatement("insert into Insurance(id , name , createdDate) values (?,?,?) ");

            java.util.Date createdDate = insurance.getCreatedDate();

            stmnt.setInt(1, insurance.getId());
            stmnt.setString(2, insurance.getName());
            stmnt.setDate(3, new java.sql.Date(createdDate.getTime()));
            stmnt.execute();

            InsuranceRepository insuranceRep = new InsuranceRepository();
            insurance = insuranceRep.getInsurances(insurance);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) { // ignore
            }

            try {
                if (stmnt != null && !stmnt.isClosed()) {
                    stmnt.close();
                }
            } catch (SQLException e) { // ignore
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) { // ignore
            }

        }

        return insurance;

    }

    public void deleteInsurance(Insurance insurance) {
        ResultSet rs = null;
        PreparedStatement stmnt = null;
        Connection conn = null;
        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            stmnt = conn.prepareStatement("delete from Insurance where id=?");
            stmnt.setInt(1, insurance.getId());
            int row = stmnt.executeUpdate();
            System.out.println(row);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) { // ignore
            }

            try {
                if (stmnt != null && !stmnt.isClosed()) {
                    stmnt.close();
                }
            } catch (SQLException e) { // ignore
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) { // ignore
            }

        }
    }

    public Insurance updateInsurance(int personId, Insurance insurance) throws ParseException {
        ResultSet rs = null;
        PreparedStatement stmnt4 = null;
        Connection conn = null;

        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");

            stmnt4 = conn.prepareStatement(" Update Insurance Set name = ? Where id = ?");
            // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            //java.util.Date createdDate = insurance.getCreatedDate();

            stmnt4.setString(1, insurance.getName());

            stmnt4.setInt(2, insurance.getId());
            int row = stmnt4.executeUpdate();
            System.out.println(row);

            InsuranceRepository insuranceRep = new InsuranceRepository();
            insurance = insuranceRep.getInsurances(insurance);

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) { // ignore
            }

            try {
                if (stmnt4 != null && !stmnt4.isClosed()) {
                    stmnt4.close();
                }
            } catch (SQLException e) { // ignore
            }
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) { // ignore
            }

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
