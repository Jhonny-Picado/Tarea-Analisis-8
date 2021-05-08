/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenasmarkov;

/**
 *
 * @author Jhonny Picado Vega
 */
public class Pensamiento {
    
    public Pensamiento(){
        
    }
    
    //Algoritmo de la cadena de pensamiento, recibe la cantidad de pensamientos 
    public void cadenaPensamiento(int cantidadPensamientos){
        
        //Variables string a utilizar
        String estadoActual = "Quedarse";
        System.out.print(estadoActual+", ");
        String siguienteEstado = "";
        
        //Itera sobre todos los pensamientos
        for(int i=0; i<cantidadPensamientos; i++){
            
            int tmp = (int)(Math.random()*100+1);   //Genera un numero entre 1 y 100
            
            //Realiza un switch para verificar el estado actual de la persona
            //en cada caso llama a una función auxiliar para cambiar estado
            switch (estadoActual) {
                case "Quedarse":
                    siguienteEstado = validacionQuedarse(tmp);
                    break;
                case "Aburrido":
                    siguienteEstado = validacionAburrido(tmp);
                    break;
                case "OtrasCosas":
                    siguienteEstado = validacionOtrasCosas(tmp);
                    break;
                case "Irse":
                    siguienteEstado = validacionIrse(tmp);
                default:
                    break;
            }
            
            //Acomoda el estado actual y lo despliega
            estadoActual = siguienteEstado;
            System.out.print(estadoActual+", ");
        } 
    }
    
    //Funcion auxiliar para validar los caminos de "quedarse"
    private String validacionQuedarse(int tmp) {
        
        //si random va de 1 a 45 (45%) se mantiene en quedarse
        if( tmp <46)
            return "Quedarse";
        
        //Si va de 46 a 76 (30%) entonces pasa a aburrido
        else if (tmp <76)
            return "Aburrido";
        
        //Sino entonces es un (25%) se pasa a otras cosas
        else
            return "OtrasCosas";
        
    }
    
    //Funcion auxiliar para validar los caminos de "aburrido"
    private String validacionAburrido(int tmp) {
        
        //de 1 a 21 (20%) se mantiene en aburrido
        if(tmp < 21 )
            return "Aburrido";
        
        //de 21 a 35 (15%), decide quedarse
        else if(tmp < 36)
            return "Quedarse";
        
        //de 36 en adelante (65%) decide irse
        else
            return "Irse";
    }

    //Funcion auxiliar para validar los caminos de "irse"
    private String validacionIrse(int tmp) {
        
        //Si va de 0 a 96, se mantiene en irse
        if(tmp<97)
            return "Irse";
        
        //Sino, entonces cambia de opinion a quedarse
        else
            return "Quedarse";
    }

    //Funcion auxiliar para validar los caminos de "OtrasCosas"
    private String validacionOtrasCosas(int tmp) {
        
        //de 1 a 35 (35%) decide seguir pensando en otras cosas
        if(tmp<36)
            return "OtrasCosas";
        
        //de 36 a 51 (15%) decide quedarse
        else if(tmp < 51)
            return "Quedarse";
        
        //Sino un (50%) decide irse
        else 
            return "Irse";
    }
}
