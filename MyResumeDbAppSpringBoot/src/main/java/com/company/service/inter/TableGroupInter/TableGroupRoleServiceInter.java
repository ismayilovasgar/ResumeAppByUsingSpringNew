package com.company.service.inter.TableGroupInter;

import com.company.entity.TableGroupRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableGroupRoleServiceInter {
    public List<TableGroupRole> getAllRoleByUserId(int tableGroupId);

    public boolean insertTableGroupRole(TableGroupRole tableGroupRole);

    public boolean updateTableGroupRole(TableGroupRole tableGroupRole);

    public boolean removeTableGroupRole(int tableGroupId);
}
