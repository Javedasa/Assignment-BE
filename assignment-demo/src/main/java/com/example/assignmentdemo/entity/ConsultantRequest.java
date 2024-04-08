package com.example.assignmentdemo.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "consultantRequest")
public class ConsultantRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String name;

     int age;

     String status;

     String phoneNo;
}
