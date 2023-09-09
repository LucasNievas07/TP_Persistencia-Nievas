package com.example.practicopersistencia.Entities;

import com.example.practicopersistencia.ENUMS.FormaPago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Factura extends ClaseBase{
    private String fecha;
    private int numero;
    private double descuento;
    private double total;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
}
