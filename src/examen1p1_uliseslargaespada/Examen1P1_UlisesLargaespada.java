/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_uliseslargaespada;

import java.util.Scanner;

/**
 *
 * @author ularg
 */
public class Examen1P1_UlisesLargaespada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Llamar unicamente el menu
        mainMenu();
    }
    
    // Metodo para el menu inicial
    public static void mainMenu() {
        System.out.println("-- Bienvenido al examen I del laboratorio --");
        
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Iniciar menu repetitivo
        do {
            System.out.println("Elija una de las siguientes oppciones");
            System.out.println("1 - Conjuntos");
            System.out.println("2 - Cifrado por substitucion");
            System.out.println("3 - Sobre");
            System.out.println("4 - Salir");
            
            int option = entry.nextInt();
            
            switch (option) {
                case 1 -> conjuntos();
                
                case 2 -> cifradoSubstitucion();
                
                case 3 -> sobreFigura();
                
                case 4 -> System.out.println("Gracias por usar el programa, feliz dia!");
                
                default -> System.out.println("Elija una opcion de las anteriores");
            }
            
            // Salir del programa 
            if (option == 4) {
                break;
            }
        } while(true);
    }
    
    // Metodo para la funcion conjuntos
    public static void conjuntos() {
        System.out.println("-- Bienvenido al ejercicio de conjuntos --");
        System.out.println("En este ejercicio nos debera de ingresar dos conjuntos y evaluaremos si: ");
        System.out.println("a) Son iguales o no");
        System.out.println("b) Su Union");
        System.out.println("c) Su Interseccion");
        
        // Solicitar que ingresen los conjuntos
        System.out.println("Porfavor ingrese el primer conjunto de la forma: A = {a, b, c, ...}");
        char letraConjunto1 = 'A';
        String A = solicitudValidarConjunto(letraConjunto1);
        
        System.out.println("Porfavor ingrese el segundo conjunto de la forma: B = {a, b, c, ...}");
        char letraConjunto2 = 'B';
        String B = solicitudValidarConjunto(letraConjunto2);
        
        // Llamar conjunto final para transformar los conjuntos a un array
        boolean sonIguales = compararConjuntos(A, B);
        
        if (sonIguales) {
            System.out.println("Ambos conjuntos son iguales");
        } else {
            System.out.println("Ambos conjuntos no son iguales");
            
            // Llamar metodo para unir e interseccionar
            unionInterseccion(A, B);
        }
        
        System.out.println();
    }
    
    // Metodo para validar la entrada de conjuntos
    public static String solicitudValidarConjunto(char letraConjunto) {
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Bolean para ver si la entrada esta correcta
        boolean check = true;
        
        // Variable para ingresar el string
        String conjunto = "";
        
        // chars a utilizar para validar
        char igual = '=';
        char llave1 = '{';
        char llave2 = '}';
        char espacio = ' ';
        
        while(check) {
            conjunto = entry.nextLine();
            
            // Char del momento 
            char letra1 = conjunto.charAt(0);
            check = letraConjunto != letra1; 
            
            if (conjunto.length() < 7){
                check = true;
            }
            if ((conjunto.length() > 3) && (check == false)) {
                // Char del momento para validar el igual
                char letra2 = conjunto.charAt(2);
                check = letra2 != igual;
                
                // Validar espacio entre conjunto e igual
                for(int i = 1; i < 4; i = i + 2) {
                    // Char del momento 
                    char espacio1 = conjunto.charAt(i);
                
                    check = espacio1 != espacio;
                }
            } 
            
            if ((conjunto.length() > 7) && (check == false)) {
                // Char del momento para validar la primera llave
                char letra3 = conjunto.charAt(4);
                check = letra3 != llave1;                
                
                // Validar espacio entre letras
                for(int i = 7; i < conjunto.length()-1; i = i + 3) {
                    // Char del momento 
                    char letraMomento = conjunto.charAt(i);
                
                    check = letraMomento != espacio;
                }
            }
            
            // Validar las ultimas dos casillas
            // Char del momento para validar que antes de la llave halla letra
            char letra4 = conjunto.charAt(conjunto.length()-2);

            // Char del momento para validar la ultima llave
            char letra5 = conjunto.charAt(conjunto.length()-1);
            
            if(!((Character.isLetter(letra4)) && (letra5 == llave2))) {
                check = true;
            }
            
            // Validar luego de ver si todo sigue valido o no
            if (check == true) {
                System.out.println("Formato Incorrecto, ingrese de nuevo");
            }
        }
        
        return conjunto;
    }
    
    // Metodo para compara si son iguales los conjuntos
    public static boolean compararConjuntos(String conjunto1, String conjunto2) {
        // Boolean de los conjuntos
        boolean check = true;
        
        for(int i = 5; i < conjunto1.length() - 1; i = i + 3) {
            // Letra del momento
            char letra1 = conjunto1.charAt(i);
            if (!conjunto2.contains(Character.toString(letra1))) {
                check = false;
            }   
        }
        
        for(int i = 5; i < conjunto2.length() - 1; i = i + 3) {
            // Letra del momento
            char letra2 = conjunto2.charAt(i);
            if (!conjunto1.contains(Character.toString(letra2))) {
                check = false;
            }   
        }
                
        return check;
    }
    
    // Metodo para realizar union e interseccion de conjuntos
    public static void unionInterseccion(String conjunto1, String conjunto2) {
       String conjuntosUnion = "C = {";
       String conjuntosInterseccion = "D = {";
       
       String letrasIguales = "";
       
       // Crear la union
       for(int i = 5; i < conjunto1.length() - 1; i = i + 3) {
           char letra1 = conjunto1.charAt(i);
           conjuntosUnion += letra1;
           conjuntosUnion += ", ";          
       }
       
       for(int j = 5; j < conjunto2.length(); j += 1){
           char letra2 = conjunto2.charAt(j);
           conjuntosUnion += letra2;
       }
       
       // Crear la interseccion
       for(int z = 5; z < conjunto1.length(); z = z + 3) {
           char letra3 = conjunto1.charAt(z);
           String letra3String = Character.toString(letra3);
           
           // Comparar esa letra a ver si esta repetida
           if(conjunto1.contains(letra3String) && conjunto2.contains(letra3String)) {
               letrasIguales += letra3;
           }
       }
       
       // Anidar letras iguales a la string de solucion
       if (letrasIguales.length() > 1) {
            for(int n = 0; n < letrasIguales.length() - 1; n++) {
                char letraIgual = letrasIguales.charAt(n);
                conjuntosInterseccion += letraIgual;
                conjuntosInterseccion += ", ";
            }
            
            char letraIgualU1 = letrasIguales.charAt(letrasIguales.length() - 1);
            conjuntosInterseccion += letraIgualU1;
       } else {
           char letraIgualU2 = letrasIguales.charAt(0);
           conjuntosInterseccion += letraIgualU2;
       }
       
       
       // Agregar final
       conjuntosInterseccion += "}";
       
       System.out.println("Union: " + conjuntosUnion);
       System.out.println("Interseccion: " + conjuntosInterseccion);
    } 
    
    // Metodo para el ejercicio de cifrado 
    public static void cifradoSubstitucion() {
        System.out.println("-- Bienvenido al ejercicio de cifrado por substitucion --");
        System.out.println("-- En este ejercicio transformaremos una palabra para hacerla cifrada --");
        
        System.out.print("Por favor, ingrese una cadena para substituirla: ");
        
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
        
        // Guardar variable solicitada
        String palabra = entry.next();
        
        String palabraCifrada = cifrarLaPalabra(palabra);
        
        // Entregar resultado al usuario
        System.out.println("La cadena cifrada es: " + palabraCifrada);
        
        System.out.println();
    }
    
    // Metodo para realizar el cifrado
    public static String cifrarLaPalabra(String palabra) {
        String palabraCifrada = "";
        
        for(int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            
            // Check si es upper case y hacerla lowercase
            if(Character.isUpperCase(letra)) {
                letra = Character.toLowerCase(letra);
            }
            
            int letraAscii = letra;
            
            // Transformar letra formula
            int temp = 122 - letraAscii;
            int valorTransformado = temp + 97;
            
            char letraFinal = (char) valorTransformado;
            
            // Almacenar valores en palabta final
            palabraCifrada += letraFinal;
        }
        
        return palabraCifrada; 
    }
    
    // Metodo para imprimir la figura
    public static void sobreFigura(){
        // Initialize scanner
        Scanner entry = new Scanner(System.in);
            
        System.out.println("-- Bienvenido al ejercicio del sobre --");
        System.out.println("En este ejercicio realizaremos un sobre con el caracter que usted elija y su cantidad");
        System.out.print("Elija la altura (numero entero y par): ");
        
        int numero = validarNumero();
        
        System.out.print("Ingrese el contorno: ");
        String contorno = entry.next();
        
        construirContorno(numero, contorno);
    }
    
    // Validar numero par y entero
    public static int validarNumero() {
        boolean check = true;
        
        int numero = 0;
        
        while(check) {
            // Initialize scanner
            Scanner entry = new Scanner(System.in);

            numero = entry.nextInt();   
            
            if((numero > 0) && (numero%2 == 0)) {
                break;
            }
            System.out.println("Numero incorrecto, ingrese de nuevo");
        }        
        
        return numero;
    }
    
    public static void construirContorno(int n, String contorno) {
        int size  = n*2;
    
        for(int i = size; i >= 0; i--) {
            // Base y final 
            if (i == size || i == 0) {
                for (int j = 0; j <= size; j++) {
                    System.out.print(contorno + " ");
                }  
            } 
            // Contorno
            else {
                for (int j = 1; j <= size*2; j++) {
                    if (j == 1 || j == size*2) {
                        System.out.print(contorno + " ");
                    } else {
                       System.out.print(" "); 
                    }
                }    
            }
            
            System.out.println();
        }
    }
}
