package com.utn.sprint_4;

import com.utn.sprint_4.entidades.*;
import com.utn.sprint_4.enumeraciones.EstadoPedido;
import com.utn.sprint_4.enumeraciones.FormaPago;
import com.utn.sprint_4.enumeraciones.TipoEnvio;
import com.utn.sprint_4.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class sprint_4_Application {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public static void main(String[] args) {
        SpringApplication.run(sprint_4_Application.class, args);
        System.out.println("Hola, estoy andando bien");
    }

/*
    @Bean
    CommandLineRunner init() {
        return args -> {

            SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoHora= new SimpleDateFormat("hh:mm:ss");
            String fechaString = "2023-09-13";
            String fechaString2 = "2023-05-19";
            String fechaString3 = "2023-03-21";
            String fechaString4 = "2023-07-11";
            String horaString = "21:05:03";

            Date fecha = formatoFecha.parse(fechaString);
            Date fecha2 = formatoFecha.parse(fechaString2);
            Date fecha3 = formatoFecha.parse(fechaString3);
            Date fecha4 = formatoFecha.parse(fechaString4);
            Date hora = formatoHora.parse(horaString);

            Usuario usuario = Usuario.builder()
                    .auth0Id("User01")
                    .username("Facustriker")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .build();

            Cliente cliente = Cliente.builder()
                    .nombre("Juan")
                    .apellido("Marquez")
                    .telefono("2617223459")
                    .email("yoSoyDeBoca@gmail.com")
                    .usuario(usuario)
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .build();

            Domicilio domicilio1 = Domicilio.builder()
                    .calle("Beltrán")
                    .codigoPostal(5500)
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .localidad("Godoy Cruz")
                    .numero(342)
                    .numeroDpto(3)
                    .pisoDpto(2)
                    .build();

            Domicilio domicilio2 = Domicilio.builder()
                    .calle("Belgrano")
                    .codigoPostal(5519)
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .localidad("Capital")
                    .numero(302)
                    .numeroDpto(4)
                    .pisoDpto(1)
                    .build();

            cliente.AgregarDomicilios(domicilio1);
            cliente.AgregarDomicilios(domicilio2);

            DetallePedido detallePedido1 = DetallePedido.builder()
                    .cantidad(6)
                    .subtotal(7000)
                    .subtotal_costo(5000)
                    .build();

            DetallePedido detallePedido2 = DetallePedido.builder()
                    .cantidad(4)
                    .subtotal(3000)
                    .subtotal_costo(1000)
                    .build();

            DetallePedido detallePedido3 = DetallePedido.builder()
                    .cantidad(12)
                    .subtotal(13000)
                    .subtotal_costo(4500)
                    .build();

            RubroArticulo rubroArticulo = RubroArticulo.builder()
                    .denominacion("Carne")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .build();

            RubroArticulo rubroArticulo2 = RubroArticulo.builder()
                    .denominacion("Verdura")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .build();

            ArticuloInsumo artIns1 = ArticuloInsumo.builder()
                    .denominacion("Carne molida")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .precioCompra(50000)
                    .stockActual(200)
                    .stockMinimo(100)
                    .urlImagen("http://imagengod.com")
                    .rubroArticulo(rubroArticulo)
                    .build();

            ArticuloInsumo artIns2 = ArticuloInsumo.builder()
                    .denominacion("Tomate")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .precioCompra(25000)
                    .stockActual(200)
                    .stockMinimo(100)
                    .urlImagen("httpp//imagengodtomatito.com")
                    .rubroArticulo(rubroArticulo2)
                    .build();

            UnidadMedida unidadMedida = UnidadMedida.builder()
                    .abreviatura("kg")
                    .denominacion("kilogramo")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .build();


            unidadMedida.AgregarArticulosInsumo(artIns1);
            unidadMedida.AgregarArticulosInsumo(artIns2);

            DetalleArticuloManufacturado detArtManu1 = DetalleArticuloManufacturado.builder()
                    .cantidad(4)
                    .build();

            DetalleArticuloManufacturado detArtManu2 = DetalleArticuloManufacturado.builder()
                    .cantidad(5)
                    .build();

            DetalleArticuloManufacturado detArtManu3 = DetalleArticuloManufacturado.builder()
                    .cantidad(9)
                    .build();

            ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
                    .costo(3922)
                    .denominacion("Hamburguesa")
                    .descripcion("Hamburguesa simple con cheddar")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .precioVenta(13000)
                    .tiempoEstimadoCocina(20)
                    .urlImagen("http//hamborguesitas-o-ke.com")
                    .build();

            ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
                    .costo(2000)
                    .denominacion("Pizza")
                    .descripcion("Pizza con jamón")
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .precioVenta(15000)
                    .tiempoEstimadoCocina(30)
                    .urlImagen("http//mmmmPizzita.com")
                    .build();

            articuloManufacturado1.AgregarDetalleArtManufac(detArtManu1);
            articuloManufacturado1.AgregarDetalleArtManufac(detArtManu2);
            articuloManufacturado2.AgregarDetalleArtManufac(detArtManu3);

            Pedido pedido1 = Pedido.builder()
                    .estado(EstadoPedido.PAGADO)
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .fechaPedido(fecha4)
                    .formaPago(FormaPago.EFECTIVO)
                    .horaEstimadaFinalizacion(hora)
                    .tipoEnvio(TipoEnvio.TAKE_AWAY)
                    .total(4000)
                    .totalCosto(2000)
                    .domicilioEntrega(domicilio1)
                    .build();

            Pedido pedido2 = Pedido.builder()
                    .estado(EstadoPedido.COMPLETADO)
                    .fechaAlta(fecha)
                    .fechaBaja(fecha2)
                    .fechaModificacion(fecha3)
                    .fechaPedido(fecha4)
                    .formaPago(FormaPago.EFECTIVO)
                    .horaEstimadaFinalizacion(hora)
                    .tipoEnvio(TipoEnvio.TAKE_AWAY)
                    .total(9000)
                    .totalCosto(3260)
                    .domicilioEntrega(domicilio2)
                    .build();

            Factura factura1 = Factura.builder()
                    .fechaAlta(fecha)
                    .fechaFacturacion(fecha2)
                    .fechaModificacion(fecha3)
                    .formapago(FormaPago.EFECTIVO)
                    .merchantorder(201933394L)
                    .paymentid(3423523775L)
                    .paymenttype("niIdea")
                    .preferenceid("3423523775")
                    .totalventa(3099)
                    .pedido(pedido2)
                    .build();

            Factura factura2 = Factura.builder()
                    .fechaAlta(fecha)
                    .fechaFacturacion(fecha2)
                    .fechaModificacion(fecha3)
                    .formapago(FormaPago.EFECTIVO)
                    .merchantorder(201933394L)
                    .paymentid(3423523775L)
                    .paymenttype("niIdea")
                    .preferenceid("3423523775")
                    .totalventa(3099)
                    .pedido(pedido1)
                    .build();


            DetalleFactura detalleFactura1 = DetalleFactura.builder()
                    .cantidad(3)
                    .subtotal(4000)
                    .articuloManufacturado(articuloManufacturado1)
                    .facturas(factura1)
                    .build();

            DetalleFactura detalleFactura2 = DetalleFactura.builder()
                    .cantidad(4)
                    .subtotal(5000)
                    .articuloManufacturado(articuloManufacturado1)
                    .facturas(factura1)
                    .build();

            DetalleFactura detalleFactura3 = DetalleFactura.builder()
                    .cantidad(7)
                    .subtotal(12000)
                    .articuloManufacturado(articuloManufacturado2)
                    .facturas(factura2)
                    .build();

            artIns1.AgregarDetallesFactura(detalleFactura1);
            artIns1.AgregarDetallesFactura(detalleFactura2);
            artIns2.AgregarDetallesFactura(detalleFactura3);



            pedido1.AgregarDetallePedido(detallePedido1);
            pedido1.AgregarDetallePedido(detallePedido2);
            pedido2.AgregarDetallePedido(detallePedido3);
            cliente.AgregarPedidos(pedido1);
            cliente.AgregarPedidos(pedido2);

            clienteRepository.save(cliente);

            pedidoRepository.save(pedido1);
            pedidoRepository.save(pedido2);

            articuloManufacturadoRepository.save(articuloManufacturado1);
            articuloManufacturadoRepository.save(articuloManufacturado2);

            unidadMedidaRepository.save(unidadMedida);

            rubroArticuloRepository.save(rubroArticulo);
            rubroArticuloRepository.save(rubroArticulo2);

            facturaRepository.save(factura1);
            facturaRepository.save(factura2);


        };
    }*/


}
