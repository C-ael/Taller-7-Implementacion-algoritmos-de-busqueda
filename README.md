
# Taller 7 – Implementación de Búsqueda Secuencial y Binaria
### *Estructura de Datos – Unidad 2*

---
#  Tabla de Contenidos
- [Objetivos de la Practica](#Objetivos-de-la-Practica)
- [Requisitos de Software](#Requisitos-de-Software)
- [Como descargar el proyecto](#Como-descargar-el-proyecto)
- [Principales precondiciones en los algoritmos usados](#Principales-precondiciones-en-los-algoritmos-usados)
- [Casos borde](#Casos-borde)
- [Datasets](#Datasets)
- [Buenas Practicas Implementadas](#Buenas-Practicas-Implementadas)
---

##  Objetivos de la Practica

- Implementar correctamente las variantes canónicas de búsqueda secuencial y búsqueda binaria en Java. 

- Validar con casos borde, y justificar cuándo aplicar cada método según la estructura de datos (arreglo vs SLL).

---
##  Requisitos de Software
- **Java Development Kit (JDK) 17 o superior**  
  Necesario para compilar y ejecutar el proyecto.

- **IDE recomendado (uno de los siguientes):**
    - IntelliJ IDEA Community Edition
    - Visual Studio Code con extensión *“Extension Pack for Java”*
---
##  Como descargar y ejecutar el proyecto
Requisito: tener git instalado.

1. Crear una carpeta en el escritorio.
2. Dar click derecho dentro de la carpeta y dar click en Open Git Bash here.
3. Escribimos el siguiente comando "git clone" seguido del link del repositorio a clonar https://github.com/C-ael/Taller-7-Implementacion-algoritmos-de-busqueda.git
4. Abrir nuestro IDE de preferencia y abrir la carpeta que fue clonada.
5. Probar el programa ejecutando la clase main que seria la SearchDemo.
---

## Principales precondiciones en los algoritmos usados

### - Binary Search

- Requiere que el arreglo esté ordenado ascendentemente, si no se cumple, la búsqueda puede fallar.

### - Sequential Sentinel

- El arreglo no debe estar vacío para poder colocar el centinela.

### - firstOccurrence / lastOccurrence / findAll

- La colección debe existir y no ser nula.

- No requieren orden, pero el resultado depende de los datos presentes.

 ## Importancia

Cumplir las precondiciones evita errores, resultados incorrectos y asegura que los algoritmos operen bajo las condiciones para las que fueron diseñados.

## Casos borde
Para evaluar el rendimiento de los algoritmos de búsqueda y análisis, se utilizaron diferentes tipos de datasets que representan situaciones extremas o particulares. Estos casos borde permiten observar cómo se comportan los algoritmos bajo distintas condiciones.

**1. Arreglo vacío (solo en secuencial con centinela)**
- sequentialSentinel detecta si el arreglo tiene tamaño 0 y retorna -1 sin buscar.
- Los otros métodos no verifican este caso.

**2. Clave no encontrada**
- Todos los métodos (sequential, sequentialSentinel, firstOccurrence, lastOccurrence, binary) retornan -1 cuando la clave no existe.

**3. Multiples valores repetidos**
- firstOccurrence retorna la primera posición del valor.

- lastOccurrence retorna la última posición.

- findAll retorna todas las posiciones en un arreglo/Lista SLL.

- Esto es relevante especialmente en el dataset Duplicados.

**4. Dataset desordenado**
- Métodos secuenciales funcionan correctamente.

- Binary search puede fallar si el dataset no está ordenado ascendentemente.

En el dataset C que esta ordenado de manera ascente funciona bien

**5. Dataset ordenado inverso (descendente)**
- La búsqueda binaria no funciona, porque requiere orden ascendente.
- Las demás búsquedas funcionan normal.

**6. Dataset casi ordenado**
- La búsqueda binaria puede fallar.
- Las búsquedas secuenciales funcionan sin problemas.


## Datasets
### Dataset A Duplicados
Incluye múltiples elementos con el mismo valor. Este caso permite evaluar cómo los algoritmos manejan la presencia de repeticiones, especialmente en operaciones como findAll, donde es necesario identificar todas las ocurrencias de una misma clave.

### Dataset B Inverso
Los elementos se encuentran organizados de forma descendente. Este escenario es desfavorable para algoritmos que asumen un orden ascendente, obligándolos a recorrer completamente la colección o a realizar correcciones adicionales.

### Dataset C Ordenado
Corresponde a una colección cuyos elementos están organizados de forma ascendente. Este caso representa el entorno ideal para algoritmos que se benefician del orden, como la búsqueda binaria, permitiendo obtener un rendimiento óptimo.

### Dataset D Casi ordenado
Contiene elementos que en su mayoría están ordenados, pero con algunas posiciones intercambiadas o fuera de lugar. Este dataset es útil para analizar algoritmos cuyo comportamiento mejora ante datos parcialmente organizados.


#  Buenas Prácticas Implementadas

- Código limpio, modular y fácilmente extensible  
- Separación clara de responsabilidades  
- Instrumentación detallada y validada  
- Evitación de I/O dentro de la medición  
- Tests con repetición y descarte de calentamiento  
- Uso de mediana para evitar valores atípicos

---

# NOTA: 
**La clase DatasetBuilder.Java convierte los archivos csv de practicas anteriores a archivos txt, usando como referencia su mismo formato empleado en la actividad para únicamente recolectar la columna id (para trabajar con enteros), columna la cual está organizada en base a lo necesitado en el taller (ordenados, desordenados, etc). Los datasets generados (.txt) se almacenan en la misma carpeta datasets/ y usan nombres genéricos indicados en el taller (ejem: datasetA, datasetB, etc)**
