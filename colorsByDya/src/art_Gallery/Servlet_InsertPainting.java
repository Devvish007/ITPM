package art_Gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet_InsertPainting")

public class Servlet_InsertPainting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	// Insert session
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Get session
		HttpSession session = request.getSession(false);

		 if (session.getAttribute("userID") != null) {
		System.out.println("No user ID Detected in session...");
		RequestDispatcher RD = request.getRequestDispatcher("Gallery_All_Logged.jsp");
		RD.forward(request, response);
		} else {
		System.out.println("User ID detected in the session...");
		RequestDispatcher RD = request.getRequestDispatcher("Gallery_All.jsp");
		RD.forward(request, response);
		}
	}
*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 String title = request.getParameter("artworkTitle");
		 String description = request.getParameter("artworkDescription");
		 
		 String price;
		 String price2 = request.getParameter("radio_price");
		 
		 if ("Negotiate Price".equals(price2)) {
			 price = request.getParameter("radio_price");
		 }
		 else {
			 price = request.getParameter("artworkFixedValue");
		 }
		  /*
		 if(request.getParameter("artworkFixedValue") != null) {
			  price = request.getParameter("artworkFixedValue");
		 }
		 else {
			 price = request.getParameter("radio_price");
		 }
		 */
		 
		 String drawn_date = request.getParameter("drawnDate");
		 
		 String category = request.getParameter("artworkCategory");
		 String weight = request.getParameter("artworkWeight");
		 String length = request.getParameter("artworkLength");
		 String width = request.getParameter("artworkWidth");
		 
		 String image_url = request.getParameter("imagePainting");
		 
		 String material = request.getParameter("artworkMaterial");
		 
		 //String in_stock = request.getParameter();
		 
		 String frame = request.getParameter("artworkFrame");
		 
		 boolean insertSuccess;
		 
		insertSuccess = PaintingDBUtil.insertPainting(title, description, price, drawn_date, category, weight, length, width, image_url, material, frame);
		 
		 if(insertSuccess == true) {
			 RequestDispatcher dispatchSuccess = request.getRequestDispatcher("success.jsp");
			 dispatchSuccess.forward(request, response);
		 }
		 else {
			 RequestDispatcher dispatchFail = request.getRequestDispatcher("fail.jsp");
			 dispatchFail.forward(request, response);
		 }
	
	}// end of doPost method

} //end of class
