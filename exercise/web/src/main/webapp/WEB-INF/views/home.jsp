<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/example.css" type="text/css" />
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.8.1.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/numeric.jquery.js"></script>
   <script>
   $( function() {
       $('#fibonacciCalculatorForm').submit(function() {
          var number = $("#number").val();
          if( ! number || $.trim(number) === "") {
              number = "empty";
          }

          var urlEncodedNumber = encodeURIComponent(number)
          var calculateUrl = "${pageContext.request.contextPath}/app/fibonacci/" + urlEncodedNumber;
          $("#result").load(calculateUrl);

          return false;
       });

   });
   </script>
   <title>The Ultimate Fibonacci Number Calculator!</title>
</head>
<body>
   <h1>Calculate Fibonacci Number</h1>
   <form id="fibonacciCalculatorForm">
   <p>Enter  a number to calculate its fibonacci number</p>
   <input id="number" type="text" name="number" />
   <input id="submit" type="submit" value="Calculate" />
   </form>

   <p id="result"/>
</body>
</html>