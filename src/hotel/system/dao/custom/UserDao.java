/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.dao.custom;

import hotel.system.dao.CrudDao;
import hotel.system.entity.UserEntity;

/**
 *
 * @author Yuneth Perera
 */
public interface UserDao extends CrudDao<UserEntity, String> {

    public UserEntity getUserByUsername(String username);
    
    
}


