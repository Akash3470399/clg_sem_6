<!DOCTYPE html>
<html lang="en">
<head>
    <title>Book</title>
</head>
<body>
    <?php
        $xml_file = simplexml_file_load("book.xml");
        echo htmlspecialchars($xml_file->asXML());
    ?>
</body>
</html>