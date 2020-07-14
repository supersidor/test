<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
	<body>

  <table border="1">
   <tr>
    <th>shape</th>
    <th>count</th>
   </tr>
   
   <tr>
     <td> <a href="/circle">circle</a> </td>
     <td> <c:out value="${stats.circle}"/></td>
   </tr>
   <tr>
     <td> <a href="square">square</a> </td>
     <td> <c:out value="${stats.square}"/></td>
   </tr>   
   <tr>
     <td> <a href="rectangle">rectangle</a> </td>
     <td> <c:out value="${stats.rectangle}"/></td>
   </tr>   
    <tr>
     <td> <a href="ellipse">ellipse</a> </td>
     <td> <c:out value="${stats.ellipse}"/></td>
   </tr>   
  </table>	  
  
	  
	</body>
</html>
