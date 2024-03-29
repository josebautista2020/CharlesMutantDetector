# Profesor Charles
# mutantDetector
Restful API que identifica, dada una cadena de ADN, si esta es mutante o humana

# Problema

Dado un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G)
 
Se considera mutante si encuentras ​más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical. 
 Ejemplo (Caso mutante): 
 
```
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; 
```

## Tecnologías

* Java 21
* Maven - Administración y distribución del proyecto
* Jersey - Api Restful
* HK2 - Inyección de dependencias
* Grizzly - WebServer para test de integración y generación de standalone app. 
* Embeded Redis Server - Cuenta con un Server de Redis embebido para testear la aplicación.
* Swagger - Generación de documentación de la API. Swagger-UI disponible para visualizar las especificaciones de la API
* JUnit5 - Test
* Jacoco - Reporte de cobertura de tests
* Jedis - Cliente Redis
* Amazon EC2 y ElasticCache - Host de la API en Tomcat 11 y Redis para base de datos
* IDE Utilizada - Eclipse


#Demo de la API

Se puede ver la aplicación alojada en un server utilizando AWS EC2 en:

Swagger:
http://charlesmutantdetector.us-east-1.elasticbeanstalk.com/
http://ec2-52-67-163-113.sa-east-1.compute.amazonaws.com:8080/mutantDetector/docs/

Api:
http://ec2-52-67-163-113.sa-east-1.compute.amazonaws.com:8080/mutantDetector/api/

## Instrucciones

Para correr el proyecto localmente es necesario clonar el proyecto y seguir las siguientes instrucciones

### Requisitos

Antes de empezar es necesario tener instalado:

-JDK 21.0.1 con la variable de entorno JAVA_HOME configurada correctamente
-Maven 3.9.6

Una vez que todo esté instalado es momento de preparar la aplicación


## Instalación

Primero que nada posicionarse en el root del proyecto clonado.

###Para generar el JAR

```
mvn clean install -Dout=jar
```

Este comando descarga las dependecias, corre los tests y genera el JAR en /target/mutantDetector-{Version}-jar-with-dependencies.jar. 
En este caso (v1.0) la ruta es /target/mutantDetector-1.0-jar-with-dependencies.jar)


### Ejecutar la aplicación

```
java -jar target/mutantDetector-1.0-jar-with-dependencies.jar
```

Una vez inciado, si todo está en orden, aparecerá el siguiente mensaje en la consola

```
INFO [main] (ServersManager.java:138) - API - Documentación Online : http://localhost:8082/docs/
 INFO [main] (ServersManager.java:167) - Mutant Detector Iniciado.
Presione una tecla para finalizar...
```

### Test Coverage


En la Ruta /coverage/jacoco-resources/index.html se puede ver el informe de la cobertura del código testeado.


## Deploy

Para generar el WAR para deployarlo en un server Tomcat 8, ejecutar:

```
 mvn clean install -Dout=war
```

Por default genera war, por lo tanto solo se necesita ejecutar:

```
 mvn clean install
```


## Autor

* **Jose Bautista**

