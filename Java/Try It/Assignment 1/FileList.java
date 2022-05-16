import java.io.*;
import java.util.*;

class FileList {


    public static void main(String[] args) throws IOException, FileNotFoundException {

        LinkedList<String> fileList = new LinkedList<String>();


        String line;
        int choice, lineNo;

        if (args.length < 1) {
            System.out.println("Please provide file name.");
        } else {

            File f = new File(args[0]);
            BufferedReader fin = new BufferedReader(new FileReader(f));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while((line = fin.readLine()) != null){
                fileList.add(line);
            }

            fin.close();
            System.out.println(fileList);

            do {

                System.out.print("Enter your choice :\n\t1.Insert Line\n\t2.Delete Line\n\t3.Append Line\n\tModify line\n\t5.Exit\n>>>");
                choice = Integer.parseInt(br.readLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter line number(line no. starting from 0.):");
                        lineNo = Integer.parseInt(br.readLine());
                        System.out.print("Enter line to insert :");
                        line = br.readLine();
                        fileList.add(lineNo, line);
                        break;

                    case 2:
                        System.out.print("Enter line no to delete(line no. starting from 0):");
                        lineNo = Integer.parseInt(br.readLine());
                        fileList.remove(lineNo);
                        break;

                    case 3:
                        System.out.print("Enter line to appen :");
                        line = br.readLine();
                        fileList.add(line);
                        break;

                    case 4:
                        System.out.print("Enter line no to modify(line no. starting from 0):");
                        lineNo = Integer.parseInt(br.readLine());
                        System.out.print("Enter new line :" );
                        line = br.readLine();
                        fileList.remove(lineNo);
                        fileList.add(lineNo, line);

                    case 5:
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                FileWriter fwr = new FileWriter(f);

                for (String line1 : fileList) {
                    fwr.write(line1 + "\n");
                }
                fwr.close();

                System.out.println("\nfile content :" + fileList);

            } while (choice != 5);




        }
    }
}