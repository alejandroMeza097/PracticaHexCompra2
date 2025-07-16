# PracticaHexCompra2
Repositorio sobre arquitectura hexagonal.

## Modulo de Cliente
Este módulo requiere enviar una petición del tipo Post de la siguiente forma:

```
{

    "nombre":"nombre test",
    "apellido":"apellido test",
    "email":"test@gmail.com",
    "telefono":"111111111",
    "direccion":"direccion test"
}
```
La respuesta a esta peticion debe ser : 

```
{


    "id":1,
    "nombre":"nombre test",
    "apellido":"apellido test",
    "email":"test@gmail.com",
    "telefono":"111111111",
    "direccion":"direccion test"
}

```

## Módulo de Producto
Este modulo requiere enviar una solicitud Post de la siguiente forma:

```
{
    "nombre": "laptop",
    "precio": 12.30,
    "stock": 10
 }
```
La respuesta a esta peticion de ser  :
```
{
    "id":1
    "nombre": "laptop",
    "precio": 12.30,
    "stock": 10
 }
```

## Módulo de venta
En la venta debe realizarse un peticion Post de la siguiente forma:
```
{
  "clienteId":1,
  "productos": [
    { "productoId": 7, "cantidad": 45 }
    
  ]
}
```
La respuesta esperada debe ser :
```
{
    "id": 20,
    "clienteId": 1,
    "productos": [
        {
            "productoId": 7,
            "nombre": "monitor 4k",
            "cantidad": 45,
            "precioUnitario": 12.30
        }
    ],
    "precioTotal": 553.50,
    "fechaCompra": "2025-07-16T16:35:21.8479693"
}
```

