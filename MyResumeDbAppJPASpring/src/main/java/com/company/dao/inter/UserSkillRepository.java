package com.company.dao.inter;

import com.company.dao.impl.UserSkillRepositoryCustom;
import com.company.entity.User;
import com.company.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>, UserSkillRepositoryCustom {

    //todo: Men yazdiqlarimdan By-dan sonra gelen sutun adini axtarir.
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
