package com.rouvsen.blogwebsitebackend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String fullName;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String subject;

    @Column(length = 100)
    private String phone;

//    @Temporal(TemporalType.DATE)//only date
//    private Date date;
//
//    @Temporal(TemporalType.TIME)//only time
//    private Date time;
//
//    @Temporal(TemporalType.TIMESTAMP)//date+time
//    private Date dateTime;

    //modern practices
    @Column(columnDefinition = "DATE")//date
    private LocalDate date;

    @Column(columnDefinition = "TIME")//time
    private LocalTime time;

//    @Column(columnDefinition = "TIMESTAMP")//date+time
//    private LocalDateTime dateTime;

    private String message;

}
