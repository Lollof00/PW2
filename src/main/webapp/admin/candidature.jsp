<%@ page import="java.util.ArrayList" %>
<%@ page import="com.candidatoDB.pw2.interfaces.impl.*" %>
<%@ page import="com.candidatoDB.pw2.entity.*" %>
<%@ page import="com.servlets.pw2.controller.ErrorManager" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;" language="java"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<html>
<head>
    <title>Candidature</title>
    <link rel="icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/img/logoPag.png"
          style="border-radius: 10px">

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous" />
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" />

    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/ricerca_posizioni.css" />

    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/homeuser.css" />



</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>


<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    PosizioneIMPL posizioneIMPL = new PosizioneIMPL();
    ArrayList<Posizione> posizioni;

    CandidaturaUserIMPL candidaturaUserIMPL = new CandidaturaUserIMPL();

    ArrayList<Citta> cities = new CittaIMPL().getAllCitta();
    ArrayList<Regione> regioni = new RegioneIMPL().getAllRegioni();

    if(request.getAttribute("risultatiRicerca")==null){
        posizioni = posizioneIMPL.getAllPosizioni();
    }else{
        posizioni = (ArrayList<Posizione>) request.getAttribute("risultatiRicerca");
    }

    ArrayList<String> ruoli = posizioneIMPL.getAllRuoli();

    CategoriaPosizioneIMPL categoriaPosizioneIMPL = new CategoriaPosizioneIMPL();
    ArrayList<CategoriaPosizione> categorie_posizioni = categoriaPosizioneIMPL.getAllCategoriePosizioni();

    Utente utente_admin = (Utente) request.getSession().getAttribute("admin");
%>


<body style="background-color: #d4d4d4">

<jsp:include page="/admin/jspA/navbarHeaderAdmin.jsp" />


<h1>Candidature</h1>

<nav class="navbar navbar-expand-lg bg-light"
style="position: fixed; align-items:center; display:flex; top:85px; left:21.25%; height:10%; width: 70%; z-index:2; border-radius:20px; justify-content:space-around; border:3px solid #0072bc;">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/candidature.jsp">Ricerca Posizioni</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <form class="form-inline" action="${pageContext.request.contextPath}/RicercaCandidatureServlet"
          method="post">
        <div class="collapse navbar-collapse justify-content-center mt-4 p-2" id="navbarSupportedContent">
            <div class="form-group" aria-labelledby="navbarDropdown" style="margin-right:10px">
                <select class="form-select" name="ruolo" aria-label="Default select example">
                    <option disabled selected>Ruolo</option>
                    <option value="">Tutti</option>
                    <%
                        for(String r : ruoli){
                    %>
                    <option value="<%=r%>"><%=r%></option>
                    <%
                        };
                    %>
                </select>

            </div>
            <div class="form-group" aria-labelledby="navbarDropdown" style="margin-right:10px">
                <select class="form-select" name="citta" aria-label="Default select example">
                    <option disabled selected>Citt�</option>
                    <option value="">Tutte</option>
                    <%
                        for(Regione r : regioni) {
                    %>
                    <optgroup label="<%=r.getNome()%>">
                            <%
                                             for(Citta c : cities){
												 if(c.getRegione().getNome().equals(r.getNome())){
													 %>
                        <option value="<%=c.getId_citta()%>"><%=c.getNome()%></option>
                            <%
												 }
											 }
									}
									%>
                </select>

            </div>
            <div class="form-group" aria-labelledby="navbarDropdown" style="margin-right:10px">
                <select class="form-select" name="categoria" aria-label="Default select example">
                    <option disabled selected>Categoria</option>
                    <option value="">Tutte</option>
                    <%
                        for(CategoriaPosizione cat : categorie_posizioni){
                    %>
                    <option value="<%=cat.getId_categoria()%>"><%=cat.getNome_categoria()%></option>
                    <%
                        };
                    %>

                </select>
            </div>
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerca</button>
        </div>
    </form>
</nav>


<main style="margin-top: 58px">
    <div class="container pt-3">



        <div class="container">
            <div class="row">

                <%
                    if(posizioni.isEmpty()){
                %>
                <%
                    if(!ErrorManager.getOtherMessage((HttpServletRequest) request).isEmpty()){
                %>
                <div class="alert alert-warning">
                    <i class="bi bi-exclamation-diamond-fill m-1"></i><%= ErrorManager.getOtherMessage((HttpServletRequest) request)%>
                </div>
                <%
                        }
                    };
                %>
                <%
                    for(Posizione p : posizioni){
                %>

                <div class="card col-lg-4 col-md-6 col-12 mt-4 pt-2 d-flex  align-items-stretch" style=" background-color: rgba(0,0,0,0); border: none">
                    <div class="slide slide1 ">
                        <div class="content  shadow">

                            <div class="card-body p-4 bg-light" style="height:220px;width:420px">
                                <span class="badge rounded-pill bg-primary float-md-end mb-3 mb-sm-0"><%=p.getCategoria().getNome_categoria()%></span>
                                <%
                                    if(posizioneIMPL.getCurrentCandidature(p.getId_posizione()) >= p.getN_ammissioni()){
                                %>
                                <span class="badge rounded-pill bg-danger  mb-3 mb-sm-0">N�candidature inviate: <%=posizioneIMPL.getCurrentCandidature(p.getId_posizione())%>/<%=p.getN_ammissioni()%></span>
                                <%
                                }else if(posizioneIMPL.getCurrentCandidature(p.getId_posizione()) >= ((p.getN_ammissioni()*75)/100)){
                                %>
                                <span class="badge rounded-pill bg-warning  mb-3 mb-sm-0">N�candidature inviate: <%=posizioneIMPL.getCurrentCandidature(p.getId_posizione())%>/<%=p.getN_ammissioni()%></span>
                                <%
                                }else{
                                %>
                                <span class="badge rounded-pill bg-success  mb-3 mb-sm-0">N�candidature inviate: <%=posizioneIMPL.getCurrentCandidature(p.getId_posizione())%>/<%=p.getN_ammissioni()%></span>
                                <%
                                    }
                                %>
                                <h5><%=p.getRuolo()%></h5>
                                <div class="mt-3">
                                    <%
                                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    %>
                                    <span class="text-muted d-block"><i class="bi bi-calendar-check-fill m-1"></i><%=dateFormat.format(p.getData_inserimento())%></span>
                                    <span class="text-muted d-block"><i class="bi bi-geo-alt-fill m-1"></i><%=p.getCitta().getNome()%></span>
                                </div>

                                <div class="mt-3 d-flex" style="padding:0; padding-bottom:16px">
                                    <form action="classificacandidatura.jsp" method="get">
                                        <input type="hidden" name="id_posizione" value="<%=p.getId_posizione()%>" />
                                        <button type="submit" class="btn btn-success">Visualizza Candidati</button>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="slide slide2" style="width:420px;">
                    <div style="width:100%;height:90%;display:flex;overflow:auto;transform:translateY(15px);">
                        <div class="content">
                            <p><%=p.getDescrizione()%></p>
                        </div>
                        </div>
                    </div>
                </div>

                <%
                    };
                %>

            </div>
        </div>
    </div>
</main>


</body>
</html>
