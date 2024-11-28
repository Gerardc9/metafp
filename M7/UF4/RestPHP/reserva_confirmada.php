<?php
$restaurantName = $_POST['restaurantName'] ?? '';
$reservationDate = $_POST['reservationDate'] ?? '';
$people = $_POST['people'] ?? '';
$email = $_POST['email'] ?? '';
$nameSurname = $_POST['namesurname'] ?? '';

$errors = [];

if (empty($restaurantName)) {
    $errors[] = "El nombre del restaurante es obligatorio.";
}

if (empty($reservationDate) || strtotime($reservationDate) < strtotime(date('Y-m-d'))) {
    $errors[] = "La fecha de la reserva es inválida.";
}

if (empty($people) || !preg_match('/^[1-9][0-9]*$/', $people)) {
    $errors[] = "El número de personas debe ser mayor a 0.";
}

if (empty($email) || !filter_var($email, FILTER_VALIDATE_EMAIL)) {
    $errors[] = "El correo electrónico no es válido.";
}

if (empty($nameSurname) || !preg_match('/^[a-záéíóúñ]+(?: [a-záéíóúñ]+)+$/i', $nameSurname)) {
    $errors[] = "El nombre y apellido deben tener un formato válido.";
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmación de Reserva</title>
</head>
<body>
    <?php if (!empty($errors)): ?>
        <h1>Error en la Reserva</h1>
        <p>Ha ocurrido uno o más errores durante el proceso de la reserva:</p>
        <ul style="color: red;">
            <?php foreach ($errors as $error): ?>
                <li><?php echo htmlspecialchars($error); ?></li>
            <?php endforeach; ?>
        </ul>
        <button onclick="window.location.href='reserva.php?restaurante=<?php echo urlencode($restaurantName); ?>'">
            Volver al formulario
        </button>
    <?php else: ?>
        <h1>Reserva confirmada</h1>
        <p>Restaurante: <?php echo htmlspecialchars($restaurantName); ?></p>
        <p>Fecha: <?php echo htmlspecialchars(date("d-m-Y", strtotime($reservationDate))); ?></p>
        <p>Número de personas: <?php echo htmlspecialchars($people); ?></p>
        <p>Correo electrónico: <?php echo htmlspecialchars($email); ?></p>
        <p>Reservado a nombre de: <?php echo htmlspecialchars($nameSurname); ?></p>
    <?php endif; ?>
</body>
</html>
