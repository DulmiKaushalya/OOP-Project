package com.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name ="UpdateReservationServlet", urlPatterns = { "/UpdateReservationServlet" })
public class UpdateReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Uid = request.getParameter("urid");
		String Uname = request.getParameter("uname");
		String Location = request.getParameter("ulocation");
		String Ucheckin = request.getParameter("ucheckindate");
		String Ucheckout = request.getParameter("ucheckoutday");
		String Uemail = request.getParameter("uemail");
		String Uphone = request.getParameter("uphone");
		String Uother = request.getParameter("uotherD");

		boolean isTrue = false;
		
		isTrue = DBUtil.update(Uid, Uname, Location, Ucheckin, Ucheckout,Uemail, Uphone, Uother);

		if (isTrue == true) {
			List<ReservationDetails> reservationdetails = DBUtil.read();
			request.setAttribute("reservationdetails", reservationdetails);
			
			if (!reservationdetails.isEmpty()) {
				RequestDispatcher dil = request.getRequestDispatcher("show.jsp");//****************
				dil.forward(request, response);//******************
				RequestDispatcher dis = request.getRequestDispatcher("show.jsp");
				dis.forward(request, response);
			} else {
				RequestDispatcher dis = request.getRequestDispatcher("fail.jsp");
				dis.forward(request, response);
			}
		} else {
			System.out.println("Update failed.");
		}
	}

}
