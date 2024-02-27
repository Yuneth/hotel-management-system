/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.dto;

import java.util.List;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationDto {
    private String reservationId;
    private String customerId;
    private boolean status;
    
    private List<ReservationDetailsDto> reservationDetailsDtos;

    public ReservationDto() {
    }

    public ReservationDto(String reservationId, String customerId, boolean status, List<ReservationDetailsDto> reservationDetailsDtos) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.status = status;
        this.reservationDetailsDtos = reservationDetailsDtos;
    }

    /**
     * @return the reservationId
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the reservationDetailsDtos
     */
    public List<ReservationDetailsDto> getReservationDetailsDtos() {
        return reservationDetailsDtos;
    }

    /**
     * @param reservationDetailsDtos the reservationDetailsDtos to set
     */
    public void setReservationDetailsDtos(List<ReservationDetailsDto> reservationDetailsDtos) {
        this.reservationDetailsDtos = reservationDetailsDtos;
    }

    @Override
    public String toString() {
        return "ReservationDto{" + "reservationId=" + reservationId + ", customerId=" + customerId + ", status=" + status + ", reservationDetailsDtos=" + reservationDetailsDtos + '}';
    }
    
    
}
