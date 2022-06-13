<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Guía de Práctica de Laboratorio</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />
</div>

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Sort y Listas Enlazadas</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>04</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>06-Jun-2022</td><td>FECHA FIN:</td><td>10-Jun-2022</td><td>DURACIÓN:</td><td>02 horas</td>
</tr>
<tr><td colspan="6">INTEGRANTES:
    <ul>
        <li>Durand Obando, Eduardo Franshua</li>
        <li>Galvez Quilla, Henry Isaias</li>
        <li>Alvarez Astete, Kevin Jheeremy</li>
        <li>Centeno Quispe, Marco Edmundo E.</li>
    </ul>
</td>
</<tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tdbody>
</table>

# Sort y Listas Enlazadas

[![License][license]][license-file]
[![Downloads][downloads]][releases]
[![Last Commit][last-commit]][releases]

[![Debian][Debian]][debian-site]
[![Git][Git]][git-site]
[![GitHub][GitHub]][github-site]
[![Vim][Vim]][vim-site]
[![Java][Java]][java-site]

#

## OBJETIVOS TEMAS Y COMPETENCIAS

### OBJETIVOS

- Estudiar el algoritmo de ordenamiento por inserción.
- Utilizar Listas Enlazadas para guardar los datos y ejecutar el algoritmo de ordenamiento.

### TEMAS
-   Algoritmo de ordenamiento por inserción iterativo.
-   Peor caso del algoritmo por inserción iterativo.
-   GNU Plot - Java Plot

<details>
<summary>COMPETENCIAS</summary>

- C.m. Construye responsablemente soluciones haciendo uso de estructuras de datos y algoritmos, siguiendo un proceso adecuado para resolver problemas computacionales que se ajustan al uso de los recursos disponibles y a especificaciones concretas.

</details>

## CONTENIDO DE LA GUÍA


## EJERCICIOS PROPUESTOS

1.  Utilizar el tipo generico de Lista Enlazada para generar los peores casos y ejecutar el algoritmo de ordenamiento..

    -   List - Method get()
        ```sh
        public Node<T> get(int indice) {
            Node<T> aux=raiz;
            for(int i=0;i<indice;i++)
                aux=aux.getNextNode();
            return aux;
        }
        ```
    -   List - Method remove()
        ```sh
        public void remove(int indice) {
            if(indice<tamano) {
                if(indice==0)
                    raiz=raiz.getNextNode();
                else {
                    Node<T> anterior=this.get(indice-1);
                    anterior.setNextNode(this.get(indice+1));
                }
                tamano--;
            }
        }
        ```
    ### **DESARROLLO**
        Este ejercicio se encuentra dentro de la la carpeta "Ejercicio01" dentro encontramos 3 archivos:
        - Node: La clase de cada elemento de nuestra lista enlazada.
        - LinkedList: La clase de nuestra lista enlazada.
        - Test: Aquí se prueba el ejercicio.

        Dentro de Test está el método generarPeorCaso(int t), que como su nombre menciona tiene el objetivo de crearnos el peor caso de ordenamiento, para este caso de números enteros.

        El peor caso es aquel que está en orden inverso al que se busca:
        - Ordenado: 1 - 2 - 3 - 4
        - Peor Caso: 4 - 3 - 2 - 1
        
        Después hicimos el método de insertSort donde basicamente seguimos el pseudocodigo pero adaptandolo a las listas enlazadas donde utilizamos un key que nos serviras de variable auxiliar.
        Lo que hacemos es recorrer entre nodos y comparandolos siempre que estos no sean nulos intercambiamos valor con el key si es que el otro valor es mayor.
        
        Despues implementamos la funcion de nanotime para calcular el tiempo de ejecucion del algoritmo para una lista enlazada de n elementos
        
        En el test.java usamos el gnu plot para visualizar el tiempo utilizado para el ordenamiento en el peor caso
        
    #
    <img src="https://github.com/Eduard1610/EDA_Lab04/blob/main/gnuplot.jpg?raw=true" alt="Ejer01" style="width:100%; margin: auto; display: block;"/>
