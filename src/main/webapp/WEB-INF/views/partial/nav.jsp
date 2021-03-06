<%@page language="java" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@page import="java.util.*,im.dadoo.teak.domain.*,org.apache.commons.lang3.time.*" %>

<%
  List<Category> categoryNav = (List<Category>)request.getAttribute("categoryNav");
  List<Page> pageNav = (List<Page>)request.getAttribute("pageNav");
%>

<style>
  .navbar-inverse .navbar-nav li a {
    color:white;
    font-weight: bold;
  }
</style>
<div class="navbar navbar-inverse" role="navigation" style="background-color: #368ee0;border-color:transparent">
  <div class="container">
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li><a href="/">首页</a></li>
        <% if (categoryNav != null) { %>
          <% for (Category category : categoryNav) { %>
            <li><a href="/category/<%= category.getId() %>"><%= category.getName() %></a></li>
          <% } %>
        <% } %>
        <% if (pageNav != null) { %>
          <% for (Page p : pageNav) { %>
            <li><a href="/page/<%= p.getId() %>"><%= p.getName() %></a></li>
          <% } %>
        <% } %>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>