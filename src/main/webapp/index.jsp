<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Antons Skafferi</title>
    <link rel="stylesheet" type="text/css" href="css/navbar.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/event_pop_up.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<section class="start-page">
    <img src="images/background.png" alt="Background" class="start-page">
    <header class="site-header">
        <div class="header-content">
            <img src="images/only_logo.png" alt="Logo" class="logo">
            <button class="nav-toggle" aria-label="Öppna menyn">
                <i class="fa fa-bars"></i>
            </button>
        </div>
        <nav class="main-nav">
            <ul class="menu" id="menu">
                <li><a href="index.jsp">Hem</a></li>
                <li><a href="about.jsp">Om Oss</a></li>
                <li><a href="services.jsp">Tjänster</a></li>
                <li><a href="contact.jsp">Kontakt</a></li>
            </ul>
        </nav>
    </header>
    <div class="welcome-text">
        <h2>Välkommen till Antons Skafferi</h2>
        <p>Där säsongens fisk och vilt tar huvudrollen på tallriken. Upplev vårt noggrant utvalda utbud av färska råvaror från hav och skog, skapade med passion och omsorg för att ge dig en smakupplevelse utöver det vanliga.</p>
    </div>
    <section class="daily-lunch">
        <h2>Dagens lunch</h2>
        <p>Köttbullar med potatis</p>
    </section>
    <section class="actions">
        <button class="first_page_btn">Vår meny</button>
        <button class="first_page_btn">Boka Bord</button>
    </section>
    <section class="event-pop-up">
        <!-- Close button for the popup -->

        <!-- Popup for Upcoming Events -->
        <aside id="popupEvent" class="popup">
            <div class="popup-content">
                <span class="close-btn" onclick="closePopup()" aria-label="Close Event Popup">&times;</span>
                <h2 id="popupHeader">Kommande eventer</h2>
                <p id="popupText">Missa inte våra speciella helgevenemang!</p>
                <ul id="popupList">
                    <li>25 Dec - Lördag: Livemusikkväll</li>
                    <li>26 Dec - Söndag: Vinprovningsevenemang</li>
                </ul>
                <button onclick="location.href='/events';" id="pop_btn">Mer Info</button>
            </div>
        </aside>
        </section>
    <!-- END START-PAGE -->
</section>
<section class="next-page-here">

</section>

<script src="js/nav.js"></script>
<script src="js/event.js"></script>
</body>
</html>
