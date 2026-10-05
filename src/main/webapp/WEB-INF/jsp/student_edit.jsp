<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Registration Form</title>
<style>
body {
	font-family: sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
}

.container {
	background-color: white;
	padding: 20px 40px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	width: 400px;
}

h1 {
	text-align: center;
	color: #333;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
	color: #000000;
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"]
	{
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box;
}

select {
	appearance: none;
	background-color: #fff;
	background-image:
		url("data:image/svg+xml;utf8,<svg fill='%23007bff' height='20' viewBox='0 0 24 24' width='20' xmlns='http://www.w3.org/2000/svg'><path d='M7 10l5 5 5-5z'/></svg>");
	background-repeat: no-repeat;
	background-position: right 10px center;
	background-size: 16px;
	cursor: pointer;
}

input, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 18px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 15px;
	transition: border-color 0.2s ease, box-shadow 0.2s ease;
}

input:focus, select:focus {
	border-color: #007bff;
	box-shadow: 0 0 4px rgba(0, 123, 255, 0.4);
	outline: none;
}

button[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

button[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Register</h1>

		<form action="EditStudent" method="Post">
			<input type="hidden" name="s_id" id="s_id" value="${st.getS_id()}">

			<div class="form-group">
				<label for="sem_code">Semester Name:</label> <input type="text"
					id="sem_code" name="sem_code" value="${st.getSem_code() }" required>

			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" id="name"
					name="name" value="${st.getName()}" required>
			</div>

			<div class="form-group">
				<label for="gender">Gender:</label> <select name="gender"
					id="gender" required>
					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="others">Others</option>
				</select>
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input type="text"
					id="address" name="address" value="${st.getAddress() }" required>
			</div>
			<div class="form-group">
				<label for="dept_code">Dept_code:</label> <input type="text"
					id="dept_code" name="dept_code" value="${st.getDept_code() }"
					required>
			</div>
			<button type="submit">Update</button>
		</form>
	</div>
</body>
</html>