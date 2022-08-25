<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR" scope="application"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar Disciplina</title>
    </head>
    <body>
        <h2>Deletar</h2>

        <form name="delete_form" action="deletar.do" method="post">
            <label>ATENÇÃO AO SELECIONAR A DISCIPLINA:</label>
            <br><br>
            <select name="selectDisc">
                <option value="#">Escolha a Disciplina....</option>             
                <c:forEach var="li" items="${discilista}" varStatus="cont"> 
                    <option name="id" value="${li.iddisciplinas}">${li.descricao}</option>
                </c:forEach>
            </select>
            <br> <br>
            <input type="reset" value="Cancelar">
            <input type="submit" value="Deletar Disciplina!">
            <br><br>
            <a href="inicio.do">Voltar para HOME</a>
            <br><br>
            ${mensagem}
        </form>
    </body>
</html>
