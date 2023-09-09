package com.example.practicopersistencia.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Cliente extends ClaseBase{
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private List<Domicilio> domicilios = new ArrayList<>();
}
