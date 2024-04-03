/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author asgar
 */
@Repository
public class CountryRepositoryCustomImpl
        extends AbstractDAO implements CountryRepositoryCustom {


    @Override
    public List<Country> getAllCountry() {
        EntityManager em = em();
        em.getTransaction().begin();

        Query q = em.createQuery("SELECT c FROM Country c", Country.class);

        List<Country> list = q.getResultList();
        return list;
    }

    @Override
    public boolean updateCountry(Country country) {
        EntityManager em = em();

        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();

        closeEmf();
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        EntityManager em = em();
        Country c = em.find(Country.class, id);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();

        em.close();
        return true;
    }


//    private Country getCountry(ResultSet rs) throws SQLException {
//        int id = rs.getInt("id");
//        String name = rs.getString("name");
//        String nationality = rs.getString("nationality");
//        return (new Country(id, name, nationality));
//    }
//
//    @Override
//    public List<Country> getAllCountry() {
//        List<Country> result = new ArrayList<>();
//        try (Connection c = connect()) {
//            Statement stmt = c.createStatement();
//            stmt.execute("SELECT * FROM country");
//            ResultSet rs = stmt.getResultSet();
//
//            while (rs.next()) {
//
//                Country country = getCountry(rs);
//                result.add(country);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//    @Override
//    public boolean removeCountry(int id) {
//        try (Connection c = connect()) {
//            PreparedStatement stmt = c.prepareStatement("DELETE FROM Country where id=? ");
//            stmt.setInt(1, id);
//            stmt.execute();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return false;
//
//    }
//
//    @Override
//    public boolean updateCountry(Country country) {
//        try (Connection c = connect()) {
//            PreparedStatement stmt = c.prepareStatement("UPDATE Country SET name=? ,nationality=? where= id =?");
//            ;
//            stmt.setString(1, country.getName());
//            stmt.setString(2, country.getNationality());
//            stmt.setInt(3, country.getId());
//            stmt.execute();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//        return true;
//    }

}
