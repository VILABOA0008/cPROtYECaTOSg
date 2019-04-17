<html>
<body>
  <form action="./create_employee.jsp" method="get">
    <button>CREATE EMPLOYEE</button>
    <button formaction="./rest/serv/emp/listall">LIST ALL EMPLOYEES</button>
    <br />
    <p>
    
      <button type="submit" formaction="./rest/serv/emp/findbyid">FIND EMPLOYEE</button>
            <input type="text" name="id">
            </p>
            <br/>
      <button type="submit" formaction="./rest/serv/emp/findsalary">SALARY BIGGER THAN </button>
         <input type="text" name="sal">

  </form>
</body>
</html>
