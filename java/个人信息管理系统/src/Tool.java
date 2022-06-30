import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
    //当前项目地址
    private final static String PATH = System.getProperty("user.dir") + "/PersonalMessage.txt";;

    /**
     * 创建6位的id
     * @return
     */
    public static Integer getID(){
        String u_word = "";
        int num = 0;
        for(int i = 0; i < 6; i++) {
            num = (int)(Math.random()*10);
            u_word = u_word + num;
        }
        return Integer.valueOf(u_word);
    }

    /**
     * 读取文件
     * @return
     */
    public static ArrayList<String> readFile(){
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader br= Files.newBufferedReader(Paths.get(PATH))) {
            String str;
            while ((str=br.readLine())!=null){
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 写入文件
     * @return
     */
    public static void writeFile(String content){
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f = new File(PATH);
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 覆盖写入文件
     * @return
     */
    public static void coverWriteFile(String content){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(PATH));
            out.write(content);
            out.close();
        } catch (IOException e) {
        }
    }

}
