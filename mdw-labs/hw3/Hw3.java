package com.weblogic.tutorial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hw3
 */
@WebServlet("/Hw3")
public class Hw3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hw3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		String currentState = (String)session.getAttribute("currentState");
		
		String paramter = request.getParameter("state");
		System.out.println(paramter);
		
		
		if (paramter != null) {
			paramter = paramter.trim();
			switch (paramter) {
			case "NEW":
				if (currentState == null || currentState.equals("NEW")) {
					session.setAttribute("currentState", "NEW");
					out.println("Gratz!!! you created a new ticket machine");
				}
				else
					out.println("Incorrect case");
				break;
			case "PAYMENT":
				if (currentState != null && (currentState.equals("NEW") || currentState.equals("PAYMENT"))) {
					session.setAttribute("currentState", "PAYMENT");
					out.println("Gratz!!! you payed the ticket machine");
				} else {
					out.println("Incorrect case");
				}
				break;
			case "COMPLETED":
				if (currentState != null && (currentState.equals("PAYMENT"))) {
					session.invalidate();
					out.println("Gratz!!! you'he finished the ticket system");
				} else {
					out.println("Incorrect case");
				}
				break;
			default:
				out.println("Incorrect GET parameter");
				break;
			}
		} else { 
			out.println("No GET parameter present");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
