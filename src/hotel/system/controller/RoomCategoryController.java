/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.controller;

import hotel.system.dto.RoomCategoryDto;
import hotel.system.service.ServiceFactory;
import hotel.system.service.custom.RoomCategoryService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class RoomCategoryController {

    private RoomCategoryService roomCategoryService = (RoomCategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ROOMCATEGORY);

    public String saveRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.addRoomCategory(roomCategoryDto);
    }

    public String updateRoomCategory(RoomCategoryDto roomCategoryDto) throws Exception {
        return roomCategoryService.updateRoomCategory(roomCategoryDto);
    }

    public String deleteRoomCategory(String id) throws Exception {
        return roomCategoryService.deleteRoomCategory(id);
    }

    public RoomCategoryDto getRoomCategory(String id) throws Exception {
        return roomCategoryService.getRoomCategory(id);
    }

    public List<RoomCategoryDto> getAllRoomCategory() throws Exception {
        return roomCategoryService.getAll();
    }
}
