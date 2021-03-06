<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Coffee Finder</title>

    <!-- Custom fonts for this template-->
    <link href='<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>' rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href='<c:url value="/theme/css/sb-admin-2.min.css"/>' rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@ include file="../../fragments/sidebar_admin.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <%@ include file="../../fragments/topbar.jsp" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Kawy</h1>
                    <a href='<c:url value="/admin"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Panel
                        zarządzania</a>
                </div>

                <!-- Content Row -->

                <form:form method="post" modelAttribute="coffee">
                    <form:hidden path="id"></form:hidden>
                    <table class="no-bord-tab">
                        <tbody>
                        <tr>
                            <td>Nazwa</td>
                            <td>
                                <form:input path="name"/>
                                   <form:errors path="name" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Kraj pochodzenia</td>
                            <td>
                                <form:select path="country">
                                    <form:option value="" label="Wybierz kraj"/>
                                    <form:options items="${countries}" itemLabel="name" itemValue="id"/>
                                </form:select>
                                   <form:errors path="country" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Palarnia</td>
                            <td>
                                <form:select path="roastery">
                                    <form:option value="" label="Wybierz palarnię"/>
                                    <form:options items="${roasteries}" itemLabel="name"
                                                  itemValue="id"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Obróbka</td>
                            <td>
                                <form:select path="depulpingProcess">
                                    <form:option value="" label="Wybierz obróbkę"/>
                                    <form:options items="${processes}" itemLabel="name" itemValue="id"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Wypalenie</td>
                            <td>
                                <form:select path="roast">
                                    <form:option value="" label="Wybierz wypalenie"/>
                                    <form:options items="${roasts}" itemLabel="displayName"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Metody parzenia</td>
                            <td><c:forEach items="${methods}" var="method">
                                <form:checkbox path="methods" label=" ${method.name}" value="${method}"/><br>
                            </c:forEach></td>
                        </tr>
                        <tr>
                            <td>Single / Blend</td>
                            <td>
                                <form:select path="composition">
                                    <form:option value="" label="Wybierz"/>
                                    <form:options items="${composition}" itemLabel="displayName"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Gatunki</td>
                            <td><c:forEach items="${species}" var="species">
                                <form:checkbox path="species" label=" ${species.name}" value="${species}"/><br>
                            </c:forEach></td>
                        </tr>
                        <tr>
                            <td>Wielkość opakowania [gr]</td>
                            <td>
                                <form:select path="volume">
                                    <form:option value="" label="Wybierz wielkość"/>
                                    <form:options items="${volumes}" itemLabel="grams"/>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Cena</td>
                            <td><form:input path="price"/></td>
                        </tr>
                        <tr>
                            <td>Opis</td>
                            <td><form:textarea path="description"/></td>
                        </tr>
                        <tr>
                            <td>Dostępność</td>
                            <td><form:radiobutton path="active" value="true"/> Tak<br>
                                <form:radiobutton path="active" value="false"/> Nie
                            </td>
                        </tr>
                        <tr>
                            <td>Link do oferty</td>
                            <td><form:input path="link"/></td>
                        </tr>
                        <tr>
                            <td>Link do zdjęcia</td>
                            <td><form:input path="imageSrc"/></td>
                        </tr>
                        </tbody>
                    </table>
                    <br>
                    <input type="submit" value="Zapisz">
                </form:form>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2020</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Bootstrap core JavaScript-->
<script src='<c:url value="/theme/vendor/jquery/jquery.min.js"/>'></script>
<script src='<c:url value="/theme/vendor/bootstrap/js/bootstrap.bundle.min.js"/>'></script>

<!-- Core plugin JavaScript-->
<script src='<c:url value="/theme/vendor/jquery-easing/jquery.easing.min.js"/>'></script>

<!-- Custom scripts for all pages-->
<script src='<c:url value="/theme/js/sb-admin-2.min.js"/>'></script>

<!-- Page level plugins -->
<script src='<c:url value="/theme/vendor/chart.js/Chart.min.js"/>'></script>

<!-- Page level custom scripts -->
<script src='<c:url value="/theme/js/demo/chart-area-demo.js"/>'></script>
<script src='<c:url value="/theme/js/demo/chart-pie-demo.js"/>'></script>


</body>

</html>
