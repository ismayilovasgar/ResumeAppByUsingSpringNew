package com.company.dao.inter;

import com.company.dao.impl.TableGroupImpl.TableRoleRepositoryCustom;
import com.company.entity.TableRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRoleRepository extends JpaRepository<TableRole, Integer>, TableRoleRepositoryCustom {
}
