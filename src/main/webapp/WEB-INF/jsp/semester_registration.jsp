    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
       

        body { font-family: sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }
        .container { background-color: white; padding: 20px 40px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); width: 400px; }
        h1 { text-align: center; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #000000; }
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
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
         input, select {
      width: 100%;
      padding: 10px;
      margin-bottom: 18px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 15px;
      transition: border-color 0.2s ease, box-shadow 0.2s ease;
        button[type="submit"]:hover { background-color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Register </h1>
        <form action="Semesters" method="POST">
             <div class="form-group">
                <label for="sem_code">Semester Code:</label>
<input type="text" name="sem_code" id="sem_code" required>
 </div>
           
            <div class="form-group">
                
<label for="sem_name">Semester Name:</label>
<input type="text" name="sem_name" id="sem_name" required>
            </div>
             <div class="form-group">
                <label for="year_code">Year Name:</label>
<select name="year_code" id="year_code" required>
<c:forEach var="year" items="${YearList }">
<option value="${year.getYear_name() }">${year.getYear_name() }</option>
</c:forEach>
</select>
            </div>
            
            <button type="submit">Register</button>
        </form>
    </div>
</body>
</html>



