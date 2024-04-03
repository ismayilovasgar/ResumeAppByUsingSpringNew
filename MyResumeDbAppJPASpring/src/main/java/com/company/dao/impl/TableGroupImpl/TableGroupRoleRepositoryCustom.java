package com.company.dao.impl.TableGroupImpl;

import com.company.entity.TableGroupRole;

import java.util.List;

public interface TableGroupRoleRepositoryCustom {
    public List<TableGroupRole> getAllRoleByUserId(int tableGroupId);

    public boolean insertTableGroupRole(TableGroupRole tableGroupRole);

    public boolean updateTableGroupRole(TableGroupRole tableGroupRole);

    public boolean removeTableGroupRole(int tableGroupId);
}
