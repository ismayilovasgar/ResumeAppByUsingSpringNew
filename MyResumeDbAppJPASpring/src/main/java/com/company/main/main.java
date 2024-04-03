package com.company.main;

import com.company.dao.impl.SkillRepositoryCustom;
import com.company.entity.Skill;

public class main {
    public static void main(String[] args) {

        SkillRepositoryCustom userDao = Context.instanceSkillDao();
//        User u = userDao.findByEmailAndPassword("test@gmail.com", "$2a$04$SwXP/V4om46RQ8oSjr8Gm.ggiQWJeknFPR8/unalbAd.59bgpAHpC");
        Skill u = userDao.getById(5);
        System.out.println("u: " + u);
    }
}
