package com.company.dao.inter;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

    //todo: User entity class-indaki NamedQuery istifade edilir.
    User myFindByEmail2(String email);

    //todo: Men yazdiqlarimdan By-dan sonra gelen name gore axtarir ve List return edir.
    List<User> findByName(String name);

    //todo: Men yazdiqlarimdan By-dan sonra gelen name ve surname gore axtaris edir.
    User findByNameAndSurname(String name, String surname);

    //* Native Query
    @Query(value = "select * from user where email=?", nativeQuery = true)
    List<User> findByEmailNative(String email);


    //* JQPL v1
    @Query(value = "select u from User u where u.email=:alma")
    User findByEmailJPQL(@Param("alma") String email);


    //* JQPL v2
    @Query(value = "select u from User u where u.email=?1 and u.surname=?2")
    User findByEmailAndSurnameJPQL(String email, String surname);

}

