package ar.com.scriptorum.threads.multithreading;

public class Deadlock {
    static class Vecino {
    	static Object lock = new Object();
        private final String nombre;
        public Vecino(String nombre) {
            this.nombre = nombre;
        }
        public String getNombre() {
            return this.nombre;
        }
        public synchronized void saluda(Vecino vecino) {
        	//synchronized(lock) {
            System.out.format("%s:¡Buen dia %s"
                + "! %n", 
                this.nombre, vecino.getNombre());
            vecino.responder(this);
        	//}
        	
        	
        }
        public synchronized void responder(Vecino vecino) {
            //synchronized(lock) {
        	System.out.format("%s: ¡Buen dia %s"
                + "!%n",
                this.nombre, vecino.getNombre());
            //}
        }
    }

    public static void main(String[] args) {
        final Vecino jose =
            new Vecino("Jose");
        final Vecino gaston =
            new Vecino("Gaston");
        final Vecino olga =
            new Vecino("Olga");
        new Thread(new Runnable() {
            public void run() { jose.saluda(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.saluda(jose); }
        }).start();
        new Thread(new Runnable() {
            public void run() { jose.saluda(olga); }
        }).start();
        
        new Thread(new Runnable() {
            public void run() { gaston.saluda(olga); }
        }).start();
    }
}