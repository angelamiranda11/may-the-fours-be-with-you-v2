package game.before;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.before.wordsBean;
import game.before.InitializeGameServlet;
import game.utility.FileManipulation;
@WebServlet("/checking.html")
public class CheckingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String answer = request.getParameter("answer");
		String a = request.getParameter("button1");
		String b = request.getParameter("button2");
		String c = request.getParameter("button3");
		String d = request.getParameter("button4");
		String[] arrayWord = wordsBean.words; //SEARCH HOW TO GET STRING[] IN SERVLET FROM BEAN
		System.out.println("User's answer: " + answer);		
		System.out.println("FROM CHECKING SERVLET #2: " + a + b + c + d);
		
		RequestDispatcher rd =null;
		
		boolean flag = false;
		//checks the array per word (hindi na pwde ksama si index[0])
		for(int i=1; i<arrayWord.length; i++){
			flag = FileManipulation.StringMatching(arrayWord, answer);
			
		}
	
		if(flag==true){
			getServletContext().getRequestDispatcher("/during.html").forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
				
				
		
		
		
		
		
		
		
	}

}
