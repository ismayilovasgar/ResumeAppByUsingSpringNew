package com.company.service.impl.TableGroupImpl;

import com.company.dao.impl.TableGroupImpl.TableGroupUserRepositoryCustom;
import com.company.entity.TableGroupUser;
import com.company.entity.User;
import com.company.service.inter.TableGroupInter.TableGroupUserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TableGroupUserServiceImpl implements TableGroupUserServiceInter {
    @Autowired
    @Qualifier("tableGroupUserRepositoryCustomImpl")
    private TableGroupUserRepositoryCustom tableGroupUserDao;

    @Override
    public List<TableGroupUser> getAllGroupByUserId(int UserId) {
        return tableGroupUserDao.getAllGroupByUserId(UserId);
    }

    @Override
    public boolean insertGroupUser(TableGroupUser tableGroupUser) {
        return tableGroupUserDao.insertGroupUser(tableGroupUser);
    }

    @Override
    public boolean updateTableGroupUser(TableGroupUser tableGroupUser) {
        return tableGroupUserDao.updateTableGroupUser(tableGroupUser);
    }

    @Override
    public boolean removeTableGroupUser(User user) {
        return tableGroupUserDao.removeTableGroupUser(user);
    }
}
