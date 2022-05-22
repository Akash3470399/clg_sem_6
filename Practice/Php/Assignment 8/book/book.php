<?php

    $name = $_POST['name'];
    $quantity = $_POST['quantity'];
    $price = $_POST['price'];
    $stock = $_POST['stock'];

    class Book{
        var $book_name;
        var $book_quantity;
        var $book_price;
        var $book_stock;

        function __construct($name, $quantity, $price, $stock){
            $this->book_name = $name;
            $this->book_quantity = $quantity;
            $this->book_price = $price;
            $this->book_stock = $stock;
        }

        function display(){
            echo " Name :".$this->book_name;
            echo " Quantity :".$this->book_quantity;
            echo " Price". $this->book_price;
            echo " Stock". $this->book_stock;
        }
    }

    $b = new Book($name, $quantity, $price, $stock);
    $b->display();
?>