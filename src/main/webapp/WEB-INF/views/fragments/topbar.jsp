<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Topbar Navbar -->
    <ul class="navbar-nav ml-auto">

        <!-- Menu -->
        <div class="topbar-divider d-none d-sm-block"></div>
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href='<c:url value="/"/>'>
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kawy</span>
            </a>
        </li>
        <div class="topbar-divider d-none d-sm-block"></div>
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kalkulator proporcji</span>
            </a>
        </li>
        <div class="topbar-divider d-none d-sm-block"></div>
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">O projekcie</span>
            </a>
        </li>
        <!--                         -->
        <div class="topbar-divider d-none d-sm-block"></div>
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Kontakt</span>
            </a>
        </li>

    </ul>

</nav>