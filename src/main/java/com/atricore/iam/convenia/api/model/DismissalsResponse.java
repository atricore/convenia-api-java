package com.atricore.iam.convenia.api.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DismissalsResponse {

    private List<DismissalRecord> data;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    private Integer from;

    @JsonProperty("last_page")
    private Integer lastPage;

    @JsonProperty("last_page_url")
    private String lastPageUrl;

    private List<Link> links;

    // Getters and setters
    public List<DismissalRecord> getData() {
        return data;
    }

    public void setData(List<DismissalRecord> data) {
        this.data = data;
    }

    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public String getLastPageUrl() {
        return lastPageUrl;
    }

    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
