public class Capital {
    private String capname;
    private Double population;

    public Capital(String capname, Double population) {
        this.capname = capname;
        this.population = population;
    }

    public String getInfo() {
        return "首都： " + capname+",人口:  "+population + "千万";
    }

}
