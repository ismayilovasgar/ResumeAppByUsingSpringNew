package com.company.service.impl;

import com.company.dao.impl.SkillRepositoryCustom;
import com.company.entity.Skill;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {
    @Autowired
    @Qualifier("skillRepositoryCustomImpl")
    private SkillRepositoryCustom skillDao;

    @Override
    public List<Skill> getAll() {
        return null;
    }

    @Override
    public Skill getById(int id) {
        return null;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        return false;
    }

    @Override
    public boolean removeSkill(int id) {
        return false;
    }

    @Override
    public List<Skill> getByName(String name) {
        return null;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        return false;
    }
}
