/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.entity.ReservationDetailsEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import hotel.system.dao.custom.ReservationDetailsDao;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationDetailsDaoImpl implements ReservationDetailsDao {

    @Override
    public boolean save(ReservationDetailsEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO reservation_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
                t.getReservationId(),
                t.getRoomId(),
                t.getCustomerId(),
                t.getPackageId(),
                t.getReserveDate(),
                t.getCheckInDate(),
                t.getCheckInTime(),
                t.getCheckOutDate(),
                t.getCheckOutTime(),
                t.getReserveStatus(),
                t.getAmount(),
                t.isStatus());
    }

    @Override
    public boolean update(ReservationDetailsEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE reservation_details SET room_id=?, customer_id=?, package_id=?, reserve_date=?, check_in_date=?, check_in_time=?, check_out_date=?, check_out_time=?, reserve_status=?, amount=?,  status=?  WHERE reservation_id=?",
                t.getRoomId(),
                t.getCustomerId(),
                t.getPackageId(),
                t.getReserveDate(),
                t.getCheckInDate(),
                t.getCheckInTime(),
                t.getCheckOutDate(),
                t.getCheckOutTime(),
                t.getReserveStatus(),
                t.getAmount(),
                t.isStatus(),
                t.getReservationId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("UPDATE reservation_details SET status=false WHERE reservation_id = ?", id);
    }

    @Override
    public ReservationDetailsEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM reservation_details WHERE reservation_id = ?", id);
        while (rst.next()) {
            return new ReservationDetailsEntity(
                    rst.getString("reservation_id"),
                    rst.getString("room_id"),
                    rst.getString("customer_id"),
                    rst.getString("package_id"),
                    rst.getDate("reserve_date"),
                    rst.getDate("check_in_date"),
                    rst.getString("check_in_time"),
                    rst.getDate("check_out_date"),
                    rst.getString("check_out_time"),
                    rst.getString("reserve_status"),
                    rst.getDouble("amount"),
                    rst.getBoolean("status"));
        }
        return null;
    }

    @Override
    public List<ReservationDetailsEntity> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM reservation_details");
        List<ReservationDetailsEntity> reservationEntities = new ArrayList<>();

        while (rst.next()) {
            reservationEntities.add(new ReservationDetailsEntity(
                    rst.getString("reservation_id"),
                    rst.getString("room_id"),
                    rst.getString("customer_id"),
                    rst.getString("package_id"),
                    rst.getDate("reserve_date"),
                    rst.getDate("check_in_date"),
                    rst.getString("check_in_time"),
                    rst.getDate("check_out_date"),
                    rst.getString("check_out_time"),
                    rst.getString("reserve_status"),
                    rst.getDouble("amount"),
                    rst.getBoolean("status")));
        }
        return reservationEntities;
    }

}
