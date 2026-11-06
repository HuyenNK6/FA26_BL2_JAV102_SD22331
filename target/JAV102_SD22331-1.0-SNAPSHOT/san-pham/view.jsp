<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 11/6/2026
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Đây là trang sản phẩm </h1>
    <table>
        <thead>
            <th>STT</th>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Hành động</th>
        </thead>
        <tbody>
            <c:forEach items="${listSanPham}" var="sp" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${sp.id}</td>
                    <td>${sp.ma}</td>
                    <td>${sp.ten}</td>
                    <td>
                        <a href="#">Detail</a>
                        <a href="#">Update</a>
                        <a href="#">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
