package com.company.dao.impl.TableGroupImpl;

import com.company.entity.TableRole;

import java.util.List;

public interface TableRoleRepositoryCustom {
    public List<TableRole> getAll();

    public TableRole getById(int tableRoleId);

    public boolean updateTableRole(TableRole tableRole);

    public boolean removeTableRole(int tableRoleId);

    public List<TableRole> getByName(String name);

    public boolean insertTableRole(TableRole tableRole);
}
