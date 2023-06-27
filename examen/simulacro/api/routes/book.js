const express = require('express');
const router = express.Router();
const dbo = require('../db/conn');
const ObjectId = require('mongodb').ObjectId;
const MAX_RESULTS = parseInt(process.env.MAX_RESULTS);
const COLLECTION = 'books';

//getBooks()
router.get('/', async (req, res) => {
  let limit = MAX_RESULTS;
  if (req.query.limit){
    limit = Math.min(parseInt(req.query.limit), MAX_RESULTS);
  }
  let next = req.query.next;
  let query = {}
  if (next){
    query = {_id: {$lt: new ObjectId(next)}}
  }
  const dbConnect = dbo.getDb();
  let results = await dbConnect
    .collection(COLLECTION)
    .find(query,{projection:{_id:1, title:1, author:1}}) // Mostrar solo las propiedades _id, title y author
    .sort({_id: -1})
    .limit(limit)
    .toArray()
    .catch(err => res.status(400).send('Error searching for books'));

  // Agregar el atributo "link" a cada libro
  const baseUrl = "localhost:3000/api/book/"; // Ruta base de los libros
  results.forEach((book) => {
    book.link = baseUrl + book._id.toString();
   
   /*const baseUrl = "localhost:3000/api/book/"; // Ruta base de los libros
  results.forEach((book, index) => {
    book.link = baseUrl + book._id.toString();
    if (index < results.length - 1) {
      book.next = results[index + 1]._id.toString();
    } else {
      book.next = null;
    }
  });
   AÑADE LA REFERENCIA AL SIGUIENTE LIBRO DENTRO DE CADA OBJETO LIBRO.
  */
    
  });
   //para mostrar la propiedad next
  next = results.length == limit ? results[results.length - 1]._id : null;
  res.json({results, next}).status(200);
});


//getBookById()
router.get('/:id', async (req, res) => {
  const dbConnect = dbo.getDb();
  let query = {_id: new ObjectId(req.params.id)};
  let result = await dbConnect
    .collection(COLLECTION)
    .findOne(query);
  if (!result){
    res.send("Not found").status(404);
  } else {
    res.status(200).send(result);
  }
});

//addBook()
router.post('/', async (req, res) => {
  const {title, author} = req.body;

  // Verificar si los campos obligatorios están presentes
  if (!title || !author) {
    res.status(400).send('Invalid book data'); //adaptar los errores en funcion del openAPI
    return;
  }

  // Verificar si los campos tienen los tipos correctos (opcional)
  if (
    typeof title !== 'string' ||
    typeof author !== 'string'
  ) {
    res.status(400).send('Invalid book data types');
    return;
  }

  const dbConnect = dbo.getDb();
  console.log(req.body);
  let result = await dbConnect
    .collection(COLLECTION)
    .insertOne(req.body);
  res.status(201).send(result);
});

//updateBookById()
router.put('/:id', async (req, res) => {
  const { title, author } = req.body;

  // Verificar si los campos obligatorios están presentes
  if (!title || !author) {
    res.status(400).send('Invalid book data');
    return;
  }

  // Verificar si los campos tienen los tipos correctos
  if (typeof title !== 'string' || typeof author !== 'string') {
    res.status(400).send('Invalid book data types');
    return;
  }

  const dbConnect = dbo.getDb();
  const query = { _id: new ObjectId(req.params.id) };
  const update = { $set: { title, author } };

  let result = await dbConnect
    .collection(COLLECTION)
    .updateOne(query, update);

  if (result.modifiedCount === 0) {
    res.status(404).send('Book not found');
  } else {
    res.status(200).send('Book updated successfully');
  }
});

module.exports = router;


//deleteBookById()
router.delete('/:id', async (req, res) => {
  const query = { _id: new ObjectId(req.params.id) };
  const dbConnect = dbo.getDb();
  let result = await dbConnect
    .collection(COLLECTION)
    .deleteOne(query);
  res.status(200).send(result);
  /*
  if (result.deletedCount === 0) {
    res.status(404).send('Book not found');
  } else {
    res.status(200).send('Book deleted successfully');
  }
  */
});

module.exports = router;
