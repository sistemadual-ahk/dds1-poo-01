package domain;

public class DemoMain {

    public static void main(String[] args) {
        gary gary = domain.gary.INSTANCE;

        System.out.println("gary en este momento tiene "+ gary.getHambre()+" puntos de hambre");
        System.out.println("También tiene "+ gary.getEnergia()+" puntos de energia");
        System.out.println("Es un gato de color "+ gary.getColor());

        gary.come(2);
        gary.dormi(45);
        System.out.println("Después de darle 2 raciones de comida tiene "+gary.getHambre()+" puntos de hambre");
        System.out.println("Y luego de dormir 45 minutos tiene "+gary.getEnergia() +" de energia");
    }
}
