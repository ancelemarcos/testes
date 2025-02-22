package br.com.heaven.entidades;

import javax.servlet.ServletContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Tarefa implements Runnable {
    String tarefaNome;
    long tarefaTempo;
    ServletContext sce;
    public Tarefa(int tarefaNumero, int multiplicador, ServletContext pSce) {
        this.tarefaNome = "Tarefa n. " + String.valueOf(tarefaNumero);
        this.tarefaTempo = 1000L * multiplicador;
        this.sce = pSce;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        ExecutorService executor = (ExecutorService) this.sce.getAttribute("executorService");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        long y = 1;
        try {
            System.out.println("VAI ESPERAR..> " + this.tarefaTempo);
            Thread.sleep(this.tarefaTempo);
            for (long x = 1; x < 1000000; x++) {
                if (y==1000||x==999999) {
                    //System.out.println(Thread.currentThread().getName() + " -> " + String.valueOf(x));
                    y = 1;
                }else{
                    y++;
                }
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("Threads em uso...> " + threadPoolExecutor.getActiveCount());
            System.out.println("Threads ativas: " + threadPoolExecutor.getActiveCount());
            System.out.println("Tarefas completadas: " + threadPoolExecutor.getCompletedTaskCount());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
