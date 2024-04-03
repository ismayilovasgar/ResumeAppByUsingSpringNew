package com.company.dao.inter;

import com.company.dao.impl.TableGroupImpl.TableGroupRepositoryCustom;
import com.company.entity.TableGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TableGroupRepository extends JpaRepository<TableGroup, Integer>, TableGroupRepositoryCustom {
}
