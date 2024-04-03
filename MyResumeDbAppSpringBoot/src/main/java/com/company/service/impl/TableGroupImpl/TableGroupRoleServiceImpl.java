package com.company.service.impl.TableGroupImpl;

import com.company.dao.impl.TableGroupImpl.TableGroupRoleRepositoryCustom;
import com.company.entity.TableGroupRole;
import com.company.service.inter.TableGroupInter.TableGroupRoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableGroupRoleServiceImpl implements TableGroupRoleServiceInter {
    @Autowired
    @Qualifier("tableGroupRoleRepositoryCustomImpl")
    private TableGroupRoleRepositoryCustom tableGroupRoleDao;

    @Override
    public List<TableGroupRole> getAllRoleByUserId(int tableGroupId) {
        return tableGroupRoleDao.getAllRoleByUserId(tableGroupId);
    }

    @Override
    public boolean insertTableGroupRole(TableGroupRole tableGroupRole) {
        return tableGroupRoleDao.insertTableGroupRole(tableGroupRole);
    }

    @Override
    public boolean updateTableGroupRole(TableGroupRole tableGroupRole) {
        return tableGroupRoleDao.updateTableGroupRole(tableGroupRole);
    }

    @Override
    public boolean removeTableGroupRole(int tableGroupId) {
        return tableGroupRoleDao.removeTableGroupRole(tableGroupId);
    }
}
