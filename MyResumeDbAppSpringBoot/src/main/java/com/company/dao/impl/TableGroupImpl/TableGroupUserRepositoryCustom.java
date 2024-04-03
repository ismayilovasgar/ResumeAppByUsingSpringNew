package com.company.dao.impl.TableGroupImpl;

import com.company.entity.TableGroupUser;
import com.company.entity.User;

import java.util.List;

public interface TableGroupUserRepositoryCustom {

    public List<TableGroupUser> getAllGroupByUserId(int UserId);

    public boolean insertGroupUser(TableGroupUser tableGroupUser);

    public boolean updateTableGroupUser(TableGroupUser tableGroupUser);

    public boolean removeTableGroupUser(User user);

}
