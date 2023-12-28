package chap06.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chap06.model.PizzaOrder;


/*
	# Front Controller Design Pattern
  
	- 모든 요청을 하나의 서블릿에서 받고 URI에 따라 알맞은 페이지로 포워딩
	- 요청 -> URI 식별 -> 처리 -> 포워딩 -> 뷰 생성 순서로 모든 요청을 처리할 수 있다
*/
public class ApplicationServlet extends HttpServlet{

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		ServletContext applicationContext = req.getServletContext();
		HttpSession session = req.getSession();
		
		// 1. 요청을 받으면 URI를 통해 알맞은 처리로 안내한다
		String cmd = req.getRequestURI().substring(req.getContextPath().length());
	 	// System.out.println(cmd);
	 	// 2. 원하는 코드로 처리한 후 뷰 페이지에서 필요한 데이터는 어트리뷰트에 실어보낸다
	 	// 3. 다음 뷰로 포워딩
	 	if (cmd.equals("/hello")) {
			String keyword = req.getParameter("keyword");
			
			// DB에 접근해서 자료를 들고온 후 어트리뷰트에 실어 보낸다...
			Set<String> resultSet = new HashSet<>();
			
			resultSet.add("Smith A");
			resultSet.add("Smith B");
			resultSet.add("Smith C");
			
			req.setAttribute("result", resultSet);
			
			// 포워딩을 통해서는 WEB-INF 폴더에 접근할 수 있다
			req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
		} else if (cmd.equals("/pizza/form")) {
			req.getRequestDispatcher("/WEB-INF/views/pizza/form.jsp").forward(req, resp);
		} else if (cmd.equals("/pizza/cart/add")) {
			String size = req.getParameter("size");
			String qtyStr = req.getParameter("qty");	
			
			String pizzaName = req.getParameter("pizzaName");
			String priceStr = req.getParameter("price");
			
			System.out.println(size);
			System.out.println(qtyStr);
			System.out.println(pizzaName);
			System.out.println(priceStr);	
			
			// 파라미터 값이 안전한지 체크
			if (size == null || qtyStr == null || size.equals("") || qtyStr.equals("") || 
					pizzaName == null || priceStr == null || pizzaName.equals("") || priceStr.equals("")) {
				throw new ServletException("파라미터 값이 이상함");
			}
			int qty = Integer.parseInt(qtyStr);	
			
			int price = Integer.parseInt(priceStr);
			
			
			
			Object c = session.getAttribute("cart");
			
			if (c == null) {
				// 새로운 장바구니 리스트를 추가
				List<PizzaOrder> newCart =  new ArrayList<>();
				newCart.add(new PizzaOrder(size, qty, pizzaName, price));
				session.setAttribute("cart", newCart);
			} else {
				// 있던 카트에 방금 받은 파라미터를 추가
				List<PizzaOrder> cartList = (List)c;
				cartList.add(new PizzaOrder(size, qty, pizzaName, price));
			}
			
			resp.sendRedirect(req.getContextPath() + "/pizza/form");
		}
	 	
	 	
//		else if (cmd.equals("/menu")) {
//			List<String> menuList = new ArrayList<>();
//			
//			menuList.add("스노우 브리스킷 바비Q");
//			menuList.add("스노우 블랙타이거 슈림프");
//			menuList.add("스노우 와일드 와일드 웨스트 스테이크");
//			menuList.add("브리스킷 바비Q");
//			
//			Map<String, int[]> menuPrice = new HashMap<>();
//			int[] price1 = {35900, 30000};
//			menuPrice.put(menuList.get(0), price1);
//			int[] price2 = {37900, 31000};
//			menuPrice.put(menuList.get(1), price2);
//			int[] price3 = {34900, 29000};
//			menuPrice.put(menuList.get(2), price3);
//			int[] price4 = {34900, 29000};
//			menuPrice.put(menuList.get(3), price4);
//			
//			
//			req.setAttribute("menus", menuList);
//			req.setAttribute("price", menuPrice);
//			req.getRequestDispatcher("/WEB-INF/views/menus.jsp").forward(req, resp);
//		} else if (cmd.equals("/orderList")) {
//			System.out.println("orderList 확인용");
//			System.out.println(req.getAttribute(""));
//			
//			req.getRequestDispatcher("/WEB-INF/views/orderList.jsp").forward(req, resp);
//		}
	 	 
	}
}
