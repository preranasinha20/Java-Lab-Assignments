import java.io.FileWriter;
import java.io.IOException;

public class StudentFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Students.csv");

            writer.append("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");

            writer.append("1,mon,CS,80,85,90,0,0,0\n");
            writer.append("2,Ela,IT,75,70,80,0,0,0\n");

            writer.close();
            System.out.println("File created successfully with initial data.");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
