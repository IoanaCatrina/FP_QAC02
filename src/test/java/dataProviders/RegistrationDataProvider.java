package dataProviders;

import objectModels.RegistrationModel;
import org.testng.annotations.DataProvider;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDataProvider {
    @DataProvider(name = "registrationDataProvider")
    public Iterator<Object[]> registrationDataProvider() throws SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();

        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users" );

        while (resultSet.next()) {
            RegistrationModel register = new RegistrationModel
                    (databaseUtils.getElementFromDB(resultSet, "lastname"),
                    databaseUtils.getElementFromDB(resultSet, "firstname"),
                    databaseUtils.getElementFromDB(resultSet, "phone"),
                    databaseUtils.getElementFromDB(resultSet, "email"),
                    databaseUtils.getElementFromDB(resultSet, "address"),
                    databaseUtils.getElementFromDB(resultSet, "city"),
                    databaseUtils.getElementFromDB(resultSet, "county"),
                    databaseUtils.getElementFromDB(resultSet, "password"),
                    databaseUtils.getElementFromDB(resultSet, "confirmPassword"),
                    databaseUtils.getElementFromDB(resultSet, "registerError"));
            dp.add(new Object[]{register});
        }
        return dp.iterator();
    }
}
