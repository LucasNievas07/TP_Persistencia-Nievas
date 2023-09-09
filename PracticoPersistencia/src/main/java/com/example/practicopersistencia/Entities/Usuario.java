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
public class Usuario extends ClaseBase{
    private String nombre;
    private String password;
    private String rol;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="usuario_id")
    private List<Pedido> pedidos = new ArrayList<>();
}
