
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Teachers Details</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <style>
    body {
      background-color: #f4f6f9;
      font-family: "Segoe UI", Arial, sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .container {
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
      padding: 40px 50px;
      width: 450px;
      animation: fadeIn 0.4s ease-in;
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(10px); }
      to { opacity: 1; transform: translateY(0); }
    }

    .header {
      text-align: center;
      margin-bottom: 30px;
    }

    .header h2 {
      color: #2563eb;
      font-size: 26px;
      margin-bottom: 8px;
    }

    .header p {
      color: #6b7280;
      font-size: 14px;
      margin: 0;
    }

    .details {
      line-height: 1.8;
      color: #333;
    }

    .details .label {
      font-weight: 600;
      color: #1e293b;
    }

    .details p {
      margin: 8px 0;
      border-bottom: 1px solid #e5e7eb;
      padding-bottom: 6px;
    }

    .actions {
      text-align: center;
      margin-top: 25px;
    }

    .actions a {
      text-decoration: none;
      background-color: #2563eb;
      color: #fff;
      padding: 10px 20px;
      border-radius: 6px;
      transition: background-color 0.3s;
      font-size: 14px;
      margin: 0 5px;
    }

    .actions a:hover {
      background-color: #1e40af;
    }

    .actions .back {
      background-color: #6b7280;
    }

    .actions .back:hover {
      background-color: #4b5563;
    }
  </style>
</head>
<body>

  <div class="container">
    <div class="header">
      <h2><i class="fa-solid fa-user-graduate"></i> Teachers Details</h2>
      <img alt="" src="ViewFile?file=${teachers.getImage() }" height="100px" width="100px">
    </div>
    <p>
				<span class="label">Name:</span> ${teachers.name}
			</p>
 
    <div class="details">
 

<c:forEach var="t" items="${teacher}">

    <p>${t.sub_name},${t.sem_code },${t.dept_code}</p>
</c:forEach>

    <div class="actions">
      
      <a href="Logout" class="back"><i class="fa-solid fa-pen-to-square"></i> Back</a>
    </div>
  </div>

</body>
</html>
