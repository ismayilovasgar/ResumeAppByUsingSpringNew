/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asgar
 */
public abstract class AbstractDAO {

    private static EntityManagerFactory emf = null;

    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "1234";
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }

    public EntityManager em() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("resumappPU");
        }
        EntityManager entitymanager = emf.createEntityManager();
        return entitymanager;
    }

    public void closeEmf() {
        emf.close();
    }
}
