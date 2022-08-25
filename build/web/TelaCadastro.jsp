<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR" scope="application"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h2>Cadastro de Disciplinas</h2>

        <form name="cadastro_form" action="cadastro.do" method="post">
            <label>Preencha todos os campos para cadastrar uma disciplina!</label>
            <br> <br>        
            <label>Nome da Disciplina:</label>
            <input type="text" required name="descricao">
            <br> <br>
            
            <label>Relacionar com algum curso:</label>
            <select name="seletor">
                <option value="#">Escolha de curso....</option>
                <c:forEach var="list" items="${cursolista}" varStatus="cont"> 
                    
                    <option name="id" value="${list.idcursos}">${list.descricao}</option>
                    
                </c:forEach>
            </select>

            <br> <br>
            <label>Qual a Carga Horária:</label>
            <input type="number" name="cargahora" required placeholder="Valor máximo de 200 horas!">
            <br> <br>
            <input type="reset" value="Limpar Campos">
            <input type="submit" value="Cadastrar Disciplina">
            <br><br>
            <a href="inicio.do">Voltar para HOME</a>
            <br><br>
            ${mensagem}
        </form>
        
        
        
    </body>
</html>
