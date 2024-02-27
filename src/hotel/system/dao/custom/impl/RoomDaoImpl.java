/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.RoomDao;
import hotel.system.db.DBConnection;
import hotel.system.entity.RoomEntity;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuneth Perera
 */
public class RoomDaoImpl implements RoomDao {

    @Override
    public boolean save(RoomEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO rooms VALUES (?,?,?,?,?,?)",
                t.getRoomId(),
                t.getRoomNo(),
                t.getCategoryId(),
                t.getAvailabilityStatus(),
                t.getPrice(),
                t.isStatus());
    }

    @Override
    public boolean update(RoomEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE rooms SET   room_number=?, category_id=?, availability_status=?, pricing=?, status=? WHERE room_id=?",
                t.getRoomNo(),
                t.getCategoryId(),
                t.getAvailabilityStatus(),
                t.getPrice(),
                t.isStatus(),
                t.getRoomId());

    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE rooms SET status=false WHERE room_id = ?", id);
    }

    @Override
    public RoomEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM rooms WHERE room_id = ?", id);
        while (rst.next()) {
            return new RoomEntity(
                    rst.getString("room_id"),
                    rst.getString("room_number"),
                    rst.getString("category_id"),
                    rst.getString("availability_status"),
                    rst.getDouble("pricing"),
                    rst.getBoolean("status"));
        }
        return null;
    }

    @Override
    public List<RoomEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM rooms");
        List<RoomEntity> roomEntities = new ArrayList<>();

        while (rst.next()) {
            roomEntities.add(new RoomEntity(
                    rst.getString("room_id"),
                    rst.getString("room_number"),
                    rst.getString("category_id"),
                    rst.getString("availability_status"),
                    rst.getDouble("pricing"),
                    rst.getBoolean("status")));
        }
        return roomEntities;
    }

//    @Override
//    public boolean updateAvailabilityStatus(RoomEntity roomEntity) throws Exception {
//        String sql = "UPDATE rooms SET availability_status = ? WHERE room_id = ?";
//        
//        try (PreparedStatement pst = connection.prepareStatement(sql)) {
//            pst.setString(1, roomEntity.getAvailabilityStatus());
//            pst.setString(2, roomEntity.getRoomId());
//
//            int affectedRows = pst.executeUpdate();
//            return affectedRows > 0;
//        }
//    }
//    @Override
//    public boolean updateAvailabilityStatus(String roomId, String availabilityStatus) {
//        try (Connection connection = DBConnection.getInstance().getConnection(); PreparedStatement pst = connection.prepareStatement("UPDATE rooms SET availability_status = ? WHERE room_id = ?")) {
//
//            pst.setString(1, availabilityStatus);
//            pst.setString(2, roomId);
//
//            int affectedRows = pst.executeUpdate();
//            return affectedRows > 0;
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(RoomDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return false;
//    }

}
