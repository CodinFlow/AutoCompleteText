package de.project.autocompletetext;

public class CountryItem {
    private String countryName;
    private String imageUrl;

    public CountryItem(String countryName, String imageUrl) {
        this.countryName = countryName;
        this.imageUrl = imageUrl;


    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "CountryItem{" +
                "countryName='" + countryName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}