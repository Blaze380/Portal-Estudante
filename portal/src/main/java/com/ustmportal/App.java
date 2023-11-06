package com.ustmportal;

import com.ustmportal.resources.menu.StudentMenus;
import com.ustmportal.resources.menu.TeacherMenus;

import com.ustmportal.resources.menu.Menus;

final class App {
    final static StudentMenus studentMenus = new StudentMenus();
    final static TeacherMenus teacherMenu = new TeacherMenus();
    final static Menus menu = new Menus();
    static byte option = 1;

    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    static void mainMenu() {
        // TODO put the loading bar to the menu loadingBar();
        option = menu.mainMenu();
        switch (option) {
            case 1:
                teacherMenu.chooseSigninOrSignup();
                break;
            case 2:

                studentMenus.chooseSigninOrSignup();
                break;
            case 0:
                System.exit(0);
        }
    }

}
