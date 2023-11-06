package com.ustmportal.resources.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.ustmportal.resources.logs.Log;

public final class JsonFiles {

    final private Gson gson = new Gson();
    final private Archive file = new Archive();
    final private String jsonFileFormat = ".json";

    /**
     * This methos can save Different object data in a Json file, by using generic
     * class
     * 
     * @param userPath          path of the to be saved(file name not included)
     * @param userGenericObject the generic object, and remenber to insert the
     *                          object into the generic variable in the constructor
     */
    public void saveUserData(File userPath, Generic<?> userGenericObject) {
        String userData = gson.toJson(userGenericObject.getGenericObject());
        file.createFile("data", userData, userPath, jsonFileFormat);
    }

    // TODO remove this useless code!!!
    // public void saveStudentData(Student student) {
    // String studentUserName = student.getUserName();
    // File studentPath =
    // file.createDiretoryPath(file.getStudentPath(studentUserName));
    // String studentData = gson.toJson(student);
    // // saveUserData(studentPath, studentData);
    // Log.info("Student saved sucessifuly!");
    // }

    // public void saveTeacherData(Teacher teacher) {
    // String teacherUserName = teacher.getUserName();
    // File teacherPath =
    // file.createDiretoryPath(file.getTeacherPath(teacherUserName));
    // String teacherData = gson.toJson(teacher);
    // // saveUserData(teacherPath, teacherData);
    // Log.info("Teacher saved sucessifuly");
    // }

    /**
     * Verifies if the student that it's trying to signin, exists
     * 
     * @param studentUserName student username
     * @return <code>true</code> if the student folder exists and
     *         <code>false</code> otherwise.
     */
    public boolean thisUserExists(String userPath) {
        File file = new File(userPath);
        boolean thisUserExists = file.exists();
        Log.info("Verifiying user...");
        return thisUserExists;
    }

    private String readUserData(File userPath) {
        final String fileSeparator = "\\";
        String fileName = fileSeparator + "data.json";

        final FileReader fileReader = file.getFileReader(userPath, fileName);

        final BufferedReader linReader = file.getBufferedReader(fileReader);

        String userData = "";

        try {
            String line = "";
            while ((line = linReader.readLine()) != null) {
                userData += line;
            }
        } catch (IOException e) {
            Log.error(e, "Error While Reading a file!");
        }
        Log.info("File Read.");
        return userData;
    }

    /**
     * Allows you to read a file information and save into different objects like
     * Teacher and Student object
     * 
     * @param userPath          Path of the file to be read
     * @param userGenericObject the generic object, and remenber to insert the
     *                          object into the generic variable in the constructor
     * @return Generic object with the object data stored in the generic attribute
     */
    public Generic<?> loadUserData(File userPath, Generic<?> userGenericObject) {
        String userData = readUserData(userPath);
        Generic<?> object = new Generic<>(gson.fromJson(userData, userGenericObject.getGenericObject().getClass()));
        return object;
    }
    // TODO remove this useless code!!!
    // public Student loadStudentData(String studentUserName) {
    // File studentPath =
    // file.createDiretoryPath(file.getStudentPath(studentUserName));
    // String studentData = readUserData(studentPath);
    // Student student = gson.fromJson(studentData, Student.class);
    // return student;
    // }

    // public Teacher loadTeacherData(String teacherUserName) {
    // File teacherPath =
    // file.createDiretoryPath(file.getTeacherPath(teacherUserName));
    // String teacherData = readUserData(teacherPath);
    // Teacher teacher = gson.fromJson(teacherData, Teacher.class);
    // return teacher;
    // }
}
