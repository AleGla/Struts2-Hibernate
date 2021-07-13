<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Jugadores</title>
        <link href="<s:url value='recursos/estilosLista.css'/>" rel="stylesheet"/>
    </head>
    <body>
        <h1 id="texto"><p>Lista Jugadores</p></h1>
        <table class="container">
            <thead>
            <tr>
                <th><h1>Club</h1></th>
                <th><h1>Nombre</h1></th>
                <th><h1>Apellido</h1></th>
                <th><h1>Edad</h1></th>
                <th><h1>Altura</h1></th>
                <th><h1>Peso</h1></th>
                <th><h1>Eliminar</h1></th>
                <th><h1>Modificar</h1></th>
            </tr>
            </thead>
            
            <tbody>
            <s:iterator value="lista" >
                <tr>
                    <td><s:property value="%{nombreClub}"/></td>
                    <td><s:property value="%{jugador.nombre}"/></td>
                    <td><s:property value="%{jugador.apellido}"/></td>
                    <td><s:property value="%{jugador.edad}"/></td>
                    <td><s:property value="%{jugador.altura}"/></td>
                    <td><s:property value="%{jugador.peso}"/></td>
                    <td id="boton"><s:form>
                         <s:submit type="submit" name="borrar" id="borrar" value="%{idClub}" theme="simple" />
                    </s:form></td>
                    <td id="boton"><s:form>
                        <a href="modificar"><s:submit type="submit" name="borrarM" id="borrarM" value="%{idClub}" theme="simple"/></a>
                    </s:form></td>
                        
                </tr>
            </s:iterator>
            </tbody>   
        </table>
    </body>
</html>
