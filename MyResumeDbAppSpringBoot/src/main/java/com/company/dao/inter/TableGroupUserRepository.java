package com.company.dao.inter;

import com.company.dao.impl.TableGroupImpl.TableGroupUserRepositoryCustom;
import com.company.entity.TableGroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableGroupUserRepository extends JpaRepository<TableGroupUser, Integer>, TableGroupUserRepositoryCustom {
}
