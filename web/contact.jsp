<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Contact</title>
</head>
<body>
     <header>
        <h1>Welcome to My Portfolio</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="projects.jsp">Projects</a></li>
                <li><a href="contact.jsp">Contact</a></li>
            </ul>
        </nav>
    </header>
    <h2>Contact Me</h2>
    <form action="ContactServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br>
        <label for="message">Message:</label><br>
        <textarea id="message" name="message" required></textarea><br>
        <input type="submit" value="Submit">
    </form>
    <!-- Display success or error message -->
    <% String status = request.getParameter("status");
       if (status != null && status.equals("success")) { %>
           <p style="color: green;">Message sent successfully!</p>
    <% } else if (status != null && status.equals("error")) { %>
           <p style="color: red;">Error occurred while sending message. Please try again later.</p>
    <% } %>
     <footer>
        <p>&copy; 2024 My Portfolio</p>
    </footer>
</body>

</html>
