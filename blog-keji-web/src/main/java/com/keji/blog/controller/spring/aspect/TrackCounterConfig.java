package com.keji.blog.controller.spring.aspect;

import com.keji.blog.controller.spring.bean.BlankDisc;
import com.keji.blog.controller.spring.bean.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

/**
 * Created by wb-ny291824 on 2017/8/24.
 */
@Configuration
@EnableAspectJAutoProxy  //启动AspectJ自动代理
public class TrackCounterConfig {
    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("this is title");
        cd.setArtist("this is artist");

        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("1");
        tracks.add("2");
        tracks.add("3");
        tracks.add("4");

        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() { //TrackCounter bean
        return new TrackCounter();
    }
}
