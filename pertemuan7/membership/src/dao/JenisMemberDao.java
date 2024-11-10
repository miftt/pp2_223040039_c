package pertemuan7.membership.src.dao;

import pertemuan7.membership.src.db.MySqlConnection;
import pertemuan7.membership.src.model.JenisMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisMemberDao {
    public int insert(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO jenis_member (id, nama) VALUES (?, ?);");

            statement.setString(1, jenisMember.getId());
            statement.setString(1, jenisMember.getNama());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(JenisMember JenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE jenis_member SET nama = ? WHERE id = ?;");
            statement.setString(1, JenisMember.getNama());
            statement.setString(2, JenisMember.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(JenisMember JenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM jenis_member WHERE id = ?;");
            statement.setString(1, JenisMember.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<JenisMember> findAll(){
        List<JenisMember> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM JENIS_MEMBER");){
                //retrieving the data
                while (resultSet.next()) {
                    JenisMember JenisMember = new JenisMember();
                    JenisMember.setId(resultSet.getString("id"));
                    JenisMember.setNama(resultSet.getString("nama"));
                    list.add(JenisMember);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}


