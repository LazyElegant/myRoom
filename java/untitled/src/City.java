public class City {
    private String number;
    private String name;
    private double population;

    public City(String number, String name, double population) {
        this.number = number;
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return  number +"  "+ name +"  " +  population ;
    }
}
