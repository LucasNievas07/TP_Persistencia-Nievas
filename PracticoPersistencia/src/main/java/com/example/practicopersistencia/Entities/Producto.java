package com.example.practicopersistencia.Entities;

import com.example.practicopersistencia.ENUMS.Tipo;
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
public class Producto extends ClaseBase{
    private int tiempoEstimadoCocina;
    private String denominacion;
    private double precioVenta;
    private double precioCompra;
    private int stockActual;
    private int stockMinimo;
    private String unidadMedida;
    private String foto;
    private String receta;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="producto_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();
}
