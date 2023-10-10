//javac IniciarPortal.java Config.java BaseDisciplina.java Disciplina.java Estudante.java Docente.java

import resources.Config;

final class IniciarPortal extends Config implements Runnable {
    private static String login = "";
    static IniciarPortal thisClasse = new IniciarPortal();
    static Thread novaThread = new Thread(thisClasse);

    public static void main(String[] args) {
        novaThread.start();
        menuPrincipal();
        // registrarEstudante();
    }

    static void menuPrincipal() {
        loadingBar();
        System.out.println("Powered By BL4Z3 \n\n\n\n");
        System.out.println("                                        * * * * * * * * * * * * * * * * * * * ");
        System.out.println("                                        *                                   *");
        System.out.println("                                        *       P O R T A L   U S T M       *");
        System.out.println("                                        *                                   *");
        System.out.println("                                        * * * * * * * * * * * * * * * * * * * \n");
        System.out.println("                                                1 - Login como Docente");
        System.out.println("                                               2 - Login como Estudante");
        System.out.println("                                                       0 - Sair");
        System.out.print("Opcao:");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                login = "docente";
                loginMenu();
                break;
            case 2:
                login = "estudante";
                loginMenu();
                break;
        }
    }

    static void registrarEstudante() {
        cleanConsole();
        System.out.println(
                "                                * * * *   R E G I S T R O   E S T U D A N  T E   * * * *\n\n");
        regEstudantePessoais(1);
    }

    static void logarEstudante() {
        System.out.println(
                "                                   * * * *   L O G A R   E S T U D A N  T E   * * * *\n\n");
    }

    static void loginMenu() {
        cleanConsole();
        membro();
        System.out.println("                                                   1 - Fazer Login");
        System.out.println("                                                   2 - Criar conta");
        System.out.println("                                                      0 - Voltar");
        System.out.print("Opcao:");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                break;
            case 2:
                registrarEstudante();
                break;
            case 0:
                menuPrincipal();
                break;

        }
    }

    static void membro() {
        switch (login) {
            case "docente":
                System.out.println(
                        "\n\n                                     * * * * * * *  D O C E N T E   * * * * * * *\n\n");
                break;
            case "estudante":
                System.out.println(
                        "\n\n                                   * * * * * * *   E S T U D A N T E   * * * * * * *\n\n");
                break;
        }
    }

    @Override
    public void run() {
        construtor();
        hasFinished = !hasFinished;
        novaThreadExec();
        System.out.println("Terminado!");
    }

    synchronized void novaThreadExec() {
        while (suspend) {
            delayTime(1000);
        }
    }
}
