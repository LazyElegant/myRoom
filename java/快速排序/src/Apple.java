import java.util.Scanner;

public class Apple {

    private Boolean worm;
    private Double price;
    private Double weight;


    public Apple(Boolean worm, Double weight) {
        this.worm = worm;
        this.weight = weight;
        if (worm){
            this.price=this.weight *10;
        }else {
            this.price= this.weight*5;
        }
    }

    public Double getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean b = Boolean.valueOf(scanner.nextLine());
        Double w = Double.valueOf(scanner.nextLine());
        Apple apple = new Apple(b,w);
        System.out.println(String.format("%.2f",apple.getPrice()));
    }
}
