import java.util.ArrayList;
import java.util.Arrays;

public class Node {

    private Node left;

    private Node right;

    private Integer value;

    public static Integer[] insert(Integer[] arr) {

        Node n = new Node();
        n.value = arr[0];
        for (int i =1; i< arr.length;i++){
            if ( arr[i] !=null && n.value >= arr[i]){
                Node rn = new Node();
                n.right= rn;
                rn.value = arr[i];
            }else if( arr[i]!=null &&n.value < arr[i] ){
                Node ln = new Node();
                n.left= ln;
                ln.value= arr[i];
            }
        }
        return preOrder(n);
    }
    private static Integer[] preOrder(Node root){
        ArrayList list = new ArrayList();
        if (root!= null){
            list.add(root.value);
            Integer[] left = preOrder(root.left);
            for (Integer integer : left) {
                list.add(integer);
            }

            Integer[] right = preOrder(root.right);
            for (Integer integer : right) {
                list.add(integer);
            }
        }
        return Arrays.copyOfRange(list.toArray(),0,list.toArray().length,Integer[].class);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insert(new Integer[]{1, null, 2, 3})));
    }
}