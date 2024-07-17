package com.ms.comments.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CommentDTO implements Serializable {

    //@NotBlank(message = "Id is required")
    //@Size(min=1, max=10)
    @Size(max=300)
    @NotEmpty(message = "no debe estar vacio")
    private String message;
    @NotNull(message = "no puede ser nulo")
    private Long user;
    @NotNull(message = "no puede ser nulo")
    private Long task;
}
