<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="wrap">
		<header>
			<jsp:include page="menu.jsp"/>
		</header>
	</div>
	<%--
		ShopBean이라는 빈을 재사용하자
		앞서 product_list.jsp에서 useBean으로 사용된 ShopBean을
		다시 세션으로부터 가져와서 재사용하면 ShopBean에 있는 p_list 또는
		category가 있는 상태에서 재사용을 하게된다.
	 --%>
	 
	 <jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
	 <jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
	 
	<table class="table">

		<tr>
			<td colspan="6">:: 장바구니 내용</td>
		</tr>
		<tr bgcolor="#dedede">
			<th>제품번호</th>
			<th width="25%">제품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
			<th>삭제</th>
		</tr>
		<%
			// 장바구니에 저장된 모든 제품들을 배열로 받기
			ProductVO[] c_ar = cart.getList();
			long total = 0;
			if(c_ar != null){
				for(ProductVO vo: c_ar){
		%>
		<tr align="center">
			<td><%=vo.getP_num() %></td>
			<td><%=vo.getP_name() %></td>
			<td>
				정가:<%=vo.getP_price() %>원<br>
				<font color="red">
				세일가격:<%=vo.getP_saleprice() %>원
				</font>
			</td>
			<td>
			<!-- 수량 조정 폼 -->
			<form action="changeCount.jsp" method:"post">
				<input type="hidden" name="p_num" value="<%=vo.getP_num() %>">
				<input type="number" name="count" min="1" value="<%=vo.getQuant() %>">
				<button>변경</button>

			</form>
			<!------------------>

			</td>
			<td><%=vo.getTotalprice() %>원</td>
			<td>
			<input type="button" value="삭제" 
			style="border:1 solid black;cursor:pointer" 
			onclick="javascript:location.href='delProduct.jsp?p_num=<%=vo.getP_num()%>'">
			</td>
		</tr>
		<%
			total += vo.getTotalprice(); // 결제 총액 누적
				}// for문의 끝
		}//if의 끝
			else{
		%>
		<tr align="center">
			<td colspan="6">
				<b>장바구니가 비었습니다.</b>
			</td>
		</tr>
		<%}%>
		<tr>
			<td colspan="5" align="right">총 결재액 : </td>
			<td><%=total %>원</td>
		</tr>
	</table>
</body>
</html>