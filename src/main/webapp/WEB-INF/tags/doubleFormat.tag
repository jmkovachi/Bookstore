<%@ attribute name="num" required="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${num}" />