package com.keji.blog.controller.spring.aspect;

/**
 * Created by wb-ny291824 on 2017/8/24.
 */
public class CriticismEngineImpl implements CriticismEngine {

    public CriticismEngineImpl() {

    }

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return null;
    }

    //injected
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
