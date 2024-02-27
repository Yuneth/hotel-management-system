/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.RoomDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface RoomService extends SuperService  {
    String addRoom(RoomDto dto) throws Exception;

    String updateRoom(RoomDto dto) throws Exception;

    String deleteRoom(String id) throws Exception;

    RoomDto getRoom(String id) throws Exception;

    List<RoomDto> getAll() throws Exception;
}
