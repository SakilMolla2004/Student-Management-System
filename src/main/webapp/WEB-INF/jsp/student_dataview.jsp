<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Student DataView</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<style>
body {
	background-color: #f5f7fa;
	font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
	
}
 a {
        color: #4a90e2;
        text-decoration: none;
        font-weight: bold;
    }

h2 {
	color: #3b82f6;
}

table {
	margin: 30px auto;
	border-collapse: collapse;
	width: 85%;
	background: white;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 18px;
	text-align: left;
}

th {
	background-color: #3b82f6;
	color: white;
	text-transform: uppercase;
}

tr:nth-child(even) {
	background-color: #f8faff;
}

.action-icons {
	display: flex;
	gap: 12px;
}

.action-icons i {
	cursor: pointer;
	color: #3b82f6;
	transition: color 0.3s;
}

.action-icons i:hover {
	color: #2563eb;
}
body {
  margin: 0;
  padding: 0;
}

h2, p {
  margin: 10px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  background-color: blue;
  display: flex;
  justify-content: center;
}

ul li a {
  display: block;
  color: white;
  padding: 14px 16px;
  text-decoration: none;
}

ul li a:hover {
  background-color: #111111;
}
</style>
</head>
<body>
<%@include file="navigation.jsp" %>


<button > <a href="StudentRegistration">Registration</a></button>

	

	<table>
		<thead>
			<tr>
				<th>Sem_name</th>
				<th>Name</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Dept_Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="Student" items="${List }">
				<tr>
					<td>${Student.getSem_name() }</td>
					<td>${Student.getName() }</td>
					<td>${Student.getGender() }</td>
					<td>${Student.getAddress() }</td>
					<td>${Student.getDept_name() }</td>


					<td class="action-icons"><a
						href="EditStudent?s_id=${Student.getS_id() }"> <i
							class="fa-solid fa-pen-to-square" title="Edit"></i>
					</a> <a href="StudentDataView?s_id=${Student.getS_id() }"> <i
							class="fa-solid fa-eye" title="View"></i>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

</body>
</html>
