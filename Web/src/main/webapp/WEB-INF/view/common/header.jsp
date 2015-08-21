<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row" id="header">
    <div class="span11">
        <h2>
            <spring:message code="message.welcome_anonim"/>
        </h2>
    </div>
    <div class="span1">
        <a href="?locale=en">en</a>
        |
        <a href="?locale=ru">ru</a>
    </div>
</div>

