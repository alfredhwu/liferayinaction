<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<jsp:useBean id="userName" class="java.lang.String" scope="request"></jsp:useBean>


<portlet:defineObjects />

This is the Hello You portlet.
<br/>
<p>Hello <%= userName %>!</p>
