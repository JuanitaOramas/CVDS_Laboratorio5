package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;
import java.util.ArrayList;

@WebServlet(
        urlPatterns = "/SecondServlet"
)
public class SecondSampleServlet extends HttpServlet{

    private ArrayList<Todo> myTodos;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Writer responseWriter = response.getWriter();
        myTodos = new ArrayList<Todo>();
        try {
            Optional<String> optTodoId = Optional.ofNullable(req.getParameter("id")); // localhost:8080/SecondServlet?id=1
            String  todoId = optTodoId.isPresent() && !optTodoId.get().isEmpty() ? optTodoId.get() : "";
            Todo myTodo = Service.getTodo(Integer.parseInt(todoId));
            response.setStatus(HttpServletResponse.SC_OK);
            myTodos.add(myTodo);
            responseWriter.write(Service.todosToHTMLTable(myTodos));
        } catch (FileNotFoundException  e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("<h1> ITEM NOT FOUND :/ </h1>");
        } catch (NumberFormatException  e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }  catch (MalformedURLException  e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        responseWriter.flush();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Writer responseWriter = response.getWriter();
        myTodos = new ArrayList<Todo>();
        try {
            Optional<String> optTodoId = Optional.ofNullable(req.getParameter("id")); // localhost:8080/SecondServlet?id=1
            String  todoId = optTodoId.isPresent() && !optTodoId.get().isEmpty() ? optTodoId.get() : "";
            Todo myTodo = Service.getTodo(Integer.parseInt(todoId));
            response.setStatus(HttpServletResponse.SC_OK);
            myTodos.add(myTodo);
            responseWriter.write(Service.todosToHTMLTable(myTodos));
        } catch (FileNotFoundException  e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseWriter.write("<h1> ITEM NOT FOUND :/ </h1>");
        } catch (NumberFormatException  e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }  catch (MalformedURLException  e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        responseWriter.flush();
    }

}
