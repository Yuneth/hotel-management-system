/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.system.service.custom.impl;

import hotel.system.dao.DaoFactory;
import hotel.system.dao.custom.ReservationDao;
import hotel.system.dto.ReservationDetailsDto;
import hotel.system.entity.ReservationDetailsEntity;
import hotel.system.service.custom.ReservationService;
import java.util.ArrayList;
import java.util.List;
import hotel.system.dao.custom.ReservationDetailsDao;
import hotel.system.dao.custom.RoomDao;
import hotel.system.db.DBConnection;
import hotel.system.dto.ReservationDto;
import hotel.system.entity.ReservationEntity;
import hotel.system.entity.RoomEntity;
import java.sql.Connection;
import java.util.Date;

/**
 *
 * @author Yuneth Perera
 */
public class ReservationServiceImpl implements ReservationService {

    private ReservationDetailsDao reservationDetailsDao = (ReservationDetailsDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.RESERVATION_DETAILS);
    private ReservationDao reservationDao = (ReservationDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.RESERVATION);
    private RoomDao roomDao = (RoomDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.ROOM);

    @Override
    public String addReservation(ReservationDetailsDto dto) throws Exception {
        ReservationDetailsEntity reservationEntity = new ReservationDetailsEntity(
                dto.getReservationId(), dto.getRoomId(), dto.getCustomerId(), dto.getPackageId(), dto.getReserveDate(), dto.getCheckInDate(), dto.getCheckInTime(), dto.getCheckOutDate(), dto.getCheckOutTime(), dto.getReserveStatus(), dto.getAmount(), dto.isStatus());

        if (reservationDetailsDao.save(reservationEntity)) {
            return "Successfully Saved";
        } else {
            return "Fail";
        }
    }

