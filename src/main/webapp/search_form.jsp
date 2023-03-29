<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="sql" uri="jakarta.tags.sql" %>

<title>   SearchForm   </title>

<html>
    <head>
        
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Search Form</h1>
        <h3>Please Enter Username, email or any part of them</h3>  
        <form action = "search_form.jsp" method="post">
            Search: <input type="text" name="searchName" id="searchNameText">
            <input type="submit" value="search" id="searchBtn">
        </form>
        <sql:setDataSource
            driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/sakila"
            user="root" password="1234"
            var="databaseOne"
            scope="session" />
        <table>
            <tr>
                <th>id</th>
                <th>Username</th>
                <th>email</th>
                <th>password</th>
            </tr>
            
            <sql:query var="result" dataSource="${databaseOne}">
                SELECT id, user_name, email, password FROM users_custom WHERE user_name LIKE ? OR email LIKE ?;
                <sql:param value="%${param.searchName}%"/>
                <sql:param value="$%{param.searchName}%"/>
            </sql:query>
            <c:forEach items="${result.rows}" var="row">
                <tr>
                    <td><c:out value="${row.id}"/></td>
                    <td><c:out value="${row.user_name}"/></td>
                    <td><c:out value="${row.email}"/></td>
                    <td><c:out value="${row.password}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>