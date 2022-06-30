public class TestDivision {
    public static Double Division(Double beDivided,Double divided){
        if (divided == 0){
            return 0.0;
        }
        return beDivided / divided;
    }

    public static void main(String[] args) {
        Double division = Division(34.0, 2.0);

        if (division==0){
            System.out.println("除数不能为零");
        }else {
            System.out.println(division);
        }
    }
}
