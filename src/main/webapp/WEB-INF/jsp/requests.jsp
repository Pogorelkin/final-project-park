<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../common/header.jsp"%>
<%@include file="../common/navigation.jsp"%>

<div class="content">
        <div>
            <div>
            <table border="1">
                <caption><h2>Request list</h2></caption>
                <thead>
                <tr>
                    <th>id</th>
                    <th>work-kind</th>
                    <th>work status</th>
                    <th>owner id</th>
                    <th>forester id</th>
                    <th>tree id</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requests}" var="request">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.workKind}</td>
                    <td>${request.status}</td>
                    <td>${request.id_owner}</td>
                    <td>${request.id_forester}</td>
                    <td>${request.id_tree}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
        </div>
    </div>

    <c:if test="${currentUserRole == '1'}">
    <div class="content">
            <form action="<c:url value="/requests/add"/>" method="post">
                <div>
                <table border="1">
                    <caption><p>Add a request</p></caption>
                    <thead>
                    <tr>
                       <th>id</th>
                       <th>workKind</th>
                       <th>status</th>
                       <th>id_owner</th>
                       <th>id_forester</th>
                       <th>id_tree</th>
                       <th>Add-button</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><label><input type="number" name="id"></label></td>
                        <td><label><input type="text" name="workKind"></label></td>
                        <td><label><input type="text" name="status"></label></td>
                        <td><label><input type="number" name="id_owner"></label></td>
                        <td><label><input type="number" name="id_forester"></label></td>
                        <td><label><input type="number" name="id_tree"></label></td>
                        <td><button type="submit">Post</button></td>
                    </tr>
                    </tbody>
                </table>
                </div>
            </form>
        </div>
         </c:if>

          <c:if test="${currentUserRole == '0'}">
          <div class="content">
            <form action="<c:url value="/requests/done"/>" method="post">
                <table border="1">
                     <caption><p>Confirm completed job</p></caption>
                     <tr>
                        <th>
                          Id of completed request
                        </th>
                     </tr>

                      <tr>
                      <td>
                         <label><input type="number" name="id"></label>
                      </td>
                      <td><button type="submit">Confirm</button></td>
                      </tr>
                </table>
            </form>
          </div>

           </c:if>

                     <c:if test="${currentUserRole == '1'}">
          <div class="content">
            <form action="<c:url value="/requests/confirm"/>" method="post">
                <table border="1">
                     <caption><p>Check completed job</p></caption>
                     <tr>
                        <th>
                          Id of completed job
                        </th>
                     </tr>

                      <tr>
                      <td>
                         <label><input type="number" name="id"></label>
                      </td>
                      <td><button type="submit">Confirm</button></td>
                      </tr>
                </table>
            </form>
          </div>

          

           </c:if>






<%@include file="../common/footer.jsp"%>