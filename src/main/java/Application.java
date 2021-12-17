import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, LiquibaseException {
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/liquibase_example","root","Hoanglong100%");
        Database database= DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(c));

        Liquibase liquibase= new Liquibase("classpath:db-changelog.xml",new ClassLoaderResourceAccessor(), database);

        liquibase.update("");
    }
}
