import java.io.*;
import java.util.*;

class Teacher{
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static PreparedStatement insertTeacher, insertWorkload;

    public static void main(String[] args){

        int choice;
        BufferedRreader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/ty8810", "ty8810", "");
            
            if(conn == null)
            {
                System.out.println("Error during connectin.");
                System.exit();
            }

            insertTeacher = conn.preparedStatement("insert into teacher values(?, ?);");
            insertWorkload = conn.preparedStatement("insert into workload values(?, ?, ?, ?, ?, ?);");
            st = conn.createStatement();

            do{
                System.out.println("Enter your choice.");
                System.out.println("1.add\n2.display date wise\n3.display class wise\n4.modify\n5");
                choice = Integer.parseInt(br.readLine());
                switch(choice){
                    case 1:
                        addRecord();
                        break;
                    case 2:
                        display_datewise();
                        break;
                    case 3:
                        display_classwise();
                        break;
                    case 4:
                        break;
                }
            }while(choice == 5)

        }
        catch(Exception e){}
    }

    static void addRecord(){
        int t_id;
        String name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("Enter teacher id:");
            t_id = Integer.parseInt(br.readLine());

            System.out.print("Enter teacher name :");
            name = br.readLine();

            insertTeacher.setInt(1, t_id);
            insertTeacher.setString(2, name);
            insertTeacher.executeUpdate();

            System.out.print("Data added.");
        }
        catch(Exception e){}
    }

    static void display_datewise(){
        String t_name;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        try{
            System.out.print("Enter teacher teacher name :");
            t_name = br.readLine();

            String sql_query = "select t_name,workload.* from teacher,workload where teacher.t_id=workload.t_id and t_name ='"+t_name+"';"

            rs = st.executeUpdate(sql_query);

            while(rs.next()){
                System.out.println(rs.getString("t_name"));
                System.out.println(rs.getInt("subject_code"));
                System.out.println(rs.getString("subject"));
                System.out.println(rs.getString("date_"));
                System.out.println(rs.getString("time_"));
            }

        }
        catch(Exception e){}
    }

    static void display_classwise(){
        String c_name;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
			System.out.println("\n Enter Class Name  : ");	
			c_name =Br.readLine();

            rs=st.executeQuery("Select * from workload where class_ ='"+c_name+"';");	

            while(rs.next()){
                System.out.println(rs.getInt("subject_code"));
                System.out.println(rs.getString("subject"));
                System.out.println(rs.getString("date_"));
                System.out.println(rs.getString("time_"));
            }
        }catch(){}
    }
}