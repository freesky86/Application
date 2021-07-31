package com.freesky.io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * https://blog.csdn.net/liangjf85/article/details/84654073
 * 
 * @author freesky
 */
public class ByteArrayOutputStreamTest {

    public static void main(String[] args) {
        try {
            FileInputStream fos = new FileInputStream("resource/input.txt");
            int size = 0;
            double i = 1;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            for (; (size = fos.read()) != -1; i++) {
                out.write(size);
            }

            fos.close(); // it dosn't take effect

            System.out.println("-----------input.txt content-------------");
            byte retArr[] = out.toByteArray();
            String str = new String(retArr);
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
