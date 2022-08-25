<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR" scope="application"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Informações</title>
    </head>
    <body>
        <h2>Alterar Dados das Disciplinas!</h2>

        <form name="update_form" action="update.do" method="post">
            <label>Preencha todos os campos para alterar!</label>

            <label>Qual a disciplina deseja alterar: </label>
            <select name="selectDisc">
                <option value="#">Escolha a Disciplina....</option>
                <c:forEach var="li" items="${discilista}" varStatus="cont"> 

                    <option name="id" value="${li.iddisciplinas}">${li.descricao}</option>

                </c:forEach>
            </select>

            <br> <br>        

            <label>Relacionar com algum curso:</label>
            <select name="seletor">
                <option value="#">Escolha de curso....</option>
                <c:forEach var="list" items="${cursolista}" varStatus="cont"> 

                    <option name="id" value="${list.idcursos}">${list.descricao}</option>

                </c:forEach>
            </select>

            <br> <br>
            <label>Adicionar uma Carga Horária:</label>
            <p>Se não deseja adicionar (ou alterar CH) apenas adicione 0.</p>
            <input type="number" name="cargahora" required placeholder="Valor máximo de 200 horas!">
            <br> <br>
            <input type="reset" value="Limpar Campos">
            <input type="submit" value="Alterar Disciplina">
            <br><br>
            <a href="inicio.do">Voltar para HOME</a>
            <br><br>
            ${mensagem}
        </form>
    </body>
</html>
