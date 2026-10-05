<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Details</title>
    
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    
    <link href="css/style.css" rel="stylesheet">
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <style>
        .profile-container {
            padding-top: 50px;
            padding-bottom: 50px;
        }

        /* Deep black title styling */
        .card-title-dark {
            color: #111827 !important;
            font-weight: 700;
        }

        /* Lite black / crisp charcoal labels */
        .text-label-dark {
            color: #4b5563 !important; 
            font-weight: 600;
            font-size: 13px;
            letter-spacing: 0.5px;
            display: flex;
            align-items: center;
        }

        /* Styling for the new column logos/icons */
        .text-label-dark i {
            margin-right: 8px;
            color: #2563eb; /* Theme blue icon color */
            font-size: 14px;
            width: 16px;
            text-align: center;
        }

        /* Deep black value text */
        .text-value-dark {
            color: #1f2937 !important;
            font-weight: 600;
            margin-top: 6px;
            padding-left: 24px; /* Aligns text beautifully beneath the label logo */
        }

        .actions {
            text-align: center;
            margin-top: 30px;
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
            background-color: #4b5563;
        }

        .actions .back:hover {
            background-color: #374151;
        }
        
        .img-profile-avatar {
            object-fit: cover;
            border-radius: 50%;
            border: 3px solid #d1d5db;
        }
        
        /* Teacher badges with distinct dark text */
        .teacher-badge {
            display: block;
            background: #f3f4f6;
            border-left: 4px solid #2563eb;
            padding: 10px 14px;
            margin-bottom: 8px;
            border-radius: 0 4px 4px 0;
            font-size: 14px;
            color: #1f2937;
        }

        .teacher-badge strong {
            color: #111827;
        }

        .teacher-subject {
            color: #4b5563;
            font-weight: 500;
        }

        .detail-item {
            margin-bottom: 22px;
            border-bottom: 1px solid #e5e7eb;
            padding-bottom: 8px;
        }
    </style>
</head>

<body class="card-no-border" style="background-color: #f3f4f6;">
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    
    <div class="container profile-container">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8 col-sm-12">
                <div class="card shadow">
                    <div class="card-body">
                        <center class="m-t-20">
                            <img src="ViewFile?file=${st.getImage()}" class="img-circle img-profile-avatar" width="150" height="150" alt="Student Photo"/>
                            
                            <h4 class="card-title-dark m-t-15" style="text-transform: capitalize;">${st.name}</h4>
                        </center>
                    </div>
                    
                    <div class="card-body">
                        <div class="detail-item">
                            <small class="text-label-dark">
                                <i class="fa-solid fa-venus-mars"></i> GENDER
                            </small>
                            <h6 class="text-value-dark" style="text-transform: capitalize;">${st.gender}</h6>
                        </div>

                        <div class="detail-item">
                            <small class="text-label-dark">
                                <i class="fa-solid fa-calendar-days"></i> SEMESTER CODE
                            </small>
                            <h6 class="text-value-dark">${st.sem_code}</h6>
                        </div>

                        <div class="detail-item">
                            <small class="text-label-dark">
                                <i class="fa-solid fa-graduation-cap"></i> DEPARTMENT CODE
                            </small>
                            <h6 class="text-value-dark">${st.dept_code}</h6>
                        </div>

                        <div class="detail-item">
                            <small class="text-label-dark">
                                <i class="fa-solid fa-location-dot"></i> ADDRESS
                            </small>
                            <h6 class="text-value-dark">${st.address}</h6>
                        </div>
                        
                        <div class="m-t-25">
                            <small class="text-label-dark db m-b-10">
                                <i class="fa-solid fa-chalkboard-user"></i> ASSIGNED FACULTY & SUBJECTS
                            </small>
                            <c:forEach var="sts" items="${Students}">
                                <div class="teacher-badge">
                                    <strong>${sts.t_name}</strong> 
                                    <span class="teacher-subject">(${sts.sub_name})</span>
                                </div>
                            </c:forEach>
                        </div>
                        
                        <div class="actions">
                            <a href="Logout" class="back">
                                <i class="fa-solid fa-arrow-left"></i> Back
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="assets/plugins/jquery/jquery.min.js"></script>
    <script src="assets/plugins/bootstrap/js/popper.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.slimscroll.js"></script>
    <script src="js/waves.js"></script>
    <script src="js/custom.min.js"></script>
</body>

</html>