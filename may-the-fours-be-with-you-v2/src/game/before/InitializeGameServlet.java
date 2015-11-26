package game.before;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.before.wordsBean;
import game.utility.FileManipulation;

@WebServlet("/initializegame.html")
public class InitializeGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestDispatcher rd;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		wordsBean bean = new wordsBean();
		
		String source = "C://dictionary.txt";
		String dest = "C://fourletters.txt";
		String four = "C://arrangedfourletters.txt";
		String csv = "C://fourletterscsv.csv";

		FileManipulation.prepareGameFile(dest);
		FileManipulation.prepareGameFile(four);
		FileManipulation.prepareGameFile(csv);
		
		/*
		 * //if source1 doest not exist if(!source1.exists()) {
		 * source1.createNewFile(); }
		 * 
		 * //if dest1 does not exist if(!dest1.exists()) {
		 * dest1.createNewFile(); }
		 * 
		 * //if csv1 does not exist if(!csv1.exists()) { csv1.createNewFile(); }
		 * 
		 * //convert to String String source = source1.toString(); String dest =
		 * dest1.toString(); String csv = csv1.toString();
		 */
		// call FileManipulation.java
		
		FileManipulation.dictionary(source, dest, four, csv);
		
		FileManipulation.PrintOutput(dest, four);
		
		String[] randomLine = FileManipulation.randomLine(csv);
		System.out.println("Chosen Line in csv:");
		for(int i=0; i<randomLine.length; i++){
			System.out.println(randomLine[i]);
		}
		
		String indexZeroWord = FileManipulation.indexZeroWord(randomLine);
		
		
		//splitting the letters then setting it
	
		String[] splitLetter = indexZeroWord.split("");
		
		FileManipulation.shuffleLetters(splitLetter);
		
	
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
