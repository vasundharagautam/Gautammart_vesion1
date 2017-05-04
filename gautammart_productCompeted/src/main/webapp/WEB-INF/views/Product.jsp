<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div align="center">
        <sf:form action="insertProduct" method="GET" commandName="product">
            <table border="0">
                <tr>
                    <td colspan="2" align="center">
                    <h2>Product name</h2></td>
               
                <tr>
                    <td>Pro ID</td>
                    <td><sf:input path="proID"/></td>
                </tr>
                <tr>
                    <td>Pro Name</td>
                    <td><sf:input path="proName"/></td>
                </tr>
                <tr>
                    <td>Sup ID</td>
                    <td><sf:input path="supplierID"/></td>
                </tr>
                <tr>
                    <td>Cat ID</td>
                    <td><sf:input path="categoryID"/></td>
                </tr>
                 <tr>
                    <td>Quantity</td>
                    <td><sf:input path="quantity"/></td>
                </tr>
                <tr>
                    <td>Stock</td>
                    <td><sf:input path="stock"/></td>
                </tr>
                <tr>
                    <td>DECS</td>
                    <td><sf:input path="description"/></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add Product" /></td>
                </tr>
            </table>
        </sf:form>
    </div>
</body>
</html>