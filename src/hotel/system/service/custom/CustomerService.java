/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.CustomerDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface CustomerService extends SuperService {

    String addCustomer(CustomerDto dto) throws Exception;

    String updateCustomer(CustomerDto dto) throws Exception;

    String deleteCustomer(String id) throws Exception;

    CustomerDto getCustomer(String id) throws Exception;

    List<CustomerDto> getAll() throws Exception;
    
//    List<CustomerDto> getCustomersByNIC(String nic) throws Exception;
    
//    List<CustomerDto> searchCustomerByTerm(String searchTerm) throws Exception;
}
