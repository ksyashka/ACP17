package multithreads;


public class ChickenVoice {
    static EggVoice anotherOpinion;

    public static void main(String[] args) {
        anotherOpinion = new EggVoice();

        System.out.println("Discuss is starting!");

        anotherOpinion.start();

        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chicken!");
        }
        if (anotherOpinion.isAlive())    //Если оппонент еще не сказал последнее слово
        {
            try {
                anotherOpinion.join();    //Подождать пока оппонент закончит высказываться.
            } catch (InterruptedException e) {}

            System.out.println("First was egg!");
        } else    //если оппонент уже закончил высказываться
        {
            System.out.println("First was chicken");
        }
        System.out.println("Discuss is over!");
    }
}


