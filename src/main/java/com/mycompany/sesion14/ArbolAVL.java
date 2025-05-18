/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sesion14;

/**
 *
 * @author subkel
 */
public class ArbolAVL {

    private Nodo raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertar(int valor) {
        this.setRaiz(insertar(valor, raiz));
        // imprimir el arbol actualizado, despues de la insercion
        System.out.println("----------------------------------------------------------\n");
        mostrarArbol();
        System.out.println("----------------------------------------------------------\n");
    }

    public Nodo insertar(int valor, Nodo nodo) {
        // Si el nodo donde se va a insertar es null, se debe crear y retornar un nuevo nodo
        if (nodo == null) {
            Nodo nuevoNodo = new Nodo(valor);
            return nuevoNodo;
        }

       // verificar si es mahor o menor 
        if (valor < nodo.getValor()) {
            /* 
                Se debe insertar en el hijo izquierdo, de manera recursiva
                El hijo izquierdo se actualiza con la inserción
             */
            nodo.setIzquierdo(insertar(valor, nodo.getIzquierdo()));
        } else if (valor > nodo.getValor()) {
             
                //Se debe insertar en el hijo derecho, de manera recursiva
     
            nodo.setDerecho(insertar(valor, nodo.getDerecho()));
        } else {
            /*
                Si el valor no es menor ni mayor, significa que es un valor igual al valor actual
                Solamente se retorna el mismo nodo
             */
            return nodo;
        }

        // Actualizar altura del nodo
        actualizarAltura(nodo);

        // Retornar el nodo actualizado
        return aplicarRotacion(nodo);
    }

    // Obtiene la altura de un nodo
    public int getAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    // Obtiene el factor de balance de un nodo
    public int getFactorBalance(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        // Retorna la diferencia de alturas (altura rama izquierda - altura rama derecha)
        return getAltura(nodo.getIzquierdo()) - getAltura(nodo.getDerecho());
    }

    // Actualizar la altura, para las inserciones
    public void actualizarAltura(Nodo nodo) {
        // Se calcula cual rama del nodo tiene la altura mayor
        int maximo = Math.max(getAltura(nodo.getIzquierdo()),
                getAltura(nodo.getDerecho()));

        // Se actualiza la altura. Se suma 1 
        nodo.setAltura(maximo + 1);
    }

    // Verifica el factor de balance y dependiendo del resultado, aplica la rotacion o rotaciones adecuadas
    public Nodo aplicarRotacion(Nodo nodo) {
        int balance = getFactorBalance(nodo);

        // Evaluar los casos de balance
        // Si la rama izquierda es más grande que la rama derecha
        if (balance > 1) {
            // rotacion doble (t)
            
            if (getFactorBalance(nodo.getIzquierdo()) < 0) {
                nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            }
            // rotacion simple
            return rotarDerecha(nodo);
        }

        // Si la rama izquierda es más pequeña que la rama derecha
        if (balance < -1) {
            // rotacion doble (t1)
            
            if (getFactorBalance(nodo.getDerecho()) > 0) {
                nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            }
            // rotacion simple
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public Nodo rotarDerecha(Nodo nodo) {
        Nodo raizNueva = nodo.getIzquierdo();
        Nodo derechoNuevo = nodo;
        Nodo izquierdoAux = raizNueva.getDerecho();
        raizNueva.setDerecho(derechoNuevo);
        derechoNuevo.setIzquierdo(izquierdoAux);
        
        // Actualizar alturas de la raiz anterior y la raiz nueva
        actualizarAltura(derechoNuevo);
        actualizarAltura(raizNueva);
        
        // Retornar la nueva raiz
        return raizNueva;
    }

    public Nodo rotarIzquierda(Nodo nodo) {
        Nodo raizNueva = nodo.getDerecho();
        Nodo izquierdoNuevo = nodo;
        Nodo derechoAux = raizNueva.getIzquierdo();
        raizNueva.setIzquierdo(izquierdoNuevo);
        izquierdoNuevo.setDerecho(derechoAux);

        // Actualizar alturas de la raiz anterior y la raiz nueva
        actualizarAltura(izquierdoNuevo);
        actualizarAltura(raizNueva);

        // Retornar la raiz nueva
        return raizNueva;
    }
    
    // Impresion del arbol
    public void mostrarArbol() {
        printTree(raiz);
    }
    
    public void printTree(Nodo nodo) {     
        imprimir(nodo, 0);
    }
    
    public void imprimir(Nodo nodo, int nivel) {
        if (nodo == null) {
            return;
        }
        // Imprime recursivamente la rama derecha del nodo actual
        imprimir(nodo.getDerecho(), nivel + 1);
        
        // Imprime los espacios en blanco
        for (int i = 0; i < 4*nivel; i++) {
            System.out.print(" ");            
        }
        // Imprime el valor del nodo actual
        System.out.println(nodo.getValor());
        
        // Imprime recursivamente la rama izquierda del nodo actual
        imprimir(nodo.getIzquierdo(), nivel + 1);
    }
    
    // Extra: Busqueda de un elemento
    public int buscar(int valor) {
        return buscar(valor, raiz);
    }
    
    public int buscar(int valor, Nodo nodo){
        // Si el nodo actual es nulo, se retorna un valor de -1
        if (nodo == null) {
            return -1;
        }
        
        if (valor == nodo.getValor()) {
            // Se evalua si el valor buscado se encuentra en el nodo actual. Si es asi, se retorna el
            // valor del nodo actual
            return nodo.getValor();
        } else if (valor < nodo.getValor()) {
            // Si el valor buscado es menor al valor del nodo actual, se busca en la rama izquierda del
            // nodo actual
            return buscar(valor, nodo.getIzquierdo());
        } else if (valor > nodo.getValor()) {
            // Si el valor buscado es mayor al valor del nodo actual, se busca en la rama derecha del
            // nodo actual
            return buscar(valor, nodo.getDerecho());
        }
        
        // Si no se encontró el valor buscado, se retorna un valor de -1
        return -1;
    }
}
