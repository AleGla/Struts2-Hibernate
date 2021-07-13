<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Jugador</title>
<link href="<s:url value='recursos/estilos.css'/>" rel="stylesheet"/>
    </head>
    <body>
        
        <p class="texto">Modificar Jugador</p>
        <div class="Registro">    
        <s:form action="modificar">

            <s:textfield id="inputN" type="number" key="ID Jugador" value="%{borrarM}" name="id" readonly="true"/>
            <s:textfield id="input" key="Nombre" name="nombre" placeholder="introduce nombre"/>
            <s:textfield id="input" key="Apellido" name="apellido" placeholder="Introduce Apellido"/>
            <s:textfield id="inputN" type="number" key="Edad" name="edad" placeholder="Introduce Edad"/>
            <s:textfield id="input" key="Altura" name="altura" placeholder="Introduce Altura(cm)"/>
            <s:textfield id="inputN" type="number" key="Peso" name="peso" placeholder="Introduce Peso(kg)"/>
            <s:textfield id="input" key="Nombre Club" name="nombreClub" placeholder="Nombre Del Club"/>
            <s:textfield id="input" key="Categoria" name="categoria" placeholder="Introduce Categoria"/>
            <s:textfield id="input" key="Pais" name="pais" placeholder="Introduce¨Pais"/>

            <s:submit key="Modificar" id="submit"/>

        </s:form>
            </div>
    </body>
</html>
