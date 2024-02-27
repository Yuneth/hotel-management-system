/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.RoomCategoryDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface RoomCategoryService extends SuperService {

    String addRoomCategory (RoomCategoryDto dto) throws Exception;

    String updateRoomCategory (RoomCategoryDto dto) throws Exception;

    String deleteRoomCategory(String id) throws Exception;

    RoomCategoryDto getRoomCategory(String id) throws Exception;

    List<RoomCategoryDto> getAll() throws Exception;
    
    //List<String> getAllCategoryIds() throws Exception;
}
