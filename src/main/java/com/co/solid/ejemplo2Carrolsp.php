
<?php
////aplicacion de carros////
//////////////////////sin aplicar liskov///////////////////

abstract class Carro {
    abstract public function encender();
    abstract public function acelerar();
    abstract public function frenar();
    abstract public function cargarBateria();

}

class CarroGasolina extends Carro {
    public function encender() {
        return "Motor de gasolina encendido";
    }

    public function acelerar() {
        return "Acelerando gasolina";
    }

    public function frenar() {
        return "Frenando";
    }
   
    public function cargarBateria() {
        throw new Exception("No aplica para gasolina");//// rompe con el principio liskov
    }
}

class CarroElectrico extends Carro {
    public function encender() {
        return "Sistema eléctrico activado";
    }

    public function acelerar() {
        return "Acelerando eléctrico";
    }

    public function frenar() {
        return "Frenando ";
    }
    public function cargarBateria() {
        return "Carro cargado exitosamente";
    }

   
}

//  Uso Polimórfico
function probarCarro(Carro $carro) {
    echo $carro->encender();
    echo $carro->acelerar();
    echo $carro->frenar();
    echo $carro->cargarBateria();
    
}

// Probamos ambos carros
probarCarro(new CarroGasolina());
probarCarro(new CarroElectrico());



///////////////////////////////////////con aplicando  liskov//////////////////////////////////////////
abstract class Carro {
    abstract public function encender();
    abstract public function acelerar();
    abstract public function frenar();

}

class CarroGasolina extends Carro {
    public function encender() {
        return "Motor de gasolina encendido";
    }

    public function acelerar() {
        return "Acelerando gasolina";
    }

    public function frenar() {
        return "Frenando";
    }
    public function tanquearGasolina() {
        return "Carro tanqueado exitosamente";
    }
}

class CarroElectrico extends Carro {
    public function encender() {
        return "Sistema eléctrico activado";
    }

    public function acelerar() {
        return "Acelerando eléctrico";
    }

    public function frenar() {
        return "Frenando ";
    }
    public function cargarBateria() {
        return "Carro cargado exitosamente";
    }
}

//  Uso Polimórfico
function probarCarro(Carro $carro) {
    echo $carro->encender();
    echo $carro->acelerar();
    echo $carro->frenar(); 
}

// Probamos ambos carros
probarCarro(new CarroGasolina());
probarCarro(new CarroElectrico());


