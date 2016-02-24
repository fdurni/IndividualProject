package com.feliciadurni.tt.persistence;

import com.feliciadurni.tt.entity.Person;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felic on 2/7/2016.
 */
public class PersonDaoWithSql implements PersonDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<Person>();

        Database database = Database.getInstance();

        Connection connection = null;


        String sql = "select * from Person order by personId";
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            // iterate over the resultset, adding each person to the list
            while (results.next()) {
                Person person = createPersonFromResults(results);
                people.add(person);
            }
        } catch (SQLException e) {
            log.error("SQL Exception: ", e);
        } catch (Exception e) {
            log.error(e);
        }


        return people;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }

    @Override
    public int addPerson(Person person) {
        return 0;
    }

    private Person createPersonFromResults(ResultSet results) throws SQLException {
        Person person = new Person();
        person.setPersonId(results.getInt("personId"));
        person.setFirstName(results.getString("firstName"));
        person.setLastName(results.getString("lastName"));
        person.setUserName(results.getString("userName"));
        person.setPassword(results.getString("password"));
        return person;
    }
}
