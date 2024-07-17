package com.ms.comments.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Validated
@Entity
@Table(name="comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "message")
    private String message;

    @Getter @Setter @Column(name = "user_id")
    private Long user;

    @Getter @Setter @Column(name = "task_id")
    private Long task;

}
