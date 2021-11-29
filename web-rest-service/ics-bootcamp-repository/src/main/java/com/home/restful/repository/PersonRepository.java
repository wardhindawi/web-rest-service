package com.home.restful.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import com.home.restful.entity.Person;

import oracle.jdbc.driver.OracleDriver;

/**
 * @author preetham
 */
public class PersonRepository {
    String connectString = "jdbc:oracle:thin:@10.100.102.5:1521:hobank";
    Connection conn = null;

    // private MockDatabase mockDatabase = MockDatabase.getInstance();

    public PersonRepository() {
        System.out.println("Person repository called");
    }

    public Map<Integer, Person> getPersons() {
        Map<Integer, Person> personResult = new HashMap<>();
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn.prepareStatement("select id , firstname, lastname , JOINEDDATE from Person");
            ResultSet rs = stmnt.executeQuery();
            PersonRepository personRep = new PersonRepository();
            Person person = new Person();
            int key = 1;
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("firstname"));
                person.setLastName(rs.getString("lastname"));
                person.setJoinedDate(rs.getDate("joineddate"));

                personResult.put(key, personRep.getPerson(person));
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
        return personResult;
    }

    public Person getPerson(Person person) {
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn
                    .prepareStatement("select id , firstName ,lastName, joinedDate from Person where id = ?");
            stmnt.setInt(1, person.getId());
            ResultSet rs = stmnt.executeQuery();

            while (rs.next()) {
                person.setId(rs.getInt("id"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setJoinedDate(rs.getDate("joinedDate"));

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

        return person;
    }

    public Person addPerson(Person person) {
        try {
            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn
                    .prepareStatement("insert into person(id , firstName , lastName, JoinedDate) values (?,?,?,?) ");
            // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date joinedDate = person.getJoinedDate();
            stmnt.setInt(1, person.getId());
            stmnt.setString(2, person.getFirstName());
            stmnt.setString(3, person.getLastName());
            stmnt.setDate(4, new java.sql.Date(joinedDate.getTime()));
            stmnt.execute();
            stmnt.close();
            conn.close();

            PersonRepository personRep = new PersonRepository();
            person = personRep.getPerson(person);

        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException f) {
                f.printStackTrace();
            }
            ex.printStackTrace();
        }
        return person;
    }

    public Person updatePerson(Person person) throws ParseException {
        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");

            PreparedStatement stmnt4 = conn
                    .prepareStatement(" Update Person Set firstName=? , lastName = ?,joinedDate = ? Where id = ?");
            // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date joinedDate = person.getJoinedDate();

            stmnt4.setString(1, person.getFirstName());
            stmnt4.setString(2, person.getLastName());
            stmnt4.setDate(3, new java.sql.Date(joinedDate.getTime()));
            stmnt4.setInt(4, person.getId());
            int row = stmnt4.executeUpdate();
            System.out.println(row);

            PersonRepository personRep = new PersonRepository();
            person = personRep.getPerson(person);

        } catch (SQLException e) {
            System.out.println(e);
        }

        return person;
    }

    public void deletePerson(Person person) {

        try {

            OracleDriver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(connectString, "EEDEV", "EEDEV");
            PreparedStatement stmnt = conn.prepareStatement("delete from person where id=?");
            stmnt.setInt(1, person.getId());
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
}
/* public List<Person> getPersons() {
 * List<Person> personList = null;
 * Map<Long, Person> persons = mockDatabase.getPersons();
 * if (persons != null) {
 * personList = new ArrayList<Person>(persons.values());
 * }
 * return personList;
 * }
 *
 * public Person getPerson(long id) {
 * return mockDatabase.getPerson(id);
 * }
 *
 * public Person addPerson(Person person) {
 * return mockDatabase.addPerson(person);
 * }
 *
 * public void deletePerson(long id) {
 * mockDatabase.deletePerson(id);
 *
 * }
 *
 * public Person updatePerson(Person person) {
 * return mockDatabase.updatePerson(person);
 *
 * }
 * } */
