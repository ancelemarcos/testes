package br.com.heaven.entidades;

import javax.servlet.ServletContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tarefa implements Runnable {
    private static final Logger logger = Logger.getLogger(Tarefa.class.getName());
    private static final long MILLISECONDS_MULTIPLIER = 1000L;
    
    private final String tarefaNome;
    private final long tarefaTempo;
    private final ServletContext sce;
    
    public Tarefa(int tarefaNumero, int multiplicador, ServletContext pSce) {
        this.tarefaNome = "Tarefa n. " + String.valueOf(tarefaNumero);
        this.tarefaTempo = MILLISECONDS_MULTIPLIER * multiplicador;
        this.sce = pSce;
    }

    @Override
    public void run() {
        logger.info("VAI ESPERAR...> " + Thread.currentThread().getName());
        ExecutorService executor = (ExecutorService) this.sce.getAttribute("executorService");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        long y = 1;
        try {
            logger.info("VAI ESPERAR..> " + this.tarefaTempo);
            Thread.sleep(this.tarefaTempo);
            for (long x = 1; x < 1000000; x++) {
                if (y==1000||x==999999) {
                    //logger.info(Thread.currentThread().getName() + " -> " + String.valueOf(x));
                    y = 1;
                }else{
                    y++;
                }
            }
            logger.info(Thread.currentThread().getName());
            logger.info("Threads em uso...> " + threadPoolExecutor.getActiveCount());
            logger.info("Threads ativas: " + threadPoolExecutor.getActiveCount());
            logger.info("Tarefas completadas: " + threadPoolExecutor.getCompletedTaskCount());
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Essa Thread foi interrompida!");
            Thread.currentThread().interrupt();
        }
    }
}
