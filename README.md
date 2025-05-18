Este proyecto implementa un **Árbol AVL** (Adelson-Velsky y Landis) en Java, 
una estructura de datos auto-balanceada que mantiene un tiempo eficiente de búsqueda, inserción y eliminación.


 ## Contenido

- [`Nodo.java`](src/main/java/com/mycompany/sesion14/Nodo.java): Representa los nodos del árbol.
- [`ArbolAVL.java`](src/main/java/com/mycompany/sesion14/ArbolAVL.java): Contiene toda la lógica para inserción, búsqueda y balanceo del árbol.
- [`Sesion14.java`](src/main/java/com/mycompany/sesion14/Sesion14.java): Clase `main`, con menú de consola para interactuar con el árbol.

## Funciones principales:

insertar: puedes inserta un valor en el árbol y el programa lo balancea automáticamente.

buscar: Retorna el valor si existe o -1 si no se encuentra dentro del árbol.

mostrarArbol: Imprime el árbol en forma jerárquica.

rotarIzquierda, rotarDerecha: Corrige desequilibrios modificando la raices y alturas de las ramas.

actualizarAltura, getFactorBalance: Se usan para mantener el árbol balanceado.



## El menú interactivo permite:

• Insertar valores al árbol.

• Buscar valores.

• Visualizar el árbol en cada inserción.

• Salir escribiendo -1 o exit.
