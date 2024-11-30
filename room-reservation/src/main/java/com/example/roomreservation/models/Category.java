package com.example.roomreservation.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // default name is the name of class "Category", is like you set: @Entity(name = "Category")
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "Name is required.")
    @Size(min = 2, max = 100, message = "Name '${validatedValue}' length must be between {min} and {max} characters.")
    private String name;

    @NotBlank(message = "Price is required.")
    @Positive
    @Range(min=10, max=Integer.MAX_VALUE, message = "Price '${validatedValue}' must be grater or equal with {min}.")
    private String price;

    private Timestamp created_at;

    private Timestamp updated_at;
}
