<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/example.css" type="text/css" />
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.1.js"></script>
   <script>
   $( function() {
      $("#submit").click(function () {
         var number = encodeURIComponent($("#number").val());
         var calculateUrl = "${pageContext.request.contextPath}/app/fibonacci/" + number;
         $("#result").load(calculateUrl);
      });
   });
   </script>
   <title>The Ultimate Fibonacci Number Calculator!</title>
</head>
<body>
   <h1>Calculate Fibonacci Number</h1>
   <form>
   <p>Enter  a number to calculate its fibonacci number</p>
   <input id="number" type="text" name="number" />
   <input id="submit" type="button" value="Calculate" />
   </form>

   <p id="result"/>
</body>
</html>