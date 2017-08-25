package com.keji.blog.controller.spring.aspect;

/**
 * Created by wb-ny291824 on 2017/8/24.
 * CriticAspect的职责是在表演结束后发表评论。
 */
public aspect CriticAspect {
    public CriticAspect() {
    }

    pointcut performance() : execution(* perform(..));

   afterReturning() : performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

   public void setCriticismEngine(CriticismEngine criticismEngine){
       this.criticismEngine = criticismEngine;
   }
}
