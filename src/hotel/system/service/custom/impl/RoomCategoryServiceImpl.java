/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.RoomCategoryDao;
import hotel.system.dto.RoomCategoryDto;
import hotel.system.entity.RoomCategoryEntity;
import hotel.system.service.custom.RoomCategoryService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class RoomCategoryServiceImpl implements RoomCategoryService {

    private RoomCategoryDao roomCategoryDao = (RoomCategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ROOMCATEGORY);

    @Override
    public String addRoomCategory(RoomCategoryDto dto) throws Exception {
        RoomCategoryEntity roomCategoryEntity = new RoomCategoryEntity(
                dto.getCategoryId(), dto.getCategoryType(), dto.getDescription(), dto.getFacilities(), dto.isStatus());

        if (roomCategoryDao.save(roomCategoryEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateRoomCategory(RoomCategoryDto dto) throws Exception {
        RoomCategoryEntity roomCategoryEntity = new RoomCategoryEntity(
                dto.getCategoryId(), dto.getCategoryType(), dto.getDescription(), dto.getFacilities(), dto.isStatus());

        if (roomCategoryDao.update(roomCategoryEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteRoomCategory(String id) throws Exception {
        if (roomCategoryDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public RoomCategoryDto getRoomCategory(String id) throws Exception {
        RoomCategoryEntity entity = roomCategoryDao.get(id);
        if (entity != null) {
            return new RoomCategoryDto(entity.getCategoryId(), entity.getCategoryType(), entity.getDescription(), entity.getFacilities(), entity.isStatus());
        }

        return null;
    }

    @Override
    public List<RoomCategoryDto> getAll() throws Exception {
        List<RoomCategoryDto> roomCategoryDtos = new ArrayList<>();
        List<RoomCategoryEntity> roomCategoryEntities = roomCategoryDao.getAll();
        for (RoomCategoryEntity entity : roomCategoryEntities) {
            roomCategoryDtos.add(new RoomCategoryDto(entity.getCategoryId(), entity.getCategoryType(), entity.getDescription(), entity.getFacilities(), entity.isStatus()));
        }
        return roomCategoryDtos;
    }
    
//    @Override
//    public List<String> getAllCategoryIds() throws Exception {
//        List<RoomCategoryDto> roomCategoryDtos = getAll();
//        List<String> categoryIds = new ArrayList<>();
//
//        for (RoomCategoryDto roomCategoryDto : roomCategoryDtos) {
//            categoryIds.add(roomCategoryDto.getCategoryId());
//        }
//
//        return categoryIds;
//    }

}
