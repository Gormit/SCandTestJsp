<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<div class="span12">

    <h4>c ${sDate} по ${eDate}</h4>

    <table id="hello-table" class="table table-striped table-hover">
        <thead>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Performer</th>
        <th>Activity</th>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reportList}">
            <tr>
                <td>${report.startDate}</td>
                <td>${report.endDate}</td>
                <td>${report.performer}</td>
                <td>${report.activity}</td>
                <td>${pageContent.good.price}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/scand/" class="btn">Back</a>

</div>

