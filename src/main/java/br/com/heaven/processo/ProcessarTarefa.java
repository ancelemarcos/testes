package br.com.heaven.processo;

import br.com.heaven.entidades.Tarefa;

import javax.servlet.ServletContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ProcessarTarefa {
    public void usarExecutorService(ServletContext servletContext, Tarefa tarefa) {
        ExecutorService executor = (ExecutorService) servletContext.getAttribute("executorService");
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        if (executor != null) {
            executor.execute(tarefa);
        }
    }
}

