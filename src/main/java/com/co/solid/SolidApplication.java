package com.co.solid;

import com.co.solid.after.service.PagoAfter;
import com.co.solid.after.service.PagoConTarjetaAfter;
import com.co.solid.after.service.PagoGratisAfter;
import com.co.solid.before.service.PagoConTarjetaBefore;
import com.co.solid.before.service.PagoGratisBefore;
import com.co.solid.before.service.PagoBefore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolidApplication {

	public static void main(String[] args) {
        SpringApplication.run(SolidApplication.class, args);


        //LISKOV - ANTES

        PagoBefore pagoTarjeta = new PagoConTarjetaBefore();
        pagoTarjeta.pagar();

        PagoBefore pago = new PagoGratisBefore();
        pago.pagar();

        //LISKOV - DESPUES
        PagoAfter pagoTarjetaa = new PagoConTarjetaAfter();
        pagoTarjetaa.pagar();

        PagoAfter pagoo = new PagoGratisAfter();
        pagoo.pagar();

        //INTERFACE SEGREGATION -ANTES

        //INTERFACE SEGREGATION -DESPUES
    }
}
