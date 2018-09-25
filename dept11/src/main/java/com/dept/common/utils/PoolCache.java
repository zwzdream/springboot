package com.dept.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WH1707008
 * @date 2018/8/30 11:40
 * Description: 相当于一个缓存池， 可使用redis代替
 */
public class PoolCache {
    private static final Logger logger = LoggerFactory.getLogger(PoolCache.class);

    // 缓存超时时间 10分钟
    private static Long timeOutSecond = 10 * 60 * 1000L;

    /*每半小时清理一次缓存*/
    private static Long cleanIntervalSecond = 30 * 60 * 1000L;


    /*专用于高并发的map类-----Map的并发处理（ConcurrentHashMap）*/
    public static ConcurrentHashMap<String, ScanPool> cacheMap = new ConcurrentHashMap<>();


    static {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(cleanIntervalSecond);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clean();
            }

        }).start();
    }

    public static void clean(){
        try {
            if (cacheMap.keySet().size()>0){
                Iterator<String> iterator = cacheMap.keySet().iterator();
                while(iterator.hasNext()){
                    String key=iterator.next();
                    ScanPool pool=cacheMap.get(key);
                    if(System.currentTimeMillis()-pool.getCreateTime()>timeOutSecond){
                        cacheMap.remove(key);
                    }
                }

            }
        } catch (Exception e) {
            logger.error("定时清理uuid异常", e);
        }
    }

}