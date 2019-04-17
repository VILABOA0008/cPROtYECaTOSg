<html>
<body>
  <form action="./create_proyect.jsp" method="get">
    <button>CREATE PROYECTS</button>
    <button formaction="./rest/serv/proy/listall">LIST ALL PROYECTS</button>
    <br />
    <p>
      PROYECT ID <input type="text" name="id">
      <button type="submit" formaction="./rest/serv/proy/findbyid">FIND DEPARTAMENT</button>
    </p>
    <button formaction="./asignToProyect.jsp" >ASSING</button>
  </form>
</body>
</html>
