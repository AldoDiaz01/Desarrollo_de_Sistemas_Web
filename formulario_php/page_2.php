<?php
$nombre = $_POST['nombre'];
$apellidos = $_POST['apellidos'];
$direccion = $_POST['direccion'];
$telefono = $_POST['telefono'];

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.0/flatly/bootstrap.min.css" integrity="sha384-mhpbKVUOPCSocLzx2ElRISIORFRwr1ZbO9bAlowgM5kO7hnpRBe+brVj8NNPUiFs" crossorigin="anonymous">
    <title>Guardado</title>
</head>

<body>
    <div class="col-md-3">
        <div class="container p-2">
            <div class="card ">
                <div class="card-header text-center">
                    Se guardó correctamente
                </div>

                <div class="card-body">
                <p>El nombre guardado es: <strong><?php echo $nombre ?></strong></p>
				<p>Los apellidos guardados son: <strong><?php echo $apellidos ?></strong></p>
                <p>La dirección guardada es: <strong><?php echo $direccion ?></strong></p>
                <p>El telefono guardado es: <strong><?php echo $telefono ?></strong></p>
                    <button class="btn btn-primary" type="button" onclick="location.href='index.html'">Volver</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>