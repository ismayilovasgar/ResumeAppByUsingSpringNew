package com.company.dao.inter;

import com.company.dao.impl.TableGroupImpl.TableGroupRoleRepositoryCustom;
import com.company.entity.TableGroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableGroupRoleRepository extends JpaRepository<TableGroupRole, Integer>, TableGroupRoleRepositoryCustom {
}
