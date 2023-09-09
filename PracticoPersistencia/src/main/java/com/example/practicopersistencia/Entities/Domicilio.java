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
public class Domicilio extends ClaseBase{
    private String calle;
    private String numero;
    private String localidad;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="domicilio_id")
    private List<Pedido> pedidos = new ArrayList<>();
}
