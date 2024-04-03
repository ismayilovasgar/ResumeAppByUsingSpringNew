package com.company.dao.impl.TableGroupImpl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.TableRole;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TableRoleRepositoryCustomImpl extends AbstractDAO implements TableRoleRepositoryCustom {

    private TableRole getTableRole(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return (new TableRole(id, name));
    }


    @Override
    public List<TableRole> getAll() {
        List<TableRole> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM TableRole");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableRole tableRole = getTableRole(rs);
                result.add(tableRole);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public TableRole getById(int tableGroupId) {
        TableRole tableRole = null;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM TableRole WHERE ID = ?");
            stmt.setInt(1, tableGroupId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                tableRole = getTableRole(rs);
            }
        } catch (Exception ex) {

        }
        return tableRole;
    }

    @Override
    public boolean updateTableRole(TableRole tableRole) {
        boolean b = true;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE TableRole SET name=? WHERE id= ?");
            stmt.setString(1, tableRole.getName());
            stmt.setInt(2, tableRole.getId());
            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return b;
        }
        return b;
    }

    @Override
    public boolean removeTableRole(int tableRoleId) {
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM TableRole WHERE id=?;");
            stmt.setInt(1, tableRoleId);
            return stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public List<TableRole> getByName(String tableRoleName) {
        List<TableRole> result = new ArrayList<>();
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM TableRole WHERE name LIKE ?;");
            stmt.setString(1, tableRoleName);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableRole tableGroup = getTableRole(rs);
                result.add(tableGroup);
            }
        } catch (Exception ex) {
            System.err.println("Houston, we have a problem");
        }
        return result;
    }

    @Override
    public boolean insertTableRole(TableRole tableRole) {
        boolean b = true;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("insert tableRole (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tableRole.getName());
            b = stmt.execute();
            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                tableRole.setId(genKeys.getInt(1));
            }
        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }
}
