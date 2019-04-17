<html>
<body>
  <form action="./create_departament.jsp" method="post">
    <p>
      DEPARTAMENT ID <input type="text" name="id_dep"> EMPLOYEE ID <input type="text" name="id_emp">
          </p>
      <button type="submit" formaction="./rest/serv/dept/asignemp">ASIGN EMPLOYEE</button>
  </form>
  <form method="get">
    <button formaction="./rest/serv/emp/listall">VIEW EMPLOYEES</button>
    <button formaction="./rest/serv/proy/listall">VIEW PROYECTS</button>
  </form>
</body>
</html>
