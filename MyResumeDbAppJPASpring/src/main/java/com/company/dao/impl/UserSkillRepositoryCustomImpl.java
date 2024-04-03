/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author asgar
 */
@Repository
public class UserSkillRepositoryCustomImpl extends AbstractDAO implements UserSkillRepositoryCustom {

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        EntityManager em = em();
        Query q = em.createQuery("Select us FROM UserSkill us Where us.user.id=:userID", UserSkill.class);
        q.setParameter("userID", userId);

        List<UserSkill> list = q.getResultList();

        closeEmf();
        return list;
    }

    public boolean insertUserSkill(UserSkill u) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    public boolean updateUserSkill(UserSkill u) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        em.close();
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        EntityManager em = em();
        UserSkill u = em.find(UserSkill.class, id);

        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }
//
//* JDBC
//    private UserSkill getUserSkill(ResultSet rs) throws SQLException {
//        int userSkillId = rs.getInt("userSkillId");
//        int userId = rs.getInt("id");
//        int skillId = rs.getInt("skill_id");
//        String skillName = rs.getString("skill_name");
//        int power = rs.getInt("power");
//
//        Skill skill = new Skill(skillId, skillName);
//        User user = new User(userId);
//
//        return new UserSkill(null, user, skill, power);
////        return null;
//    }
//
//    @Override
//    public List<UserSkill> getAllSkillByUserId(int userId) {
//        List<UserSkill> result = new ArrayList<>();
//        try (Connection c = connect()) {
//
//            PreparedStatement stmt = c.prepareStatement(
//                    "SELECT"
//                            + "us.id as userSkillId,"
//                            + "	u.*,"
//                            + "	us.skill_id,"
//                            + "	s.name AS skill_name,"
//                            + "	us.power "
//                            + "FROM"
//                            + "	user_skill us"
//                            + "	LEFT JOIN USER u ON us.user_id = u.id"
//                            + "	LEFT JOIN skill s ON us.skill_id = s.id "
//                            + "WHERE"
//                            + "	us.user_id =?  ");
//            stmt.setInt(1, userId);
//            stmt.execute();
//            ResultSet rs = stmt.getResultSet();
//
//            while (rs.next()) {
//                UserSkill u = getUserSkill(rs);
//                result.add(u);
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    public boolean insertUserSkill(UserSkill u) {
//        boolean b = true;
//        try (Connection c = connect()) {
//            PreparedStatement stmt = c.prepareStatement("INSERT INTO user_skill (skill_id , user_id ,power) VALUES (? , ? ,  ? ) ;");
//
//            stmt.setInt(1, u.getSkill().getId());
//            stmt.setInt(2, u.getUser().getId());
//            stmt.setInt(3, u.getPower());
//
//            b = stmt.execute();
//
//        } catch (Exception ex) {
//            System.err.println(ex);
//            b = false;
//        }
//        return b;
//    }
//
//    public boolean updateUserSkill(UserSkill u) {
//
//        boolean b = true;
//        try (Connection c = connect()) {
//            PreparedStatement stmt = c.prepareStatement("UPDATE user_skill SET skill_id = ? , user_id =? ,power =?  WHERE id = ? ;");
//
//            stmt.setInt(1, u.getSkill().getId());
//            stmt.setInt(2, u.getUser().getId());
//            stmt.setInt(3, u.getPower());
//
//            stmt.setInt(4, u.getId());
//
//            b = stmt.execute();
//
//        } catch (Exception ex) {
//            System.err.println(ex);
//            b = false;
//        }
//        return b;
//    }
//
//    @Override
//    public boolean removeUserSkill(int id) {
//        try (Connection c = connect()) {
//
//            PreparedStatement stmt = c.prepareStatement("DELETE FROM user_skill  WHERE user_id=?;");
//            stmt.setInt(1, id);
//            System.out.println("id :" + String.valueOf(id) + "Silindi...");
//            return stmt.execute();
//
//        } catch (Exception ex) {
//            System.out.println(ex);
//            return false;
//        }
//    }

}
