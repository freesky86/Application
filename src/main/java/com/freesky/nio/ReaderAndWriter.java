/**
 * JAVA NIO
 * 
 * https://www.jianshu.com/p/d30893c4d6bb
 */
package com.freesky.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Channel & Buffer
 * 
 * @author freesky
 */
public class ReaderAndWriter {

    /**
     * @param args
     */
    public static void main(String[] args) {
        nio();

        // File file = new File(".");
        // System.out.println(file.getAbsolutePath());
    }

    public static void nio() {
        File input = new File("resource/input.txt");
        File output = new File("resource/output.txt");
        try {
            // 1. source
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            // 2. channel
            FileChannel inputChannel = fis.getChannel();
            FileChannel outputChannel = fos.getChannel();

            // 3. buffer
            ByteBuffer buffer = ByteBuffer.allocate(256);

            // 4. read from channel and write into buffer
            int read = inputChannel.read(buffer);
            System.out.println("--read result: " + read);

            // 5. transfer the mode of buffer from write to read
            buffer.flip();

            // 6. write from buffer and send to channel
            outputChannel.write(buffer);

            // 7. reset buffer
            buffer.clear();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
