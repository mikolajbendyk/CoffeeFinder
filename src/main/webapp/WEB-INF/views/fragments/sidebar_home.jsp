<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href='<c:url value="/"/>'>
        <div class="sidebar-brand-text mx-3">Coffee Finder</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Filtrowanie
    </div>

    <form method="get" class="filter-form">
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#sort">
                <span>Sortuj</span>
            </a>
            <div id="sort" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                      <input type="radio" name="sort" value="priceAsc">  Cena rosnąco<br>
                </div>
                <div class="bg-white py-2 collapse-inner rounded">
                      <input type="radio" name="sort" value="priceDesc">  Cena malejąco
                </div>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#roastery">
                <span>Palarnia</span>
            </a>
            <div id="roastery" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${roasteries}" var="roastery">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="roasteriesIds" value="${roastery.id}">  ${roastery.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#country">
                <span>Kraj pochodzenia</span>
            </a>
            <div id="country" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${countries}" var="country">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="countriesIds" value="${country.id}">  ${country.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#method">
                <span>Metoda parzenia</span>
            </a>
            <div id="method" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${methods}" var="method">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="methodsIds" value="${method.id}">  ${method.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#roast">
                <span>Wypalenie</span>
            </a>
            <div id="roast" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${roasts}" var="roast">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="roasts" value="${roast.ordinal()}">  ${roast.displayName}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#depulpingProcess">
                <span>Obróbka</span>
            </a>
            <div id="depulpingProcess" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <c:forEach items="${depulpingProcesses}" var="depulpingProcess">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="depulpingProcessesIds"
                                 value="${depulpingProcess.id}">  ${depulpingProcess.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#composition">
                <span>Single / Blend</span>
            </a>
            <div id="composition" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${compositions}" var="composition">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="compositions"
                                 value="${composition.ordinal()}">  ${composition.displayName}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#species">
                <span>Gatunek</span>
            </a>
            <div id="species" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${species}" var="species">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="speciesIds" value="${species.id}">  ${species.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#volume">
                <span>Wielkość opakowania</span>
            </a>
            <div id="volume" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${volumes}" var="volume">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="volumesIds" value="${volume.id}">  ${volume.grams}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#shipmentType">
                <span>Sposób wysyłki</span>
            </a>
            <div id="shipmentType" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${shipmentTypes}" var="shipmentType">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="shipmentTypesIds"
                                 value="${shipmentType.id}">  ${shipmentType.name}
                    </div>
                </c:forEach>
            </div>
        </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#city">
                <span>Miasto palarni</span>
            </a>
            <div id="city" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                <c:forEach items="${cities}" var="city">
                    <div class="bg-white py-2 collapse-inner rounded">
                          <input type="checkbox" name="cities" value="${city}">  ${city}
                    </div>
                </c:forEach>
            </div>
        </li>

          
        <input type="reset" value="Wyczyść" style="background: orangered"
               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
          
        <input type="submit" value="Wyślij" style="background: limegreen"
               class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
    </form>


    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Zarządzanie
    </div>

    <li class="nav-item">
        <a class="nav-link" href='<c:url value="/admin"/>'>
            <span>Admin</span>
        </a>
    </li>
    <li class="nav-item">
        <sec:authorize access="isAuthenticated()">
            <form action="<c:url value="/logout"/>" method="post">
                 <input type="submit" value="Wyloguj" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> </form>
        </sec:authorize>
    </li>



</ul>
