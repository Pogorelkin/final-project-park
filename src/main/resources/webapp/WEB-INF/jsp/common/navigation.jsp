<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="menu-navi">
        <header>
            <div>
                <nav>
                    <a href="<c:url value="/forest"/>">Tree list</a>
                    <c:if test="${currentUserRole == '1'}">
                         <a href="<c:url value="/registration"/>">Register new forester</a> /** mb add possibility create any role user **/
                    </c:if>
                    <a href="<c:url value="/requests"/>">Requests</a>
                    <a class="reg-url" href="<c:url value="/index"/> ">Logout</a>
                </nav>
            </div>
        </header>
    </div>