package com.example.assignmentdemo.entity;

import com.example.assignmentdemo.Enum.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "mentorRequest")
public class MentorRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    UUID requestId;

    String email;

    @Enumerated(EnumType.STRING)
    Status status;

    @CreationTimestamp
    Date date;

}
