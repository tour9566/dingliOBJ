package object.stream;

import java.io.*;

public class IoStreamOpration {
    public static void main(String[] args) {

        String dir = "D:" + File.separator + "WorkSpaces" + File.separator + "DingLi" + File.separator + "share1" + File.separator;
        String touch = "file.txt";
        //2.实例化File对象
        String path = dir + touch;

//
        String content = "\n\r湖北鼎利学院1810班";
        //一块一块写入
//        writeBlock(content,path);

        //一个字节一个字节写入
//        writeSingle(content,path);

        //一块一块读取
        readBlock(path);

        //一个字节一个字节读取
//        readSingle(path);
//        writeToFile(content, path, false);
//        readfromFile(path);


//        String encoding = "utf-8";
//        try {
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path), encoding);
//            outputStreamWriter.write("你好");
//            outputStreamWriter.flush();
//            System.out.println("写入完成");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), "GBK");
//            char[] cs=new char[1024];
//            int len=-1;
////            System.out.println("读取长度"+inputStreamReader.read(cs));
//            while((len=inputStreamReader.read())!=-1){
//                System.out.println(new String(cs,0,len));
//                System.out.println("111111");
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void readBlock(String path) {
        FileInputStream inputStream = null;
        byte[] bytes = new byte[1024];
        int length = 0;
        try {
            inputStream = new FileInputStream(path);
            while ((length = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, length));
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
        }
    }

    private static void readSingle(String path) {
        FileInputStream inputStream = null;
        int temp;
        int length = 0;
        byte[] bytes = new byte[1024];
        try {
            inputStream = new FileInputStream(path);
            while ((temp = inputStream.read()) != -1) {
                bytes[length] = (byte) temp;
                length++;
            }
            System.out.println(new String(bytes, 0, length));
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
        }


    }

    private static void writeSingle(String content, String path) {
        byte[] bytes = content.getBytes();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeBlock(String content, String path) {
        byte[] bytes = content.getBytes();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private static void readfromFile(String path) {
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(path);
//            byte[] bytes = new byte[1024];
//            int length = fileInputStream.read(bytes);
//            System.out.println(new String(bytes, 0, length));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("读取完毕");
//        }
//
//    }


    private static void writeToFile(String content, String path, boolean append) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path, append);
            byte[] bytes = content.getBytes();
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                System.out.println("写入完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
