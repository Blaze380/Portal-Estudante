package com.ustmportal.resources.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.ustmportal.resources.student.Student;

public class JsonFiles {
    private Gson gson = new Gson();
    private Archive file = new Archive();
    private String jsonFileFormat = ".json";

    public void saveStudentData(Student student) {
        String studentData = gson.toJson(student);
        String studentUserName = student.getUserName();
        File studentPath = file.createDiretoryPath(file.getStudentPath(studentUserName));
        file.createFile("data", studentData, studentPath, jsonFileFormat);
    }

    /**
     * Verifies if the student that it's trying to signin, exists
     * 
     * @param studentUserName student username
     * @return <code>true</code> if the student folder exists and
     *         <code>false</code> otherwise.
     */
    public boolean thisStudentExist(String studentUserName) {
        String studentPath = file.getStudentPath(studentUserName);
        File file = new File(studentPath);
        boolean thisStudentExist = file.exists();

        return thisStudentExist;
    }

    public Student loadStudentData(String studentUserName) {
        String fileSeparator = "\\";
        File studentPath = file.createDiretoryPath(file.getStudentPath(studentUserName));
        String fileName = fileSeparator + "data.json";

        FileReader fileReader = file.getFileReader(studentPath, fileName);

        BufferedReader linReader = file.getBufferedReader(fileReader);

        String studentData = "";

        try {
            String line = "";
            while ((line = linReader.readLine()) != null) {
                studentData += line;
            }
        } catch (IOException e) {

        }
        Student student = gson.fromJson(studentData, Student.class);
        return student;
    }
}
