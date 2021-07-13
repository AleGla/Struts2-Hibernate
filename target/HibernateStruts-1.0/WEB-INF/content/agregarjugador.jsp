<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Jugador</title>
        <link href="<s:url value='recursos/estilos.css'/>" rel="stylesheet"/>
    </head>
    <body>
        
        <p class="texto">Agregar Jugador</p>
        <div class="Registro">    
        <s:form>
            
            <s:textfield id="input" placeholder="Nombre Jugador" name="nombre"/>
            <s:textfield id="input" placeholder="Apellido Jugador" name="apellido"/>
            <s:textfield id="inputN" type="number" key="Edad Jugador" name="edad"/>
            <s:textfield id="input" placeholder="Altura Jugador" name="altura"/>
            <s:textfield id="inputN" type="number" key="Peso Jugador" name="peso"/>
            <s:textfield id="input" placeholder="Nombre Club" name="nombreClub"/>
            <s:textfield id="input" placeholder="Categoria Club" name="categoria"/>
            <s:textfield id="input" placeholder="Pais Club" name="pais"/>

            <s:submit key="Agregar" id="submit"/>
        </s:form>
            
        </div>
    </body>
</html>
