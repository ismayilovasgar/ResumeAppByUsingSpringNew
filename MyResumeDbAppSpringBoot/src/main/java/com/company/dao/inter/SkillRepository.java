package com.company.dao.inter;

import com.company.dao.impl.SkillRepositoryCustom;
import com.company.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>, SkillRepositoryCustom {
//
//    //todo: Men yazdiqlarimdan By-dan sonra gelen sutun adini axtarir.
//    User findByName(String name);
//
//    User findByNameAndSurname(String name, String surname);
//
//    //* Native Query
//    @Query(value = "select * from user where email=?", nativeQuery = true)
//    User findByEmailNative(String email);
//
//    //* JQPL v1
//    @Query(value = "select u from User u where u.email=:alma")
//    User findByEmailJPQL(@Param("alma") String email);
//
//    //* JQPL v2
//    @Query(value = "select u from User u where u.email=?1 and u.surname=?2")
//    User findByEmailAndSurnameJPQL(String email, String surname);

}
