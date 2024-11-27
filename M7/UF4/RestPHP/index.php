<?php
$restaurantsAvailable = ["Restaurante Primero", "Restaurante Segundo", "Restaurante Tercero"];
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurantes Disponibles</title>
</head>
<body>
    <h1>Selecciona un Restaurante</h1>
    <ul>
        <?php foreach ($restaurantsAvailable as $restaurant): ?>
            <li><a href="reserva.php?restaurante=<?php echo urlencode($restaurant); ?>"><?php echo htmlspecialchars($restaurant); ?></a></li>
        <?php endforeach; ?>
    </ul>
</body>
</html>
