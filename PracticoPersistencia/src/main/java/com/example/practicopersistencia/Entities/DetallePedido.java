package com.example.practicopersistencia.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DetallePedido extends ClaseBase{
    private int cantidad;
    private double subtotal;
}
