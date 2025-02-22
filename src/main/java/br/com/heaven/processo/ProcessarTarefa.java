package br.com.heaven.processo;

import br.com.heaven.entidades.Tarefa;

import javax.servlet.ServletContext;
import java.util.concurrent.ExecutorService;

public class ProcessarTarefa {
    public void usarExecutorService(ServletContext servletContext, Tarefa tarefa) {
        ExecutorService executor = (ExecutorService) servletContext.getAttribute("executorService");
        if (executor != null) {
            executor.execute(tarefa);
        }
    }
}

