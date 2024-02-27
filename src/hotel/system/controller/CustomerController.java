/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.controller;

import hotel.system.dto.CustomerDto;
import hotel.system.service.ServiceFactory;
import hotel.system.service.custom.CustomerService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class CustomerController {

    private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);

    public String saveCustomer(CustomerDto customerDto) throws Exception {
        return customerService.addCustomer(customerDto);
    }

    public String updateCustomer(CustomerDto customerDto) throws Exception {
        return customerService.updateCustomer(customerDto);
    }

    public String deleteCustomer(String id) throws Exception {
        return customerService.deleteCustomer(id);
    }

    public CustomerDto getCustomer(String id) throws Exception {
        return customerService.getCustomer(id);
    }

    public List<CustomerDto> getAllCustomer() throws Exception {
        return customerService.getAll();
    }

//    public List<CustomerDto> getCustomersByNIC(String nic) throws Exception {
//        return customerService.getCustomersByNIC(nic);
//    }

//    public List<CustomerDto> searchCustomer(String searchTerm) throws Exception {
//        return customerService.searchCustomerByTerm(searchTerm);
//    }
}
