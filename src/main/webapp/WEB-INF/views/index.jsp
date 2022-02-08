<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>COVID-19 APP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="${contextPath}/resources/css/all.css" rel="stylesheet">
</head>
<body>
    <div class="square">
        <i class="fa fa-calendar-alt"></i>
        <h1>${covidStats.date}r.</h1>
        <h2>DATE OF STATISTICS</h2>
    </div>
    <div class="square">
        <i class="fa fa-head-side-mask"></i>
        <h1>${covidStats.confirmedToday}</h1>
        <h2>TODAY CONFIRMED</h2>
    </div>
    <div class="square">
        <i class="fa fa-viruses"></i>
        <h1>${covidStats.totalConfirmed}</h1>
        <h2>TOTAL CONFIRMED</h2>
    </div>
    <div class="square">
        <i class="fa fa-user-slash"></i>
        <h1>${covidStats.deathsToday}</h1>
        <h2>TODAY DEATHS</h2>
    </div>
    <div class="square">
        <i class="fa fa-users-slash"></i>
        <h1>${covidStats.totalDeaths}</h1>
        <h2>TOTAL DEATHS</h2>
    </div>
</body>
</html>