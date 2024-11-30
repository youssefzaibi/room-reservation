package com.example.roomreservation.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "Client is required.")
    @Positive
    @Range(min = 1, max = Integer.MAX_VALUE, message = "Client '${validatedValue}' must be grater or equal with {min}.")
    private Long client_id;

    @NotNull(message = "Room is required.")
    @Positive
    @Range(min = 1, max = Integer.MAX_VALUE, message = "Room '${validatedValue}' must be grater or equal with {min}.")
    private Long room_id;

    @NotNull(message = "Reservation Date is required.")
    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull(message = "No Days is required.")
    @Range(min = 1, max = Integer.MAX_VALUE, message = "No Days '${validatedValue}' must be grater or equal with {min}.")
    private Integer no_days;

    @NotNull(message = "No Persons is required.")
    @Range(min = 1, max = Integer.MAX_VALUE, message = "No Persons '${validatedValue}' must be grater or equal with {min}.")
    private Integer no_persons;

    private Timestamp created_at;

    private Timestamp updated_at;
}
