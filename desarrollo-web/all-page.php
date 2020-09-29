<?php

// Configuracion de la conexion

$host = "localhost";
$user = "postgres";
$password = "postgres";
$dbname = "desarrollo-web";

$conexion = pg_connect("host=$host dbname=$dbname user=$user password=$password");

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Registros</title>
</head>

<body>

    <table border="1">
        <thead>
            <tr>
                <td>ID</td>
                <td>Nombre</td>
                <td>Direccion</td>
                <td>Telefono</td>
            </tr>
        </thead>

        <?php

        $sql = "SELECT * FROM tb_personas ORDER BY id";
        $registros = pg_query($conexion, $sql);

        while ($obj = pg_fetch_array($registros)) {
        ?>
            <tr>
                <td><?php echo $obj['id'] ?></td>
                <td><?php echo $obj['nombre'] ?></td>
                <td><?php echo $obj['direccion'] ?></td>
                <td><?php echo $obj['telefono'] ?></td>
            </tr>

        <?php
        }
        ?>
    </table>

    <button type="button" onclick="location.href='index.html'">Regresar</button>
</body>

</html>