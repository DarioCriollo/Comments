package com.ms.comments.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class ErrorDTO {

    private Date date = new Date();
    private String descripcion;
    private String path;
    private List<String> reasons;

    public ErrorDTO(String descripcion, List<String> reasons){
        this.descripcion = descripcion;
        this.reasons = reasons;
    }

    public ErrorDTO(String descripcion, String path){
        this.descripcion = descripcion;
        this.path = path;
    }

    public ErrorDTO(String descripcion, String path, List<String> reasons){
        this.descripcion = descripcion;
        this.path = path;
        this.reasons = reasons;
    }
}
