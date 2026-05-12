<%@ page import="java.sql.*" %>

<html>
<head>

<title>View Booking</title>

<style>

body{

    font-family:Arial;

    background:#f4f4f4;

    padding:40px;
}

h1{

    text-align:center;

    margin-bottom:30px;
}

table{

    width:90%;

    margin:auto;

    border-collapse:collapse;

    background:white;

    box-shadow:0 0 10px rgba(0,0,0,0.2);
}

th{

    background:#0097b2;

    color:white;

    padding:15px;
}

td{

    padding:15px;

    text-align:center;

    border-bottom:1px solid #ddd;
}

tr:hover{
    background:#f1f1f1;
}

</style>

</head>

<body>

<h1>Vaccination Bookings</h1>

<table>

<tr>

<th>ID</th>
<th>Full Name</th>
<th>Age</th>
<th>Vaccine</th>
<th>Hospital</th>
<th>Date</th>

</tr>

<%

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/immunityplus",
"root",
"Root123@"
);

Statement st = con.createStatement();

ResultSet rs =
st.executeQuery(
"SELECT * FROM vaccination"
);

while(rs.next()){

%>

<tr>

<td><%= rs.getInt("id") %></td>

<td><%= rs.getString("fullname") %></td>

<td><%= rs.getInt("age") %></td>

<td><%= rs.getString("vaccine") %></td>

<td><%= rs.getString("hospital") %></td>

<td><%= rs.getString("booking_date") %></td>

</tr>

<%
}
%>

</table>

</body>
</html>