package pertemuan7.membership.src.dao;

import pertemuan7.membership.src.db.MySqlConnection;
import pertemuan7.membership.src.model.JenisMember;
import pertemuan7.membership.src.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    public int insert(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO member (id, nama, jenis_member_id) VALUES (?, ?, ?);");
            statement.setString(1, member.getId());
            statement.setString(2, member.getNama());
            statement.setString(3, member.getJenisMember().getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE member SET nama = ?, jenis_member_id = ? WHERE id = ?;");
            statement.setString(1, member.getNama());
            statement.setString(2, member.getJenisMember().getId());
            statement.setString(3, member.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM member WHERE id = ?;");
            statement.setString(1, member.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            try(ResultSet resultSet = statement.executeQuery("select member.id, member.nama, jenis_member.id jenis_member_idm jenis_member.nama "+
                    "jenis_member_nama from member join jenis_member on jenis_member.id = member.jenis_member_id");){
                //retrieving the data
                while (resultSet.next()) {
                    Member member = new Member();
                    member.setId(resultSet.getString("id"));
                    member.setNama(resultSet.getString("nama"));

                    JenisMember jenisMember = new JenisMember();
                    jenisMember.setId(resultSet.getString("jenis_member_id"));
                    jenisMember.setNama(resultSet.getString("jenis_member_nama"));

                    member.setJenisMember(jenisMember);

                    list.add(member);
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


