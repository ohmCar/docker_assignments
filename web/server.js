const express = require('express');
const app = express();
const port = 3000;

const request = require('request');

app.use(express.urlencoded({extended: true}));

app.get('/', (req, res) => {
    res.send("Hello");
});

app.get('/todos', (req, res) => {
    const createTodoHtml = ` <h3>Create Todo:</h3><form method="POST">Title:<input type="text" name="title" required>
<br>Description: :<input type="text" name="description" required> <br><input type="submit"></form>`;
    request.get(process.env.TODO_DNS, (err, response, data) => {
        let todos = `<h3>My Todos:</h3>${data}`;
        res.send(`${createTodoHtml}${todos}`);
    });
});

app.post('/todos', (req, res) => {
    request.post({uri: process.env.TODO_DNS, json: req.body}, (error, response, data) => {
        res.send(`<h3>Stored the following todo:</h3> ${data}`);
    });
});

app.listen(port, () => console.log(`Listening on port ${port}`));