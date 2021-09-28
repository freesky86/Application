package com.freesky.rpc;

import java.io.IOException;

/**
 * @author: guangxush
 * @create: 2019/05/18
 */
public interface Server {

    int getPort();

    boolean isRunning();

    void register(Class serviceInterface, Class impl);

    void start() throws IOException;

    void stop();
}
