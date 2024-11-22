package objectModels;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SearchModel {

    private String searchPhrase;

    public SearchModel(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    @XmlElement
    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    @Override
    public String toString() {
        return "SearchModel: {" +
                "searchPhrase='" + searchPhrase + '\'' +
                '}';
    }
}
