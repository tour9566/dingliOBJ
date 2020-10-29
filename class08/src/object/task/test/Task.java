package object.task.test;

import java.io.*;

public class Task {
    public static void main(String[] args) {
        WriteContest();

        copyContest();

        WriteGBK();
//        new InputStreamReader(new FileInputStream())

    }

    private static void WriteGBK() {
        String contest = "  静夜思\r\n窗前明月光\r\n疑是地上霜\r\n举头望明月\r\n低头思故乡";
        OutputStreamWriter outputStream;
        try {
            outputStream = new OutputStreamWriter(new FileOutputStream("test1.txt"), "GBK");
            outputStream.write(contest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyContest() {
        InputStream inputStream=null;
        OutputStream outputStream=null;

        try {
            inputStream = new FileInputStream("test.txt");
            outputStream =new FileOutputStream("copy.txt");
            int temp=0;
            while ((temp=inputStream.read())!=-1){
                outputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void WriteContest() {
        String contest="  静夜思\r\n窗前明月光\r\n疑是地上霜\r\n举头望明月\r\n低头思故乡";
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("test.txt");
            byte[] bytes = contest.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
