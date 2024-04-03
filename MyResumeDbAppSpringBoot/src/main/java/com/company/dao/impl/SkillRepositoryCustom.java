package com.company.dao.impl;

import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepositoryCustom {

    public List<Skill> getAll();

    public Skill getById(int id);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);

    public List<Skill> getByName(String name);

    public boolean insertSkill(Skill skill);

}
