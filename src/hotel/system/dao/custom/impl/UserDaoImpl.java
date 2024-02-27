/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.UserDao;
import hotel.system.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuneth Perera
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO  users VALUES (?,?,?,?,?)",
                t.getId(),
                t.getUsername(),
                t.getPassword(),
                t.getRole(),
                t.isStatus());

    }

    @Override
    public boolean update(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE users SET  username=?, password=?, role=?, status=? WHERE id=?",
                t.getUsername(),
                t.getPassword(),
                t.getRole(),
                t.isStatus(),
                t.getId());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE users SET status=false WHERE id = ?", id);
    }

    @Override
    public UserEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users WHERE id = ?", id);
        while (rst.next()) {
            return new UserEntity(
                    rst.getString("id"),
                    rst.getString("username"),
                    rst.getString("password"),
                    rst.getString("role"),
                    rst.getBoolean("status"));
        }
        return null;
    }

    @Override
    public List<UserEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users");
        List<UserEntity> userEntities = new ArrayList<>();

        while (rst.next()) {
            userEntities.add(new UserEntity(
                    rst.getString("id"),
                    rst.getString("username"),
                    rst.getString("password"),
                    rst.getString("role"),
                    rst.getBoolean("status")));
        }
        return userEntities;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        try {
            ResultSet rst = CrudUtil.executeQuery("SELECT * FROM users WHERE username = ?", username);

            while (rst.next()) {
                return new UserEntity(
                        rst.getString("id"),
                        rst.getString("username"),
                        rst.getString("password"),
                        rst.getString("role"),
                        rst.getBoolean("status"));
            }

            return null;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
