public class Country {
    private String title;
    private Double area;

    public Country(String title, Double area) {
        this.title = title;
        this.area = area;
    }
    private Capital capital;

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public String getInfo() {
        return "国家名： " + title+",面积:  "+area+ "万平方千米";

    }

    public Capital getCapital() {
        return capital;
    }
}
