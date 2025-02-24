package br.com.heaven.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class ExecutorServiceListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ExecutorServiceListener.class.getName());
    private ExecutorService executorService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        executorService = Executors.newCachedThreadPool(); // Cria um ThreadPool com 10 threads
        sce.getServletContext().setAttribute("executorService", executorService); // Armazena o ExecutorService no contexto da aplicação
        LOGGER.log(Level.INFO, "Executor Service inicializado.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        executorService.shutdown();
        try{
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    LOGGER.log(Level.SEVERE, "Exeutor Service nao encerrou");
                }
            }
        } catch (InterruptedException ie){
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        LOGGER.log(Level.INFO, "Executor Service encerrado.");
    }
}
