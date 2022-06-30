public class Test {

    public static void main(String[] args) {

        City[] list = new City[4];
        list[0] = new City("0451","哈尔滨",600.0);
        list[1]= new City("0452","齐齐哈尔",300.0);
        list[2]= new City("0453","牡丹江",200.0);
        list[3]= new City("0454","佳木斯",180.0);
        for (int i = list.length-1; i >=0 ; i--) {
            System.out.println(list[i]);
        }

    }
}
