/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system;

import hotel.system.dto.ReservationDetailsDto;
import hotel.system.view.AddUserView;
import hotel.system.view.AllReservationView;
import hotel.system.view.CustomerView;
import hotel.system.view.LoginView;
import hotel.system.view.AdminDashboardView;
import hotel.system.view.PackageView;
import hotel.system.view.ReceptionistDashboardView;
import hotel.system.view.ReservationUpdateView;
import hotel.system.view.ReservationView;
import hotel.system.view.RoomView;
import hotel.system.view.RoomCategoryView;
import hotel.system.view.test;

/**
 *
 * @author Yuneth Perera
 */
public class Main {

    public static void main(String[] args) {
//        ReservationDetailsDto ReservationDetailsDto = null;
//        new ReservationView(ReservationDetailsDto).setVisible(true);

        new LoginView().setVisible(true);
    }

}
