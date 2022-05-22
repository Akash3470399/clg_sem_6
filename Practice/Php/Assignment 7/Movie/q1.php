<?php
    $aname = $_POST['aname'];
    $year = $_POST['year'];
    $mname = $_POST['mname'];

    $conn = pg_connect("host=192.168.16.1 port=5432 dbname=ty8810 user=ty8810 password=");

    if(!$conn){
        echo "error occured.";
    }
    else{

        if(strcmp($_POST['operation'], "display") == 0){
            $sql_query = "select * from movie where movie.movie_no in (select movie_no from actor_movie where actor.actor_no = select actor_no from actor where actor_name ='".$aname."');"

            $result = pg_query($conn, $sql_query);
            while ($row = pg_fetch_assoc($result)) {
                echo $row['movie_name'];
            }
        }
        elseif (strcmp($_POST[operation], 'update') == 0) {
            $sql_query = "update movie set release_year=".$year."where movie_name = '".mname."';";
            $result = pg_query($conn, $sql_query);

            if($result)
                echo "updated.";
            else
                echo 'error occured.';
        }
    }
?>