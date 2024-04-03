/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author asgar
 */
@Repository
public interface UserSkillRepositoryCustom {

    public List<UserSkill> getAllSkillByUserId(int userId);

    public boolean insertUserSkill(UserSkill u);

    public boolean updateUserSkill(UserSkill u);

    public boolean removeUserSkill(int id);

}
