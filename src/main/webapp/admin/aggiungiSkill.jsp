<%@ page contentType="text/html;" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.candidatoDB.pw2.entity.*"%>
<%@ page import="com.candidatoDB.pw2.interfaces.impl.*"%>
<%@ page import="com.servlets.pw2.controller.ErrorManager"%>
<%@ page isELIgnored="false"%>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    QuizIMPL quizImpl = new QuizIMPL();

    ArrayList<Quiz> all_quizzes = quizImpl.getAllQuiz();

%>

<html>
<head>

    <title>Aggiungi Skill</title>
    <link rel="icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/img/logoPag.png"
          style="border-radius: 10px">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />
</head>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/homeuser.css">
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/modificaPosizione.css">

<body style="background-color: #d4d4d4;">




<main style="margin: 50px; padding: 0;">

    <div class="container mt-5">

        <div class="row flex-lg-nowrap">
            <div class="col">
                <div class="row">
                    <div class="col mb-3">
                        <div class="card mt-4" style="border: 2px solid blue;">
                            <div class="card-body">
                                <%
                                    if (!ErrorManager.getSUccessMessage((HttpServletRequest) request).isEmpty()) {
                                %>
                                <div class="alert alert-success">
                                    <%=ErrorManager.getSUccessMessage((HttpServletRequest) request)%>
                                </div>
                                <%
                                    }
                                    ;
                                %>
                                <%
                                    if (!ErrorManager.getErrorMessage((HttpServletRequest) request).isEmpty()) {
                                %>
                                <div class="alert alert-danger">
                                    <%=ErrorManager.getErrorMessage((HttpServletRequest) request)%>
                                </div>
                                <%
                                    }
                                    ;
                                %>
                                <%
                                    if (!ErrorManager.getOtherMessage((HttpServletRequest) request).isEmpty()) {
                                %>
                                <div class="alert alert-warning">
                                    <%=ErrorManager.getOtherMessage((HttpServletRequest) request)%>
                                </div>
                                <%
                                    }
                                    ;
                                %>

                                <div class="e-profile">

                                    <div class="tab-content pt-3">
                                        <div class="tab-pane active justify-content-center">
                                            <form class="form" method="post"
                                                  action="${pageContext.request.contextPath}/gestioneSkill">

                                                <div class="row">
                                                    <div class="form-group">
                                                        <label for="nome" class="form-label">Nome</label>
                                                        <input type="text" class="form-control" name="nome" id="nome"  required>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="form-group">
                                                        <label>Tipologia</label> <select class="form-select" name="tipologia">

                                                        <option value="hard">Hard</option>
                                                        <option value="soft" selected>Soft</option>

                                                    </select>
                                                    </div>
                                                </div>



                                                <div class="row">
                                                    <div class="form-group">
                                                        <label>Quiz </label> <select class="form-select"
                                                                                     name="quiz" aria-label="Default select example">
                                                        <%
                                                            for (Quiz q : all_quizzes) {
                                                        %>
                                                        <option value="<%=q.getId_quiz()%>"><%=q.getDescrizione()%></option>
                                                        <%
                                                            }
                                                        %>
                                                    </select>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col d-flex justify-content-center">
                                                        <button class="btn btn-primary" type="submit">Salva</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</main>

</body>
</html>
