<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tz" uri="/WEB-INF/tld/tz.tld" %>
<%
  String path = request.getContextPath();
  int port = request.getServerPort();
  String basePath = null;
  
  if(port == 80){
    basePath = request.getScheme()+"://"+request.getServerName()+path;
  }else{
    basePath = request.getScheme()+"://"+request.getServerName()+":"+port+path;
  }
  pageContext.setAttribute("basePath", basePath);             //   http://localhost/DonnieAdmin
  pageContext.setAttribute("adminPath", basePath + "/admin"); //   http://localhost/DonnieAdmin
%>
