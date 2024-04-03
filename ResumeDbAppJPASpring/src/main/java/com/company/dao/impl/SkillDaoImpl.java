/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asgar
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return (new Skill(id, name));
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM skill");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                Skill skill = getSkill(rs);
                result.add(skill);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Skill getById(int userId) {
        Skill user = null;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM skill WHERE ID = ?");
            stmt.setInt(1, userId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                user = getSkill(rs);
            }
        } catch (Exception ex) {

        }
        return user;
    }

    @Override
    public boolean updateSkill(Skill s) {

        boolean b = true;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE skill SET name=? WHERE id= ?");
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getId());
            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return b;
        }
        return b;
    }

    @Override
    public boolean insertSkill(Skill s) {

        boolean b = true;
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("insert skill (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, s.getName());
            b = stmt.execute();
            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                s.setId(genKeys.getInt(1));
            }

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeSkill(int id) {

        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM skill WHERE id=?;");
            stmt.setInt(1, id);
            return stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public List<Skill> getByName(String skillName) {
        List<Skill> result = new ArrayList<>();
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM skill WHERE name LIKE ?;");
            stmt.setString(1, skillName);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                Skill skill = getSkill(rs);
                result.add(skill);
            }
        } catch (Exception ex) {
            System.err.println("Houston, we have a problem");
        }
        return result;
    }

}
