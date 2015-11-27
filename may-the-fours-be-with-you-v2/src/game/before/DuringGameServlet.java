package game.before;

import game.utility.FileManipulation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/during.html")
public class DuringGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		wordsBean bean = new wordsBean();
		RequestDispatcher rd;
		
		
		String csv = "D://fourletterscsv.csv";
		
		String[] randomLine = FileManipulation.randomLine(csv);
		
		String indexZeroWord = FileManipulation.indexZeroWord(randomLine);
		
		//splitting the letters then setting it
	
		String[] splitLetter = indexZeroWord.split("");
		
		for(int i=0; i<randomLine.length; i++){
			System.out.println(randomLine[i]);
		}
		
	
		//trial printing-can be deleted later
		for(int i=0; i < 4; i++){
			System.out.println(splitLetter[i]);
		}
		bean.setWords(randomLine);
		bean.setA(splitLetter[0]);
		bean.setB(splitLetter[1]);
		bean.setC(splitLetter[2]);
		bean.setD(splitLetter[3]);
		request.setAttribute("bean", bean);
		rd = getServletContext().getRequestDispatcher("/main-game.jsp");
	
		rd.forward(request,  response);
	}

}
