package com.company.service.inter.TableGroupInter;

import com.company.entity.TableRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRoleServiceInter {
    public List<TableRole> getAll();

    public TableRole getById(int tableRoleId);

    public boolean updateTableRole(TableRole tableRole);

    public boolean removeTableRole(int tableRoleId);

    public List<TableRole> getByName(String name);

    public boolean insertTableRole(TableRole tableRole);
}
