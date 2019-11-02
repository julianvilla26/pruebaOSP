# Automatizaci�n de Pruebas para APP Personas
### Descripci�n y contexto
---

Paga tus facturas y productos Bancolombia, transfiere, consulta y conoce tus movimientos desde tu dispositivo m�vil con App Personas.

Desc�rgala de manera f�cil y gratuita en tu celular y estaremos al alcance de tu mano en todo momento.

##**Con App Personas estamos siempre conectados**
�S�cale el mayor provecho a tu smartphone y tableta! A trav�s de App Personas tienes a tu mano en todo momento, la informaci�n de tus productos y las noticias econ�micas en una sola aplicaci�n.


### Resumen de codificaci�n
---
El c�digo se encuentra documentado y la generaci�n del Documento se realiz� con JavaDoc.


### El framework
---
## BDD
Se utiliza BDD como framework de automatizaci�n para la automatizaci�n de los escenarios de prueba, la idea es escribir las pruebas antes de escribir el c�digo fuente, pero en lugar de pruebas unitarias, lo que haremos ser� escribir pruebas que verifiquen que el comportamiento del c�digo es correcto desde el punto de vista de negocio. Tras escribir las pruebas escribimos el c�digo fuente de la funcionalidad que haga que estas pruebas pasen correctamente. Despu�s refactorizamos el c�digo fuente.
partimos de historias de usuario, siguiendo el modelo �Como [rol ] quiero [ caracter�stica ] para que [los beneficios]�. A partir de aqu�, en lugar de describir en 'lenguaje natural' lo que tiene que hacer esa nueva funcionalidad, vamos a usar un lenguaje que nos va a permitir describir todas nuestras funcionalidades de una misma forma, un lenguaje espec�fico para BDD.
## Gherkin
Se utiliza Gherkin como lenguaje de desarrollo de las funcionalidades dado que es un lenguaje comprensible por humanos y por ordenadores, con el vamos a definir el comportamiento de la p�gina que vamos a automatizar.
Se trata de un lenguaje f�cil de leer, f�cil de entender y f�cil de escribir. Utilizar Gherkin nos va a permitir crear una documentaci�n viva a la vez que automatizamos los tests, haci�ndolo adem�s con un lenguaje que puede entender negocio.
Lo bueno de Gherkin es que para empezar a hacer BDD s�lo nos hace falta conocer 5 palabras, con las que construiremos sentencias con las que vamos a describir las funcionalidades:
- Feature: Indica el nombre de la funcionalidad que vamos a probar. Debe ser un t�tulo claro y expl�cito. Incluimos aqu� una descripci�n en forma de historia de usuario: �Como [rol] quiero [caracter�stica] para que [los beneficios]�. Sobre esta descripci�n empezaremos a construir nuestros escenarios de prueba.
- Scenario: Describe cada escenario que vamos a probar.
-	Given: Provee contexto para el escenario en que se va a ejecutar el test, tales como punto donde se ejecuta el test, o prerequisitos en los datos. Incluye los pasos necesarios para poner al sistema en el estado que se desea probar.
-	When: Especifica el conjunto de acciones que lanzan el test. La interacci�n del usuario que acciona la funcionalidad que deseamos testear.

-	Then: Especifica el resultado esperado en el test. Observamos los cambios en el sistema y vemos si son los deseados.
Lo normal es probar distintos escenarios para comprobar una determinada funcionalidad. De esta forma vamos a pasar de nuestras historias de usuario a pruebas de comportamiento automatizables.
## Cucumber
Se utiliza cucumber como herramienta para para automatizar las pruebas en BDD. Cucumber nos va permitir ejecutar descripciones funcionales en texto plano como pruebas de software automatizadas. Totalmente compatible con el lenguaje Gherkin.

### Compilador
---
Se crea el proyecto sobre Gradle, es una herramienta de automatizaci�n de la construcci�n de nuestro c�digo, es la versi�n mejorada de Maven, pero intenta llevarlo todo un paso m�s all�. Para empezar, se apoya en Groovy y en un DSL (Domain Specific Language) para trabajar con un lenguaje sencillo y claro a la hora de construir el build comparado con Maven. Por otro lado, dispone de una gran flexibilidad que permite trabajar con ella utilizando otros lenguajes y no solo Java. Dispone por otro lado de un sistema de gesti�n de dependencias s�lido.

