package com.reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ReservationServlet", urlPatterns = { "/ReservationServlet" })
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Vname = request.getParameter("name");
		String VLocation = request.getParameter("location");
		String VCheckindate = request.getParameter("checkindate");
		String VCheckoutdate = request.getParameter("checkoutdate");
		String Vemail = request.getParameter("email");
		String Vphone = request.getParameter("phone");
		String Vother = request.getParameter("otherD");
		String Vusername = request.getParameter("username");
		String Vpassword = request.getParameter("password");

		boolean isTrue = false;
		boolean validate = true;
		

		if (validate == DBUtil.validateLogin(Vusername, Vpassword)) {

			isTrue = DBUtil.insert(Vname, VLocation, VCheckindate,VCheckoutdate, Vemail, Vphone, Vother);

			if (isTrue == true) {
				List<ReservationDetails> reservationdetails = DBUtil.read();
				request.setAttribute("reservationdetails", reservationdetails);
				//amount = DBUtil.CalculateDistance(VpickLocation, VdropLocation);
				//request.setAttribute("amount", amount);

				if (!reservationdetails.isEmpty()) {
					RequestDispatcher dil = request.getRequestDispatcher("payment.jsp");
					dil.forward(request, response);
					RequestDispatcher dis = request.getRequestDispatcher("payment.jsp");
					dis.forward(request, response);
				} else {
					RequestDispatcher dis = request.getRequestDispatcher("fail.jsp");
					dis.forward(request, response);
				}
			} 
			else {
				System.out.println("Data insert failed");
			}
		} else {
			response.getWriter().println("<script>alert('Incorrect username or password');window.location.href='Reservation.jsp';</script>");
		}
	}

}
