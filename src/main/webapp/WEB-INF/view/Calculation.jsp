<%@ page import="org.springframework.ui.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>

<%
        Long basicSalary = Long.parseLong(request.getParameter("basicSalary")) ;
        Long houseRent = Long.parseLong(request.getParameter("houseRent")) ;
        Long medical = Long.parseLong(request.getParameter("medical")) ;
        Long conveyance = Long.parseLong(request.getParameter("conveyance")) ;
        Long bonus = Long.parseLong(request.getParameter("bonus")) ;
        String category = request.getParameter("category") ;

        long total = 0;
        long total1 = 0;
        long tconv = 0;
        long trent = 0;
        long tmed = 0;
        long taxable = 0;
        if (basicSalary >= 0 || houseRent >= 0 || medical >= 0 || conveyance >= 0 || bonus >= 0) {
        total1 = (basicSalary * 12) + (houseRent * 12) + (medical * 12) + (conveyance * 12) + (bonus * 2);
        if (conveyance * 12 > 30000) {
        tconv = (conveyance * 12) - 30000;
        }
        if (basicSalary * 6 > 300000) {
        trent = houseRent * 12 - 300000;
        } else {
        trent = houseRent * 12 - basicSalary * 6;
        }
        if (((basicSalary * 12) * 10) / 100 > 120000) {
        tmed = medical * 12 - 1200000;
        } else {
        tmed = medical * 12 - ((basicSalary * 12) * 10) / 100;
        }
        total = tconv + trent + tmed + (bonus * 2) + (basicSalary * 12);
        }

        taxable = total;

        long tax1 = 0;
        long tax2 = 0;
        long tax3 = 0;
        long tax4 = 0;
        long tax5 = 0;

        if (category.equals("General")) {
        if (total > 300000) {
        total = total - 300000;

        if (total > 100000) {
        total = total - 100000;
        tax1 = 100000 * 5 / 100;

        if (total > 300000) {
        total = total - 300000;
        tax2 = 300000 * 10 / 100;

        if (total > 400000) {
        total = total - 400000;
        tax3 = 400000 * 15 / 100;

        if (total > 500000) {
        total = total - 500000;
        tax4 = 500000 * 20 / 100;

        if (total >= 1) {
        tax5 = total * 25 / 100;
        }
        } else {
        tax4 = total * 20 / 100;
        }
        } else {
        tax3 = total * 15 / 100;
        }
        } else {
        tax2 = total * 10 / 100;
        }
        } else {
        tax1 = total * 5 / 100;
        }
        }
        } else if (category.equals("Female/Senior Citizen")) {
        if (total > 350000) {
        total = total - 350000;

        if (total > 100000) {
        total = total - 100000;
        tax1 = 100000 * 5 / 100;

        if (total > 300000) {
        total = total - 300000;
        tax2 = 300000 * 10 / 100;

        if (total > 400000) {
        total = total - 400000;
        tax3 = 400000 * 15 / 100;

        if (total > 500000) {
        total = total - 500000;
        tax4 = 500000 * 20 / 100;

        if (total >= 1) {
        tax5 = total * 25 / 100;
        }
        } else {
        tax4 = total * 20 / 100;
        }
        } else {
        tax3 = total * 15 / 100;
        }
        } else {
        tax2 = total * 10 / 100;
        }
        } else {
        tax1 = total * 5 / 100;
        }
        }
        } else if (category.equals("Freedom Fighter")) {
        if (total > 375000) {
        total = total - 375000;

        if (total > 100000) {
        total = total - 100000;
        tax1 = 100000 * 5 / 100;

        if (total > 300000) {
        total = total - 300000;
        tax2 = 300000 * 10 / 100;

        if (total > 400000) {
        total = total - 400000;
        tax3 = 400000 * 15 / 100;

        if (total > 500000) {
        total = total - 500000;
        tax4 = 500000 * 20 / 100;

        if (total >= 1) {
        tax5 = total * 25 / 100;
        }
        } else {
        tax4 = total * 20 / 100;
        }
        } else {
        tax3 = total * 15 / 100;
        }
        } else {
        tax2 = total * 10 / 100;
        }
        } else {
        tax1 = total * 5 / 100;
        }
        }
        }

        long tax = tax1 + tax2 + tax3 + tax4 + tax5;
%>

</body>
</html>
