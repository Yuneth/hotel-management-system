/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.dao.custom;

import hotel.system.dao.CrudDao;
import hotel.system.entity.RoomEntity;

/**
 *
 * @author Yuneth Perera
 */
public interface RoomDao extends CrudDao<RoomEntity, String> {
    
    // Update the availability status of a room
    ///boolean updateAvailabilityStatus(RoomEntity roomEntity);
    
    // Update the availability status of a room
    //boolean updateAvailabilityStatus(String roomId, String availabilityStatus);
}
