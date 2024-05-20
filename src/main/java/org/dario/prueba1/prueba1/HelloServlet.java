package org.dario.prueba1.prueba1;
/* *Nombre de los programadores: Adrian Lopez y Dario Verdezoto
        * *Materia: Programacion 2
        * *Fecha: 20/05/2024
        * *Detalle: Ecuacion de segundo Grado
        * *Version: 1
        */


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//Es una anotacion o un path o una key para hacer conexion con servlet
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
@Override

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Obtener los coeficientes de la solicitud
        Double a = Double.parseDouble(request.getParameter("a"));
        Double b = Double.parseDouble(request.getParameter("b"));
        Double c = Double.parseDouble(request.getParameter("c"));
        //Calcular Primera operacion(b*b-4*a*c)
        Double d = b * b - 4 * a * c;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ecuacion</title>");
        // Incluir Bootstrap CSS -->
        out.print("<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css' rel='stylesheet'>");
        // Incluir jQuery -->
        out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
    if (a == 0) {
        // Manejar el caso especial de ecuación lineal (bx + c = 0)
        if (b != 0) {
            double raiz = -c / b;
            out.println("Su ecuacion es lineal pero no tiene Solucion ");
        } else if (c == 0) {
            out.println("La ecuación es identidad");
        } else {
            out.println("La ecuación no tiene solución");
        }
    } else {

        if (d> 0) {
            double raiz1 = (-b + Math.sqrt(d)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(d)) / (2 * a);
            out.println("Las raíces son: " + raiz1 + " y " + raiz2);
        } else if (d == 0) {
            double raiz = -b / (2 * a);
            out.println("La raíz es: " + raiz);
        } else {
            out.println("La ecuación no tiene raíces reales.(Osea es negativa)");
        }
    }
    out.println("</div>");
    out.println("</body>");
    out.print("</html>");
}


}









