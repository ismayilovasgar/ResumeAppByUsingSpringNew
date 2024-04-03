package com.company.service.inter.TableGroupInter;

import com.company.entity.TableGroupUser;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableGroupUserServiceInter {
    public List<TableGroupUser> getAllGroupByUserId(int UserId);

    public boolean insertGroupUser(TableGroupUser tableGroupUser);

    public boolean updateTableGroupUser(TableGroupUser tableGroupUser);

    public boolean removeTableGroupUser(User user);
}