2.  Utilizar el tipo generico de Doble Lista Enlazada para generar los peores casos y ejecutar el algoritmo de ordenamiento.
    ```sh
    public class Node <E > {
        Node () {
            this . data = null ;
            this . nextNode = null ;
            this . previousNode = null ;
        }

        Node ( E data ) {
            this . data = data ;
            this . nextNode = null ;
            this . previousNode = null ;
        }

        Node ( E data , Node <E > nextNode ) {
            this . data = data ;
            this . nextNode = nextNode ;
            this . previousNode = null ;
        }

        Node ( E data , Node <E > nextNode , Node <E > previousNode ) {
            this . data = data ;
            this . nextNode = nextNode ;
            this . previousNode = previousNode ;
        }

        private E data ;
        private Node <E > nextNode ;
        private Node <E > previousNode ;

        /* Getters y Setter ... */
    }
    ```

    ### **DESARROLLO**
        Este ejercicio se encuentra dentro de la la carpeta "Ejercicio02" dentro encontramos 3 archivos:
        - Node: La clase de cada elemento de la lista enlazadas dobles.
        - DoubleLinkedList: La clase de las listas enlazadas dobles con las siguiente funciones:
          - **add:** Añade un nodo a la lista doble.
          - **get:** Devuelve el nodo en el indice dado.
          - **remove:** Elimina el nodo en el indice dado.
          - **insertionSort:** Ordena la lista doble devolviendo el tiempo de ejecucion.
          - **isEmpty:** Verifica si la lista esta vacio.
          - **toString:** Imprime los elementos de la lista

        - Test: Aquí se prueba el ejercicio.

        Dentro de Test está el método generarPeorCaso(int t), que como su nombre menciona tiene el objetivo de crearnos el peor caso de ordenamiento, para este caso de números enteros.

        El peor caso es aquel que está en orden inverso al que se busca:
        - Ordenado: 1 - 2 - 3 - 4
        - Peor Caso: 4 - 3 - 2 - 1

## CUESTIONARIO
-   ¿Cómo se ejecutaría sus implementaciones desde terminal(consola)?
    Por ejemplo en el IDE Eclipse se agrega un jar externo así:
    ![ADD-EXTERNAL-JARs](imagenes/Add_External_JARs.png)
    ¿Cómo lo haría desde la terminal?

## REFERENCIAS
    - https://www.w3schools.com/java/
    - https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers
    -   https://javaplot.panayotis.com/
    -   https://sourceforge.net/projects/gnuplot/files/gnuplot/5.4.3/

#

[license]: https://img.shields.io/github/license/rescobedoq/pw2?label=rescobedoq
[license-file]: https://github.com/rescobedoq/pw2/blob/main/LICENSE

[downloads]: https://img.shields.io/github/downloads/rescobedoq/pw2/total?label=Downloads
[releases]: https://github.com/rescobedoq/pw2/releases/

[last-commit]: https://img.shields.io/github/last-commit/rescobedoq/pw2?label=Last%20Commit

[Debian]: https://img.shields.io/badge/Debian-D70A53?style=for-the-badge&logo=debian&logoColor=white
[debian-site]: https://www.debian.org/index.es.html

[Git]: https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white
[git-site]: https://git-scm.com/

[GitHub]: https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white
[github-site]: https://github.com/

[Vim]: https://img.shields.io/badge/VIM-%2311AB00.svg?style=for-the-badge&logo=vim&logoColor=white
[vim-site]: https://www.vim.org/

[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white
[java-site]: https://docs.oracle.com/javase/tutorial/


[![Debian][Debian]][debian-site]
[![Git][Git]][git-site]
[![GitHub][GitHub]][github-site]
[![Vim][Vim]][vim-site]
[![Java][Java]][java-site]

[![License][license]][license-file]
[![Downloads][downloads]][releases]
[![Last Commit][last-commit]][releases]
