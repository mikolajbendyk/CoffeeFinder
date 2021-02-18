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

    <style>
        table, th, td {
            border: 1px solid;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
        }
    </style>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
            <div class="sidebar-brand-text mx-3">Coffee Finder</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Zarządzanie
        </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/coffees/all"/>'>
                <span>Kawy</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/roasteries/all"/>'>
                <span>Palarnie</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/countries/all"/>'>
                <span>Kraje pochodzenia</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/species/all"/>'>
                <span>Gatunki kawy</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/methods/all"/>'>
                <span>Metody parzenia</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/flavours/all"/>'>
                <span>Nuty smakowe</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/volumes/all"/>'>
                <span>Wielkości opakowań</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href='<c:url value="/admin/shipment-types/all"/>'>
                <span>Sposoby wysyłki</span>
            </a>
        </li>


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">


                    <!-- Menu -->
                    <div class="topbar-divider d-none d-sm-block"></div>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kawy</span>
                        </a>
                    </li>
                    <div class="topbar-divider d-none d-sm-block"></div>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kalkulator proporcji</span>
                        </a>
                    </li>
                    <div class="topbar-divider d-none d-sm-block"></div>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">O projekcie</span>
                        </a>
                    </li>
                    <!--                         -->
                    <div class="topbar-divider d-none d-sm-block"></div>
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kontakt</span>
                        </a>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Gatunki kawy</h1>
                    <a href='<c:url value="/admin"/>' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Panel zarządzania</a>
                </div>

                <!-- Content Row -->

                <table>
                    <thead>
                    <th>Nr</th>
                    <th>Wielkość opakowania [gr]</th>
                    <th>Akcje</th>
                    </thead>
                    <tbody>
                    <c:forEach items="${volumes}" var="volume" varStatus="loop">
                        <tr>
                            <td><c:out value="${loop.count}"/></td>
                            <td><c:out value="${volume.grams}"/></td>
                            <td><a href='<c:url value="/admin/volumes/edit/${volume.id}"/>'>Edytuj</a> 
                                <a href='<c:url value="/admin/volumes/confirm?id=${volume.id}"/>'>Usuń</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div><br>
                    <button><a href='<c:url value="/admin/volumes/add"/>'>Dodaj opakowanie</a></button></div>

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