    @Override
    public String updateReservation(ReservationDetailsDto dto) throws Exception {
        ReservationDetailsEntity reservationEntity = new ReservationDetailsEntity(
                dto.getReservationId(), dto.getRoomId(), dto.getCustomerId(), dto.getPackageId(), dto.getReserveDate(), dto.getCheckInDate(), dto.getCheckInTime(), dto.getCheckOutDate(), dto.getCheckOutTime(), dto.getReserveStatus(), dto.getAmount(), dto.isStatus());

        if (reservationDetailsDao.update(reservationEntity)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteReservation(String id) throws Exception {
        if (reservationDetailsDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public ReservationDetailsDto getReservation(String id) throws Exception {
        ReservationDetailsEntity entity = reservationDetailsDao.get(id);
        if (entity != null) {
            return new ReservationDetailsDto(entity.getReservationId(), entity.getRoomId(), entity.getCustomerId(), entity.getPackageId(), entity.getReserveDate(), entity.getCheckInDate(), entity.getCheckInTime(), entity.getCheckOutDate(), entity.getCheckOutTime(), entity.getReserveStatus(), entity.getAmount(), entity.isStatus());
        }

        return null;
    }

    @Override
    public List<ReservationDetailsDto> getAll() throws Exception {
        List<ReservationDetailsDto> reservationDtos = new ArrayList<>();
        List<ReservationDetailsEntity> reservationEntities = reservationDetailsDao.getAll();
        for (ReservationDetailsEntity entity : reservationEntities) {
            reservationDtos.add(new ReservationDetailsDto(entity.getReservationId(), entity.getRoomId(), entity.getCustomerId(), entity.getPackageId(), entity.getReserveDate(), entity.getCheckInDate(), entity.getCheckInTime(), entity.getCheckOutDate(), entity.getCheckOutTime(), entity.getReserveStatus(), entity.getAmount(), entity.isStatus()));
        }
        return reservationDtos;
    }

    @Override
    public String confirmReservation(ReservationDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            ReservationEntity reservationEntity = new ReservationEntity(
                    dto.getReservationId(),
                    dto.getCustomerId(),
                    dto.isStatus());

            if (reservationDao.save(reservationEntity)) {
                boolean isSavedReservationDetail = true;

                for (ReservationDetailsDto reservationDetailsDto : dto.getReservationDetailsDtos()) {
                    ReservationDetailsEntity reservationDetailsEntity = new ReservationDetailsEntity(
                            dto.getReservationId(),
                            //reservationDetailsDto.getReservationId(),
                            reservationDetailsDto.getRoomId(),
                            reservationDetailsDto.getCustomerId(),
                            reservationDetailsDto.getPackageId(),
                            reservationDetailsDto.getReserveDate(),
                            reservationDetailsDto.getCheckInDate(),
                            reservationDetailsDto.getCheckInTime(),
                            reservationDetailsDto.getCheckOutDate(),
                            reservationDetailsDto.getCheckOutTime(),
                            reservationDetailsDto.getReserveStatus(),
                            reservationDetailsDto.getAmount(),
                            reservationDetailsDto.isStatus());

                    if (!reservationDetailsDao.save(reservationDetailsEntity)) {
                        isSavedReservationDetail = false;
                    }
                }

                if (isSavedReservationDetail) {
                    boolean isRoomUpdated = true;

                    for (ReservationDetailsDto reservationDetailsDto : dto.getReservationDetailsDtos()) {
                        RoomEntity roomEntity = roomDao.get(reservationDetailsDto.getRoomId());
                        roomEntity.setAvailabilityStatus("Booked");
                        roomEntity.setStatus(true);

                        if (!roomDao.update(roomEntity)) {
                            isRoomUpdated = false;
                        }
                    }
                    if (isRoomUpdated) {
                        connection.commit();
                        return "Successfully Saved";
                    } else {
                        connection.rollback();
                        return "Error in Room Update";
                    }
                } else {
                    connection.rollback();
                    return "Error in Reservation Detail Save";
                }
            } else {
                connection.rollback();
                return "Error in Reservation save";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public String cancelReservation(String reservationId) throws Exception {
        // Retrieve reservation details
        ReservationDetailsDto reservationDetailsDto = getReservation(reservationId);

        // Check if 24 hours have passed
        if (hasTwentyFourHoursPassed(reservationDetailsDto.getReserveDate())) {
            return "Cannot cancel reservation. 24 hours have passed.";
        }

        // Update reservation details
        reservationDetailsDto.setReserveStatus("Cancelled");
        reservationDetailsDto.setStatus(false);
        updateReservation(reservationDetailsDto);

        // Update room availability status
        RoomEntity roomEntity = roomDao.get(reservationDetailsDto.getRoomId());
        roomEntity.setAvailabilityStatus("Available");
        roomEntity.setStatus(true);
        roomDao.update(roomEntity);

        return "Reservation cancelled successfully.";
    }

    // Implement the hasTwentyFourHoursPassed method
    private boolean hasTwentyFourHoursPassed(Date reserveDate) {
        // Get the current date and time
        Date currentDate = new Date();

        // Calculate the time difference in milliseconds
        long timeDifference = currentDate.getTime() - reserveDate.getTime();

        // Calculate the time difference in hours
        long hoursDifference = timeDifference / (60 * 60 * 1000);

        // Check if 24 hours have passed
        return hoursDifference >= 24;
        //return false;
    }

    public String updateReservation(ReservationDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);

            // Update ReservationEntity
            ReservationEntity reservationEntity = new ReservationEntity(
                    dto.getReservationId(),
                    dto.getCustomerId(),
                    dto.isStatus());

            if (reservationDao.update(reservationEntity)) {
                // Update ReservationDetailsEntities
                boolean isUpdatedReservationDetails = true;

                for (ReservationDetailsDto reservationDetailsDto : dto.getReservationDetailsDtos()) {
                    ReservationDetailsEntity reservationDetailsEntity = new ReservationDetailsEntity(
                            dto.getReservationId(),
                            reservationDetailsDto.getRoomId(),
                            reservationDetailsDto.getCustomerId(),
                            reservationDetailsDto.getPackageId(),
                            reservationDetailsDto.getReserveDate(),
                            reservationDetailsDto.getCheckInDate(),
                            reservationDetailsDto.getCheckInTime(),
                            reservationDetailsDto.getCheckOutDate(),
                            reservationDetailsDto.getCheckOutTime(),
                            reservationDetailsDto.getReserveStatus(),
                            reservationDetailsDto.getAmount(),
                            reservationDetailsDto.isStatus());

                    if (!reservationDetailsDao.update(reservationDetailsEntity)) {
                        isUpdatedReservationDetails = false;
                    }
                }

                if (isUpdatedReservationDetails) {
                    connection.commit();
                    return "Successfully Updated";
                } else {
                    connection.rollback();
                    return "Error in Updating Reservation Details";
                }
            } else {
                connection.rollback();
                return "Error in Updating Reservation";
            }
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }

    }
}
