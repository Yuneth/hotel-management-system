/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao.custom.impl;

import hotel.system.dao.CrudUtil;
import hotel.system.dao.custom.ReservationDao;
import hotel.system.entity.ReservationEntity;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationDaoImpl implements ReservationDao {

    @Override
    public boolean save(ReservationEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO reservations VALUES (?,?,?)",
                t.getReservationId(),
                t.getCustomerId(),                
                t.isStatus());
    }

    @Override
    public boolean update(ReservationEntity t) throws Exception {
         return CrudUtil.executeUpdate("UPDATE reservations SET customer_id = ?, status = ? WHERE reservation_id = ?",
            t.getCustomerId(),
            t.isStatus(),
            t.getReservationId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReservationEntity get(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservationEntity> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
