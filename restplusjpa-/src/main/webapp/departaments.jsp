<html>
<body>
  <form action="./create_departament.jsp" method="get">
    <button>CREATE DEPARTAMENTS</button>
    <button formaction="./rest/serv/dept/listall">LIST ALL DEPARTAMENTS</button>
    <br />
    <p>
      DEPARTAMENT ID <input type="text" name="id">
      <button type="submit" formaction="./rest/serv/dep/findbyid">FIND DEPARTAMENT</button>
    </p>
    <button formaction="./asignToDepartament.jsp" >ASSING</button>
  </form>
</body>
</html>
