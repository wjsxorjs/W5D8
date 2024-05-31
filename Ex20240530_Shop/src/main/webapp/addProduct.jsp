<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session" />

<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>

<%
	String pnum = request.getParameter("p_num");
	if(pnum != null){
		cart.addProduct(sb, pnum);
	}
	response.sendRedirect("product_content.jsp?p_num="+pnum);
	
	// 위의 방식말고 아래방식으로 해도되나.
	// url로 바로 들어오는 것을 방지하기 위해 위의 것으로 코딩함
	/*
		cart.addProduct(sb, sb.getP_num());
	response.sendRedirect("product_content.jsp?p_num="+sb.getP_num());
	*/
%>
