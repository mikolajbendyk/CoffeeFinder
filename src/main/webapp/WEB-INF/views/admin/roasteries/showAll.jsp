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

    <link href='<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>' rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
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
                    <h1 class="h3 mb-0 text-gray-800">Palarnie kawy</h1>
                    <a href='<c:url value="/admin/roasteries/all"/>' class="d-none d-sm-inline-block btn btn-sm shadow-sm">
                        Sortuj wg nazwy</a>
                    <a href='<c:url value="/admin/roasteries/all?sort=city"/>' class="d-none d-sm-inline-block btn btn-sm shadow-sm">
                        Sortuj wg miasta</a>

                    <a href='<c:url value="/admin"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Panel
                        zarządzania</a>
                </div>
                <a href='<c:url value="/admin/roasteries/add"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                    Dodaj palarnię</a>
                <br>
                <br>
                <!-- Content Row -->
                <table class="bord-tab">
                    <thead>
                    <th>Nr</th>
                    <th>Palarnia</th>
                    <th>Miasto</th>
                    <th>Adres</th>
                    <th>Akcje</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${roasteries}" var="roastery" varStatus="loop">
                        <tr>
                            <td><c:out value="${loop.count}"/></td>
                            <td><c:out value="${roastery.name}"/></td>
                            <td><c:out value="${roastery.city}"/></td>
                            <td><c:out value="${roastery.address}"/></td>
                            <td><a href='<c:url value="/admin/roasteries/edit/${roastery.id}"/>'>Edytuj</a> 
                                <a href='<c:url value="/admin/roasteries/confirm?id=${roastery.id}"/>'>Usuń</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br>
                <div>
                    <a href='<c:url value="/admin/roasteries/add"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                        Dodaj palarnię</a>
                    <br>
                    <br>
                </div>


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
