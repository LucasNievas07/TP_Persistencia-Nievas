package com.example.practicopersistencia.Entities;

import com.example.practicopersistencia.ENUMS.Estado;
import com.example.practicopersistencia.ENUMS.TipoEnvio;
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
public class Pedido extends ClaseBase{
    private String fecha;
    private String horaEstimadaEntrega;
    private double total;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    private List<DetallePedido> detallePedidos = new ArrayList<>();

}
