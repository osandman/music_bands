<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Music bands project</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="script/script.js" defer></script>

</head>
<body>
<p>Hello, bro!</p>

<div>
    <form name="searchForm" action="${pageContext.request.contextPath}/band"
          id="searchFormId"
          method="get" target="_self"
          onsubmit="addText()">
        <label for="bandNameInput">Enter band name</label>
        <br>
        <input type="search" id="bandNameInput" placeholder="Band name.."
               name="name" value="Nirvana">
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
        <input type="submit" class="button styled"
               id="searchBandButton" value="Find">
    </form>
</div>

<br>
<div>
    <div>You searched for:</div>
    <div class="shadowbox" id="bottomText">

    </div>
</div>

<br>
<a href="${pageContext.request.contextPath}/band?name=metall">Bands</a>

<%--<script>--%>
<%--    var input = document.getElementById("bandNameInput");--%>
<%--    input.addEventListener("keypress", function (event) {--%>
<%--        if (event.key === "Enter") {--%>
<%--            event.preventDefault()--%>
<%--            // alert("Catch event!!!");--%>
<%--            document.getElementById("searchBandButton").click();--%>
<%--        }--%>
<%--    });--%>
<%--</script>--%>

</body>
</html>
