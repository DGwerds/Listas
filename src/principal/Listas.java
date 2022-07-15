package principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Santiago Andres Delgado 211799
 */
public class Listas {
    static Scanner input = new Scanner(System.in);
    static List<String> lista = new ArrayList<>();
    public static void main(String[] args) {
        System.out.print("Ingrese la cantidad de elementos: ");
        int cant = input.nextInt();
        input.nextLine();
        int i = 0;
        while (i < cant){
            String opciones = opciones();
            switch (opciones){
                case "a" -> {a_opciones(); i++;}

                case "b" -> {
                    if (lista.isEmpty()){
                        System.out.println("No hay elementos a eliminar. Elija otra opcion");
                        continue;
                    }
                    lista.remove(lista.indexOf(input.nextLine()));
                }
            }
            System.out.println(lista);
        }
    }
    
    public static String opciones(){
        System.out.println("""
                           a.Insertar Nodo
                           b.Eliminar Nodo
                           c.Buscar Nodo
                           d.Tamaño de la Lista
                           e.Comprobar Lista Vacia
                           f.Mostrar Lista
                           g.Vaciar Lista""");
        System.out.print("\nSeleccionar opcion: ");
        return input.nextLine();
    }
    
    public static void a_opciones(){
        System.out.println("""
                           a.Insertar Nodo al inicio
                           b.Insertar Nodo al final
                           c.Insertar Nodo antes del Elemento X
                           d.Insertar Nodo después del Elemento X""");
        System.out.print("\nSeleccionar opcion: ");
        String opcion = input.nextLine();
        int index = 0;
        switch (opcion) {
            case "b" -> index=lista.size();
            case "c" -> {
                System.out.print("Agregar valor antes del elemento: ");
                index = lista.indexOf(input.nextLine());
            }
            case "d" -> {
                System.out.print("Agregar valor despues del elemento: ");
                index = lista.indexOf(input.nextLine())+1;
            }
        }
        System.out.print("Ingrese el valor a agregar: ");
        String valor = input.nextLine();
        lista.add(index, valor);
        System.out.println("El valor " + valor + " agregado\n");
    }
}
