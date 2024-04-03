package com.company.service.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillServiceInter {
    public List<Skill> getAll();

    public Skill getById(int id);

    public boolean updateSkill(Skill skill);

    public boolean removeSkill(int id);

    public List<Skill> getByName(String name);

    public boolean insertSkill(Skill skill);
}
