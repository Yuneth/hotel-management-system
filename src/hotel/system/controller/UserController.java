/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.controller;

import hotel.system.dto.UserDto;
import hotel.system.service.ServiceFactory;
import hotel.system.service.custom.UserService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class UserController {

    private UserService userService = (UserService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public String saveUser(UserDto userDto) throws Exception {
        return userService.addUser(userDto);
    }

    public String updateUser(UserDto userDto) throws Exception {
        return userService.updateUser(userDto);
    }

    public String deleteUser(String id) throws Exception {
        return userService.deleteUser(id);
    }

    public UserDto getUser(String id) throws Exception {
        return userService.getUser(id);
    }

    public List<UserDto> getAllUser() throws Exception {
        return userService.getAll();
    }
    
    public UserDto getUserByUsername(String username) throws Exception {
        return userService.getUserByUsername(username);
    }
}
