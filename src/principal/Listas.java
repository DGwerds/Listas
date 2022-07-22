package principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Santiago Andres Delgado 2211799
 */
public class Listas {
    static Scanner input = new Scanner(System.in);
    static List<String> lista = new ArrayList<>();
    static int cant = 0;
    
    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de nodos: ");
        boolean error;
        do {
            try{
                error = false;
                cant = input.nextInt();
            }
            catch(java.util.InputMismatchException e){
                System.out.print("Porfavor ingresa un numero: "); 
                error = true;
            }
            input.nextLine();
        } while (error);
        Random random = new Random();
        for(int i = 0; i < cant; i++){
            lista.add(Integer.toString(random.nextInt(cant+1)));
        }
        mostrarLista();
        boolean loop = true;
        while (loop){
            String opciones = opciones();
            switch (opciones){
                case "a" -> {opciones_insertar(); cant--;}
                case "b" -> {if(eliminar()){cant++;}}
                case "c" -> buscar();
                case "d" -> tamanio();
                case "e" -> comprobar();
                case "f" -> mostrarLista();
                case "g" -> {if(vaciar()){cant=0;}}
                case "h" -> loop = false;
                default -> System.out.println("Opcion no disponible");
            }
        }
    }
    
    public static String opciones(){
        System.out.print("\na.Insertar Nodo");
        if (cant == 0){
            System.out.print(" (No disponible)");
        }
        System.out.println("""
                           \nb.Eliminar Nodo
                           c.Buscar Nodo
                           d.Tamanio de la Lista
                           e.Comprobar Lista Vacia
                           f.Mostrar Lista
                           g.Vaciar Lista
                           h.Salir""");
        System.out.print("\nSeleccionar opcion: ");
        
        String in = input.nextLine().toLowerCase();
        if (cant == 0 && in.equals("a")){
            return "_";
        }
        return in;
    }
    
    public static void opciones_insertar(){
        boolean lista_vacia = lista.isEmpty();
        String opcion = "";
        String elemento = "";
        int index = 0;
        System.out.println("""
                           a.Insertar Nodo al inicio
                           b.Insertar Nodo al final""");
        if (!lista_vacia){
            System.out.println("""
                               c.Insertar Nodo antes del Elemento X
                               d.Insertar Nodo despues del Elemento X""");
        }
        while (opcion.isEmpty()){            
            System.out.print("\nSeleccionar opcion: ");
            opcion = input.nextLine().toLowerCase();
        
            if (lista_vacia && (!opcion.equals("a") && !opcion.equals("b"))){
                opcion = "";
            }
            switch (opcion) {
                case "a" -> index = 0;
                case "b" -> index = lista.size();
                case "c" -> {
                    System.out.print("Agregar valor antes del elemento: ");
                    elemento = input.nextLine();
                    index = lista.indexOf(elemento);
                }
                case "d" -> {
                    System.out.print("Agregar valor despues del elemento: ");
                    elemento = input.nextLine();
                    index = lista.indexOf(elemento)+1;
                }
                default -> System.out.println("Opcion no disponible");

            }
        }
            System.out.print("Ingrese el valor a agregar: ");
            String valor = input.nextLine();
        try{
            lista.add(index, valor);
            System.out.println("El valor " + valor + " agregado");
        }
        catch (IndexOutOfBoundsException e){
            elemento_no_encontrado(elemento);
        }
    }
    
    public static boolean eliminar(){
        if (lista.isEmpty()){
            System.out.println("No hay nodos a eliminar");
            return false;
        }
        System.out.print("Ingresar elemento a eliminar: ");
        String elemento = input.nextLine();
        try{
            lista.remove(lista.indexOf(elemento));
            System.out.println("Valor: " + elemento + " eliminado");
        } catch (IndexOutOfBoundsException e){
            elemento_no_encontrado(elemento);
        }
        return true;
    }
    
    public static boolean buscar(){
        if (lista.isEmpty()){
            System.out.println("No hay nodos a buscar");
            return false;
        }
        System.out.print("Ingresar elemento a buscar: ");
        String valor = input.nextLine();
        int index = lista.indexOf(valor);
        if (index == -1){
            elemento_no_encontrado(valor);
        }else{
            System.out.println(valor + " encontrado en la posicion: " + index);
        }
        return true;
    }
    
    public static void tamanio(){
        if (lista.isEmpty()){
            System.out.println("La lista esta vacia");
        } else{
            System.out.println("Tamaño de la lista es: " + lista.size());
        }
    }
    
    public static void comprobar(){
        if (lista.isEmpty()){
            System.out.println("La lista esta vacia");
        } else{
            System.out.println("La lista NO esta vacia");
        }
    }
    
    public static void mostrarLista(){
        System.out.println("Contenido de la lista: " + lista);
    }
    
    public static boolean vaciar(){
        lista.clear();
        System.out.println("Contenido de la lista eliminado");
        return true;
    }
    
    private static void elemento_no_encontrado(Object valor){
        if (lista.isEmpty()){
                System.out.println("La lista esta vacia");
        }
        System.out.println("No se encontro el elemento: " + 
                valor + " en la lista\n");
    }
}
