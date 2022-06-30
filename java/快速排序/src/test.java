import java.util.Scanner;

/**
 * @Author admin
 * @create 2022/6/6 11:05
 */
public class test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.valueOf(scanner.nextLine());

        Integer arr[] = new Integer[n];
        for (Integer i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Integer x = arr[arr.length /2];
        for(int i = 0,j = n-1;i >= j ;){
            if (arr[i] < x ){
                i++;
            }else if(arr[j] >= x ){
                j--;
            }else {
                int te = arr[i];
                arr[i] = arr[j];
                arr[j] = te;
            }
        }

        for (Integer integer : arr) {
            System.out.println(integer);
        }


    }
}
