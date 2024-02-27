/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dao;

import hotel.system.dao.custom.impl.CustomerDaoImpl;
import hotel.system.dao.custom.impl.PackageDaoImpl;
import hotel.system.dao.custom.impl.ReservationDaoImpl;
import hotel.system.dao.custom.impl.ReservationDetailsDaoImpl;
import hotel.system.dao.custom.impl.RoomCategoryDaoImpl;
import hotel.system.dao.custom.impl.RoomDaoImpl;
import hotel.system.dao.custom.impl.UserDaoImpl;

/**
 *
 * @author Yuneth Perera
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DaoFactory();
        }

        return daoFactory;
    }

    public SuperDao getDao(DaoType type) {
        switch (type) {
            case USER:
                return new UserDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ROOMCATEGORY:
                return new RoomCategoryDaoImpl();
            case ROOM:
                return new RoomDaoImpl();
            case PACKAGE:
                return new PackageDaoImpl();
            case RESERVATION_DETAILS:
                return new ReservationDetailsDaoImpl();
            case RESERVATION:
                return new ReservationDaoImpl();
            default:
                return null;
        }
    }

    public enum DaoType {
        USER, CUSTOMER, ROOMCATEGORY, ROOM, PACKAGE, RESERVATION_DETAILS, RESERVATION
    }
}
