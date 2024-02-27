/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service;

import hotel.system.service.custom.impl.CustomerServiceImpl;
import hotel.system.service.custom.impl.PackageServiceImpl;
import hotel.system.service.custom.impl.ReservationServiceImpl;
import hotel.system.service.custom.impl.RoomCategoryServiceImpl;
import hotel.system.service.custom.impl.RoomServiceImpl;
import hotel.system.service.custom.impl.UserServiceImpl;

/**
 *
 * @author Yuneth Perera
 */
public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }

        return serviceFactory;
    }

    public SuperService getService(ServiceType type) {
        switch (type) {
            case USER:
                return new UserServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ROOMCATEGORY:
                return new RoomCategoryServiceImpl();
            case ROOM:
                return new RoomServiceImpl();
            case PACKAGE:
                return new PackageServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            default:
                return null;
        }
    }

    public enum ServiceType {
        USER, CUSTOMER, ROOMCATEGORY, ROOM, PACKAGE, RESERVATION
    }
}
