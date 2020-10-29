package object.task.day1019;

import java.io.*;

public class Task {
    public static void main(String[] args) {

        String contest = " 静夜诗\r\n窗前明月光,\r\n疑是地上霜,\r\n举头望明月,\r\n低头思故乡。";
        writeContext(contest, "test.txt");
        copyContest("test.txt", "copy.txt");
        write(contest, "test3.txt", "GBK");
        GbkToUTF();


    }

    private static void GbkToUTF() {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream("test.txt"), "GBK");
            char[] chars = new char[1024];
            int length = inputStreamReader.read(chars);
            String temp = new String(chars, 0, length);
            System.out.println(new String(temp));
            write(temp, "testUTF.txt", "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void write(String contest, String Path, String charset) {
        OutputStreamWriter OutputStreamWriter = null;
        try {
            OutputStreamWriter = new OutputStreamWriter(new FileOutputStream(Path), charset);
            OutputStreamWriter.write(contest);
            OutputStreamWriter.flush();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyContest(String from, String to) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(from);
            outputStream = new FileOutputStream(to);
            int temp;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeContext(String contest, String file) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = contest.getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
