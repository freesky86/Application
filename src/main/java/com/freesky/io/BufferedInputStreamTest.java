/**
 * https://blog.csdn.net/forezp/article/details/88414741/
 */
package com.freesky.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author freesky
 */
public class BufferedInputStreamTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        method1();
        // method2();
    }

    /**
     * New IO
     */
    public static void method1() {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("resource/input.txt", "rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            // System.out.println(buf.getChar());
            // System.out.println(buf.get());
            // System.out.println((char) buf.get());
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (aFile != null) {
                    aFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Traditional IO
     */
    public static void method2() {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("resource/input.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                System.out.println();
                System.out.println("--------------------");
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
