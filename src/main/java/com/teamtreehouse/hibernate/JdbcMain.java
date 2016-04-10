package com.teamtreehouse.hibernate;

import java.sql.*;

/**
 * Created by leonardo on 10.04.2016.
 */
public class JdbcMain
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:contactmgr.db")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS contacts");

            statement.executeUpdate("CREATE TABLE contacts (id INTEGER PRIMARY KEY, firstname STRING, lastname STRING, email STRING, phone INT(10))");

            Contact leo = new Contact("Leonardo", "Cserny", "email@email.com", 351315);
            save(leo, statement);

            Contact sabina = new Contact("Sabina", "Hodorog", "email3@email.com", 8814351);
            save(sabina, statement);
//            statement.executeUpdate("INSERT INTO contacts (firstname, lastname, email, phone) VALUES ('Leonardo', 'Cserny', 'email@email.com', 351315)");
//            statement.executeUpdate("INSERT INTO contacts (firstname, lastname, email, phone) VALUES ('Sabina', 'Hodorog', 'email3@email.com', 8814351)");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");

                System.out.printf("%s, %s with id: %d%n", firstName, lastName, id);
            }
        } catch (SQLException ex) {
            System.err.printf("There was a database error: %s%n", ex.getMessage());
        }
    }

    public static void save(Contact contact, Statement statement) throws SQLException
    {
        // compose query
        String sql = "insert into contacts (firstname, lastname, email, phone) values ('%s', '%s', '%s', %d)";
        sql = String.format(sql, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());

        // execute query
        statement.executeUpdate(sql);
    }
}
