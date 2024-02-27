/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.dao;

import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface CrudDao <T, ID> extends SuperDao {
    boolean save(T t) throws Exception;
    boolean update(T t) throws Exception;
    boolean delete(ID id) throws Exception;
    T get(ID id) throws Exception;
    List<T> getAll() throws Exception;
    
    //List<T> getByNIC(String nic) throws Exception;
}
