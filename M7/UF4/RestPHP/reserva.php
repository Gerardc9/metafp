<?php
$restaurantName = isset($_GET['restaurante']) ? $_GET['restaurante'] : ($oldData['restaurantName'] ?? '');
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Reserva</title>
</head>
<body>
    <h1>Formulario de Reserva</h1>

    <form action="reserva_confirmada.php" method="post">
        <label for="restaurantName">Restaurante:</label><br>
        <input type="text" 
                id="restaurantName" 
                name="restaurantName" 
                value="<?php echo htmlspecialchars($restaurantName); ?>" 
                <?php echo $restaurantName ? 'readonly' : ''; ?>
        ><br><br>

        <label for="reservationDate">Fecha de la Reserva:</label><br>
        <input type="date" 
               id="reservationDate" 
               name="reservationDate" 
               min="<?php echo date('Y-m-d'); ?>" 
               value="<?php echo htmlspecialchars($oldData['reservationDate'] ?? ''); ?>" 
               required><br><br>

        <label for="people">Número de Personas:</label><br>
        <input type="text" 
               id="people" 
               name="people" 
               pattern="^[1-9][0-9]*$" 
               value="<?php echo htmlspecialchars($oldData['people'] ?? ''); ?>" 
               required><br><br>

        <label for="email">Correo Electrónico:</label><br>
        <input type="email" 
               id="email" 
               name="email" 
               value="<?php echo htmlspecialchars($oldData['email'] ?? ''); ?>" 
               required><br><br>

        <label for="namesurname">Nombre y Primer Apellido</label><br>
        <input type="text" 
               id="namesurname" 
               name="namesurname"
               value="<?php echo htmlspecialchars($oldData['name'] ?? ''); ?>" 
               minlength="3" 
               maxlength="50"
               title="Por favor, ingrese un nombre y apellido válidos, separados por un espacio"
               required><br><br>

        <input type="submit" value="Reservar">
        <button type="button" onclick="window.location.href='index.php'">Volver</button>
    </form>
</body>
</html>
