package dataProviders;

import com.opencsv.exceptions.CsvException;
import objectModels.RegistrationModel;
import org.testng.annotations.DataProvider;
import utils.CSVUtils;
import utils.DatabaseUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RegistrationDataProvider {
    @DataProvider(name = "registrationDataProvider")
    public Iterator<Object[]> registrationDataProvider() throws SQLException {
        Collection<Object[]> dp = new ArrayList<>();
        DatabaseUtils databaseUtils = new DatabaseUtils();

        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

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

// DataProvider for validating email format for registration page

    @DataProvider(name = "emailFormatDataProvider")
    public Iterator<Object[]> emailFormatDataProvider() throws IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();

        List<String[]> csvData = CSVUtils.readCSV("src/test/resources/testData/registrationEmailFormatValidationTest.csv");

        int lastnameIndex = 0, firstnameIndex = 1, phoneIndex = 2, emailIndex = 3,
                addressIndex = 4, cityIndex = 5, countyIndex = 6, passwordIndex = 7, confirmPasswordIndex = 8, registerErrorIndex = 9;

        for (int i = 1; i < csvData.size(); i++) {
            String[] line = csvData.get(i);
            RegistrationModel registrationModel = new RegistrationModel(line[lastnameIndex], line[firstnameIndex], line[phoneIndex],
                    line[emailIndex], line[addressIndex], line[cityIndex], line[countyIndex],
                    line[passwordIndex], line[confirmPasswordIndex], line[registerErrorIndex]);

            dp.add(new Object[]{registrationModel});

        }
        return dp.iterator();
    }

}