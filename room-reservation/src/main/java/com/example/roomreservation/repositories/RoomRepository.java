package com.example.roomreservation.repositories;

import com.example.roomreservation.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    void deleteRoomById(Long id);
    Room findRoomById(Long id);
    List<Room> findAll();
    @Query(value = "select r.id, r.name, r.floor, r.is_view, r.no_places, c.name as category_name from rooms r " +
            "inner join categories c on r.category_id = c.id ", nativeQuery = true)
    List<Object> findAllCustom();
}
