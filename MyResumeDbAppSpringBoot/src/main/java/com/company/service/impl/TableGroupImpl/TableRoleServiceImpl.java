package com.company.service.impl.TableGroupImpl;

import com.company.dao.impl.TableGroupImpl.TableRoleRepositoryCustom;
import com.company.entity.TableRole;
import com.company.service.inter.TableGroupInter.TableRoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableRoleServiceImpl implements TableRoleServiceInter {
    @Autowired
    @Qualifier("tableRoleRepositoryCustomImpl")
    private TableRoleRepositoryCustom tableRoleDao;

    @Override
    public List<TableRole> getAll() {
        return tableRoleDao.getAll();
    }

    @Override
    public TableRole getById(int tableRoleId) {
        return tableRoleDao.getById(tableRoleId);
    }

    @Override
    public boolean updateTableRole(TableRole tableRole) {
        return tableRoleDao.updateTableRole(tableRole);
    }

    @Override
    public boolean removeTableRole(int tableRoleId) {
        return tableRoleDao.removeTableRole(tableRoleId);
    }

    @Override
    public List<TableRole> getByName(String name) {
        return tableRoleDao.getByName(name);
    }

    @Override
    public boolean insertTableRole(TableRole tableRole) {
        return tableRoleDao.insertTableRole(tableRole);
    }
}
