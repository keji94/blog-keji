package com.keji.blog.controller.spring.bean.test;

import com.keji.blog.controller.spring.bean.CDPlayerConfig;
import com.keji.blog.controller.spring.bean.CompactDisc;
import com.keji.blog.controller.spring.bean.MediaPlayer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by wb-ny291824 on 2017/8/18.
 * SpringJUnit4ClassRunner:测试的时候自动创建上下文
 * ContextConfiguration：需要在CDPlayer中加载配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDplayerTest {

    private Logger log = LoggerFactory.getLogger(CDplayerTest.class);

    @Autowired
    private CompactDisc cd;
    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        Assert.assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
        Assert.assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",
                log);
    }
}
