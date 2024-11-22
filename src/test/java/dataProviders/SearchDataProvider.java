package dataProviders;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import objectModels.SearchModel;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SearchDataProvider {

    @DataProvider(name = "searchDataProvider")
    public Iterator<Object[]> searchDataProvider() throws JAXBException {
        Collection<Object[]> dp = new ArrayList<>();

        File xmlFile = new File("src/test/resources/testData/searchTestDataInput.xml");
        SearchModel searchModel = (SearchModel) unMarshalObjectModel(xmlFile, SearchModel.class);
        dp.add(new Object[]{searchModel});
        return dp.iterator();
    }

    private Object unMarshalObjectModel(File f, Class<?>...classesToBeBound) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(f);
    }
}
