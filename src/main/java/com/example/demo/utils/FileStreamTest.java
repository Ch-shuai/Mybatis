package com.example.demo.utils;

import com.google.common.base.Utf8;
import org.apache.poi.hssf.record.DVALRecord;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.JarOutputStream;

/**
 * 2020/3/13
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      读取外面的文件需要使用反斜杠来进行转义，
        字节流,FileInputStream,FileOutStream
 *          输入流，        输出流
 *
 *      slash,斜杠
 *
 *        关闭,先关闭输出流，后关闭输入流
 *             fileOutputStream.flush();
 *             fileOutputStream.close();
 *             fileInputStream.close();
 */
public class FileStreamTest {

    public static void main(String[] args) throws Exception {
        FileStreamTest filetStreamTest = new FileStreamTest();
//        filetStreamTest.CopyDirectoryTest("D:\\Collections\\node.js");
    }

    /**
     * 用字节流实现文件的读取
     */
    public void InputStreamTest() throws Exception {
        File file = new File("C:\\Users\\bjkf0\\Desktop\\loginCmd.text");
        if (file.isDirectory() || ! file.exists()){
            System.out.println("该文件为文件夹或者是文件不存在");
        }
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        try {
            int readLength = inputStream.read(bytes);
            if (readLength != -1){
                //创建string（要转化为字符的字节，起始位置，长度，编码格式）
                String s = new String(bytes, 0, readLength, "GBK");
                System.out.println("读取到的数据是"+s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        CheckCodeFormat(inputStream);
        inputStream.close();
    }

    /**
     * 利用字节输出流实现文件的写入
     */
    public void OutputStreamTest() throws Exception {
        File file = new File("C:\\Users\\bjkf0\\Desktop\\loginCmd.text");
        if (file.isDirectory() || ! file.exists()){
            System.out.println("该文件为文件夹或者是文件不存在");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String str = "这是使用OutputStream写入的";
        fileOutputStream.write(str.getBytes("UTF-8"));
        fileOutputStream.flush();
        fileOutputStream.close();
        InputStreamTest();
    }

    /**
     * 利用字节输入流和字节输出流实现文件的拷贝
     */
    public void CopyTest(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.isDirectory() || ! file.exists()){
            System.out.println("该文件为文件夹或者是文件不存在");
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //获取文件名
        String fileName = file.getName();
        /*
        String fileName = getFileName(file.getName());
         */
        System.out.println(fileName);
        String target_path = "D:\\git\\"+fileName;
        System.out.println(target_path);
        //设置输出流的路径
        FileOutputStream fileOutputStream = new FileOutputStream(target_path);
        byte[] bytes = new byte[1024];
        int size = 0;
        do {
            //源文件使用fileInputStream去读取文件，
            size = fileInputStream.read(bytes);
            if (size!=-1){
            //复制之后的文件，使用FileOutStream
            fileOutputStream.write(bytes,0,size);
            }
        }while (size!=-1);
        //关闭,先关闭输出流，后关闭输入流
            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();
}

    /**
     * 设置Copy之后的文件名
     * @param name
     * @return
     */
    private static String getFileName(String name) {
        //格式化时间，将当前时间保存到新的文件中
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        //abc.mp4  ---abc_20190805164520.mp4
        //根据.分别获取文件名称和扩展名
        String[] name_infos = name.split("\\.");
        //获取当前日期的字符串
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        System.out.println(dateStr);
        return name_infos[0]+"_"+dateStr+"."+name_infos[1];

    }

    /**
     *  使用字节流复制某一文件夹下所有文件
     *      FileFilter,File过滤器，得到的是每一个文件的file对象
     */
    public void CopyDirectoryTest(String filePath) throws Exception {
        System.out.println(filePath);
        File file = new File(filePath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || ! pathname.getPath().endsWith("msi")){
                    return true;
                }
                return false;
            }
        };
        File[] listFiles = file.listFiles(fileFilter);
        int length = listFiles.length;
        for (int i=0 ;i<listFiles.length;i++){
            File childFile = listFiles[i];
            //如果childFile是一个文件，则直接复制
            if (childFile.isFile()){
                byte[] bytes = new byte[1024];
                FileInputStream fileInputStream = new FileInputStream(childFile);
                int readLength = fileInputStream.read(bytes);
                String name = childFile.getName();
                String target_path = "C:\\Users\\bjkf0\\Desktop\\" + name;
                //按照文件的路径去创建新的复制文件
                FileOutputStream fileOutputStream = new FileOutputStream(target_path);
                //先判断里面有没有数据
                if (readLength != -1){
                    fileOutputStream.write(bytes,0,readLength);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                fileInputStream.close();
            }
            if (childFile.isDirectory()){
                String childFilePath = childFile.getPath();
                CopyDirectoryTest(childFilePath);
            }

        }
    }
    /**
     *      使用字符流的读取和写入
     *          Char是字符
     */
    public void ReaderTest(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[10000];
        int read = fileReader.read(chars);
        FileWriter fileWriter = new FileWriter("C:\\Users\\12825\\Desktop\\"+file.getName());
        fileWriter.write(read);
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
      }

    /**
     * 检验数据流的编码格式
     * @param inputStream       文件输入流
     * @throws IOException
     */
    private void CheckCodeFormat(FileInputStream inputStream) throws IOException {
        InputStreamReader streamGBKReader = new InputStreamReader(inputStream, "GBK");
        int GBKlength = streamGBKReader.read();

        InputStreamReader streamUTF8Reader = new InputStreamReader(inputStream, "UTF-8");
        int UTFlength = streamUTF8Reader.read();

        if (UTFlength>GBKlength){
            System.out.println("使用的是UTF-8");
        }else {
            System.out.println("使用的是GBK");
        }
        streamGBKReader.close();
        streamUTF8Reader.close();
    }

}
