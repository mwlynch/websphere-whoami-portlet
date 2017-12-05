<%@ page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:defineObjects />

<html>
<head>

</head>

<body>
<c:out value="${renderRequest.getAttribute('whoami')}" />
<iframe src="/wps/proxy/https/example.com/whoami/servlet">
</iframe>
</body>
</html>
