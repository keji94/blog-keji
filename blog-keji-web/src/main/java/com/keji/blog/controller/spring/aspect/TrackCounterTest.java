package com.keji.blog.controller.spring.aspect;

import com.keji.blog.controller.spring.bean.CompactDisc;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wb-ny291824 on 2017/8/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        Assert.assertEquals(1,counter.getPlayCout(1));
        Assert.assertEquals(1,counter.getPlayCout(2));
        Assert.assertEquals(4,counter.getPlayCout(3));
        Assert.assertEquals(0,counter.getPlayCout(4));
        Assert.assertEquals(0,counter.getPlayCout(5));
        Assert.assertEquals(0,counter.getPlayCout(6));
        Assert.assertEquals(2,counter.getPlayCout(7));


    }
}
