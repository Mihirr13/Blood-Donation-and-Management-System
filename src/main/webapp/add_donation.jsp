<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession officerSession = request.getSession(false);
    if (officerSession == null || officerSession.getAttribute("officerId") == null) {
        response.sendRedirect("officer_login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Record Blood Donation</title>
    <style>
        body { font-family: Arial; background: #f5f5f5; }
        .container {
            width: 400px; margin: 50px auto; background: white;
            padding: 25px; border-radius: 10px; box-shadow: 0 0 10px #ccc;
        }
        input, select { width: 100%; padding: 10px; margin: 10px 0; }
        input[type=submit] {
            background-color: #e53935; color: white; border: none; cursor: pointer;
        }
        input[type=submit]:hover { background-color: #c62828; }
    </style>
</head>
<body>
<div class="container">
    <h2>Record Blood Donation</h2>
    <form action="AddDonationServlet" method="post">
        <input type="number" name="donorId" placeholder="Donor ID" required />
        <input type="text" name="name" placeholder="Name">
        <input type="date" name="donationDate" required />
        <select name="bloodGroup" required>
            <option value="">Select Blood Group</option>
            <option>A+</option><option>A-</option>
            <option>B+</option><option>B-</option>
            <option>AB+</option><option>AB-</option>
            <option>O+</option><option>O-</option>
        </select>
        <input type="text" name="location" placeholder="Location" required />
        <input type="submit" value="Record Donation" />
    </form>
</div>
</body>
</html>
