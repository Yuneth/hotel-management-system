/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotel.system.service.custom;

import hotel.system.dto.ReservationDetailsDto;
import hotel.system.dto.ReservationDto;
import hotel.system.service.SuperService;
import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public interface ReservationService extends SuperService {

    String addReservation(ReservationDetailsDto dto) throws Exception;

    String updateReservation(ReservationDetailsDto dto) throws Exception;

    String deleteReservation(String id) throws Exception;

    ReservationDetailsDto getReservation(String id) throws Exception;

    List<ReservationDetailsDto> getAll() throws Exception;

    String confirmReservation(ReservationDto dto) throws Exception;
    
    String cancelReservation(String reservationId) throws Exception;
}
