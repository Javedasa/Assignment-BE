package com.example.assignmentdemo.entity;

import com.example.assignmentdemo.Enum.ApprovalStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "mentor")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    String contactNumber;
    //CV (possibly stored as a file path or a reference to a file storage system)
    //Other details related to the consultant (e.g., specialization, experience, etc.)

    @Enumerated(EnumType.STRING)
    ApprovalStatus approvalStatus;

    //Timestamp (for tracking when the account was approved)
    @CreationTimestamp
    Date approvedDate;
}
