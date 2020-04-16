#  Gary - Seguimos avanzando en el Paradigma Orientado a Objetos
**Índice**
- [Paradigma orientado a Objetos](#paradigma-orientado-a-objetos)
    - [Principios](#principios)
        - [Objeto](#objeto)
        - [Mensajes y métodos](#mensajes-y-métodos)
        - [Atributos](#atributos)
        - [Interface](#interface)
- [Gary](#gary)
    - [Cuarta iteración](#cuarta-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Kotlin
    - [Quinta iteración](#quinta-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Kotlin
    - [Sexta iteración](#sexta-iteración)
        - Dominio
        - Diseño en objetos
        - Implementación
        - Tests
            - En Kotlin

### Paradigma orientado a Objetos
#### Estado
Ya hemos dicho, en la explicación anterior, que un objeto tiene características que le pertenecen y que lo diferencian del resto. Estas características se conocen como atributos. Al conjunto de atributos que tiene un objeto se lo conoce como estado interno. Y como los atributos son variables, también podríamos afirmar que el estado interno es el conjunto de variables que contiene un objeto.

#### Comportamiento
En la jerga cotidiana se suelen escuchar preguntas como: ¿cuál es el comportamiento de este objeto? ¿qué hace? ¿para qué existe?
Al conjunto de mensajes que entiende un objeto se lo conoce como *comportamiento*. 
El comportamiento que tiene un objeto está ligado con la responsabilidad que le dá sentido de existencia.

#### Responsabilidad
Cuando vamos a un kiosko a comprar golosinas, ¿qué deberíamos hacer para conseguirlas? Siendo respetuosos, deberíamos pedírselas al kioskero. El kioskero debería agarrar aquellas golosinas que le hayamos indicado y luego debería cobrarnos. Una vez que entreguemos el dinero, el kioskero nos debería dar la bolsita con las golosinas. 
Si tuviéramos que modelar este pequeño dominio, ¿qué objetos identificaríamos? En principio, Cliente, Kioskero y Golosina (sin importancia por el momento). 
¿Y qué responsabilidad tendría cada uno? El Cliente tendría la responsabilidad de pedirle al kioskero una o varias golosinas. El kioskero debería buscar las golosinas y luego cobrarle al cliente. El cliente debería pagar por la compra.
¿Qué acabamos de hacer? Establecimos las responsabilidades principales a nuestros objetos.
Cada objeto debería tener una responsabilidad asociada, una razón de ser, algo que resolver.
Un objeto no debería tener muchas responsabilidades asociadas porque ello llevaría a que se vuelva inmantenible. Si un objeto tiene muchas responsabilidades, probablemente no hayamos modelado bien el dominio y todavía tengamos más abstracciones por encontrar.

#### Encapsulamiento
Este término hace referencia a que un objeto no debería saber cómo está implementado otro objeto que conoce. En otras palabras, un objeto A debería solamente conocer los mensajes que puede enviarle a un objeto B, pero no debería saber la implementación de los métodos que se ejecutan cuando le envía un mensaje.
Tampoco se debería dar a conocer el estado interno de un objeto. Un objeto A no debería acceder directamente a los atributos de un objeto B, porque si lo hiciera de esa forma, A estaría conociendo exactamente las cosas que tiene B.
Las formas posibles interactuar con un objeto deberían ser acotadas y explícitas y es por eso que el objeto debe definir qué mensajes se deberían utilizar para interactuar con él.

Pero... ¿por qué existe este concepto? Supongamos que estamos modelando un objeto A y los objetos B, C y D que lo conocen y usan. Todos los objetos que conocen a A acceden a un atributo de él de forma directa. ¿Qué pasa si necesito hacer un cambio en A que involucra tocar sus atributos? Mis objetos B, C y D se verían impactados en sus implementaciones por un cambio en la implementación de A. Cuando sucede esto, se dice que los objetos están** acoplados**.

¿Cómo lo aplico?
- Utiliando los ***accessors*** que nos provee el lenguaje de programación en el que estemos codeando. ¿Qué son los accessors? Los accessors son definiciones que acompañan a los atributos de los objetos para especificar si los mismos serán *privados*, *públicos* o* protegidos*.  Si un atributo está anotado como privado, solamente el objeto dueño de ese atributo podrá acceder a él. En cambio, si está anotado como público, cualquier otro objeto podrá tener acceso a él. Por el momento no nos interesa el accessor protegido.
Por ejemplo, hagamos algún atributo de Gary privado:

    ```kotlin
    object gary {
        private var color : String? = "Naranja"
    }
    ```
Pero no solamente  se pueden utilizar para los atributos sino que también valen para los métodos. Por ejemplo, ¿cómo hacemos para preguntarle de qué color es el pelaje de Gary si no tenemos posibilidad de acceder desde afuera (porque su atributo es privado)?

    ```kotlin
    object gary {
        private var color : String? = "Naranja"
        
        public fun getColor() : String? {
            return this.color
        }
    }
    ```
Lo cierto es que, por defecto, todo es público. Es decir, si dejamos sin especificar el *public* será público de todas formas (vale tanto para atributos como para métodos).

- Evitando acceder directamente a atributos de otros objetos.
- Evitando conocer demasiado a otros objetos. "Conocer demasiado" implica saber exactamente cómo funciona, estar acoplados.

#### Declaratividad
Una primera, y suficiente por ahora, aproximación a este concepto nos dice que debemos **pensar en el qué y no en el cómo**. Deberíamos dejar de pensar los problemas algoritmicamente, imperativamente, y comenzar a concentrarnos en lo que realmente necesitamos.
Para aplicar este concepto en el paradigma orienta a objetos deberíamos pensar qué objetos necesitamos para resolver el dominio presentado, qué mensajes deberían entender, qué responsabilidades deberían tener.
Este concepto se verá reflejado y remarcado en la resolución del ejercicio que nos acontece.
#### Programa objetos
El paradigma orientado a objetos nos hace pensar a nuestro programa como un conjunto de objetos que se relacionan entre sí (se envían mensajes) para resolver ciertas cuestiones del dominio. Dejamos de tener procedimientos, estructuras de datos, líneas inmensas e inmantenibles de código, para tener un conjunto de objetos que se encarguen de realizar ciertas tareas.
Nuestros objetos viven en un **ambiente** donde se conocen y se pueden enviar mensajes. Allí, en el ambiente, todos los objetos permanecen vivos mientras alguien tenga una referencia a ellos.
#### Delegación
Este térmido es conocido como "**patear la pelota**" y viene de la mano con la declaratividad, la cual nos pide que pensemos en el qué y no en el cómo. Las preguntas que deberían surgirnos son:
- ¿Qué es patear la pelota? Patear la pelota signifca hacer las cosas (calcularlas/obtenerlas/pedirlas) cuando realmente las necesitamos.
- ¿A quién se la pateamos? Puede ser al mismo objeto u otro objeto. 
- ¿Qué le pateamos? ¡La pelota obvio! ¿Pero qué es la pelota?  Como dijimos, todo lo que necesitemos calcular, hacer, pedir. Pateamos *responsabilidades*.

Veamos un ejemplo.
¿Qué hacía gary cuando caminaba? *Cuando Gary camina, disminuye su energía en 1 unidad por cada 70 metros y aumenta su hambre en 2 unidades por cada 40 metros.*
Nuestra implementación fue:
```kotlin
object gary {
        var hambre : Int = 10
        var energia : Int = 10

        fun camina(unosMetros : Int){
            this.energia -= 1 * (unosMetros/70)
            this.hambre += 2 * (unosMetros/40)
        }
    }
```
¿Y cuándo duerme? *Sabemos que cuando Gary duerme recupera dos puntos de energía por cada 30 minutos que durmió.*

```kotlin
object gary {
        var hambre : Int = 10
        var energia : Int = 10
        
        fun dormi(unosMinutos : Int){
            this.energia += 2 * (unosMinutos/30)
        }
        
        fun camina(unosMetros : Int){
            this.energia -= 1 * (unosMetros/70)
            this.hambre += 2 * (unosMetros/40)
        }
    }
```
¿Pero qué estamos haciendo realmente? Aumentando el hambre y disminuyendo la energía. ¡Patiemos la pelota entonces! ¿A quién? A Gary, pero a otro método que se encargue de aumentar/disminuir estos atributos.
```kotlin
object gary {
        var hambre : Int = 10
        var energia : Int = 10
        
        fun aumentarHambreEn(algunasUnidades : Int){
            this.hambre += algunasUnidades
        }

        fun disminuirEnergiaEn(algunasUnidades: Int){
            this.energia -= algunasUnidades
     }
    
        fun aumentarEnergiaEn(algunasUnidades : Int){
            this.energia += algunasUnidades
        }
    
        fun dormi(unosMinutos : Int){
            aumentarEnergiaEn(2 * (unosMinutos/30))
     }
    
        fun camina(unosMetros : Int){
            disminuirEnergiaEn(unosMetros/70)
            aumentarHambreEn(2 * (unosMetros/40))
        }
    }
```
Muy sencillo en este caso, ¿no?
#### Identidad vs Igualdad

## Gary
### Cuarta iteración
#### Dominio
Hasta ahora sabíamos que a Gary le gustaba salir a caminar. ¿A dónde va cuando camina?
Gary siempre ronda por los mismos lugares:
- *Habitación*: se encuentra en el punto (x,y) = (14,10) de la casa donde vive.
- *Cocina*: se encuentra en el punto (x,y) = (4,30) de la casa.
- *La casa del vecino*: se encuentra en el punto (x,y) = (180,5) con respecto a la puerta de la casa donde vive Gary.

Además, sabemos que cada vez que Gary camina hacia la habitación, el desorden del cuarto aumenta en un punto.  Cuando va hacia la cocina, la cantidad de pelos que tiene este lugar se duplica. El vecino de Gary cuenta las veces que este gatito lo visitó.

#### Diseño en objetos
Como el dominio nos plantea, por ahora solo sabíamos que Gary salía a caminar pero no a dónde. ¿Cuáles son estos lugares? La habitación, la cocina y la casa del vecino.
Si prestamos un poco de atención, fácilmente podemos darnos cuenta que estos lugares tienen algo que los caracteriza, como la ubicación. Además, sabemos exactamente qué sucede cuando Gary visita a cada uno de ellos; es decir, podemos identificar un comportamiento en cada una de estas abstracciones.  ¡Opa! ¿Qué acabo de decir? ¡Abstracciones! Acabamos de encontrar nuevos objetos para modelar, y ellos son:
- **Habitación**: deberá tener un atributo ubicación y entender algún mensaje para que Gary lo visite. Cuando éste lo visite, deberá aumentar el desorden; por lo que el desorden también deberá ser un atributo.
- **Cocina**: también deberá tener un atributo ubicación y también deberá entender algún mensaje para que Gary lo visite. Cuando esto suceda, habrá que duplicar la cantidad de pelos; por lo que la cantidad de pelos deberá ser un atributo.
- **La casa del vecino**:  al igual que la habitación y la cocina, también deberá tener una ubicación y entender el mismo mensaje que estos objetos. Cuando Gary lo visite solo se deberá incrementar el contador de "visitas", por lo que éste deberá ser un atributo.

Pero... pensemos en el mensaje principal que deberá entender Gary. Este mensaje podría ser del estilo `fun caminaHacia(unLugar : ???)`. ¿Cómo lo resolvemos?
Ya nos hemos chocado con un problema parecido al querer modelar las comidas y lo resolvimos con una interface. ¿Por qué no usar la misma estrategia?

¿Y qué pasa cuando Gary camina? Se debería desplazar e ir a ese lugar. Pero si recordamos, cada vez que camina disminuye su energía y aumenta su hambre. Para acotar el dominio, haremos que Gary se desplace con movimientos rectos: si el está en la posición (0,0) y tiene que ir a la cocina, entonces primero avanzará a (4,0) y luego a (4,30)

Tenemos todo pensado. ¡Manos a la obra!

#### Implementación
Comencemos por crear nuestra interface. ¿Cómo podríamos llamarla? Un buen nombre podría ser `lugarVisitable`. ¿Y qué mensajes pondríamos en ella para que todos los lugares entiendan? Pensemos en lo que gary debería hacer cuando alguien le dice `caminaHacia(unLugar : lugarVisitable)`
```kotlin
object gary {

        fun caminaHacia(unLugar : lugarVisitable){
            unLugar.serVisitadoPorGary()
            desplazarEnEjeXHacia(unLugar)
            desplazarEnEjeYHacia(unLugar)
     }
}
```
¡Claro! El lugar necesita enterarse que está siendo visitado por Gary, y a su vez, Gary necesita desplazarse hasta dicho lugar. ¿Y cómo se desplaza? Veamos:
```kotlin
object gary {
    private var posicionX : Int = 0
    private var posicionY : Int = 0
    
    private fun desplazarEnEjeXHacia(unLugar: lugarVisitable){
        var unParDeMetrosEnX = unLugar.distanciaXHacia(this.posicionX)
        this.posicionX = unLugar.getPosicionX()
        camina(unParDeMetrosEnX)
    }

    private fun desplazarEnEjeYHacia(unLugar: lugarVisitable){
        var unParDeMetrosEnY = unLugar.distanciaYHacia(this.posicionY)
        this.posicionY = unLugar.getPosiconY()
        camina(unParDeMetrosEnY)
    }
}
```
Entonces ya tenemos todo lo que necesitamos definir en nuestra interface. Ésta deberá quedar así:
```kotlin
interface lugarVisitable {
    fun serVisitadoPorGary()
    fun distanciaXHacia(otroPunto: Int) : Int
    fun distanciaYHacia(otroPunto : Int) : Int
    fun getPosicionX() : Int
    fun getPosiconY() : Int
}
```

Ahora nos queda definir nuestros lugares. Comencemos por la casa del vecino:

```kotlin
object casaDelVecino : lugarVisitable {

    private var cantidadVisitasGary : Int = 0
    private var posicionX : Int = 180
    private var posicionY : Int = 5

    override fun getPosicionX(): Int {
        return this.posicionX
    }

    override fun getPosiconY(): Int {
        return this.posicionY
    }

    override fun serVisitadoPorGary() {
        this.cantidadVisitasGary++;
    }

    fun distanciaAbsolutaEntre(unPunto : Int, otroPunto: Int) : Int{
        return abs(unPunto - otroPunto)
    }

    override fun distanciaXHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionX, otroPunto)
    }

    override fun distanciaYHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionY, otroPunto)
    }
}
```
La cocina:
```kotlin
object cocina : lugarVisitable {
    private var pelos : Int = 1
    private var posicionX : Int = 4
    private var posicionY : Int = 30

    override fun getPosicionX(): Int {
        return this.posicionX
    }

    override fun getPosiconY(): Int {
        return this.posicionY
    }

    override fun serVisitadoPorGary() {
        this.pelos *= 2
    }

    fun distanciaAbsolutaEntre(unPunto : Int, otroPunto: Int) : Int{
        return abs(unPunto - otroPunto)
    }

    override fun distanciaXHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionX, otroPunto)
    }

    override fun distanciaYHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionY, otroPunto)
    }
}
```
Y por último la habitación:
```kotlin
object habitacion : lugarVisitable {
    private var desorden :  Int = 0
    private var posicionX : Int = 14
    private var posicionY : Int = 10

    override fun getPosicionX(): Int {
        return this.posicionX
    }

    override fun getPosiconY(): Int {
        return this.posicionY
    }

    override fun serVisitadoPorGary() {
        this.desorden++
    }

    fun distanciaAbsolutaEntre(unPunto : Int, otroPunto: Int) : Int{
        return abs(unPunto - otroPunto)
    }

    override fun distanciaXHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionX, otroPunto)
    }

    override fun distanciaYHacia(otroPunto: Int) : Int {
        return this.distanciaAbsolutaEntre(this.posicionY, otroPunto)
    }
}
```

¡Todos muy sencillos! Pero podemos detectar algo a simple vista... ¡Estamos repitiendo lógica en todos los lugares! Los métodos `distanciaAbsolutaEntre(unPunto : Int, otroPunto: Int) : Int`, `distanciaXHacia(otroPunto: Int) : Int` y `distanciaYHacia(otroPunto: Int) : Int` son exactamente iguales en todos los lugares. Esto no es muy escalable y tampoco  muy mantenible. ¿Cómo lo solucionamos? En el próximo repositorio nos encargaremos de atacar estos problemas. Por el momento, aceptaremos hacerlo así.
#### Tests
##### En Kotlin
Vamos a hacer que Gary visite los tres lugares en el mismo tests. Verifiquemos si cada uno de los lugares se ve afectado por esta visita.
```kotlin
@Test
    fun garyVisitaLugares(){
        gary.caminaHacia(cocina)
        assertEquals(2, cocina.cantidadDePelos())
        assertEquals(10, gary.getEnergia())
        assertEquals(10, gary.getHambre())

        gary.caminaHacia(habitacion)
        assertEquals(1, habitacion.desordenTotal())

        gary.caminaHacia(casaDelVecino)
        assertEquals(8, gary.getEnergia())
        assertEquals(18, gary.getHambre())
        assertEquals(1, casaDelVecino.cantidadDeVecesVisitado())
    }
```
### Quinta iteración
#### Dominio
Gary es un gato muy friolento y cuando está medio fresco siempre quiere que lo abriguen. Su dueño le ha comprado algunos abrigos:
- *Buso*: cuando Gary se pone un buso, su temperatura corporal aumenta en medio grado Celsius.
- *Capa*: aumenta la temperatura corporal en la décima parte de un grado Celsius.
- *Chaqueta de jean*: aumenta la temperatura corporal en la cuarta parte de un grado Celsius.

#### Diseño en objetos
Pensemos, primero que nada, en lo que podríamos decirle a Gary: `gary.abrigateCon(buso)` podría ser una línea válida, ¿no? Al igual que `gary.sacateElAbrigo()`.

Como cada prenda influye en el gato de una forma distinta, podríamos pensar a cada una de ellas como un objeto distinto. De esta forma, volvemos a caer en un problema similar al anterior: `fun abrigateCon(unaPrenda : ???)`. ¿Cómo lo resolvemos? ¡Interface! Podríamos llamarla `prendaAbrigable` y debería definir, por lo menos, dos mensajes: `abrigarA(gary : gary)` y `quitateDe(gary : gary)`

¿Qué hacen estas prendas cuándo abrigan a Gary? Generan un aumento en la temperatura corporal. Dicho esto, vamos a necesitar agregar un atributo en Gary que lleve el registro de su temperatura.

Además, es necesario que Gary sepa si está abrigado o no. Para solucionar esto, podemos pensar en dos alternativas principales:
1. Un atributo de tipo booleano que apunte a True cuando alguien le dice que se abrigue, y que cambie a False cuando alguien le dice que se saque el abrigo.
2. Un atributo que apunte a la prenda que tiene puesto o a Null en caso de no tener ninguna.

#### Implementación
Comencemos por definir la interface `prendaAbrigable`
```kotlin
interface prendaAbrigable {
    fun abrigarA(gary : gary)
    fun quitateDe(gary : gary)
}
```

Ahora veamos cómo Gary debería usar estos abrigos. Definamos los métodos `abrigateCon` y `sacateElAbrigo`:
```kotlin
object gary {
    private var prenda : prendaAbrigable? = null
    
    fun abrigateCon(unaPrenda : prendaAbrigable){
        this.prenda = unaPrenda
        unaPrenda.abrigarA(this)
    }
    
    fun sacateElAbrigo(){
        this.prenda!!.quitateDe(this)
        this.prenda = null
    }
}
```
Para tener en cuenta:
- Cuando un atributo puede apuntar a un objeto en particular o a null, al momento de usuarlo (llamarlo/enviarle un mensaje) debemos hacer *una llamada segura*. Esto se hace poniendo los sigos **!!** como se puede ver en el método `sacateElAbrigo()`

Ahora definamos nuestras prendas.

```kotlin
object buso : prendaAbrigable {

    override fun abrigarA(gary: gary) {
        gary.aumentarTemperaturaCorporalEn(0.5)
    }

    override fun quitateDe(gary: gary) {
        gary.disminuirTemperaturaCorporalEn(0.5)
    }
}
```

```kotlin
object chaquetaDeJean : prendaAbrigable {

    override fun abrigarA(gary: gary) {
        gary.aumentarTemperaturaCorporalEn(0.4)
    }

    override fun quitateDe(gary: gary) {
        gary.disminuirTemperaturaCorporalEn(0.4)
    }
}
```

```kotlin
object capa : prendaAbrigable {

    override fun abrigarA(gary: gary) {
        gary.aumentarTemperaturaCorporalEn(0.1)
    }

    override fun quitateDe(gary: gary) {
        gary.disminuirTemperaturaCorporalEn(0.1)
    }
}
```

Gary necesita entender los mensajes `aumentarTemperaturaCorporalEn(algunasUnidades: Double)` y `disminuirTemperaturaCorporalEn(algunasUnidades: Double)`. ¡Hagamoslo!

```kotlin
object gary {
    private var temperaturaCorporalActual : Double = 37.0
    
    fun aumentarTemperaturaCorporalEn(algunasUnidades: Double){
        this.temperaturaCorporalActual += algunasUnidades
    }

    fun disminuirTemperaturaCorporalEn(algunasUnidades: Double){
        this.temperaturaCorporalActual -= algunasUnidades
    }
}
```

#### Tests
##### En Kotlin
Iremos abrigando a Gary, verificando si su temperatura aumenta. Luego le sacaremos el abrigo y volveremos a verificar si su temperatura disminuye.
Probaremos a todos los abrigos en el mismo test.

```kotlin
@Test
    fun garyAbrigate() {
        gary.abrigateCon(buso)
        assertEquals(37.5, gary.getTemperaturaCorporal())

        gary.sacateElAbrigo()
        assertEquals(37.0, gary.getTemperaturaCorporal())

        gary.abrigateCon(capa)
        assertEquals(37.1, gary.getTemperaturaCorporal())

        gary.sacateElAbrigo()
        assertEquals(37.0, gary.getTemperaturaCorporal())

        gary.abrigateCon(chaquetaDeJean)
        assertEquals(37.4, gary.getTemperaturaCorporal())

        gary.sacateElAbrigo()
        assertEquals(37.0, gary.getTemperaturaCorporal())
    }
```
### Sexta iteración
#### Dominio
Gary tiene dos juguetes:
- *Ratón*: cada vez que Gary juega con el ratón, su nivel de diversión aumenta en 10 puntos.
- *Bola de lana*: incrementa en 5 el nivel de diversión.

Pero Gary es un gato muy bipolar. Si lo mandás a jugar más de 5 veces seguidas, se cansa. Cuando está cansado, no te hace caso si le decís que juegue con su ratón o con su bola de lana. Para que vuelva a jugar, hay que mandarlo a dormir por, al menos, 30 minutos de corrido.

#### Diseño en objetos
Ahora, ¿qué podemos decirle a Gary? `gary.jugaCon(raton)` o `gary.jugaCon(bolaDeLana)` deberían ser dos sentencias válidas, ¿no?
Si definimos la firma de este mensaje vamos a necesitar, nuevamente, modelar una interface que podríamos llamar `juguete`.  A su vez, el mensaje que debería definir esta interface sería `jugarCon(gary : gary)`.
Tanto el ratón como la bola de lana incrementan el nivel de diversión de Gary; entonces, necesitamos definir un atributo `diversion` en Gary. Es suficiente, por el momento, modelar a este atributo como de tipo `Int`.

¿Pero qué sucede si le decimos que juegue 5 veces o más? Se cansa y no juega más. Lo primero que, seguramente, se nos ocurre es hacer algo en Gary del estilo:

```kotlin
fun jugarCon(unjuguete: juguete){
        if (cantidadVecesJugadas => 5)
        ........
}
```
Pero hacer esto no es muy escalable. ¿Qué sucedería si Gary comienza a comportarse distinto a medida que juega más veces? Tendríamos un if por cada condición. Esto nos llevaría a que Gary se vuelva cada vez más inmantenible.
¿Cómo lo podemos solucionar? Podríamos generar un objeto por cada uno de los estados de Gary.  ¿Estados? ¡Claro! Gary reacciona de diferente forma dependiendo si está cansado o descansado. Como reacciona de diferente forma, podríamos cosificar estos conceptos en objetos. Por este motivo, vamos a necesitar modelar dos objetos más: `descansado` y `cansado`. Ambos compartirán una interface con el método `jugarCon(unJuguete : juguete, gary: gary)`. A la interface la llamaremos `estado`.

Todo listo. ¡Vamos!
#### Implementación
Comencemos definiendo la interface y los juguetes.

```kotlin
interface juguete {
    fun jugarCon(gary : gary)
}
```

```kotlin
object raton : juguete {

    override fun jugarCon(gary: gary) {
        gary.aumentarDiversionEn(10)
    }
}
```

```kotlin
object bolaDeLana : juguete {

    override fun jugarCon(gary: gary) {
        gary.aumentarDiversionEn(5)
    }
}
```
Tenemos que definir el método `aumentarDiversionEn(algunasUnidades: Int)` en Gary. Vamos a ese paso:
```kotlin
object gary {
    private var diversion : Int = 0
    
    fun aumentarDiversionEn(algunasUnidades: Int){
        this.diversion += algunasUnidades
    }
}
```
Y ahora vayamos al método principal `jugarCon(unjuguete: juguete)`

```kotlin
object gary {
    private var estado : estado = descansado
    
    fun jugarCon(unjuguete: juguete){
        this.estado.jugarCon(unjuguete, this)
    }
}
```
¿Qué acabamos de hacer en el método principal? Decidimos patear la pelota al estado de Gary para que ellos decidan qué hacer frente a la petición de `jugar`. Definamos, entonces, la interface `estado`:

```kotlin
interface estado {
    fun jugarCon(unjuguete: juguete, gary : gary)
}
```
Las implementaciones de `cansado` y `descansado` serán:
```kotlin
object cansado : estado {
    override fun jugarCon(unjuguete: juguete, gary: gary) {

    }
}
```
```kotlin
object descansado : estado {
    private var cantidadDeVecesJugadas : Int = 0

    override fun jugarCon(unjuguete: juguete, gary: gary) {
        this.cantidadDeVecesJugadas++
        unjuguete.jugarCon(gary)
        verificarCansancioDe(gary)
    }

    private fun verificarCansancioDe(gary: gary){
        if (this.cantidadDeVecesJugadas >= 5){
            gary.setEstado(cansado)
            resetearContador()
        }
    }

    private fun resetearContador(){
        this.cantidadDeVecesJugadas = 0
    }
}
```
¿Por qué el método `jugarCon` de `cansado` está vacío? Porque cuando Gary está cansado no juega, no hace nada. Entiende el mensaje, pero no hace nada, no responde a él.
Mucha atención al método `verificarCansancioDe(gary: gary)`: allí establecemos cuándo estará cansado. Cuando el contador de veces jugadas sea igual o mayor a 5, llevamores a Gary al estado `cansado`. ¿Pero cómo salimos de él? El dominio nos planteaba: *"Para que vuelva a jugar, hay que mandarlo a dormir por, al menos, 30 minutos de corrido"*. Vamos a tener que retocar el método `dormi` que entendía Gary y también nuestra interface `estado`.

```kotlin
object gary {
    private var energia : Int = 10
    private var estado : estado = descansado
    
    fun dormi(unosMinutos : Int){
        this.energia += 2 * (unosMinutos/30)
        this.estado.dormir(unosMinutos, this)
    }
}
```

```kotlin
interface estado {
    fun jugarCon(unjuguete: juguete, gary : gary)
    fun dormir(unosMinutos : Int, gary: gary)
}
```
Está cansado y lo mandan a dormir 30 minutos o más, ¿sigue cansado? No. Vayamos por eso entonces:
```kotlin
object cansado : estado {

    override fun dormir(unosMinutos: Int, gary: gary) {
        if (unosMinutos >= 30)
            gary.setEstado(descansado)
    }

    override fun jugarCon(unjuguete: juguete, gary: gary) {

    }
}
```
Y en `descansado` el método `dormir` quedará, también, vacío:
```kotlin
object descansado : estado {

    override fun dormir(unosMinutos: Int, gary: gary) {

    }
}
```
#### Tests
##### En Kotlin
Vamos a plantear dos test:
- En uno de ellos haremos jugar 6 veces a Gary y él debería parar de hacerlo a la 5ta vez. Nos daremos cuenta cuando preguntemos por su nivel de diversión
- En el otro, haremos jugar a Gary, pero como estará relacionado al test anterior, no debería responder (no sumará nivel de diversión). Luego, lo haremos dormir y volveremos a jugar.

```kotlin
    @Test
    fun garyJugaConRatonYAburrite(){
        gary.jugarCon(raton)
        gary.jugarCon(raton)
        gary.jugarCon(raton)
        gary.jugarCon(raton)
        gary.jugarCon(raton)
        gary.jugarCon(raton)
        assertEquals(50, gary.getDiversion())
    }

    @Test
    fun garyJugaLuegoDesaburrite() {
        gary.jugarCon(raton)
        assertEquals(50, gary.getDiversion())

        gary.dormi(30)
        gary.jugarCon(raton)
        assertEquals(60, gary.getDiversion())
    }
```
