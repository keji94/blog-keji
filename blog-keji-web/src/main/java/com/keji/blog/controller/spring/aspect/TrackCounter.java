package com.keji.blog.controller.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wb-ny291824 on 2017/8/21.
 * 参数化的通知来监听次数
 */
@Aspect
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

    @Pointcut(
            "execution(* com.keji.blog.controller.spring.bean.CompactDisc.playTrack(int))" +
            "&& args(trackNumber)") //int 表示接受int类型的参数
    public void trackPlayed(int trackNumber) { }

    @Before("trackPlayed(trackNumer)")
    public void countTrack(int trackNumer) {
        int currentCount = getPlayCout(trackNumer);
    }

    private int getPlayCout(int trackNumer) {
        return trackCounts.containsKey(trackNumer) ? trackCounts.get(trackNumer):0;
    }
}
