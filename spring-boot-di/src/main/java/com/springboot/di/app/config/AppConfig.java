package com.springboot.di.app.config;

import com.springboot.di.app.domain.ItemFactura;
import com.springboot.di.app.domain.Producto;
import com.springboot.di.app.service.MiServiceInterface;
import com.springboot.di.app.service.MiServiceMain;
import com.springboot.di.app.service.MiServiceSecundary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean("miServicioSecundary")
    @Primary
    public MiServiceInterface miServiceSecundary() {
        return new MiServiceSecundary();
    }

    @Bean("miServicioMain")
    //@Primary
    public MiServiceInterface miServiceMain() {
        return new MiServiceMain();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems() {
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta", 200);
        Producto producto3 = new Producto("Play Station", 400);

        ItemFactura itemFactura1 = new ItemFactura(producto1, 3);
        ItemFactura itemFactura2 = new ItemFactura(producto2, 4);
        ItemFactura itemFactura3 = new ItemFactura(producto3, 5);

        return Arrays.asList(itemFactura1, itemFactura2, itemFactura3);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina() {
        Producto producto1 = new Producto("Camara Sony Oficina", 100);
        Producto producto2 = new Producto("Bicicleta Oficina", 200);
        Producto producto3 = new Producto("Play Station Oficina", 400);

        ItemFactura itemFactura1 = new ItemFactura(producto1, 3);
        ItemFactura itemFactura2 = new ItemFactura(producto2, 4);
        ItemFactura itemFactura3 = new ItemFactura(producto3, 5);

        return Arrays.asList(itemFactura1, itemFactura2, itemFactura3);
    }
}
