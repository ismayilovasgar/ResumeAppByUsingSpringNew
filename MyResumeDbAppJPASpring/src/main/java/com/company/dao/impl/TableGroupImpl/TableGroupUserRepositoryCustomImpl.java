package com.company.dao.impl.TableGroupImpl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.TableGroup;
import com.company.entity.TableGroupUser;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TableGroupUserRepositoryCustomImpl extends AbstractDAO implements TableGroupUserRepositoryCustom {

    private TableGroupUser getTableGroupUser(ResultSet rs) throws SQLException {
        int tableGroupUserId = rs.getInt("groupUserId");
        int tableGroupId = rs.getInt("id");
        String groupName = rs.getString("group_name");
        int UserId = rs.getInt("user_id");

        TableGroup tableGroup = new TableGroup(tableGroupId, groupName);
        User user = new User(UserId);

        return new TableGroupUser(null, tableGroup, user);
    }

    @Override
    public List<TableGroupUser> getAllGroupByUserId(int UserId) {
        List<TableGroupUser> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement(
                    " SELECT " +
                            "  u. *," +
                            " us.skill_id," +
                            " s. `name` AS skill_name," +
                            " us.power" +
                            " FROM " +
                            "  user_skill us" +
                            " LEFT JOIN USER u ON us.user_id = u.id" +
                            " LEFT JOIN skill s ON us.skill_id = s.id" +
                            "  WHERE " +
                            "us.user_id = ?"
            );
            stmt.setInt(1, UserId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableGroupUser tableGroupUser = getTableGroupUser(rs);
                result.add(tableGroupUser);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertGroupUser(TableGroupUser tableGroupUser) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO table_group_user (group_id , role_id ) VALUES (? , ?  ) ;");

            stmt.setInt(1, tableGroupUser.getGroup().getId());
            stmt.setInt(2, tableGroupUser.getUser().getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean updateTableGroupUser(TableGroupUser tableGroupUser) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE table_group_user SET group_id = ? , role_id =?   WHERE id = ? ;");

            stmt.setInt(1, tableGroupUser.getGroup().getId());
            stmt.setInt(2, tableGroupUser.getUser().getId());
            stmt.setInt(3, tableGroupUser.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeTableGroupUser(User user) {
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("DELETE FROM table_group_user  WHERE user_id=?;");
            stmt.setInt(1, user.getId());
            System.out.println("id :" + String.valueOf(user.getId()) + "Silindi...");
            return stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
