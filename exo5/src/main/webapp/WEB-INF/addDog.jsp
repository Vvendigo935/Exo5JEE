<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Form</title>
</head>
<body>
<h1>Form to add your doggo :</h1>
<form action="show" method="post">
  <div>
    <label for="name">Name : </label>
    <input type="text" name="name" id="name">
  </div>
  <div>
    <label for="breed">Breed : </label>
    <input type="text" name="breed" id="breed">
  </div>
  <div>
    <label for="dateOfBirth">Birth Date : </label>
    <input type="date" name="dateOfBirth" id="dateOfBirth">
  </div>
  <button>Add</button>
</form>

</body>
</html>