package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

    //todo Men yazdiqlarimdan By-dan sonra gelen sutun adini axtarir.
    User findByName(String name);
    User findByNameAndSurname(String name, String surname);

    //* Native Query
    @Query(value = "select * from user where email=?", nativeQuery = true)
    User findByEmailNative(String email);

    //* JQPL v1
    @Query(value = "select u from User u where u.email=:alma")
    User findByEmailJPQL(@Param("alma") String email);

    //* JQPL v2
    @Query(value = "select u from User u where u.email=?1 and u.surname=?2")
    User findByEmailAndSurnameJPQL(String email, String surname);

}

