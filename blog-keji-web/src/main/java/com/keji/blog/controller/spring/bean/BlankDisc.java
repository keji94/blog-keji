package com.keji.blog.controller.spring.bean;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/22.
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;


    public BlankDisc() {

    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(String title, String artist,List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }
    @Override
    public void play() {
        System.out.println("Playing"+title+"by"+artist);
        if (tracks != null && tracks.size() > 0) {
            for (String track : tracks) {
                System.out.println("-Track : "+track);
            }
        }
    }

    @Override
    public void playTrack(int num) {
        System.out.println("播放"+num+"次");
    }

    //setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
