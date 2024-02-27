/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.RoomDao;
import hotel.system.dto.RoomDto;
import hotel.system.entity.RoomEntity;
import hotel.system.service.custom.RoomService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class RoomServiceImpl implements RoomService {

    private RoomDao roomDao = (RoomDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ROOM);

    @Override
    public String addRoom(RoomDto dto) throws Exception {
        RoomEntity roomEntity = new RoomEntity(
                dto.getRoomId(), dto.getRoomNo(), dto.getCategoryId(), dto.getAvailabilityStatus(), dto.getPrice(), dto.isStatus());

        if (roomDao.save(roomEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateRoom(RoomDto dto) throws Exception {
        RoomEntity roomEntity = new RoomEntity(
                dto.getRoomId(), dto.getRoomNo(), dto.getCategoryId(), dto.getAvailabilityStatus(), dto.getPrice(), dto.isStatus());

        if (roomDao.update(roomEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteRoom(String id) throws Exception {
        if (roomDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public RoomDto getRoom(String id) throws Exception {
        RoomEntity entity = roomDao.get(id);
        if (entity != null) {
            return new RoomDto(entity.getRoomId(), entity.getRoomNo(), entity.getCategoryId(), entity.getAvailabilityStatus(), entity.getPrice(), entity.isStatus());
        }

        return null;
    }

    @Override
    public List<RoomDto> getAll() throws Exception {
        List<RoomDto> roomDtos = new ArrayList<>();
        List<RoomEntity> roomEntities = roomDao.getAll();
        for (RoomEntity entity : roomEntities) {
            roomDtos.add(new RoomDto(entity.getRoomId(), entity.getRoomNo(), entity.getCategoryId(), entity.getAvailabilityStatus(), entity.getPrice(), entity.isStatus()));
        }
        return roomDtos;
    }

}
