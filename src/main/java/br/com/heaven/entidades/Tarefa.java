package br.com.heaven.entidades;

public class Tarefa implements Runnable {
    String tarefaNome; 
    public Tarefa(int tarefaNumero) {
        this.tarefaNome = "Tarefa n. " + String.valueOf(tarefaNumero);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        long y = 1;
        try {
            Thread.sleep(3000);
            for (long x = 1; x < 1000000; x++) {
                if (y==1000||x==999999) {
                    System.out.println(this.tarefaNome + " -> " + String.valueOf(x));
                    y = 1;
                }else{
                    y++;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
