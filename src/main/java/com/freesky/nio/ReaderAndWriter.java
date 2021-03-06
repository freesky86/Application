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
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * JAVA NIO
 * 
 * @author freesky
 */
public class ReaderAndWriter {

    public static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(1024));
    }

    public static void handleRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = sc.read(buf);
        }
        if (bytesRead == -1) {
            sc.close();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // channel & buffer
        // operateByChannelAndBuffer();

        // selector
        try {
            operateBySelector();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File file = new File(".");
        // System.out.println(file.getAbsolutePath());
    }

    /**
     * Channel & Buffer
     */
    public static void operateByChannelAndBuffer() {
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
            System.out.println("--------------------");
            byte[] data = buffer.array();
            String str = new String(data);
            System.out.println(str);
            System.out.println("--------------------");

            // 5. transfer the mode of buffer from write to read
            buffer.flip();

            // 6. write from buffer and send to channel
            outputChannel.write(buffer);

            // 7. reset buffer
            buffer.clear();

            // 8. close file input/output stream
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use selector
     */
    public static void operateBySelector() throws IOException {
        // 1. ????Selector????
        Selector selector = Selector.open();

        // 2. ??Selector????????????
        // a. ??????????????????????????????????
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);

        // b. ??????????????????
        ServerSocket socket = server.socket();
        InetSocketAddress address = new InetSocketAddress(8080);
        socket.bind(address);

        // c. ??Selector??????????????????
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 3. ????????
        try {
            System.out.println("--Listening...");
            while (true) {
                // ??????????????????????????????????????????????
                selector.select();
                // ????????????????????????????????????????
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iter = keys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove();
                    // System.out.println("--Key is " + key);
                    processKey(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            handleAccept(key);
        }
        if (key.isReadable()) {
            handleRead(key);
        }
    }
}
