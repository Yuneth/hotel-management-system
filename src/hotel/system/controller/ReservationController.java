/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.controller;

import hotel.system.dto.ReservationDetailsDto;
import hotel.system.dto.ReservationDto;
import hotel.system.service.ServiceFactory;
import hotel.system.service.custom.ReservationService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationController {
    
    private ReservationService reservationService = (ReservationService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.RESERVATION);

    public String saveReservation(ReservationDetailsDto reservationDto) throws Exception {
        return reservationService.addReservation(reservationDto);
    }

    public String updateReservation(ReservationDetailsDto reservationDto) throws Exception {
        return reservationService.updateReservation(reservationDto);
    }

    public String deleteReservation(String id) throws Exception {
        return reservationService.deleteReservation(id);
    }

    public ReservationDetailsDto getReservation(String id) throws Exception {
        return reservationService.getReservation(id);
    }

    public List<ReservationDetailsDto> getAllReservation() throws Exception {
        return reservationService.getAll();
    }
    
    public String confirmReservation(ReservationDto reservationDto) throws Exception {
        return reservationService.confirmReservation(reservationDto);
    }
    
    public String cancelReservation(String reservationId) throws Exception {
        return reservationService.cancelReservation(reservationId);
    }
    
    
}
