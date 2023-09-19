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
        // Retrieve user input from the form
        String nStr = request.getParameter("N");
        String kStr = request.getParameter("K");
        
        // Validate user input (check for empty or non-numeric values)
        if (nStr == null || kStr == null || nStr.isEmpty() || kStr.isEmpty()) {
            request.setAttribute("error", "Informe valores válidos para N e K.");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return;
        }

        try {
            int n = Integer.parseInt(nStr);
            int k = Integer.parseInt(kStr);
            
            // Calculate permutations and combinations
            long permutations = calculatePermutations(n, k);
            long combinations = calculateCombinations(n, k);
            
            // Store results in session
            request.getSession().setAttribute("permutations", permutations);
            request.getSession().setAttribute("combinations", combinations);
            
            // Redirect to a JSP page to display the results
            response.sendRedirect("result.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Informe valores numéricos válidos para N e K.");
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
    }
    
    // Implement your factorial calculation methods here
private long calculatePermutations(int n, int k) {
    // Calculate and return permutations
    // A k,n = (n!) / (n-k)!
    if (k > n) {
        return 0; // Invalid input, k should be less than or equal to n
    }
    
    long numerator = 1;
    for (int i = n; i > n - k; i--) {
        numerator *= i;
    }
    
    return numerator;
}

private long calculateCombinations(int n, int k) {
    // Calculate and return combinations
    // C k,n = (n!) / (k! * (n-k)!)
    if (k > n) {
        return 0; // Invalid input, k should be less than or equal to n
    }
    
    long numerator = 1;
    long denominator = 1;
    
    for (int i = n; i > n - k; i--) {
        numerator *= i;
    }
    
    for (int i = k; i > 0; i--) {
        denominator *= i;
    }
    
    return numerator / denominator;
}

}
