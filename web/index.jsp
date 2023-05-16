<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music bands project</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="script/script.js" defer></script>
</head>
<body>
<p>Hello, bro!</p>

<div>
    <form name="find">
        <label for="bandName">Band name</label>
        <br>
        <input type="text" id="bandName" placeholder="Band name.." value="Nirvana">
        <!--        <br>-->
        <!--        <label for="country">Country</label>-->
        <!--        <br>-->
        <!--        <select id="country" name="country">-->
        <!--            <option value="blank"></option>-->
        <!--            <option value="uk">UK</option>-->
        <!--            <option value="Germany">Germany</option>-->
        <!--            <option value="usa">USA</option>-->
        <!--        </select>-->
        <br>
        <input type="submit" value="Find" onclick="openFindBand()">
    </form>
</div>

<p id="test">
    -----------------------
</p>


<br>
<a href="${pageContext.request.contextPath}/band?name=metall">Bands</a>
</body>
</html>
