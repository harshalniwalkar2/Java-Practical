import java.io.*;

public class FileOperation {

   public static void main(String[] args ){
        String filename="demo.txt"; //file path

        try{
            //  1.Create file

            File file=new File(filename);
            if(file.createNewFile()){
                System.out.println("File created Successfully");
            }
            else{
                System.out.println("File already exist");
            }
            //    2.Write

            FileWriter writer=new FileWriter(filename);
            writer.write("Java Programming Lab");
            writer.close();
            System.out.println("File written Successfully");

            //  3.Read

            FileReader reader=new FileReader(filename);
            int ch;
            while((ch= reader.read())!=-1){
                System.out.print((char)ch);
            }
            reader.close();

            //  4.Append

            FileWriter appendWriter= new FileWriter(filename,true);
            appendWriter.write("\n  Practical Number 11📝");
            appendWriter.close();
            System.out.println("\nData appended successfully!!");

            // 5.Delete

            if(file.delete()){
                System.out.println("File deleted successfully");
             }

            else{
                System.out.println("File not Deleted");
            }

        }
        catch(IOException e) {
            System.out.println("Error:"+e.getMessage());

        }
    }
}
