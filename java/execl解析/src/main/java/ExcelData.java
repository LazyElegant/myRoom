import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author admin
 * @create 2021/10/4 17:35
 */
public class ExcelData {

    private XSSFSheet sheet;


    /**
     * 构造函数，初始化excel数据
     * @param filePath  excel路径
     * @param sheetName sheet表名
     */
    ExcelData(String filePath,String sheetName){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            this.sheet = sheets.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断传入字符是否是英文
     * @param a
     * @return
     */
    public static boolean examCode(char a){
        return a >= 'A' && a <= 'Z' || a >= '0' && a <= '9' ||a >= 'a' && a <= 'z' || a == '-' || a == ' ' || a == ')' || a == '(' || a == '\''
                || a == '<' || a == '&' || a == '.' || a == ',' || a == '（' || a == '）' || a == '\u00AD';
    }

    /**
     * 判断传入字符是否是中文
     * @param a
     * @return
     */
    public static boolean examWord(char a){
        return a >= 'A' && a <= 'Z' || a >= 'a' && a <= 'z' || a == '-' ;
    }
    /**
     * 获取英文
     * @param sum
     * @return
     */
    public static String getCode(String sum){

        String code = "";

        for (int i = 0 ; i< sum.length(); i++){
            if (sum.charAt(i) != '(') {
                if(examCode(sum.charAt(i))){
                    code += sum.charAt(i);
                }else {
                    return code;
                }
            }else if (sum.charAt(i) == '（'){
                code += examCode(sum.charAt(i+1)) ? "（" : "";
            }
            else {
                code += examCode(sum.charAt(i+1)) ? "(" : "";
            }
        }
        return code;
    }

    /**
     * 获取中文
     * @param sum
     * @return
     */
    public static String getWord(String sum){

        String word = "";

        for (int i = 0 ; i< sum.length(); i++){
            if (!examWord(sum.charAt(i))) {
                word += sum.charAt(i);
            } else {
                return word;
            }
        }
        return word;
    }

    //判断文件是否存在
    public static boolean fileExist(String filePath){
        boolean flag = false;
        File file = new File(filePath);
        flag = file.exists();
        return flag;
    }

    public static void main(String[] args) {

        String relativelyPath=System.getProperty( "user.dir" );
        ExcelData sheet1 = new ExcelData(relativelyPath + "\\src\\main\\resources\\1.xlsx", "sheet1");

        //写入地址
        String filePath = relativelyPath + "\\src\\main\\resources\\2.xlsx";
        // 行数
        int num =sheet1.sheet.getLastRowNum();
        // 单词本
        String sum = "";
        // 用于存放英文
        List<String>  English = new ArrayList<>();
        // 用于存放中文
        List<String> Chinese = new ArrayList<>();

        // 循环将所有的单词提出
        for (int i = 0 ; i<= num ; i++){
            XSSFRow row = sheet1.sheet.getRow(i);
            XSSFCell cell = row.getCell(0);
            sum += cell;
        }

        //将单词本分为英语和中文
        while (!sum.isEmpty()){
            String code = getCode(sum);
            English.add(code.trim());
            sum = sum.substring(code.length());
            String word = getWord(sum);
            Chinese.add(word.trim());
            sum = sum.substring(word.length());
        }

        boolean flag = fileExist(filePath);

        if (!flag){
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("English");
            XSSFRow firstRow = sheet.createRow(0);
            XSSFCell cells[] = new XSSFCell[2];

            String[] titles = new String[]{"单词","意思"};
            //循环设置表头信息
            for (int i=0;i<titles.length;i++){
                cells[0]=firstRow.createCell(i);
                cells[0].setCellValue(titles[i]);
            }

            //遍历list,将数据写入Excel中
            for (int i=0;i<English.size();i++){
                XSSFRow row = sheet.createRow(i+1);
                XSSFCell cell = row.createCell(0); //第一列
                cell.setCellValue(English.get(i));
                cell=row.createCell(1); //第二列
                System.out.println(Chinese.get(i));
                cell.setCellValue(Chinese.get(i));
            }
            OutputStream out = null;
            try {
                out = new FileOutputStream(filePath);
                workbook.write(out);
                System.out.println("1");
                out.close();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
