package com.company.dao.impl.TableGroupImpl;

import com.company.entity.TableGroup;

import java.util.List;

public interface TableGroupRepositoryCustom {
    public List<TableGroup> getAll();

    public TableGroup getById(int id);

    boolean updateTableGroup(TableGroup u);

    boolean removeTableGroup(int id);

    public List<TableGroup> getByName(String name);

    public boolean insertTableGroup(TableGroup tableGroup);
}
