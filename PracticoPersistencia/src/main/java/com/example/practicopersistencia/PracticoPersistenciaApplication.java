package com.example.practicopersistencia;

import com.example.practicopersistencia.ENUMS.Estado;
import com.example.practicopersistencia.ENUMS.FormaPago;
import com.example.practicopersistencia.ENUMS.Tipo;
import com.example.practicopersistencia.ENUMS.TipoEnvio;
import com.example.practicopersistencia.Entities.*;
import com.example.practicopersistencia.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class PracticoPersistenciaApplication {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ConfiguracionGeneralRepository configuracionGeneralRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RubroRepository rubroRepository;

    public static void main(String[] args) {
        SpringApplication.run(PracticoPersistenciaApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            Factura factura = Factura.builder()
                    .fecha(LocalDate.now().toString())
                    .numero(4582)
                    .descuento(9.99)
                    .formaPago(FormaPago.TRANSFERENCIA)
                    .total(572.25)
                    .build();
            facturaRepository.save(factura);

            DetallePedido detallePedido = DetallePedido.builder()
                    .cantidad(3)
                    .subtotal(3500.0)
                    .build();
            detallePedidoRepository.save(detallePedido);

            Pedido pedido = Pedido.builder()
                    .fecha(LocalDate.now().toString())
                    .estado(Estado.PREPARACION)
                    .horaEstimadaEntrega("22:45")
                    .tipoEnvio(TipoEnvio.DELIVERY)
                    .total(572.25)
                    .factura(factura)
                    .detallePedidos(new ArrayList<>())
                    .build();
            pedido.getDetallePedidos().add(detallePedido);
            pedidoRepository.save(pedido);

            Domicilio domicilio = Domicilio.builder()
                    .calle("Godoy Cruz")
                    .numero("3542")
                    .localidad("Villa Nueva")
                    .pedidos(new ArrayList<>())
                    .build();
            domicilio.getPedidos().add(pedido);
            domicilioRepository.save(domicilio);

            Cliente cliente = Cliente.builder()
                    .nombre("Felipe")
                    .apellido("Ventura")
                    .telefono("123456789")
                    .email("FelipeVentura@gmail.com")
                    .pedidos(new ArrayList<>())
                    .domicilios(new ArrayList<>())
                    .build();
            cliente.getPedidos().add(pedido);
            cliente.getDomicilios().add(domicilio);
            clienteRepository.save(cliente);

            Usuario usuario = Usuario.builder()
                    .nombre("Felipe64")
                    .password("1234abcd")
                    .rol("Usuario")
                    .pedidos(new ArrayList<>())
                    .build();
            usuario.getPedidos().add(pedido);
            usuarioRepository.save(usuario);

            Producto producto = Producto.builder()
                    .tipo(Tipo.MANUFACTURADO)
                    .tiempoEstimadoCocina(1)
                    .denominacion("Pizza")
                    .precioVenta(629.42)
                    .precioCompra(572.25)
                    .stockActual(5)
                    .stockMinimo(1)
                    .unidadMedida("cm")
                    .foto("Imagen")
                    .receta("Receta")
                    .detallePedidos(new ArrayList<>())
                    .build();
            producto.getDetallePedidos().add(detallePedido);
            productoRepository.save(producto);

            Rubro rubro = Rubro.builder()
                    .denominacion("Comida")
                    .productos(new ArrayList<>())
                    .build();
            rubro.getProductos().add(producto);
            rubroRepository.save(rubro);

            ConfiguracionGeneral configuracionGeneral = ConfiguracionGeneral.builder()
                    .cantidadCocineros(5)
                    .emailEmpresa("CocinerosCinco@gmail.com")
                    .tokenMercadoPago("Cocineros")
                    .build();
            configuracionGeneralRepository.save(configuracionGeneral);
        };
    }
}
