package com.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name ="FormAction",urlPatterns = { "/FormAction" })
public class FormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		String action2 = request.getParameter("delete");
		String Uid = request.getParameter("urid");

		boolean isTrue;

		if ("CONFIRMED".equals(action)) {
			  RequestDispatcher dis = request.getRequestDispatcher("Confirmed.jsp");
			  dis.forward(request, response);

		} else if ("UPDATE RIDE".equals(action)) {

			List<ReservationDetails> reservationdetails = DBUtil.read();
			request.setAttribute("reservationdetails", reservationdetails);
			RequestDispatcher diss = request.getRequestDispatcher("updaterental.jsp");
			diss.forward(request, response);

		} else if ("DELETE RIDE".equals(action)) {
			List<ReservationDetails> reservationdetails = DBUtil.read();
			request.setAttribute("reservationdetails", reservationdetails);
			RequestDispatcher disss = request.getRequestDispatcher("DeleteDetails.jsp");
			disss.forward(request, response);
		} else {
			System.out.println("button action failed.");
		}

		
		
		if ("DELETE".equals(action2)) {

			isTrue = DBUtil.delete(Uid);
			if (isTrue == true) {

				List<ReservationDetails> reservationdetails = DBUtil.read();
				if (!reservationdetails.isEmpty()) {
					RequestDispatcher disss = request.getRequestDispatcher("Reservation.jsp");
					disss.forward(request, response);
				} else {
					RequestDispatcher disb = request.getRequestDispatcher("something.jsp");
					disb.forward(request, response);
				}
			}
		} else {
			List<ReservationDetails> reservationdetails = DBUtil.read();
			request.setAttribute("reservationdetails", reservationdetails);
			RequestDispatcher disc = request.getRequestDispatcher("show.jsp");
			disc.forward(request, response);
		}

	}

}
