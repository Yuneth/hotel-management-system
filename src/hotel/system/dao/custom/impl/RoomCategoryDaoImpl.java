/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.RoomCategoryDao;
import hotel.system.entity.RoomCategoryEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class RoomCategoryDaoImpl implements RoomCategoryDao {

    @Override
    public boolean save(RoomCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO room_categories VALUES (?,?,?,?,?)",
                t.getCategoryId(),
                t.getCategoryType(),
                t.getDescription(),
                t.getFacilities(),
                t.isStatus());
    }

    @Override
    public boolean update(RoomCategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE room_categories SET  category_type=?, description=?, facilities=?, status=? WHERE category_id=?",
                t.getCategoryType(),
                t.getDescription(),
                t.getFacilities(),
                t.isStatus(),
                t.getCategoryId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE room_categories SET status=false WHERE category_id = ?", id);
    }

    @Override
    public RoomCategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM room_categories WHERE category_id = ?", id);
        while (rst.next()) {
            return new RoomCategoryEntity(
                    rst.getString("category_id"),
                    rst.getString("category_type"),
                    rst.getString("description"),
                    rst.getString("facilities"),
                    rst.getBoolean("status"));

        }
        return null;
    }

    @Override
    public List<RoomCategoryEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM room_categories");
        List<RoomCategoryEntity> roomCategoryEntities = new ArrayList<>();

        while (rst.next()) {
            roomCategoryEntities.add(new RoomCategoryEntity(
                    rst.getString("category_id"),
                    rst.getString("category_type"),
                    rst.getString("description"),
                    rst.getString("facilities"),
                    rst.getBoolean("status")));

        }
        return roomCategoryEntities;
    }

}
