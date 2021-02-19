<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href='<c:url value="/"/>'>
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