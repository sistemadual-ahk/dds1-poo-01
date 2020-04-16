#  Primer módulo - Paradigma Orientado a Objetos
**Índice**
- [Introducción](#introducción)
	- [Intención](#intención)
	- [Forma y metodología](#forma-y-metodología)
	- [Paradigma orientado a Objetos](#paradigma-orientado-a-objetos)
		- [Principios](#principios)
		- [Objeto](#objeto)
		- [Mensajes y métodos](#mensajes-y-métodos)
		- [Atributos](#atributos)
		- [Interface](#interface)
	- [Kotlin y Java](#kotlin-y-java)
	- [Organización del código](#organización-del-código)
- [Gary](#gary)
	- [Primera iteración](#primera-iteración)
		- Dominio
		- Diseño en objetos
		- Implementación
		- Tests
			- En Kotlin
			- En Java
	- [Segunda iteración](#segunda-iteración)
		- Dominio
		- Diseño en objetos
		- Implementación
		- Tests
			- En Kotlin
			- En Java
	- [Tercera iteración](#tercera-iteración)
		- Dominio
		- Diseño en objetos
		- Implementación
		- Tests
			- En Kotlin
			- En Java
	- [Otras cuestiones](#otras-cuestiones)
		- [Entorno de desarrollo](#entorno-de-desarrollo)
		- [¿Qué es un REPL?](#qué-es-un-repl)
		- [¿Querés jugar un poco más con Gary?](#querés-jugar-un-poco-más-con-gary)
## Introducción
### Intención
La intensión principal que tiene este documento (y el ejercicio, claro) es introducir al lector en el Paradigma de Programación Orientado a Objetos, pero de una forma distinta a la clásica.
En este caso, usaremos lenguajes púramente comerciales como Kotlin y Java. Nos apoyamos en ellos para evitar sufrir el impacto que genera el pasaje de un lenguaje de objetos puro, como Smalltalk, a uno más comercial y actual; así como también acostumbrarnos al uso de los IDEs, herramientas de gran ayuda a la hora de sentarnos a programar.
Además, veremos de entrada un concepto muy importante de este paradigma: Interfaces.
### Forma y metodología
Haremos uso de la metodología iterativa incremental. En todas las iteraciones repetiremos un proceso de trabajo similar para proporcionar un resultado completo sobre el aprendizaje esperado, de manera que el lector pueda obtener los conceptos del Paradigma Orientado a Objetos de forma incremental.
Además, como ya se adelantó, todos los conceptos serán llevados a ejemplos e implementados en lenguajes comerciales.
### Paradigma orientado a Objetos
#### Principios
El paradigma orientado a objetos nos hace pensar en la realidad, estudiarla, entenderla, conceptualizarla y luego modelarla. Claro está que nuestro entendimiento de la realidad está limitado y acotado porque nuestra mirada es totalmente subjetiva. 
Este paradigma nos hace replantear varias cuestiones sobre cómo diseñar y desarrollar un sistema. Nos hace pensar en la mantenibilidad, flexibilidad, cohesión, y muchos otras tantas cualidades y atributos de calidad que se  buscan maximizar constantemente.
Nos abstrae de pensar en cuestiones de más bajo nivel como reserva dinámica de memoria, liberación de memoria o sentencias muy primitivas. Está a favor de la reutilización de código y cree en que las cosas deben hacerse una sola vez.
#### Objeto
Para este paradigma, un objeto es toda "cosa" del mundo real, o no, que puede representarse computacionalmente. Decimos también que un objeto es una abstracción que tiene una razón de ser porque tiene una o varias responsabilidades asociadas. Estas responsabilidades quedan en evidencia cuando alguien, otro actor, le solicita a un objeto que haga algo o le pide algo. Además, cada objeto tiene características que le pertenecen y que lo diferencian del resto.
Es muy importante saber que un objeto define un tipo de dato, lo que significa que el tipo de una variable puede ser un objeto.
#### Mensajes y métodos
Hemos dicho que un objeto puede tener una o varias responsabilidades asociadas y que éstas quedan en evidencia cuando alguien le dice al mismo que haga algo o bien cuando le pide algo.
¿Quién puede decirle a un objeto que haga algo o pedirle algo? ¡Otro objeto!
Decimos entonces que los objetos se comunican enviándose mensajes entre sí.
Como en todo proceso de comunicación, existe un emisor, un mensaje y un receptor.
Cuando un objeto recibe un mensaje, ejecuta el método asociado. En el método se especifica lo que el objeto debe hacer frente a esa petición. Por ejemplo, si yo le digo a un gato que camine, el gato se desplazará un par de metros.
#### Atributos
Hemos dicho que un objeto tiene características que le pertenecen y que lo diferencian del resto. Lo que no hemos dicho es que estas características se materializan en variables, más conocidas como atributos. Es decir, un objeto puede tener una o más variables, desde ahora y para siempre atributos, que conforman su estado interno. Estos atributos sobreviven mientras el objeto sobreviva, es decir, mientras el mismo esté presente en la memoria.
Cabe destacar que un atributo no está haciendo referencia a una porción de memoria, sino que está guardando una referencia a otro objeto.
Como vamos a trabajar en lenguajes fuertemente tipados, cada variable utilizada en un programa necesita explicitar su tipo. Entonces, cada variable será de un tipo en particular. Por ejemplo, si estaría diseñando un sistema para un gimnasio y "eze" fuera un objeto, probablemente me interese que "eze" tenga un atributo `peso` de tipo `float`.

#### Interface
Una interface es un contrato en el cual se establecen los métodos que debe implementar un objeto. En la interface solo se escriben las firmas de los métodos, es decir, sin cuerpo ni desarrollo de los mismos.
Un objeto puede implementar ninguna, una o muchas interfaces al mismo tiempo. Además, es importante destacar que una interface define un nuevo tipo de dato.
En general, cuando objeto implementa una interface se dice que *cumple con esa interface*.

Por ejemplo, supongamos que establecemos la interface `desplazable` que define el método `desplazar(metros)`. Podrían existir varios objetos que cumplan con esa interface, como insectos, animales, personas, vehículos, etc. Todos estos objetos, si implementan la interface, estarían obligados a desarrollar el método `desplazar(metros)`, pero cada uno lo hará de forma distinta. Una persona podría caminar, una serpiente se podría arrastrar, una mariposa podría volar, etc.

### Kotlin y Java
Kotlin es un lenguaje mucho más nuevo que Java, pero está basado en él. Es por este motivo que son 100% compatibles, lo que nos lleva a afirmar que en un mismo proyecto puedo tener ciertas porciones de código en Kotlin y otras en Java.

Veamos un cuadro comparativo de ambos lenguajes.

| Característica  | Java | Kotlin |
| ------------ | ------------ | ------------ |
| Tipado  | Fuertemente tipado  | Fuertemente tipado  |
| Compilado/Interpretado  | Compilado  | Compilado  |
| 100% Orientado a Objetos  | No  | Si  |
| Tipo "objetct"  | No  | Si  |
| Null safety  | No  | Si  |
| Excepciones chequeadas  | Si  | No  |
| Casteos inteligentes  | No  | Si  |
| Expresiones Lambdas  | En ciertas porciones  | Si  |

### Organización del código
Por una cuestión de organización y de estructura, en todo proyecto que trabajemos, ya sea Java o Kotlin, vamos a generar las siguientes carpetas:

+ src
    + main
        + java
    + test
        + java

Detro de `src -> main -> java` vamos a crear archivos para escribir nuestro código, pero estos archivos no estarán sueltos sino que deberán pertenecer a un `package`. Los packages, como bien nos dice su traducción, son paquetes de archivos de código que están agrupados por algún concepto. Por el momento, solo crearemos un único package llamado `domain`.
Para crear un package, debemos hacer click derecho sobre esta carpeta (`src -> main -> java`) , y seleccionar `new -> Package`, le damos un nombre y listo. Claro está que todo esto lo hacemos siempre desde nuestro IDE, que será IntelliJ.
Tendremos que crear un archivo por cada objeto que modelemos en nuestro dominio.
Para crear un objeto, nos pararemos sobre el package domain y haciendo click derecho seleccionaremos `new -> Kotlin File/Class` para el caso de Kotlin, o `new -> Java Class` para el caso de Java. Si seguimos por el lado de Kotlin, nos mostrará una ventana emergente donde podremos darle un nombre al objeto y seleccionar el tipo de archivo. Por el momento, seleccionaremos `Kind -> object`.

Por el otro lado, dentro de `src -> test -> java` escribiremos código para testear las implementaciones realizadas. De la misma forma que para el caso anterior, debemos crear un package y los objetos o clases necesarias.
## Gary
### Primera iteración
#### Dominio
Gary es un gato muy mimoso, de color naranja y muy peludo. Como todo gato, le gusta comer mucho y también dormir.
Cuando Gary come, disminuye su hambre como tantas raciones le de su dueño. 
Además, sabemos que cuando duerme recupera dos puntos de energía por cada 30 minutos que durmió.

#### Diseño en objetos
La primera pregunta que nos surje, o que deberíamos hacernos, es: ¿qué abstracciones se desprenden del dominio? Nótese que nos están hablando de Gary y que gary es un gato. ¿Qué vamos a modelar, entonces? ¡Claro! A Gary. 
Gary es un fuerte candidado a ser un objeto de nuestro dominio, ya que podemos identificar en él ciertos **atributos** y **comportamiento**. 
Una vez identificado el/los objeto/s del dominio, deberíamos preguntarnos: ¿Qué les puedo pedir a ellos? ¿Qué saben hacer? ¿Qué resuelven?
A Gary le puedo dar de comer. ¿Qué le puedo dar de comer? El dominio todavía no deja expuesto explícitamente qué puede comer, pero sí sabemos que el dueño le da "raciones" y sabemos en qué medida disminuye su hambre cuando le damos una ración.
También lo puedo mandar a dormir por unos minutos, acto que le hace recuperar energía.
¿Cómo nos comunicamos con nuestros objetos? ¡Enviándole mensajes!
Eso quiere decir que a Gary le voy a poder mandar el mensaje `come` y `dormi`.  ¿Pero cómo sabe Gary cuántas raciones comer o cuántos minutos dormir? Se lo voy a tener que decir. Vamos a necesitar, en principio, un parámetro en cada uno de los mensajes. Por ejemplo: `gary.come(2)` o `gary.domi(45)`.
Bien, ¿y qué hace Gary cuando recibe esos mensajes? Ejecuta los métodos asociados:
- Cuando le damos de comer, Gary disminuye su hambre en tantas unidades como raciones le demos. ¡Momento! *Disminuye su hambre* ¿Gary tiene hambre?  Sí, y lo modelaremos como un atributo de tipo `Int`. Es decir, el hambre es una característica de Gary que varía mientras esté presente en memoria.
- Cuando le decimos a Gary que duerma, *recuperará su energía*. Otro atributo más: energía. También vamos a modelarlo como de tipo `Int` porque nos alcanza que sea de ese tipo.

Tenemos en mente todo lo necesario para empezar a implementar nuestro diseño. ¡Manos a la obra!
#### Implementación
Como dijimos, vamos a crear a Gary, nuestro primer objeto:
```kotlin
    object gary {
        
    }
```

Hasta ahora tenemos al objeto `gary` que no entiende nada y que tampoco tiene características. Hagamos que Gary entienda el mensaje `come`:

```kotlin
    object gary {
    
        fun come(algunasRaciones : Int){
    
        }
    }
```

La forma de escribir un objeto en Kotlin es, entonces:
```kotlin
    object nombreObjeto { }
```

Ahora sí le podremos dar de comer Gary tantas raciones como queramos, pero cuando él reciba este mensaje no hará nada porque no escribimos el método. ¿Qué esperamos? ¡Hagamoslo!

```kotlin
    object gary {
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    }
```
Okey. Ahora cuando le damos de comer a Gary disminuye su... ¿Hambre? `this.hambre` está haciendo referencia a su atributo hambre, que por cierto todavía no está definido.

```kotlin
    object gary {
        var hambre : Int = 10
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    }
```

Recapitulando:
- Para declarar un método en Kotlin escribimos: `fun nombreDelMensaje(parametro : TipoParametro){ }`
- ¡Ojo! Los métodos pueden tener 0, 1 o más parámetros y todos ellos se separan por `,` de la forma:
    
        fun nombreDelMetodo(parametro1 : tipoParametro1, parametro2 : tipoParametro2, ...){ ... }
- Para declarar un atributo en Kotlin escribimos: `var nombreAtributo : Tipo` Cabe aclarar que, en Kotlin, debemos inicializar los atributos. Es por ello que a Gary le dimos 10 puntos de hambre. Estos 10 puntos los tendrá desde que Gary nace en memoria hasta que se modifique ese valor o se vaya de memoria.

Gary todavía no sabe dormir, a si que vamos a darle la posibilidad de que lo entienda y lo haga:

```kotlin
    object gary {
        var hambre : Int = 10
        var energia : Int = 10
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    
        fun dormi(unosMinutos : Int){
            this.energia += 2 * (unosMinutos/30)
        }
    }
```
Pero... ¿acaso Gary no era un gato naranja? ¡Sí! Nos está faltando modelar esta característica.
```kotlin
    object gary {
        var color : String? = "Naranja"
        var hambre : Int = 10
        var energia : Int = 10
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    
        fun dormi(unosMinutos : Int){
            this.energia += 2 * (unosMinutos/30)
        }
    }
```

Hemos decidido modelar al color como un simple `String` ya que por ahora es suficiente porque no hay nada que dependa de esta característica.  Pero... ¿Por qué lo declaramos como `String?`? (nótese el signo de interrogación).
Poniendo el signo `?` justo al lado del tipo de un atributo, estamos indicando que el atributo puede estar vacío, lo que en objetos implica que el atributo está apuntando a `Null`.
En este caso, estamos inicializando el color con el valor "naranja", que es el color que representa a Gary.

Ahora sí logramos modelar el dominio presentado y estamos en condiciones de poder hacer algunas pruebas.

#### Tests
##### En Kotlin
Vamos a verificar y validar nuestro diseño e implementación mediante algunas pruebas por el REPL de Kotlin.

- Vamos a darle de comer a Gary 2 raciones. Su nivel de hambre después de comer debería ser 8.
    
    En el REPL escribimos:`gary.come(2)` y luego presionamos Ctrl+Intro.
    Si luego de ejecutar la sentencia anterior, escribimos y ejecutamos `gary.hambre`, la terminal nos mostrará: `res1: kotlin.Int = 8`
    
      gary.come(2)
      gary.hambre
      res1: kotlin.Int = 8
    
    ¡Perfecto! Gary está haciendo exactamente lo que queríamos que haga.

- Vamos a hacer dormir a Gary por 45 minutos.  Su nivel de energía luego de dormir debería ser 12.
    En el REPL escribimos: `gary.dormi(45)` y luego presionamos Ctrl+Intro.
    Ahora preguntemos por la energía de Gary. ¿Cuánto debería darnos?
        gary.dormi(45)
        gary.energia
        res1: kotlin.Int = 12

##### En Java
Por el momento, solamente printearemos algunos cosas por pantalla para dejar en evidencia cómo cambian los valores de los atributos de Gary cuando jugamos con el. 
Para esto vamos a hacer algo sin demasiada explicación por ahora.
Creaemos una Clase (¿Clase? ¿Qué es eso? ¡Lo veremos más adelante!) con un `main`. Todo programa Java siempre arranca a ejecutarse por el método main y es por ello que lo necesitamos declarar. 
```java
public class DemoMain {

    public static void main(String[] args) {

    }
}
```
¡Listo! Ahora vamos a mostrar un par de cosas por pantalla.

Primero, vamos a necesitar declarar una variable que apunte al objeto Gary. Eso lo logramos con la sentencia: `gary gary = domain.gary.INSTANCE;` Por el momento, tampoco nos interesa lo que está a la derecha del "=". Solo tenemos que entender que ahora tenemos una referencia al objeto gary.

Ya estamos listos para mostrar los valores de los atributos de Gary. 
Para mostrar algo por pantalla debemos escribir: `System.out.printIn("algo para mostrar")` 
Empecemos por el hambre:
```java
public class DemoMain {

    public static void main(String[] args) {
        gary gary = domain.gary.INSTANCE;

        System.out.println("Gary en este momento tiene "+ gary.getHambre()+" puntos de hambre");
    }
}
```
¿Qué es eso de `gary.getHambre()` ? Por buenas prácticas, y demás justificaciones que nos acontecen en otra explicación, siempre usaremos getters y setters para acceder a los atributos:
- `getNombreDelAtributo()` nos devolverá el valor que tiene el atributo. Por ejemplo:

    ```java
    int getHambre(){
        return this.hambre;
    }
    ```
- `setNombreDelAtributo(unValor)` pisará el valor que tenga el atributo en ese momento por el valor que le enviamos por parámetro. Por ejemplo:

    ```java
    void setHambre(int nivelHambre){
        this.hambre = nivelHambre;
    }
    ```

Habiendo explicado estos conceptos, ya podemos ejecutar nuestro main. Como resultado veremos por pantalla: `Gary en este momento tiene 10 puntos de hambre`

Ahora demosle de comer 2 raciones y hagamoslo dormir 45 minutos y comparemos los resultados:
```java
public class DemoMain {

    public static void main(String[] args) {
        gary gary = domain.gary.INSTANCE;

        System.out.println("Gary en este momento tiene "+ gary.getHambre()+" puntos de hambre");
        System.out.println("También tiene "+ gary.getEnergia()+" puntos de energia");
        System.out.println("Es un gato de color "+ gary.getColor());

        gary.come(2);
        gary.dormi(45);
        System.out.println("Después de darle 2 raciones de comida tiene "+gary.getHambre()+" puntos de hambre");
        System.out.println("Y luego de dormir 45 minutos tiene "+gary.getEnergia() +" de energia");
    }
}
```
Como resultado deberíamos ver por pantalla:


    "Gary en este momento tiene 10 puntos de hambre"
    "También tiene 10 puntos de energia"
    "Es un gato de color Naranja"
    "Después de darle 2 raciones de comida tiene 8 puntos de hambre"
    "Y luego de dormir 45 minutos tiene 12 de energia"

### Segunda iteración
#### Dominio
Gary no solamente es un cuatropatas peludo que come y duerme, sino que de vez en cuando sale a caminar. Cuando Gary camina, disminuye su energía en 1 unidad por cada 70 metros y aumenta su hambre en 2 unidades por cada 40 metros.
#### Diseño en objetos
Al parecer sigue habiendo un solo objeto en nuestro dominio y es Gary. Pero ahora gary no solamente sabe comer y dormir, sino que tambien debe saber caminar. Debemos poder decirle a Gary que camine algunos metros.. ¿entonces? ¡Va a entender otro mensaje! `camina(unosMetros : Int)` podría ser una buena firma de ese mensaje.
#### Implementación
Vamos a extender la implementación que teníamos sobre Gary para agregar el nuevo mensaje que tiene que entender.

```kotlin
    object gary {
        var color : String? = "Naranja"
        var hambre : Int = 10
        var energia : Int = 10
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    
        fun dormi(unosMinutos : Int){
            this.energia += 2 * (unosMinutos/30)
        }
    
        fun camina(unosMetros : Int){
            this.energia -= 1 * (unosMetros/70)
            this.hambre += 2 * (unosMetros/40)
        }
    }
```

Sencillo, ¿no?
#### Tests
##### En Kotlin
Nuevamente vamos a ir al REPL de Kotlin y vamos a probar que si mandamos a caminar a Gary 100 metros, su energía queda en 9 puntos y su hambre en 14 puntos:


    gary.camina(100)
    gary.energia
    res1: kotlin.Int = 9
    gary.hambre
    res2: kotlin.Int = 14
##### En Java
En este caso vamos a escribir nuevamente en nuestro método main:
```java
public class DemoMain {

    public static void main(String[] args) {
        gary gary = domain.gary.INSTANCE;
        gary.camina(100);
        System.out.println("Gary despues de caminar 100 metros tiene "+gary.getHambre()+" puntos de hambre");
        System.out.println("Y tambien tiene "+gary.getEnergia() +" de energia");
    }
}

```
### Tercera iteración
#### Dominio
A Gary le gustan varias comidas y cada una sacia al gato de diferente manera:
- Comida balanceada: cada ración le quita 3 puntos de hambre.
- Ceso: cada ración le quita 2 puntos de hambre.
- Pescado: cada ración le quita 4 puntos de hambre.
- Cualquier otra comida, solo le quita 1 punto de hambre por ración.

#### Diseño en objetos
Ahora sí sabemos lo que puede comer Gary y también sabemos que cada una de estas comidas afecta de distinta forma a este gato.
Lo que, quizás, se nos podría ocurrir sin pensarlo mucho es agregarle un parámetro más al método `come` que represente qué comida le estamos dando como un simple String: `come(algunasRaciones: Int, comida : String)`. Pero esto nos lleva a generar un switch (en Kotlin la sentencia equivalente es `when`) o muchos ifs dentro de nuestro método, quedando la implementación de la siguiente forma:

```kotlin
    fun come(algunasRaciones: Int, comida : String){
            when (comida){
                "ceso" -> this.hambre -= algunasRaciones *2
                "pescado" -> this.hambre -= algunasRaciones * 4
                "comidaBalanceada" -> this.hambre -= algunasRaciones * 3
                else -> this.come(algunasRaciones)
            }
    }
```

Pero esto no es muy amigable por varias razones:
- Gary sabe exactamente cómo le afeca cada comida
- Si se agrega una nueva comida a nuestro dominio, vamos a tener que tocar el objeto gary. Si hacemos esto, estamos expuestos a "romper" la implementación que teníamos hecha.
- Si aparece una nueva comida que afecta de forma diferente al gato, vamos a empezar a tener líneas de código cada vez más grandes en gary.

Entonces... ¿Cómo vamos a modelar cada comida? ¡Con más objetos!
Haremos un objeto por cada comida y le daremos, a cada uno de ellas, la responsabilidad de que sepan cómo afectar al gato cuando éste las come.

Si vamos por este camino, nuestro mensaje quedará algo como: `come(algunasRaciones: Int, comida : ????)` ¡Ops! ¿Qué tipo le ponemos al parámetro?
Vamos a necesitar modelar una **Interface** y establecer allí la responsabilidad que tendrán las comidas. Esta interface podría llamarse "comestible" y definir el mensaje `afectarHambreDe(gary : gary, raciones : Int)` . Cada comida deberá implementar esa interface para que Gary las pueda comer. Cuando un objeto "cumple" una interface está obligado a definir los métodos de todos los mensajes que la interface dice que entenderá. Por lo tanto, nuestros objetos `ceso`, `pescado` y  `comidaBalanceada` deberán entender el mensaje `afectarHambreDe(gary : gary, raciones : Int)` y desarrollar su método.

¡Listo! Tenemos todo pensado. ¡Manos a la obra!

#### Implementación
Arranquemos escribiendo nuestra interface `comestible`:

```kotlin
    interface comestible {
        fun afectarHambreDe(gary : gary, raciones : Int)
    }
```

Nótese que en las interfaces solo se escriben los mensajes que entenderán los objetos que la implementen, pero no los métodos. En otras palabras, solo se escriben firmas pero no los cuerpos.

Ahora vamos con las comidas:

```kotlin
    object ceso : comestible{
    
        override fun afectarHambreDe(gary : gary, raciones : Int){

        }
    }

    object pescado : comestible{
    
        override fun afectarHambreDe(gary : gary, raciones : Int){

        }
    }

    object comestibleBalanceada : comestible {
    
        override fun afectarHambreDe(gary : gary, raciones : Int){

        }
    }
```

Algunas cosas que no hay que pasar por alto:
- Cuando queremos hacer que un objeto implemente una interface, lo tenemos que indicar con `: nombreInterface`, tal cual lo tienen escrito nuestras comidas.
- Debemos escribir la palabra `override` delante del método para indicarle al compilador que allí estará la implementación real a ejecutar.
- Los métodos que definimos en nuestras comidas sí llevan cuerpo porque ya no estamos en la interface, sino que estamos cumpliendo con la misma.

Antes de terminar de definir los métodos `afectarHambreDe` de cada una de las comidas, vamos a retocar un poco a gary:

```kotlin
    object gary {
        var color : String? = "Naranja"
        var hambre : Int = 10
        var energia : Int = 10
    
        fun come(algunasRaciones : Int){
            this.hambre -= algunasRaciones
        }
    
        fun come(algunasRaciones: Int, comida : comestible){
            comida.afectarHambreDe(this, algunasRaciones)
        }
    
        fun dormi(unosMinutos : Int){
            this.energia += 2 * (unosMinutos/30)
        }
    
        fun camina(unosMetros : Int){
            this.energia -= 1 * (unosMetros/70)
            this.hambre += 2 * (unosMetros/40)
        }
    }
```

¿Dos mensajes que se llaman igual pero que tienen distinto número de parámetros? Sí, es posible y se llama **sobrecarga de métodos**. 

Revisemos un poco el nuevo método que establecimos en gary:

```kotlin
    fun come(algunasRaciones: Int, comida : comestible){
            comida.afectarHambreDe(this, algunasRaciones)
    }
```

Establecimos que la comida recibida es de tipo `comestible`, es decir, del tipo de la interface que definimos líneas más arriba. Esa comida que le llega por parámetro podrá ser cualquier objeto que esté implementando la interface `comestible`, como por ejemplo,  `ceso`, `pescado` o  `comidaBalanceada`.

Ahora sí vamos con las implementaciones de los métodos `afectarHambreDe` de las comidas:

```kotlin
    object ceso : comestible{
    
        override fun afectarHambreDe(gary : gary, raciones : Int){
            gary.hambre -= raciones *2
        }
    }
    
    object pescado : comestible{
    
        override fun afectarHambreDe(gary : gary, raciones : Int){
            gary.hambre -= raciones * 4
        }
    }
    
    object comestibleBalanceada : comestible {
    
        override fun afectarHambreDe(gary : gary, raciones : Int){
            gary.hambre -= raciones * 3
        }
    }
```

#### Tests
##### En Kotlin
Vamos a dejar el REPL de lado y vamos a comenzar a hacer un par de tests unitarios con la ayuda de JUnit.
Para ello vamos a crear una Clase (se debe recordar que por ahora no nos interesa saber qué son las clases) que se llame, por ejemplo, GaryTest y dentro de ella vamos a escribir métodos que nos ayudarán a testear nuestra implementación de Gary.

Comencemos haciendo caminar a Gary para que tenga más hambre:

```kotlin
    package domain
    import org.junit.Test
    import org.junit.Assert.*
    
    class GaryTest {
    
        @Test
        fun camina() {
            gary.camina(100)
            assertEquals(9, gary.energia)
            assertEquals(14, gary.hambre)
        }
    }
```

En este caso, estamos haciendo caminar a gary 100 metros. Tal como en los tests de la iteración anterior, gary debería quedar con 9 puntos de energía y 14 puntos de hambre.  Vamos a asegurarnos que así sea utilizando los métodos `assertEquals(9, gary.energia)` y `assertEquals(14, gary.hambre)`. 
Es bastante entendible lo que hace el método `assertEquals` por el nombre que lleva, pero resumidamente diremos que:
- El test  "pasa" (color verde) cuando el primer parámetro es igual al segundo parámetro; siendo el primero de ellos el valor esperado y el segundo el valor real obtenido.
- El test "no pasa" (color rojo) cuando el primer parámetro es distinto al segundo parámetro.

¿Qué significa que un test "pase" o "no pase"?
- Si el test "pasa", significa que nuestros objetos están haciendo lo que realmente queríamos que hagan; es decir, se comportan de la forma esperada.
- Si el test "no pasa", significa que nuestros objetos no están haciendo lo que queríamos que hagan (no se comportan como deberían hacerlo) y que hay un problema de lógica (modelado de dominio) o de implementación (me pude haber olvidado algún signo, restado algún valor mal, etc.).

Pero que el test "pase" no significa, de ninguna manera,  que lo que hice está bien diseñado y que es la mejor solución. Solo me da una idea de que mi solución e  implementación responden al dominio presentado.

No se debe pasar por alto el `@Test` que se escribe justo arriba de nuestro método de testeo. Esta anotación sirve para indicar que nuestro método será un Test y que deberá ser ejecutado como una prueba más. Si nos olvidamos de esta anotación, el método nunca se ejecutará y por lo tanto no sabemos si las cosas que se testean allí dentro estan bien o mal.

Otra cosa que vamos a tener que recordar es que en una misma clase se pueden escribir muchos métodos de testeo, los cuales se ejecutarán en orden alfabético. Tenemos que tener mucho cuidado con esto, por lo menos por ahora, ya que cada test está tocando al mismo objeto y por lo tanto los resultados del test N dependerán de los resultados de la ejecución del test N-1.

Ahora sí, demosle de comer 1 ración Ceso a gary:

```kotlin
    package domain
    import org.junit.Test
    import org.junit.Assert.*
    
    class GaryTest {
    
        @Test
        fun camina() {
            gary.camina(100)
            assertEquals(9, gary.energia)
            assertEquals(14, gary.hambre)
        }
    
        @Test
        fun comeCeso(){
            gary.come(1, ceso)
            assertEquals(12, gary.hambre)
        }
    }
```

¿Por qué 12? Porque por orden alfabético, Gary prmero caminará 100 metros (método `camina()`). Cuando camina 100 metros, disminuye su energía en 1 punto y su hambre en 4 puntos (no olvidemos que gary comienza con 10 puntos de energía y de hambre). Luego comerá ceso (método `comeCeso()`) y cada ración de ceso le quita el doble de puntos de hambre.

##### En Java
El código equivalente de los tests planteados en la sección anterior sería:
```java
package domain;
import org.junit.Assert;
import org.junit.Test;

public class GaryJavaTest {
    
    @Test
    public void camina(){
        gary gary = domain.gary.INSTANCE;
        gary.camina(100);
        Assert.assertEquals(9, gary.getEnergia());
        Assert.assertEquals(14, gary.getHambre());
    }

    @Test
    public void comeCeso(){
        gary gary = domain.gary.INSTANCE;
        gary.come(1, ceso.INSTANCE);
        Assert.assertEquals(12, gary.getHambre());
    }
}
```
## Otras cuestiones
### Entorno de desarrollo
Se necesitan tener instalados los siguientes componentes:
- [JDK Java 8](https://www.java.com/es/download/ "JDK Java 8")
- [ Maven](https://maven.apache.org/download.cgi " Maven")
- [IntelliJ Communty Version](https://www.jetbrains.com/idea/download/#section=windows "IntelliJ Communty Version")

### ¿Qué es un REPL?
La palabra REPL significa "Read-Eval-Print-Loop", que si lo traducimos sería "bucle Lectura-Evaluación-Impresión". Es un entorno interactivo de programación que toma entradas de un solo usuario (es decir, expresiones únicas), las evalúa y devuelve el resultado.
Nos será de gran ayuda contar con esta herramienta para probar ciertas cosas y entender mejor los conceptos.
Cabe aclarar que no todos los lenguajes disponen de estos entornos.

### ¿Querés jugar un poco más con Gary?
Podés clonarte el repositorio y luego tendrás que seguir los siguientes pasos:
- Abrí una terminal y situate sobre el directorio raíz del proyecto que te acabás de clonar.
- Escribí en la terminal `mvn idea:clean`
- Luego escribí `mvn idea:idea`
- Ahora sí ya estás en condiciones de abrir IntelliJ e ir a `File -> Open` y buscar la carpeta donde clonaste el repositorio
- ¡Listo! Podés empezar a cambiar el comportamiento de Gary, crear tests, etc.

