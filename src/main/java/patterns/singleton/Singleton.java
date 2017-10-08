package patterns.singleton;
/*
public class Singleton {
    //можно создать экземпляр заранее, если он не рет много рессурсов
    //private static Singleton uniqueInstance = new Singleton();
    private static Singleton uniqueInstance;

    private Singleton(){};

    //решение для многопоточности,но трудозатратно, актуально только для первого создания
    //public synchronized static Singleton getInstance(){
    public static Singleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}*/

//3 метод решения проблемы с многопоточностью
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){};

    public static Singleton getInstance(){
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }
}