### Patrones de desarrollo
---
Para el desarrollo de la automatizaci�n se utilizaron los siguientes patrones de desarrollo:

Variables: camelCase
Funciones: camelCase
Clases: PascalCase
Paquetes: camelCase

Camel Case: El nombre viene porque se asemeja a las dos jorobas de un camello, y se puede dividir en dos tipos:
� Upper Camel Case, cuando la primera letra de cada una de las palabras es may�scula. Tambi�n denominado Pascal Case. Ejemplo: EjemploDeNomenclatura.
� Lower Camel Case, igual que la anterior con la excepci�n de que la primera letra es min�scula. Ejemplo: ejemploDeNomenclatura.
Es muy usada en los #hashTags de Twitter o en lenguajes como Java, PHP, C#�

### Pr�cticas de automatizaci�n
---
Un proyecto donde se ejemplifica el uso del patr�n serenity
[screenplay](http://thucydides.info/docs/serenity-staging/#_serenity_and_the_screenplay_pattern) con cucumber y gradle.

Los tests usan tareas (tasks), interacciones (interactions), preguntas (questions), elementos de p�ginas (user_interface) y basicamente se tiene la siguiente estructura a nivel de proyecto de automatizaci�n.

+ model
    Clases que usan el patr�n DTO o relacionadas con el modelo de dominio

+ tasks
    Clases que representan tareas que realiza el actor a nivel de proceso de negocio
+ interacion
    Clases que representan las interacciones directas con la interfaz de usuario
+ user_interface
    Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario
+ questions
    Objectos usados para consultar acerca del estado de la aplicaci�n
+ Facade
    Clases que permiten la integraci�n con el Backend en nuestro caso iSeries

### Herramienta de automatizaci�n utilizado
---
Se utiliza el IDE de Eclipse para el desarrollo de la automatizaci�n. Eclipse es una plataforma de desarrollo, dise�ada para ser extendida de forma indefinida a trav�s de plug-ins. Fue concebida desde sus or�genes para convertirse en una plataforma de integraci�n de herramientas de desarrollo. No tiene en mente un lenguaje espec�fico, sino que es un IDE gen�rico, aunque goza de mucha popularidad entre la comunidad de desarrolladores del lenguaje Java usando el plug-in JDT que viene incluido en la distribuci�n est�ndar del IDE.
Proporciona herramientas para la gesti�n de espacios de trabajo, escribir, desplegar, ejecutar y depurar aplicaciones.

### Estrategia de automatizaci�n
---
Inicialmente se levantaron los flujos de cada transacci�n, para conocer el negocio y tener claro que se debia automatizar.
Una vez claro el alcance se procede con la automatizaci�n de las transacciones, para esto se decide automatizar por capas front y iseries.

El front es proporcionado por TODO1, y el Backend es desarrollado por el Banco.

Para correr el proyecto se necesita Java JDK 1.8 y Gradle preferiblemente con la versi�n 4.7.



Comando para ejecutar desde consola
Comando desde Gradle
Ejecuto un metodo en especial
gradle clean test --tests co.com.devco.certificacion.eribank.authAuthTest1.test02 aggregate -i

Ejecuto una clase en especial
gradle clean test --tests co.com.devco.certificacion.eribank.authAuthTest1 aggregate -i

Ejecuto un paquete en especial
gradle clean test --tests co.com.devco.certificacion.eribank.auth* aggregate -i

Ejecutar un feature en especial
gradle clean -Dtest.single=NombredelFeature test aggregate --stacktrace

Como Ocultar datos sensibles en el reporte de SerenityBDD
Se crea la siguiente interacccion

EnterAndHide: interacci�n que le permite ingresar un texto y ocultarlo debajo de otro, el valor predeterminado de "cualquier texto", pero se puede cambiar utilizando el m�todo as. Ver ejemplo de implemetacion



Comando para crear el gradle wrapper 

gradle wrapper --gradle-distribution-url http://artifactory.bancolombia.corp/gradlew/gradle-4.3.1-all.zip 