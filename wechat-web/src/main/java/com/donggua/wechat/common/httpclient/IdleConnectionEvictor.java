package com.donggua.wechat.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定期清理无效连接
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-04 上午 02:49
 */
public class IdleConnectionEvictor extends Thread {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(IdleConnectionEvictor.class);

    private final HttpClientConnectionManager connectionManager;

    private Integer waitTime;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connectionManager, Integer waitTime) {
        this.connectionManager = connectionManager;
        this.waitTime = waitTime;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(waitTime);
                    // 关闭失效的连接
                    connectionManager.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            LOGGER.error("清理httpClient 无效连接发生中断异常：", ex);
        }
    }

    /**
     * 销毁释放
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
