package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import POJO.LoginModel;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataProvider {

    @DataProvider(name = "loginValidDataProvider")
    public Object[][] loginValidDataProvider() {
        return new Object[][]{
//                      username, password
                {"ioanacorinaoancea@gmail.com", "SnoopyDog12!"}
        };
    }

    @DataProvider(name = "loginInvalidDataProvider")
    public Iterator<Object[]> loginInvalidDataProvider() throws IOException {
        Collection<Object[]> loginDP = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/loginInvalidTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);

        for (LoginModel loginModel : loginModelList)
            loginDP.add(new Object[]{loginModel});

        return loginDP.iterator();
    }
}
