package com.javatechie.hims.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.TrueFalseConverter;



@Entity
@Table(name = "notifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;


    @Convert(converter = TrueFalseConverter.class)
    private boolean isNotified;


    private String productId;

    @ManyToOne
    private User user;


}
