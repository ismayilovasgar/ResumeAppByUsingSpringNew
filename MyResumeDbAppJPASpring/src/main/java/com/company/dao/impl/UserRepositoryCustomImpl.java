/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author asgar
 */
@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

//
//    private User getUser(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//        String name = rs.getString("name");
//        String surname = rs.getString("surname");
//        String phone = rs.getString("phone");
//        String email = rs.getString("email");
//        String profileDesc = rs.getString("profile_description");
//        String address = rs.getString("address");
//        int nationalityId = rs.getInt("nationality_id");
//        int birthplaceId = rs.getInt("birthplace_id");
//        String nationalityStr = rs.getString("nationality");
//        String birthplaceStr = rs.getString("birthplace");
//        Date birthDate = rs.getDate("birthdate");
//
//        Country nationality = new Country(nationalityId, null, nationalityStr);
//        Country birthplace = new Country(birthplaceId, birthplaceStr, null);
//
//        return (new User(id, name, surname, phone, email, profileDesc, address, birthDate, nationality, birthplace));
//        //return new User(id, name, surname, phone, email, profileDesc, birthDate, nationality, birthplace);
//    }
//
//    private User getUserSimple(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//        String name = rs.getString("name");
//        String surname = rs.getString("surname");
//        String phone = rs.getString("phone");
//        String email = rs.getString("email");
//        String password = rs.getString("password");
//        String profileDesc = rs.getString("profile_description");
//        String address = rs.getString("address");
//        int nationalityId = rs.getInt("nationality_id");
//        int birthplaceId = rs.getInt("birthplace_id");
//        Date birthDate = rs.getDate("birthdate");
//
//        return new User(id, name, surname, phone, email, profileDesc, address, birthDate, null, null);
////        return new User(id, name, surname, phone, email, profileDesc, birthDate, null, null);
//
//    }
//
//    private UserSkill getUserSkill(ResultSet rs) throws SQLException {
//        int userId = rs.getInt("id");
//        int skillId = rs.getInt("skill_id");
//        String skillName = rs.getString("skill_name");
//        int power = rs.getInt("power");
//
//        // return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
//        return null;
//
//    }
    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override

    public List<User> getAll(String name, String surname, Integer nationalityId) {
        System.out.println("---------  UserDaoImpl1 - getAll()  -----------");
        String jpql = "select u from User u where 1=1";
//            String sql = "SELECT"
//                    + "	u.*, "
//                    + "	n.nationality , "
//                    + " c.name AS birthplace "
//                    + "FROM"
//                    + " user u"
//                    + " LEFT JOIN country n ON u.nationality_id = n.id"
//                    + " LEFT JOIN country c ON u.birthplace_id = c.id where 1=1  ";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);

        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }


    //todo: JPA
//    @Override
//    public User findByEmailAndPassword(String email, String password) {
//        EntityManager em = em();
//        Query q = em.createQuery("SELECT u FROM User u WHERE u.email=:e AND u.password=:p", User.class
//        );
//        q.setParameter("e", email);
//        q.setParameter("p", password);
//
//        List<User> list = q.getResultList();
//
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }


    //** JPQL
    @Override
    public User findByEmailAndPassword(String email, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);

        CriteriaQuery<User> q2
                = q1.where(
                cb.equal(postRoot.get("email"), email),
                cb.equal(postRoot.get("password"), password)
        );
//      CriteriaQuery<User> q3 = q2.where(cb.equal(postRoot.get("password"), ":p"));
//      Query q = em.createQuery(q3);
        Query q = em.createQuery(q2);

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }


    //todo:  JPA---------
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query q = em.createQuery("SELECT u FROM User u WHERE u.email=:e ", User.class
//        );
//        q.setParameter("e", email);
//
//        List<User> list = q.getResultList();
//
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }


    //todo:  JPQL---------
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//
//        CriteriaQuery<User> q2
//                = q1.where(cb.equal(postRoot.get("email"), email));
//
//        Query q = em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

// todo: NamedQuery---------
//    @Override
//    public User findByEmail(String email) {
//        EntityManager em = em();
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }


    //** Native SQL
    @Override
    public User findByEmail(String email) {
        Query query = em.createNativeQuery("Select * from user where email= ? ", User.class);
        Query query2 = em.createNativeQuery("Select * from user where email='" + email + "' ", User.class);

        query.setParameter(1, email);

        List<User> list = query.getResultList();
        List<User> list2 = query2.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
