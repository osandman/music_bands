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
    <form>
        <label for="bandNameSearch">Band name</label>
        <br>
        <input type="search" id="bandNameSearch" placeholder="Band name.."
               value="Nirvana">
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
        <button class="button styled" onclick="openFindBand()">Find</button>
    </form>
</div>

<p id="test">
    -----------------------
</p>


<br>
<a href="${pageContext.request.contextPath}/band?name=metall">Bands</a>
</body>
</html>
