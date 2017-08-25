<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 
   out.write("<link rel=\"stylesheet\" href=\"");
   out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
   out.write("/resources/sg/css/sg.css\"/>\r\n");
   sg.css在这一步，并没有被拆分为它所包含的各个@Import的css，并且，从Catalina目录看来，TomCat也没有编译sg.css为Java文件
       所以如果在sg.css中写${basePath}，则不能正确识别${basePath}
 -->
<script type="text/javascript">
var basePath="${basePath}";
var adminPath="${basePath}/admin";
</script>
<!-- 在 com.donnie.core.BasePathExpsoer 中，
            通过 rootPath = application.getContextPath(); 获得上下文(项目)路径，加上具体的资源文件路径，也相当于使用 绝对路径 访问了资源文件 
<link rel="stylesheet" href="${rootPath}/resources/sg/css/sg.css"/>
-->

<link rel="stylesheet" href="${basePath}/resources/sg/css/sg.css"/>
<script type="text/javascript" src="${basePath}/resources/sg/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${basePath}/resources/sg/sgutil.js"></script>
<script type="text/javascript" src="${basePath}/resources/sg/sg.js"></script>
