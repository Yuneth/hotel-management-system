/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.UserDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface UserService extends SuperService {
    
    String addUser(UserDto dto) throws Exception;

    String updateUser(UserDto dto) throws Exception;

    String deleteUser(String id) throws Exception;
    
    UserDto getUser(String id) throws Exception;
    
    List<UserDto> getAll() throws Exception;
    
    UserDto getUserByUsername(String username) throws Exception;
}
