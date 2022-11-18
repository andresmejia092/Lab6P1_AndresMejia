//Andres Mejia
package lab6p1_andresmejia;
import java.util.Scanner;
import java.security.SecureRandom;

public class Lab6P1_AndresMejia {
    static Scanner read=new Scanner(System.in);
    static SecureRandom random= new SecureRandom();
        
    public static void main(String[] args) {
        int opcion;
        
        do{
            System.out.println("Opcion 1: Turing");
            System.out.println("Opcion 2: Constante de Kaprekar");
            System.out.println("Ingrese la opcion: ");
            opcion=read.nextInt();
            
            switch(opcion){
                case 1:{
                    int size;
                    String inst;
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    size=read.nextInt();
                    System.out.println("");
                    
                    int [] arreglo;
                    arreglo=lectura(size);
                    print(arreglo);
                    
                    System.out.println("Ingrese las instrucciones: ");
                    inst=read.next().toUpperCase();
                    instrucciones(inst,arreglo);
                    break;
                }
                case 2:{
                    int numero;
                    System.out.println("Ingrese un numero entero de 4 digitos: ");
                    numero=read.nextInt();
                    while(numero<1000 || numero>9999){
                        System.out.println("El numero debe de ser de 4 digitos ");
                        System.out.println("Ingrese el numero otra vez: ");
                        numero=read.nextInt();
                    }
                    String numerostring =Integer.toString(numero);
                    char letra1=numerostring.charAt(0);
                    char letra2=numerostring.charAt(1);
                    char letra3=numerostring.charAt(2);
                    char letra4=numerostring.charAt(3);
                    
                    while(letra1==letra2 && letra1==letra3 && letra1==letra4 ){
                        System.out.println("Los 4 numeros deben ser diferentes");
                        System.out.println("Ingrese nuevamente el numero: ");
                        numero=read.nextInt();
                        while(numero<1000 || numero>9999){
                            System.out.println("Ingrese un numero de 4 digitos: ");
                            numero=read.nextInt();
                        }
                        numerostring =Integer.toString(numero);
                        letra1=numerostring.charAt(0);
                        letra2=numerostring.charAt(1);
                        letra3=numerostring.charAt(2);
                        letra4=numerostring.charAt(3);
                    }
                    int resta=0;
                    while(resta!=6174){
                        int verificado=Integer.parseInt(numerostring);

                        
                        resta=arraytoint(descendiente(arreglado(verificado)))-arraytoint(ascendiente(arreglado(verificado)));
                        numerostring = Integer.toString(resta);
                        
                        System.out.println(arraytoint(descendiente(arreglado(verificado)))+"-"+arraytoint(ascendiente(arreglado(verificado))));
                        System.out.println(resta);
                    }
                    
                    
                    
                    break;
                }
            } //Fin del switch
            
        }while(opcion!=3);
    } //Fin del main
    
    public static int [] lectura(int size){
        int [] temporal=new int [size];
        for(int i=0; i<size; i++){
            temporal[i]=random.nextInt(10);
        }
        return temporal;
    } //Fin de lectura
    
    public static void print(int [] array){
       
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");  
        }
        System.out.println("");
    } //Fin del print
    
    public static String instrucciones(String instrucciones, int[] array){
        String acumulador="";
        int apuntador=0;
        for(int i=0; i<instrucciones.length(); i++){
            char letra=instrucciones.charAt(i);
            if(letra=='R'){
                apuntador++;
            }
            if(letra=='X'&& apuntador>=0){
                acumulador=acumulador+array[apuntador];
            }
            if(letra=='L'){
                apuntador--;
            }
        }
        System.out.println(acumulador);
        if(apuntador<0 || apuntador>instrucciones.length()-1){
                System.out.println("No se puede salir del arreglo");
            }
        return acumulador;
    }//Fin instrucciones
    
    public static int [] arreglado(int verificado){
        String palabra=Integer.toString(verificado);
        int [] temporal=new int [palabra.length()];
        for (int i=0; i<palabra.length(); i++){
            char letra=palabra.charAt(i);
            int numero=Character.getNumericValue(letra);
            temporal[i]=numero;
        }
        return temporal;
    } //Fin arreglado
    
    public static int [] ascendiente(int [] arreglado){
        //Dos fors que recorren la palabra para ver cada numero
        for(int i=0; i<arreglado.length; i++){
            for(int j=i; j<arreglado.length; j++){
                // Este va a verificar si el numero original es mayor al siguiente
                if(arreglado[i]>arreglado[j]){
                    //Si es mayor entonces va a swap
                    int swap=arreglado[i];
                    arreglado[i]=arreglado[j];
                    arreglado[j]=swap;
                } 
            }
        }
        return arreglado;
    } //Fin ascendiente
    
    public static int [] descendiente(int [] arreglado){
        for(int i=0; i<arreglado.length; i++){
            for(int j=i; j<arreglado.length; j++){
                // Este va a verificar si el numero original es mayor al siguiente
                if(arreglado[i]<arreglado[j]){
                    //Si es mayor entonces va a swap
                    int swap=arreglado[i];
                    arreglado[i]=arreglado[j];
                    arreglado[j]=swap;
                } 
            }
        }
        return arreglado;
    } //Fin descendiente
    public static int arraytoint(int [] array){
        int suma=0;
        suma=array[0]*1000+array[1]*100+array[2]*10+array[3];
        
        return suma;
    }
    
}
