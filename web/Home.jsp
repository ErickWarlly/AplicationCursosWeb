<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="pt_BR" scope="application"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME - Page</title>
    </head>
    <body>
        <h2>Lista dos Cursos</h2>

        <div>
            <ul>
                <li><a href="cadastrardisci.do">Cadastrar Disciplina</a></li>
                <li><a href="alterardisci.do">Alterar Disciplina</a></li>
                <li><a href="deletardisci.do">Deletar Disciplina</a></li>
            </ul>
        </div>
             
            <a href="inicio.do">Listar Todos Novamente</a>
        <br>
        
        
        
        <table border=1>
            <tr>
                <th>Id Disciplina</th>
                <th>Descrição</th>
                <th>Carga Horária</th>
                <th>Curso Relacionado</th>
            </tr>
            <c:forEach var="item" items="${diciplinalista}" varStatus="cont">
                <tr>
                    <td>${item.iddisciplinas}</td>
                    <td>${item.descricao}</td>
                    <td>${item.cargahoraria}</td>
                    <td>${item.cursos}</td>    
                </tr>

            </c:forEach>
        </table>

    </body>
</html>
