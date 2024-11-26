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

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws IOException {
        Collection<Object[]> loginDP = new ArrayList<>();
        File jsonFile = new File("src/test/resources/testData/loginTestDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        LoginModel[] loginModelList = objectMapper.readValue(jsonFile, LoginModel[].class);

        for (LoginModel loginModel : loginModelList)
            loginDP.add(new Object[]{loginModel});

        return loginDP.iterator();
    }
}
