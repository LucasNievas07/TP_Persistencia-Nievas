package com.example.practicopersistencia.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rubro extends ClaseBase{
    private String denominacion;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="rubro_id")
    private List<Producto> productos = new ArrayList<>();
}
