package com.company.service.impl.TableGroupImpl;

import com.company.dao.impl.TableGroupImpl.TableGroupRepositoryCustom;
import com.company.entity.TableGroup;
import com.company.service.inter.TableGroupInter.TableGroupServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableGroupServiceImpl implements TableGroupServiceInter {
    @Autowired
    @Qualifier("tableGroupRepositoryCustomImpl")
    private TableGroupRepositoryCustom tableGroupDao;

    @Override
    public List<TableGroup> getAll() {
        return tableGroupDao.getAll();
    }

    @Override
    public TableGroup getById(int id) {
        return tableGroupDao.getById(id);
    }

    @Override
    public boolean updateTableGroup(TableGroup u) {
        return tableGroupDao.updateTableGroup(u);
    }

    @Override
    public boolean removeTableGroup(int id) {
        return tableGroupDao.removeTableGroup(id);
    }

    @Override
    public List<TableGroup> getByName(String name) {
        return tableGroupDao.getByName(name);
    }

    @Override
    public boolean insertTableGroup(TableGroup tableGroup) {
        return tableGroupDao.insertTableGroup(tableGroup);
    }
}
