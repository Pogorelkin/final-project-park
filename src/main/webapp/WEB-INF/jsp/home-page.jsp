<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

 <a href="../login">Log on</a>

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