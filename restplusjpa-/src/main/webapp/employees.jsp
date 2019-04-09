<html>
<body>
  <form action="./create_employee.jsp" method="get">
    <button>CREATE EMPLOYEE</button>
    <button formaction="./rest/serv/emp/listall">LIST ALL EMPLOYEES</button>
    <br />
    <p>
      EMPLOYEE ID <input type="text" name="id">
      <button type="submit" formaction="./rest/serv/emp/findbyid">FIND EMPLOYEE</button>
    </p>
  </form>
</body>
</html>
