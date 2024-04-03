package com.company.dao.impl.TableGroupImpl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.TableGroup;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TableGroupRepositoryCustomImpl extends AbstractDAO implements TableGroupRepositoryCustom {

    private TableGroup getTableGroup(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        return (new TableGroup(id, name));
    }


    @Override
    public List<TableGroup> getAll() {
        List<TableGroup> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM TableGroup");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableGroup tableGroup = getTableGroup(rs);
                result.add(tableGroup);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public TableGroup getById(int tableGroupId) {
        TableGroup tableGroup = null;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM TableGroup WHERE ID = ?");
            stmt.setInt(1, tableGroupId);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                tableGroup = getTableGroup(rs);
            }
        } catch (Exception ex) {

        }
        return tableGroup;
    }

    @Override
    public boolean updateTableGroup(TableGroup u) {
        boolean b = true;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("UPDATE TableGroup SET name=? WHERE id= ?");
            stmt.setString(1, u.getName());
            stmt.setInt(2, u.getId());
            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return b;
        }
        return b;
    }

    @Override
    public boolean removeTableGroup(int tbGroupId) {
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("DELETE FROM TableGroup WHERE id=?;");
            stmt.setInt(1, tbGroupId);
            return stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public List<TableGroup> getByName(String tbGroupName) {
        List<TableGroup> result = new ArrayList<>();
        try (Connection con = connect()) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM TableGroup WHERE name LIKE ?;");
            stmt.setString(1, tbGroupName);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                TableGroup tableGroup = getTableGroup(rs);
                result.add(tableGroup);
            }
        } catch (Exception ex) {
            System.err.println("Houston, we have a problem");
        }
        return result;
    }

    @Override
    public boolean insertTableGroup(TableGroup tableGroup) {
        boolean b = true;
        try (Connection con = connect()) {
            PreparedStatement stmt = con.prepareStatement("insert TableGroup (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tableGroup.getName());
            b = stmt.execute();
            ResultSet genKeys = stmt.getGeneratedKeys();
            if (genKeys.next()) {
                tableGroup.setId(genKeys.getInt(1));
            }
        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }
}
