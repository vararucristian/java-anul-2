public abstract class Command {

    public static void generalHelp() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Commands to use:");
        System.out.println("1. add");
        System.out.println("2. save");
        System.out.println("3. load");
        System.out.println("4. open");
        System.out.println("5. list");
        System.out.println("---------------------");
        System.out.println();
    }

    abstract void implementCommand();

    abstract void help();
}