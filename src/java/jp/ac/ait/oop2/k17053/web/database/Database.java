/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.oop2.k17053.web.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author k17053kk
 */
public class Database {

    private static final String DB_HOST = "127.0.0.1";
    private static final int DB_PORT = 8889;
    private static final String DB_NAME = "ManageTM";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final String JDBC_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    /**
     * DBConnection 生成
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);  // SQLExceptionに変換して返す
        }
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
    }

    /**
     * Userテーブルからidを条件指定して1件抽出
     *
     * @param id サインインID
     * @return 取得されたUserデータ
     * @throws SQLException
     */
    public static User selectUserById(int id) throws SQLException {
        User result = null;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  id").append(System.lineSeparator());
            sql.append(", name").append(System.lineSeparator());
            sql.append(", position").append(System.lineSeparator());
            sql.append(", phone").append(System.lineSeparator());
            sql.append(", photo").append(System.lineSeparator());
            sql.append(", message").append(System.lineSeparator());
            sql.append(", email").append(System.lineSeparator());
            sql.append(", password").append(System.lineSeparator());
            sql.append(", status_id").append(System.lineSeparator());
            sql.append(", organization_id").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  User ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(id));
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                InputStream photo = rs.getBlob("photo").getBinaryStream();

                result = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getString("phone"),
                        photo,
                        rs.getString("message"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status_id"),
                        rs.getInt("organization_id"));
            }
        }

        return result;
    }

    /**
     * Userテーブルからemailを条件指定して1件抽出
     *
     * @param email サインインID
     * @return 取得されたUserデータ
     * @throws SQLException
     */
    public static User selectUserByEmail(String email) throws SQLException {
        User result = null;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  id").append(System.lineSeparator());
            sql.append(", name").append(System.lineSeparator());
            sql.append(", position").append(System.lineSeparator());
            sql.append(", phone").append(System.lineSeparator());
            sql.append(", photo").append(System.lineSeparator());
            sql.append(", message").append(System.lineSeparator());
            sql.append(", email").append(System.lineSeparator());
            sql.append(", password").append(System.lineSeparator());
            sql.append(", status_id").append(System.lineSeparator());
            sql.append(", organization_id").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  User ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  email = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                InputStream photo = rs.getBlob("photo").getBinaryStream();

                result = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getString("phone"),
                        photo,
                        rs.getString("message"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status_id"),
                        rs.getInt("organization_id"));
            }
        }

        return result;
    }

    /**
     * Userテーブルからorganization_idを条件指定して複数件抽出
     *
     * @param organization_id
     * @return 取得されたUserデータ
     * @throws SQLException
     */
    public static ArrayList<User> selectUserByOrganizationId(int organization_id) throws SQLException {
        ArrayList<User> result = new ArrayList<>();

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  id").append(System.lineSeparator());
            sql.append(", name").append(System.lineSeparator());
            sql.append(", position").append(System.lineSeparator());
            sql.append(", phone").append(System.lineSeparator());
            sql.append(", photo").append(System.lineSeparator());
            sql.append(", message").append(System.lineSeparator());
            sql.append(", email").append(System.lineSeparator());
            sql.append(", password").append(System.lineSeparator());
            sql.append(", status_id").append(System.lineSeparator());
            sql.append(", organization_id").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  User ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  organization_id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(organization_id));
            ResultSet rs = stm.executeQuery();

            User temp = null;

            while (rs.next() && rs != null) {

                InputStream photo = rs.getBlob("photo").getBinaryStream();

                temp = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getString("phone"),
                        photo,
                        rs.getString("message"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("status_id"),
                        rs.getInt("organization_id"));

                result.add(temp);
            }
        }

        return result;
    }

    /**
     * Organizationテーブルからteam_nameを条件指定して1件抽出
     *
     * @param organization （チーム名）
     * @return 取得されたOrganization_id
     * @throws SQLException
     */
    public static int selectOrganization(String organization) throws SQLException {
        int result = 0;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  id").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  Organization ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  team_name = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, organization);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                result = rs.getInt("id");

            }
        }

        return result;
    }

    /**
     * Organizationテーブルからidを条件指定して1件抽出
     *
     * @param organization_id
     * @return 取得されたOrganization_id
     * @throws SQLException
     */
    public static Organization selectOrganizationById(int organization_id) throws SQLException {
        Organization result = null;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  id").append(System.lineSeparator());
            sql.append(", team_name").append(System.lineSeparator());
            sql.append(", skills_id").append(System.lineSeparator());
            sql.append(", communication_tool").append(System.lineSeparator());
            sql.append(", created_by").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  Organization ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(organization_id));
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                result = new Organization(
                        rs.getInt("id"),
                        rs.getString("team_name"),
                        rs.getInt("skills_id"),
                        rs.getString("communication_tool"),
                        rs.getString("created_by"));

            }
        }

        return result;
    }

    /**
     * Skillsテーブルからskills_idを条件指定して1件抽出
     *
     * @param skills_id
     * @return 取得されたOrganization_id
     * @throws SQLException
     */
    public static Skills selectSkillsById(int skills_id) throws SQLException {
        Skills result = null;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  skill1").append(System.lineSeparator());
            sql.append(", skill2").append(System.lineSeparator());
            sql.append(", skill3").append(System.lineSeparator());
            sql.append(", skill4").append(System.lineSeparator());
            sql.append(", skill5").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  Skills ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(skills_id));
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                result = new Skills(
                        rs.getString("skill1"),
                        rs.getString("skill2"),
                        rs.getString("skill3"),
                        rs.getString("skill4"),
                        rs.getString("skill5"));
            }
        }

        return result;
    }

    /**
     * Statusテーブルからstatus_idを条件指定して1件抽出
     *
     * @param status_id
     * @return 取得されたOrganization_id
     * @throws SQLException
     */
    public static Status selectStatusById(int status_id) throws SQLException {
        Status result = null;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  skill1s").append(System.lineSeparator());
            sql.append(", skill2s").append(System.lineSeparator());
            sql.append(", skill3s").append(System.lineSeparator());
            sql.append(", skill4s").append(System.lineSeparator());
            sql.append(", skill5s").append(System.lineSeparator());
            sql.append("FROM ").append(System.lineSeparator());
            sql.append("  Status ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(status_id));
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                result = new Status(
                        rs.getInt("skill1s"),
                        rs.getInt("skill2s"),
                        rs.getInt("skill3s"),
                        rs.getInt("skill4s"),
                        rs.getInt("skill5s"));
            }
        }

        return result;
    }

    /**
     * Userテーブルに新規ユーザー登録
     *
     * @param user Userデータ(idは登録時無視されます)
     * @return 登録成功でtrue
     * @throws SQLException
     */
    public static boolean insertUser(User user) throws SQLException, IOException {

        // 引数のuserから、email, name, passwordをUserテーブルにINSERTします
        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO").append(System.lineSeparator());
            sql.append("  User (").append(System.lineSeparator());
            sql.append("  `name`").append(System.lineSeparator());
            sql.append(", `position`").append(System.lineSeparator());
            sql.append(", `phone`").append(System.lineSeparator());
            sql.append(", `photo`").append(System.lineSeparator());
            sql.append(", `message`").append(System.lineSeparator());
            sql.append(", `email`").append(System.lineSeparator());
            sql.append(", `password`").append(System.lineSeparator());
            sql.append(", `organization_id`").append(System.lineSeparator());
            sql.append(") VALUES (").append(System.lineSeparator());
            sql.append("  ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(");").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(
                    sql.toString(),
                    Statement.RETURN_GENERATED_KEYS // 生成されたIDの値を取得する場合には、フラグを設定する
            );
            // 追加するデータの設定
            stm.setString(1, user.getName()); // name
            stm.setString(2, user.getPosition()); // position
            stm.setString(3, user.getPhone()); // phone
            stm.setBlob(4, user.getPhoto()); // photo
            stm.setString(5, user.getMessage()); // message
            stm.setString(6, user.getEmail()); // email
            stm.setString(7, user.getPassword()); // password
            stm.setString(8, String.valueOf(user.getOrganization_id())); // password

            // パラメータがセットされたSQLを発行
            int result_count = stm.executeUpdate();
            // 登録失敗(更新件数が0件)時、falseを返す
            if (result_count == 0) {
                return false;
            }
            // idの値は、新規登録されたid列の番号を取得して、引数のuserのidに設定する
            // 自動採番されたIDの値を取得する
            int id = 0;
            ResultSet ids = stm.getGeneratedKeys();
            if (ids != null && ids.next()) {
                id = ids.getInt(1);
            }
            user.setId(id);
        }
        return true;
    }

    /**
     * Userテーブルのstatus_id新しいものに更新
     *
     * @param user
     * @throws SQLException
     */
    public static void updateStatusId(User user, int status_id) throws SQLException {

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE").append(System.lineSeparator());
            sql.append("  User").append(System.lineSeparator());
            sql.append("SET ").append(System.lineSeparator());
            sql.append("  status_id = ? ").append(System.lineSeparator());
            sql.append("WHERE ").append(System.lineSeparator());
            sql.append("  id = ? ").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(status_id));
            stm.setString(2, String.valueOf(user.getId()));
            stm.executeUpdate();

        }

    }

    /**
     * Statusテーブルに1件追加
     *
     * @return status_id (ユーザテーブルのstatus_id用)
     * @throws SQLException
     */
    public static int InsertStatusId(int skill1, int skill2, int skill3, int skill4, int skill5) throws SQLException {

        int status_id = 0;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO").append(System.lineSeparator());
            sql.append("  Status (").append(System.lineSeparator());
            sql.append("  `skill1s`").append(System.lineSeparator());
            sql.append(", `skill2s`").append(System.lineSeparator());
            sql.append(", `skill3s`").append(System.lineSeparator());
            sql.append(", `skill4s`").append(System.lineSeparator());
            sql.append(", `skill5s`").append(System.lineSeparator());
            sql.append(") VALUES (").append(System.lineSeparator());
            sql.append("  ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(", ?").append(System.lineSeparator());
            sql.append(");").append(System.lineSeparator());
            PreparedStatement stm = connection.prepareStatement(sql.toString());

            // パラメータセット
            stm.setString(1, String.valueOf(skill1));
            stm.setString(2, String.valueOf(skill2));
            stm.setString(3, String.valueOf(skill3));
            stm.setString(4, String.valueOf(skill4));
            stm.setString(5, String.valueOf(skill5));
            stm.executeUpdate();

            status_id = SelectLastIdFromStatus();

        }
        return status_id;
    }

    /**
     * *
     * 最新のステータスIdを取得する
     *
     * @return last(ステータスIdの最新値）
     * @throws SQLException
     */
    public static int SelectLastIdFromStatus() throws SQLException {
        int last = 0;

        try (Connection connection = getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT").append(System.lineSeparator());
            sql.append("  MAX(id) AS 'id' ").append(System.lineSeparator());
            sql.append("FROM").append(System.lineSeparator());
            sql.append("  Status").append(System.lineSeparator());
            PreparedStatement stm2 = connection.prepareStatement(sql.toString());

            ResultSet rs = stm2.executeQuery();
            if (rs.next()) {
                last = rs.getInt("id");
            }
        }
        return last;
    }
}
