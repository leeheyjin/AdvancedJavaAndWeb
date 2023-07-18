<%--
  Created by IntelliJ IDEA.
  User: leehyejin
  Date: 2023/07/17
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String cartId = request.getParameter("cartId");
    if (cartId == null || cartId.trim().equals("")) {
        response.sendRedirect("cart.jsp");
        return;
    }

    session.removeAttribute("cartlist");
    response.sendRedirect("cart.jsp");
%>