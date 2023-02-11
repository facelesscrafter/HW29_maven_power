package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }
    //студент в json
    public static String studentToJson(Student s) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(s);
    }
    public static String studentsToJson(List<Student> s) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(s);
    }
    //json в студент
    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }
    public static List<Student> jsonToStudens(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
    }
    //университет в json
    public static String universityToJson(University u) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(u);
    }
    public static String universitiesToJson(List<University> u) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(u);
    }
    //json в университет
    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }
    public static List<University> jsonToUniversities(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {
        }.getType());
    }
}
