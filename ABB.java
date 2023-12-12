public class ABB{
    private Nodo raiz;

    ABB(){
        this.raiz = null;
    } 

    public boolean esVacio(){
        return (this.raiz == null); 
    }

    public Nodo getRaiz(){
        return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }else{
            insertarNodo(valor, this.raiz);
        }
    }

    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato){
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }else{
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }else{
            if (valor > nodoRef.dato){
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }else{
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }
    
    //Imprime arbol horizontalmente
    public void arbolHorizontal(int nivel, Nodo nodoRef){
        if (nodoRef == null){
            return;
        }else{
            arbolHorizontal(nivel + 1, nodoRef.derecho);
            imprimirEspacios(nivel);
            System.out.println("[" + nodoRef.dato + "]");
            arbolHorizontal(nivel + 1, nodoRef.izquierdo);
        }
    }

    //Esto imprime los espacios segun la preferencia
    private void imprimirEspacios(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.print("    ");
        }
    }
    
    //Buscqueda de nodo
    public boolean busqueda(int x, Nodo nodoRef){
        if (nodoRef==null)
            return false;
        else if(x<nodoRef.dato)
            return busqueda(x,nodoRef.izquierdo);
        else if(x>nodoRef.dato)
            return busqueda(x,nodoRef.derecho);
        else 
            return true; 
    }

    //Realiza el recorrido en orden
    public void inOrden(Nodo nodoRef){
        if(nodoRef==null){
            return;
        }
        inOrden(nodoRef.izquierdo);
        System.out.print(nodoRef.dato + " - ");
        inOrden(nodoRef.derecho);
    }

    //Realiza el recorrido en preorden
    public void preOrden(Nodo nodoRef){
        if(nodoRef==null){
            return; 
        }
        System.out.print(nodoRef.dato + " - ");
        preOrden(nodoRef.izquierdo);
        preOrden(nodoRef.derecho);
    }

    //Realiza el recorrido en postorden
    public void postOrden(Nodo nodoRef){
        if(nodoRef==null){
            return; 
        }
        postOrden(nodoRef.izquierdo);
        postOrden(nodoRef.derecho);
        System.out.print(nodoRef.dato + " - ");
    }
    
    public void eliminarNodo(int valor) {
        this.raiz = eliminarNodoRecursivo(this.raiz, valor);
    }

    private Nodo eliminarNodoRecursivo(Nodo nodoRef, int valor){
        if (nodoRef == null) {
            //El nodo a eliminar no está en el árbol, no hacemos nada
            return null;
        }

        if (valor < nodoRef.dato){
            nodoRef.izquierdo = eliminarNodoRecursivo(nodoRef.izquierdo, valor);
        }else if(valor > nodoRef.dato){
            nodoRef.derecho = eliminarNodoRecursivo(nodoRef.derecho, valor);
        }else{
            //Nodo a eliminar es una hoja
            //Devolvemos null para indicar que este nodo se eliminará
            return null;
        }

        return nodoRef; 
    }
}
