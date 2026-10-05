<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<h2>Upload Document</h2>
	<form action="UploadFile" method="post" enctype="multipart/form-data">
		Select File: <input type="file" name="file" required /> <br>
		<br> <input type="submit" value="Upload File">
	</form>
</body>
</html>