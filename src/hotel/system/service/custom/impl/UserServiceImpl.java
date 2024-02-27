/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.UserDao;
import hotel.system.dto.UserDto;
import hotel.system.entity.UserEntity;
import hotel.system.service.custom.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class UserServiceImpl implements UserService {
    
    private UserDao userDao = (UserDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.USER);

    @Override
    public String addUser(UserDto dto) throws Exception {
        UserEntity userEntity = new UserEntity(
        dto.getId(),
        dto.getUsername(),
        dto.getPassword(),
        dto.getRole(),
        dto.isStatus());
        
        if (userDao.save(userEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateUser(UserDto dto) throws Exception {
        UserEntity userEntity = new UserEntity(
                dto.getId(), dto.getUsername(), dto.getPassword(), dto.getRole(),dto.isStatus());

        if (userDao.update(userEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteUser(String id) throws Exception {
        if (userDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public UserDto getUser(String id) throws Exception {
        UserEntity entity = userDao.get(id);
        if (entity != null) {
            return new UserDto(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole(),entity.isStatus());
        }

        return null;
    }

    @Override
    public List<UserDto> getAll() throws Exception {
        List<UserDto> userDtos = new ArrayList<>();
        List<UserEntity> customerEntities = userDao.getAll();
        for (UserEntity entity : customerEntities) {
            userDtos.add(new UserDto(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole(),entity.isStatus()));
        }
        return userDtos;
    }  

    @Override
    public UserDto getUserByUsername(String username) throws Exception {
        UserEntity entity = userDao.getUserByUsername(username);

        if (entity != null) {
            return new UserDto(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getRole(), entity.isStatus());
        }

        return null;
    }
}
