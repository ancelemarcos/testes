package br.com.heaven;

import br.com.heaven.entidades.Tarefa;
import br.com.heaven.processo.ProcessarTarefa;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author 黎志雄
 * 创建于2019-2-18
 *
 * Jakarta EE 课程
 */
@WebServlet(name = "Teste"
        , description = "teste de servlet"
        , urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        ProcessarTarefa proc = new ProcessarTarefa();
        if(quantidade > 0) {
            for (int x = 0; x < quantidade; x++) {
                proc.usarExecutorService(this.getServletContext(), new Tarefa(x));
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<html>");
        response.getWriter().println("<h1>Hello Servlet</h1>");
        Optional.ofNullable(request.getParameter("user")).ifPresent((user) -> {
            try {
                response.getWriter().println("<h1>：" + user + "</h1>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        response.getWriter().println("<h1>Jakarta EE</h1>");
        response.getWriter().println("</br>");
        response.getWriter().println("session=" + request.getSession(true).getId());
        response.getWriter().println("</html>");
    }
}