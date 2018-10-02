<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
        <div>
            <div>
            <table border="1">
                <caption><h2>Tree list</h2></caption>
                <thead>
                <tr>
                    <th>id</th>
                    <th>treeKind</th>
                    <th>color</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${forest}" var="tree">
                <tr>
                    <td>${tree.id}</td>
                    <td>${tree.treeKind}</td>
                    <td>${tree.color}</td>
                    <td>${tree.status}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>

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

