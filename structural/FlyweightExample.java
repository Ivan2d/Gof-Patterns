package structural;

import java.util.HashMap;

public class FlyweightExample {
    public static void main(String[] args) {
        StudentUniversityInfo studentUniversityInfo = new StudentUniversityInfo("aboba", "aboba");
        StudentCache cache = new StudentCache();
        StudentUniversityInfo s = cache.getStudentUniversityInfo("aboba");
        StudentUniversityInfo s2 = cache.getStudentUniversityInfo("aboba");
        System.out.println(s == s2);
    }
}

class StudentPersonalInfo {
    String name;
    int age;
    int course;
}

class StudentUniversityInfo {
    String faculty;
    String hostelAddress;

    public StudentUniversityInfo(String faculty, String hostelAddress) {
        this.faculty = faculty;
        this.hostelAddress = hostelAddress;
    }
}

class StudentCache {
    private final HashMap<String, StudentUniversityInfo> map = new HashMap<>();

    public StudentUniversityInfo getStudentUniversityInfo(String faculty) {
        return map.computeIfAbsent(faculty, this::createStudentUniversityInfo);
    }

    private StudentUniversityInfo createStudentUniversityInfo(String faculty) {
        return new StudentUniversityInfo(faculty, "New York");
    }
}