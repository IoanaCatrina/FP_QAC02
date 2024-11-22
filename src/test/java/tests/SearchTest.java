package tests;

import objectModels.SearchModel;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    @Test(dataProvider = "searchDataProvider", dataProviderClass = dataProviders.SearchDataProvider.class)
    public void searchTest(SearchModel searchModel) {

        setUP();
        driver.navigate().to(baseURL);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(searchModel.getSearchPhrase());
    }
}
