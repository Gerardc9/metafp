<?php
$restaurantName = $_POST['restaurantName'] ?? '';
$reservationDate = $_POST['reservationDate'] ?? '';
$people = $_POST['people'] ?? '';

if ($restaurantName && $reservationDate && $people) {
    $dateFormat = date("d-m-Y", strtotime($reservationDate));

    echo "<h1>Reserva confirmada</h1>";
    echo "<p>Restaurante: " . htmlspecialchars($restaurantName) . "</p>";
    echo "<p>Fecha: " . htmlspecialchars($dateFormat) . "</p>";
    echo "<p>Número de personas: " . htmlspecialchars($people) . "</p>";
} else {
    echo "<p>Ha ocurrido un error durante el proceso de la reserva.</p>";
}
?>
