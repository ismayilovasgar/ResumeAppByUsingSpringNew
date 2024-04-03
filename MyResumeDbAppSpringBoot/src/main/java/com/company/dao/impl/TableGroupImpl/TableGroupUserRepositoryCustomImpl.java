package com.company.dao.impl.TableGroupImpl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.Country;
import com.company.entity.TableGroup;
import com.company.entity.TableGroupUser;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TableGroupUserRepositoryCustomImpl extends AbstractDAO implements TableGroupUserRepositoryCustom {

    private TableGroupUser getTableGroupUser(ResultSet rs) throws SQLException {
        int userId = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        String profileDescription = rs.getString("profile_description");
        String address = rs.getString("address");
        Date birthDate = rs.getDate("birthdate");
        int birthplaceId = rs.getInt("birthplace_id");
        String birthplaceStr = rs.getString("birthplace");
        int nationalityId = rs.getInt("nationality_id");
        String nationalityStr = rs.getString("nationality");

        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);

        int tableGroupId = rs.getInt("id");
        String groupName = rs.getString("group_name");

        TableGroup tableGroup = new TableGroup(tableGroupId, groupName);
        User user = new User(userId, name, surname, phone, email, profileDescription, address, birthDate,
                nationality, birthplace);

        return new TableGroupUser(null, tableGroup, user);
    }

    @Override
    public List<TableGroupUser> getAllGroupByUserId(int userId) {
        List<TableGroupUser> result = new ArrayList<>();
        try (Connection c = connect()) {
            System.out.println("++");
            PreparedStatement stmt = c.prepareStatement(
                    "SELECT " +
                            " u. *," +
                            " tgroupuser.group_id, " +
                            " tgroup.name AS group_name ," +
                            " n.nationality," +
                            " c.name AS birthplace " +
                            " FROM" +
                            " table_group_user tgroupuser " +
                            " LEFT JOIN USER u ON tgroupuser.user_id = u.id" +
                            " LEFT JOIN table_group tgroup ON tgroupuser.group_id = tgroup.id" +
                            " LEFT JOIN country c ON u.birthplace_id = c.id" +
                            " LEFT JOIN country n ON u.nationality_id = n.id" +
                            " WHERE" +
                            " tgroupuser.user_id = "+userId);
            System.out.println("++");
//            stmt.setInt(1, UserId);
            boolean b = stmt.execute();
            System.out.println("b:" + b);
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
