<?php
$nombre = $_POST['nombre'];
$apellido = $_POST['apellido'];
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
                    Guardado correctamente
                </div>

                <div class="card-body">
                <p>El nombre es: <?php echo $nombre ?></p>
				<p>El apellido es: <?php echo $apellido ?></p>
                <p>La dirección es: <?php echo $direccion ?></p>
                <p>El telefono es: <?php echo $telefono ?></p>
                    <button class="btn btn-primary" type="button" onclick="location.href='index.html'">Regresar</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>