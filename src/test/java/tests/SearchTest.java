package tests;

import POJO.SearchModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    @Test(dataProvider = "searchDataProvider", dataProviderClass = data.SearchDataProvider.class)
    public void searchTest(SearchModel searchModel) {
        setUP();
        driver.navigate().to(baseURL);
        SearchPage searchPage = new SearchPage(driver);
        System.out.println(searchModel);
        searchPage.search(searchModel.getSearchPhrase());
        System.out.println("Verify valid search results");
        Assert.assertTrue(searchPage.verifyValidSearchResults(searchModel.getSearchPhrase()));
    }

}
