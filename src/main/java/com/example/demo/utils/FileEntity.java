package com.example.demo.utils;

import java.io.*;
import java.util.stream.Stream;

/**
 * 2020/3/12
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      读取外面的文件需要使用反斜杠来进行转义，
 */
public class FileEntity {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\bjkf0\\Desktop");
        //是否可写
        boolean canWrite = file.canWrite();
        System.out.println("是否可写" + canWrite);
        boolean canRead = file.canRead();
        System.out.println("是否可读" + canRead);
        long size = file.length();
        System.out.println("文件大小:" + size);
        boolean isFile = file.isFile();
        System.out.println("是否是文件:" + isFile);
        boolean isDirectory = file.isDirectory();
        System.out.println("是否是文件夹:" + isDirectory);
        String filename = file.getName();
        System.out.println("文件的名称:" + filename);
        String absolutePath = file.getAbsolutePath();
        System.out.println("文件的绝对路径:" + absolutePath);
        String filepath = file.getPath();
        System.out.println("文件的路径:" + filepath);
        boolean isExists = file.exists();
        System.out.println("是否存在:" + isExists);
        boolean isDelete = file.delete();
        System.out.println("是否已经被删除:" + isDelete);
        boolean isCreate = false;
        try {
            isCreate = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建了没有:" + isCreate);
        String fileMessage = getFileMessage();
        System.out.println(fileMessage);
    }

    private static void testDirectoryDeme(File file) {
        if (file.isDirectory()){
            File[] files = file.listFiles();
            System.out.println("文件夹"+file.getName()+"有"+files.length+"个文件");
            for (int i = 0; i < files.length; i++) {
                File childFile = files[i];
                if (childFile.isFile()) {
                    // 这是一个文件
                    System.out.println("\t这是一个文件:" + childFile.getName());
                } else {
                    // 文件夹:继续递归调用
                    testDirectoryDeme(childFile);
                }
            }
        } else {
            // 这是一个文件
            System.out.println("\t这是一个文件:" + file.getName());
        }
    }

    public static String getFileMessage(){
        File file = new File("C:\\Users\\bjkf0\\Desktop\\loginCmd.text");
        byte[] bytes = new byte[1024];
        String string = null;
        int readLength = 0;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            //将数据存储到byte中，返回长度
            readLength= inputStream.read(bytes, 0, bytes.length);
            string = new String(bytes, 0, readLength, "UTF-8");
            System.out.println(string);
            if (readLength!= -1){
                inputStream.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "address"+string + "read.length" + readLength;
    }
}
