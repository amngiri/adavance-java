<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:setProperty property="*" name="tutorial" />
<c:redirect
	url="${sessionScope.tutorial.validateAndInsertTutorial()}.jsp" />
