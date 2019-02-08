const express = require('express');
const app = express();
const port = 3000;

const request = require('request');

app.use(express.urlencoded({extended: true}));

app.get('/', (req, res) => {
    res.send("Hello");
});

app.get('/todos', (req, res) => {
    request.get("http://todoapp:8080/todos", (err, response, data) => {
        res.send(data);
    });
});

app.listen(port, () => console.log(`Listening on port ${port}`));