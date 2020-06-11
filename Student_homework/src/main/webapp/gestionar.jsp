<html>
<link rel="stylesheet" type="text/css" href="estilo.css">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function () {
 var btn=$('#carga').val();
 $.post('ServeletGestionarDocentes',{

 },function(respose){
 let datos= JSON.parse(respose);
// console.log(datos);
var tabladato=document.getElementById('tablaDatos');
for(let item of datos){
	tabladato.innerHTML += `
	
<tr>
<td>${item.idDocente}</td>
<td>${item.nombre_Dct}</td>
<td>${item.apellido_Dct}</td>
<td>${item.dui}</td>
<td>${item.telefono}</td>
<td>${item.edad}</td>
<td>${item.contrasena}</td>
<td>${item.turno}</td>
<td>${item.estado}</td>
<td>${item.direccion}</td>
<td>${item.fechaNacimiento}</td>
<td>

<a href="ServeletGestionarDocentes?btn=Eliminar&Id=${item.idDocente}" class="btn btn-warning">Eliminar Registro</a>
<a href="gestionar.jsp?idD=${item.idDocente}&n=${item.nombre_Dct}&A=${item.apellido_Dct}&N=${item.dui}&T=${item.telefono}&E=${item.edad}&p=${item.contrasena}&t=${item.turno}&activo=${item.estado}&D=${item.direccion}&f=${item.fechaNacimiento}" class="btn btn-danger">Actualizar</a>
</td>
</tr>
`
}
});
});
</script>
<%
String id = request.getParameter("idD");
String nombre= request.getParameter("n");
String apellido = request.getParameter("A");
String numero_Dui = request.getParameter("N");
String telefono = request.getParameter("T");
String edad = request.getParameter("E");
String contrasena = request.getParameter("p");
String turno = request.getParameter("t");
String  estado =request.getParameter("activo");
String Direccion = request.getParameter("D");
String Fechas =request.getParameter("f");

if(id==null){
	id="";
	nombre="";
	apellido="";
	numero_Dui="";
	telefono="";
	edad="";
contrasena="";
	turno="";
	estado ="";
	Direccion="";
	Fechas="";
		
}

%>
<body Style ="background:url('data:image/jpeg;base64,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')">

<form action="ServeletGestionarDocentes">
<h1>Gestionar Docentes</h1>
 
    <div class="wrapper">
        <div class="contact-form">
            <did class="input-fields">
               <input type="text" class="input" name="Id" id="Idcarga" value="<%=id%>" placeholder="Ingrese EL numero ID"><br>
               
                <input type="text" class="input" name="nombre" id="Nom" value="<%=nombre%>" placeholder="Ingrese Sus nombre"><br>
<input type="password" class="input" name="contrasena" id="contrasena" value="<%=contrasena%>" placeholder="Ingrese Sus Contraseña"><br>

                <input type="text" class="input" name="apellido" id="Ape" value="<%=apellido%>" placeholder="Ingrese Sus apellidos"><br>
                <input type="text" class="input" name="Dui" id="Dui" value="<%=numero_Dui%>"  placeholder="Ingrese Su DUI">
                <input type="text" class="input" name="telefono" id="telefono" value="<%=telefono%>"  placeholder="Ingrese Su Numero Telefonico">
                <input type="text" class="input" name="edad" id="edad" value="<%=edad%>"  placeholder="Ingrese Su Edad Actual">
                
                 <input type="text" class="input" name="Direccion" id="Direccion" value="<%=Direccion%>"  placeholder="Ingrese su Direccion ">
                <label  for="Mañana">turno</label>
	<select  class="controls" name="turno" id="turno" value="<%=turno%>">

<option>mañana</option>
<option>tarde</option>
<option>noche</option>
<option>tarde  y  noche</option>
<option>mañana y  tarde</option>
<option>mañana y  noche</option>
</select> 
 <label  for="Mañana">estado</label>5
<select  class="controls" name="estado" id="estado" value="<%=estado%>">

<option>activo</option>
<option>inactivo</option>
</select> 
          
            <input type="text" class="input" name="Fechas" id="Fechas" value="<%=Fechas%>"  placeholder="Ingrese su Fechas de Nacimiento "><br>
             <div class="msg">

                
                <div  "btn">
                    <input type="submit" class="btn btn-primary" value="GUARDAR_ACTUALIZACION" name="btn">
                </div>
                <div align="left" class="btn">
               <a href="Registro.jsp" class="btn btn-success">Registrar nuevo Docente</a>
                </div> 
              
                <input type="submit" class="btn btn-primary" value="carga" name="carga"i="carga">
               
                </div>   
            </did>
       
            </div>
        </div>
   

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<h1 align="center"class="text-secondary">Gestion de Registro De Docentes</h1>



		
<table class="table table-dark" id="tablaDatos">
	<thead>
	
	
		<th>idDocente</th>
		<th>Nombre_Dct</th>
		<th>Apellido_Dct</th>
		 <th>Dui</th>
	    <th>Telefono</th>
	     <th>Edad</th>
	<th>contrasena</th>
		<th>turno</th>
		<th>Estado</th>
		<th>Direccion</th>
		<th>FechaNacimiento</th>
		
       <th>opciones</th>
	</thead>
	<tbody>
		
	</tbody>
</table>
		
</form>				
</body>
</html>