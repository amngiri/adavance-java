<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" modelAttribute="user">
		<table>
				<tr>
				<td>Name</td>
				<td><form:input path="playerName" /></td>
			</tr>

			<tr>
				<td>Team</td>
				<td><form:select path="teamName" >
				<form:option value="England">England</form:option>
				<form:option value="India">India</form:option>
				<form:option value="Srilanka">Srilanka</form:option>
				</form:select></td>
			</tr>

			<tr>
				<td>Role</td>
				<td><form:select path="role" >
				<form:option value="Batsman">BatsMan</form:option>
				<form:option value="Bowler">Bowler</form:option>
				</form:select></td>
			</tr>

			<tr>
				<td>Matches played</td>
				<td><form:input path="matches" /></td>
			</tr>
			
			<tr>
				<td>Run / Wickets</td>
				<td><form:input path="stats" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="register" /></td>
			</tr>

		</table>

	</form:form>
</body>
</html>