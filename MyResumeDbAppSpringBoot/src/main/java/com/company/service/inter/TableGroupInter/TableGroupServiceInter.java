package com.company.service.inter.TableGroupInter;

import com.company.entity.TableGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TableGroupServiceInter {
    public List<TableGroup> getAll();

    public TableGroup getById(int id);

    boolean updateTableGroup(TableGroup u);

    boolean removeTableGroup(int id);

    public List<TableGroup> getByName(String name);

    public boolean insertTableGroup(TableGroup tableGroup);
}
