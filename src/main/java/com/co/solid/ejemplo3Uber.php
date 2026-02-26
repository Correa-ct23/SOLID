<?php
///aplicacion Uber
///////////////////////////sin aplicar liskov////////////////////////////////////////////
abstract class Vehiculo {
    abstract public function aceptarViaje();
    abstract public function iniciarViaje();
    abstract public function finalizarViaje();
    abstract public function transportar4Pasajeros();
}

// Implementación incorrecta
class UberMoto extends Vehiculo {

    public function aceptarViaje() {
        return "UberMoto aceptó viaje";
    }
    public function iniciarViaje() {
        return "UberMoto inicio viaje";
    }
    public function finalizarViaje() {
        return "UberMoto finalizo viaje";
    }

    public function transportar4Pasajeros() {
        throw new Exception("La moto no puede transportar 4 pasajeros");
    }
}
class UberCarro extends Vehiculo {

    public function aceptarViaje() {
        return "UberCarro aceptó viaje";
    }
    public function iniciarViaje() {
        return "UberCarro inicio viaje";
    }
    public function finalizarViaje() {
        return "UberCarro finalizo viaje";
    }
    public function transportar4Pasajeros() {
        return "recojida de pasajeros exitosa";
    }
}
//Ahora si el sistema hace:
function iniciarServicio(Vehiculo $vehiculo) {
    $vehiculo->transportar4Pasajeros();
}

//Si pasamos:

iniciarServicio(new UberMoto());
iniciarServicio(new UberCarro());

//Excepción.


//////////////////////////////////////con  aplicacion liskov///////////////////////////////////////////////////
abstract class Vehiculo {
    abstract public function aceptarViaje();
    abstract public function iniciarViaje();
    abstract public function finalizarViaje();
}

class UberCarro extends Vehiculo {
    public function aceptarViaje() { return "UberX aceptó viaje\n"; }
    public function iniciarViaje() { return "UberX inició viaje\n"; }
    public function finalizarViaje() { return "UberX finalizó viaje\n"; }
    public function transportar4Pasajeros() { return "recojida de pasajeros exitosa";}
}

class UberMoto extends Vehiculo {
    public function aceptarViaje() { return "UberMoto aceptó viaje\n"; }
    public function iniciarViaje() { return "UberMoto inició viaje\n"; }
    public function finalizarViaje() { return "UberMoto finalizó viaje\n"; }
    public function transportar1Pasajeros() { return "recojida de pasajero exitosa";}
    
}

// Uso Polimórfico
function procesarViaje(Vehiculo $vehiculo) {
    echo $vehiculo->aceptarViaje();
    echo $vehiculo->iniciarViaje();
    echo $vehiculo->finalizarViaje();
}

// Funciona con cualquiera
procesarViaje(new UberX());
procesarViaje(new UberMoto());



