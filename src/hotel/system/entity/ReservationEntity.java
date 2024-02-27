/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.entity;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationEntity {
    private String reservationId;
    private String customerId;
    private boolean status;

    public ReservationEntity() {
    }

    public ReservationEntity(String reservationId, String customerId, boolean status) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.status = status;
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

    @Override
    public String toString() {
        return "ReservationEntity{" + "reservationId=" + reservationId + ", customerId=" + customerId + ", status=" + status + '}';
    }
    
    
}
