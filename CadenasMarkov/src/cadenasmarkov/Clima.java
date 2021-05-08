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
public class Clima {
    
    public Clima(){
        
    }
    
    
    //Función que simula la cadena del clima, recibe la cantidad de dias a calcular
    public void CadenaClima(int dias){
        
        //Variables que guardan el siguiente estado y arreglo de estados
        String siguienteEstado="";
        String estados[] = {"Soleado", "Lluvioso", "Ventoso", "Tormenta"};
        
        int indexEstado = (int)(Math.random()*4);   //Random para el primer estado
        String estadoActual = estados[indexEstado]; //Se inicializa con el random
        System.out.println(estadoActual); //Despliega el primer estado
        
        //Itera sobra la cantidad de dias
        for(int i=0; i<dias; i++){
            
            int tmp = (int)(Math.random()*100+1);   //Genera un numero entre 1 y 100
            
            //Switch donde pregunto por el estado actual, en cada caso llama a una funcion auxiliar
            //para que coloquen el siguiente estado
            if(null != estadoActual)switch (estadoActual) {
                case "Soleado":
                    siguienteEstado = validacionesSoleado(tmp);
                    break;
                case "Lluvioso":
                    siguienteEstado = validacionesLluvioso(tmp);
                    break;
                case "Ventoso":
                    siguienteEstado = validacionesVentoso(tmp);
                    break;
                case "Tormenta":
                    siguienteEstado = validacionesTormenta(tmp);
                    break;
                default:
                    break;
            }
            estadoActual= siguienteEstado;  //Se cambia de estado
            System.out.println(estadoActual);   //Despliega el estado
        }
    }
    
    
    //Funcion auxiliar para el clima soleado, recibe el random
    private String validacionesSoleado(int tmp){

        //Si esta entre 1 y 85, se mantiene el estado
        if (tmp < 86)
            return "Soleado";
        
        //Entre 86 y 95 (10%) cambia a ventoso
        else if (tmp < 96)
            return "Ventoso";
        
        //Mayor a 95, 5% cambia a lluvioso
        else 
            return "Lluvioso";
    }
    
    //Funcion auxiliar para el clima lluvioso, recibe el random
    private String validacionesLluvioso(int tmp){
    
        //Entre 1 y 70 (70%), sigue lluvioso
        if (tmp < 71)
            return "Lluvioso"; 
        
        //entre 71 y 90 (20%) cambia a tormenta
        else if (tmp < 91) 
            return "Tormenta";
        
        //mayor a eso (10%) cambia a soleado
        else
            return "Soleado";
    }
    
    //Funcion auxiliar para el clima ventoso, recibe el random
    private String validacionesVentoso(int tmp){
        
        //entre 1 y 15 (15%) se mantiene en ventoso
        if (tmp < 16)
            return "Ventoso"; 
        
        //de 16 a 65 (50%) cambia a soleado
        else if (tmp < 66) 
            return "Soleado";
        
        //de 66 a 75 (10%) cambia a tormenta
        else if (tmp < 76) 
            return "Tormenta";
        
        //Si es mayor (25%) cambia a lluvioso
        else 
            return "Lluvioso";
    }
    
    //Funcion auxiliar para el clima tormenta, recibe el random
    private String validacionesTormenta(int tmp){
        
        //1 y 5 (5%) mantiene tormenta
        if (tmp < 6)    
            return "Tormenta"; 
        
        //de 6 a 15 (10%) cambia a ventoso
        else if (tmp < 16) 
            return "Ventoso";
        
        //de 16 a 75 (60%) cambia a lluvioso
        else if (tmp < 76) 
            return "Lluvioso";
        
        //Sino 25% y se pone soleado
        else 
            return "Soleado";
         
     }
}
