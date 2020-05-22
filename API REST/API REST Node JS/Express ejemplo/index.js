const express = require('express');
const app = express();
const request = require('request');
const async = require('async');

app.get('/movies', (req, res) => {
    res.json({
        "peliculas": [
            {
                "id": 1,
                "nombre": "El sexto sentido",
                "director": "M. Night Shyamalan",
                "clasificacion": "Drama"
            },
            {
                "id": 2,
                "nombre": "Pulp Fiction",
                "director": "Tarantino",
                "clasificacion": "Acción"
            },
            {
                "id": 3,
                "nombre": "Todo Sobre Mi Madre",
                "director": "Almodobar",
                "clasificacion": "Drama"
            }
        ]
    });

})

app.listen('3000', () => {
    console.log('Listening on port 3000');
})
