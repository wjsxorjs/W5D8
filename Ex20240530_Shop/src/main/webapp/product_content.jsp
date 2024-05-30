<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product_list</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>


	<div id="wrap">
        <header>
            <jsp:include page="menu.jsp" />
        </header>
        <article>
            <jsp:useBean 	id="sb"
            				class="shop.bean.ShopBean"
            				scope="session" />
            <jsp:setProperty property="*" name="sb"/>
            <%--
            	1. 이전에 카테고리를 받아 ShopBean의 category를 채워넣음
            	2. 받아온 카테고리를 이용해 ShopBean의 p_list를 채워넣음
            	3. 방금 받아온 p_num을 ShopBean의 p_num에 채워넣음
             --%>
		<%
			// DB에서 검색한 것이 아니라 p_list에서 검색한 것
			ProductVO pvo = sb.getProduct();
			
		%>
		<table class="table">
		   	<colgroup>
		   		<col width="40%">
		   		<col width="60%">
		   	</colgroup>
			<tbody>
			    <tr>
			        <td>제품Category</td>
			        <td><%=pvo.getCategory() %></td>
			    </tr>
			    <tr>
			        <td>제품번호</td>
			        <td><%=pvo.getP_num() %></td>
			    </tr>
			    <tr>
			        <td>제품이름</td>
			        <td><%=pvo.getP_name() %></td>
			    </tr>
			    <tr>
			        <td>제품 판매사</td>
			        <td><%=pvo.getP_company() %></td>
			    </tr>
			    <tr>
			        <td>제품가격</td>
			        <td>(할인가 : <%=pvo.getP_saleprice() %>원 )</td>
			    </tr>
			    <tr>
			        <td colspan="2">제품설명</td>
			    </tr>
			    <tr>
			        <td colspan="2" align="center">
			        	<img src ="images/<%=pvo.getP_image_l() %>" />
			        </td>
			    </tr>
			    <tr>
			        <td colspan="2"><%=pvo.getP_content() %></td>
			    </tr>
			    <tr>
			        <td colspan="2" align="center">
			            <input type="button" value="장바구니에 담기" 
			            onclick="javascript:location.href='addProduct.jsp?p_num=<%=pvo.getP_num() %>'"/>
			            <input type="button" value="장바구니 보기" 
			            onclick="javascript:location.href='cartList.jsp'"/>
			            <input type="button" value="목록" 
			            onclick="javascript:location.href='product_list.jsp'"/>
			        </td>
			    </tr> 
		    </tbody>   
		</table>
		</article>
	
    </div>



</body>
</html>