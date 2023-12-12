import java.io.*;
import java.util.Scanner;
public class UsaABB{
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args){
        // Crear un objeto de la clase ABB
        ABB arbol = new ABB();
        //Nodo raizArbolPtr = arbol.getRaiz();

        //Insertar nodos en el arbol
        arbol.insertarValor(10);
        arbol.insertarValor(4);
        arbol.insertarValor(2);
        arbol.insertarValor(32);
        arbol.insertarValor(12);
        arbol.insertarValor(22);
        arbol.insertarValor(16);
        arbol.insertarValor(8);
        System.out.println(" ");
        
        // Mostrar el árbol horizontalmente
        System.out.println("Árbol Binario de Búsqueda:");
        arbol.arbolHorizontal(0, arbol.getRaiz());
        System.out.println(" ");
        
        //Buscar un valor en el árbol
        System.out.println("Ingrese el valor que desea buscar: ");
        int valorBuscado = teclado.nextInt();
        if(arbol.busqueda(valorBuscado, arbol.getRaiz())){
            System.out.println("El valor " + valorBuscado + " se encuentra en el árbol.");
        }
        else{
            System.out.println("El valor " + valorBuscado + " no se encuentra en el árbol.");
        }
        System.out.println(" ");
        
        //Realiza recorridos en orden, preorden y postorden
        System.out.println("Recorrido en orden:");
        arbol.inOrden(arbol.getRaiz());
        System.out.println(" ");
         
        System.out.println("Recorrido en preorden:");
        arbol.preOrden(arbol.getRaiz());
        System.out.println(" ");
        
        System.out.println("Recorrido en postorden:");
        arbol.postOrden(arbol.getRaiz());
        System.out.println(" ");
        
        //Eliminar un nodo del árbol
        //int valorAEliminar = 8;  //Puedes cambiar esto al valor que desees eliminar
        System.out.println(" ");
        System.out.println("Eliminando el nodo con valor: " + 8);
        arbol.eliminarNodo(8);
        System.out.println(" ");

        // Muestra el árbol después de la eliminación
        System.out.println("Árbol después de eliminar el nodo " + 8 + ":");
        System.out.println(" ");
        arbol.arbolHorizontal(0, arbol.getRaiz());
    }
}