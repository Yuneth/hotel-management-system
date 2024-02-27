/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.entity;

import java.util.Date;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationDetailsEntity {

    private String reservationId;
    private String roomId;
    private String customerId;
    private String packageId;
    private Date reserveDate;
    private Date checkInDate;
    private String checkInTime;
    private Date checkOutDate;
    private String checkOutTime;
    private String reserveStatus;
    private Double amount;
    private boolean status;

    public ReservationDetailsEntity() {
    }

    public ReservationDetailsEntity(String reservationId, String roomId, String customerId, String packageId, Date reserveDate, Date checkInDate, String checkInTime, Date checkOutDate, String checkOutTime, String reserveStatus, Double amount, boolean status) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.customerId = customerId;
        this.packageId = packageId;
        this.reserveDate = reserveDate;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.checkOutDate = checkOutDate;
        this.checkOutTime = checkOutTime;
        this.reserveStatus = reserveStatus;
        this.amount = amount;
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
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
     * @return the packageId
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId the packageId to set
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * @return the reserveDate
     */
    public Date getReserveDate() {
        return reserveDate;
    }

    /**
     * @param reserveDate the reserveDate to set
     */
    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    /**
     * @return the checkInDate
     */
    public Date getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkInTime
     */
    public String getCheckInTime() {
        return checkInTime;
    }

    /**
     * @param checkInTime the checkInTime to set
     */
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    /**
     * @return the checkOutDate
     */
    public Date getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * @return the checkOutTime
     */
    public String getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * @param checkOutTime the checkOutTime to set
     */
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    /**
     * @return the reserveStatus
     */
    public String getReserveStatus() {
        return reserveStatus;
    }

    /**
     * @param reserveStatus the reserveStatus to set
     */
    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
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
        return "ReservationDetailsEntity{" + "reservationId=" + reservationId + ", roomId=" + roomId + ", customerId=" + customerId + ", packageId=" + packageId + ", reserveDate=" + reserveDate + ", checkInDate=" + checkInDate + ", checkInTime=" + checkInTime + ", checkOutDate=" + checkOutDate + ", checkOutTime=" + checkOutTime + ", reserveStatus=" + reserveStatus + ", amount=" + amount + ", status=" + status + '}';
    }

    
}
