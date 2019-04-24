import controllers.MovieController;
import controllers.PersonController;
import database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            PersonController persons = new PersonController();
            MovieController movies = new MovieController();

            persons.create("Francis Ford Coppola");
            persons.create("Marlon Brando");
            persons.create("Al Pacino");
            Database.commit();

            movies.create("The Godfather", persons.findByName("Francis Ford Coppola"));
            movies.create("The Score", persons.findByName("Marlon Brando"));
            movies.create("A Dry white Season", persons.findByName("Marlon Brando"));
            movies.create("The Panic in Needle Park", persons.findByName("Al Pacino"));
            movies.create("Serpico", persons.findByName("Al Pacino"));
            //Add other movies to the database
            Database.commit();
            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
