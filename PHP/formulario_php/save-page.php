<?php
$id = $_GET['id'];
$nombre = $_GET['nombre'];
$direccion = $_GET['direccion'];
$telefono = $_GET['telefono'];

// Configuracion de la conexion

$host = "localhost";
$user = "postgres";
$password = "postgres";
$dbname = "desarrollo-web";

$conexion = pg_connect("host=$host dbname=$dbname user=$user password=$password");

$sql = "INSERT INTO tb_personas(id,nombre,direccion,telefono) VALUES($id, '$nombre', '$direccion', '$telefono')";

?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Guardado</title>
</head>

<body>
    <p>Guardado correctamente<p>
    <p>ID<input type="text" placeholder="<?php echo $id ?>" disabled></p>
    <p>Nombre<input type="text" placeholder="<?php echo $nombre ?>" disabled></p>
    <p>Direccion<input type="text" placeholder="<?php echo $direccion ?>" disabled></p>
    <p>Telefono<input type="text" placeholder="<?php echo $telefono ?>" disabled></p>
    <button type="button" onclick="location.href='index.html'">Regresar</button>

    <?php
        return pg_query($conexion, $sql);
    ?>
    
</body>

</html>