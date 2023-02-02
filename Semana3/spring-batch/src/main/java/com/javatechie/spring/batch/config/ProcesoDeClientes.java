package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ProcesoDeClientes implements ItemProcessor<Cliente,Cliente> {

    @Override
    public Cliente process(Cliente cliente) throws Exception {
        //if(Cliente.getCountry().equals("China")) {
            return cliente;
        //  }
        //return null;
        
    }
}
