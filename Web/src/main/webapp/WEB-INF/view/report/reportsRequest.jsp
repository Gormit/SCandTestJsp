<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div class="span12">

    <form action="reports.do" method="get">
        <table>
            <tr>
                <td>Start Date</td>
                <td>
                    <input type="date" name="startDate" value=""/></td>
                </td>
            </tr>
            <tr>
                <td>End Date</td>
                <td>
                    <input type="date" name="endDate" value=""/></td>
                </td>
            </tr>
            <tr>
                <td>Performer</td>
                <td>
                    <select name="performer">
                        <option selected value="all">All Performers</option>
                        <c:forEach items="${performersList}" var="performer">
                            <option value="${performer.performer}">${performer.performer}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Time Period</td>
                <td>
                    <select name="timePeriod">
                        <option selected value=""></option>
                        <option value="lastQtr">Last Qtr</option>
                        <option value="lastMonth">Last Month</option>
                        <option value="lastCalendarYear">Last Calendar Year</option>
                        <option value="currentYearToDate">Current Year to Date</option>
                        <option value="currentQtrToDate">Current Qtr to Date</option>
                        <option value="currentMonthToDate">Current Month to Date</option>
                    </select>
                </td>
            </tr>
        </table>

        <button id="submit" type="submit" class="btn btn-info"><spring:message code="button.search"/></button>

    </form>
</div>