/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.CustomerDao;
import hotel.system.dto.CustomerDto;
import hotel.system.entity.CustomerEntity;
import hotel.system.service.custom.CustomerService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                dto.getCustomerId(), dto.getFirstName(), dto.getLastName(),dto.getContact() , dto.getAddress(), dto.getNic(),dto.isStatus());

        if (customerDao.save(customerEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                dto.getCustomerId(), dto.getFirstName(), dto.getLastName(),dto.getContact() , dto.getAddress(), dto.getNic(),dto.isStatus());

        if (customerDao.update(customerEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(String id) throws Exception {
        if (customerDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(String id) throws Exception {
        CustomerEntity entity = customerDao.get(id);
        if (entity != null) {
            return new CustomerDto(entity.getCustomerId(), entity.getFirstName(), entity.getLastName(), entity.getNic(), entity.getAddress(),entity.getContact(),entity.isStatus());
        }

        return null;
    }

    @Override
    public List<CustomerDto> getAll() throws Exception {
        List<CustomerDto> customerDtos = new ArrayList<>();
        List<CustomerEntity> customerEntities = customerDao.getAll();
        for (CustomerEntity entity : customerEntities) {
            customerDtos.add(new CustomerDto(entity.getCustomerId(), entity.getFirstName(), entity.getLastName(), entity.getNic(), entity.getAddress(),entity.getContact(),entity.isStatus()));
        }
        return customerDtos;
    }

//    @Override
//    public List<CustomerDto> searchCustomerByTerm(String searchTerm) throws Exception {
//        List<CustomerDto> result = new ArrayList<>();
//    List<CustomerEntity> foundEntities = customerDao.searchCustomersByName(searchTerm);
//
//    for (CustomerEntity entity : foundEntities) {
//        result.add(new CustomerDto(
//                entity.getCustomerId(), entity.getName(), entity.getNic(), entity.getAddress(), entity.getContact()));
//    }
//
//    return result;
//    }

//    @Override
//    public List<CustomerDto> getCustomersByNIC(String nic) throws Exception {
//        return customerDtos;
//    }
    
}
