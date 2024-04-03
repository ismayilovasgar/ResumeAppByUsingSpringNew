/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author asgar
 */
@Repository
public class SkillRepositoryCustomImpl extends AbstractDAO implements SkillRepositoryCustom {

    @Override
    public List<Skill> getByName(String skillName) {
        EntityManager em = em();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT s FROM Skill s WHERE s.name LIKE :skill_name", Skill.class);
        q.setParameter("skill_name", skillName);
        List<Skill> list = q.getResultList();
        return list;
    }

    @Override
    public List<Skill> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT s FROM Skill s", Skill.class);
        List<Skill> list = q.getResultList();
        return list;
    }

    @Override
    public Skill getById(int userId) {
        EntityManager em = em();

        Skill s = em.find(Skill.class, userId);
        closeEmf();

        return s;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(skill);
        em.getTransaction().commit();

//        closeEmf();
        return true;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        EntityManager em = em();
        Skill s = em.find(Skill.class, id);

        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }

}
