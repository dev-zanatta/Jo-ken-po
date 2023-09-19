import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nStr = request.getParameter("N");
        String kStr = request.getParameter("K");
        
        if (nStr == null || kStr == null || nStr.isEmpty() || kStr.isEmpty()) {
            request.setAttribute("error", "Informe valores válidos para N e K.");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }

        try {
            int n = Integer.parseInt(nStr);
            int k = Integer.parseInt(kStr);
            
            long permutacoes = calcularPermutacoes(n, k);
            long combinacoes = calcularCombinacoes(n, k);
            
            request.getSession().setAttribute("permutacoes", permutacoes);
            request.getSession().setAttribute("combinacoes", combinacoes);
            
            response.sendRedirect("result.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Informe valores numéricos válidos para N e K.");
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }
    
    private long calcularPermutacoes(int n, int k) {

        if (k > n) {
            return 0; 
        }

        long numerador = 1;
        for (int i = n; i > n - k; i--) {
            numerador *= i;
        }

        return numerador;
    }

    private long calcularCombinacoes(int n, int k) {
        if (k > n) {
            return 0; 
        }

        long numerador = 1;
        long denominador = 1;

        for (int i = n; i > n - k; i--) {
            numerador *= i;
        }

        for (int i = k; i > 0; i--) {
            denominador *= i;
        }

        return numerador / denominador;
    }

}
