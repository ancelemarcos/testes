package br.com.heaven.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebListener
public class ExecutorServiceListener implements ServletContextListener {

    private ExecutorService executorService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        executorService = Executors.newCachedThreadPool(); // Cria um ThreadPool com 10 threads
        sce.getServletContext().setAttribute("executorService", executorService); // Armazena o ExecutorService no contexto da aplicação
        System.out.println("ExecutorService inicializado.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        executorService.shutdown();
        System.out.println("ExecutorService encerrado.");
    }
}