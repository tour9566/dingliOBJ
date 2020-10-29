package object.task.day1019;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File inFile = new File("test.txt");//指定源文件       
        File outFile = new File("file2.txt"); //指定目标文件
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(inFile);
            outputStream = new FileOutputStream(outFile);
            int temp;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
