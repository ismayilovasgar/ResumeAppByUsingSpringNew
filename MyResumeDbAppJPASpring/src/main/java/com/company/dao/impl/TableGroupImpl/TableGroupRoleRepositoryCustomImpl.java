package com.company.dao.impl.TableGroupImpl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.TableGroup;
import com.company.entity.TableGroupRole;
import com.company.entity.TableRole;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TableGroupRoleRepositoryCustomImpl extends AbstractDAO implements TableGroupRoleRepositoryCustom {

    private TableGroupRole getTableGroupRole(ResultSet rs) throws SQLException {
        int tableGroupRoleId = rs.getInt("groupRoleId");
        int tableGroupId = rs.getInt("id");
        int tableRoleId = rs.getInt("role_id");
        String roleName = rs.getString("role_name");


        TableGroup tableGroup = new TableGroup(tableGroupId);
        TableRole tableRole = new TableRole(tableRoleId, roleName);

        return new TableGroupRole(null, tableGroup, tableRole);
    }

    @Override
    public List<TableGroupRole> getAllRoleByUserId(int tableGroupId) {
        List<TableGroupRole> result = new ArrayList<>();
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement(
                    "  SELECT" +
                            " tgrouprole.id AS number, " +
                            " tgroup.id AS group_id," +
                            " tgroup.name AS group_name," +
                            " tgrouprole.role_id," +
                            " trole.name AS role_name" +
                            "  FROM " +
                            "  table_group_role tgrouprole" +
                            " LEFT JOIN table_group tgroup ON tgrouprole.group_id = tgroup.id" +
                            "  LEFT JOIN table_role trole ON tgrouprole.role_id = trole.id" +
                            "  WHERE" +
                            " tgrouprole.group_id = ?;"
            );
            stmt.setInt(1, tableGroupId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableGroupRole tableGroupRole = getTableGroupRole(rs);
                result.add(tableGroupRole);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertTableGroupRole(TableGroupRole tableGroupRole) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO table_group_role (group_id , role_id ) VALUES (? , ?  ) ;");

            stmt.setInt(1, tableGroupRole.getGroup().getId());
            stmt.setInt(2, tableGroupRole.getRole().getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean updateTableGroupRole(TableGroupRole tableGroupRole) {
        boolean b = true;
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE table_group_role SET group_id = ? , role_id =?   WHERE id = ? ;");

            stmt.setInt(1, tableGroupRole.getGroup().getId());
            stmt.setInt(2, tableGroupRole.getRole().getId());
            stmt.setInt(3, tableGroupRole.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeTableGroupRole(int tableGroupId) {
        try (Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("DELETE FROM table_group_role  WHERE group_id=?;");
            stmt.setInt(1, tableGroupId);
            System.out.println("id :" + String.valueOf(tableGroupId) + "Silindi...");
            return stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
