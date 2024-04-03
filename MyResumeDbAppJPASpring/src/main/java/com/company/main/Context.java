package com.company.main;


import com.company.dao.impl.*;
import com.company.dao.impl.TableGroupImpl.*;

public class Context {

    public static UserRepositoryCustom instanceUserDao() {
        return new UserRepositoryCustomImpl();
    }

    public static UserSkillRepositoryCustom instanceUserSkillDao() {
        return new UserSkillRepositoryCustomImpl();
    }

    public static EmploymentHistoryRepositoryCustom instanceEmploymentHistoryDao() {
        return new EmploymentHistoryRepositoryCustomImpl();
    }

    public static SkillRepositoryCustom instanceSkillDao() {
        return new SkillRepositoryCustomImpl();
    }

    public static TableGroupRepositoryCustom instanceTableGroupDao() {
        return new TableGroupRepositoryCustomImpl();
    }

    public static TableRoleRepositoryCustom instanceTableRoleDao() {
        return new TableRoleRepositoryCustomImpl();
    }

    public static TableGroupRoleRepositoryCustom instanceTableGroupRoleDao() {
        return new TableGroupRoleRepositoryCustomImpl();
    }

    public static TableGroupUserRepositoryCustom instanceTableGroupUserDao() {
        return new TableGroupUserRepositoryCustomImpl();
    }

}

