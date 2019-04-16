import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Catalog catalog = new Catalog("E:/JAVA/lab4/src/graphs");
        catalog.add (new Graph("K4", "E:\\JAVA\\lab4\\src\\graphs\\complet\\k4.tgf", "E:\\JAVA\\lab4\\src\\graphs\\complet\\view\\k4.png"));
        catalog.add (new Graph("Petersen", "E:\\JAVA\\lab4\\src\\graphs\\c3\\k3.tgf", "E:\\JAVA\\lab4\\src\\graphs\\c3\\view\\k3.jpg"));
        catalog.list();
//        catalog.open("K4");
        catalog.save("catalog.dat");
        catalog.load("catalog.dat");
        catalog.list();
        String commandLine;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        catalog=new Catalog("");
        while (true){
            try {
                System.out.print("shell > ");
                commandLine = console.readLine();
                if (commandLine.matches("new .+")) {
                    System.out.println(commandLine.split(" ")[1]);
                    catalog = new Catalog(commandLine.split(" ")[1]);
                    continue;
                }
                if (commandLine.matches("load .+")) {
                    LoadCommand loadCommand = new LoadCommand(catalog);
                    catalog.graphs = loadCommand.implementComand(commandLine.split(" ")[1]).graphs;
                    catalog.path = loadCommand.implementComand(commandLine.split(" ")[1]).path;
                    continue;
                }
                if (commandLine.matches("help")) {
                    Command.generalHelp();
                    continue;
                }
                if (commandLine.matches("add .+"))
                    try {
                        if (catalog.path.equals(""))
                            throw new IllegalComponentStateException();
                        else {
                            AddCommand add = new AddCommand(commandLine.split(" ")[1], commandLine.split(" ")[3], commandLine.split(" ")[4], commandLine.split(" ")[2]);
                            catalog = add.implementCommand(catalog);
                            continue;
                        }
                    } catch (IllegalComponentStateException e) {
                        System.out.println("You must create a catalog first!");
                    } finally {
                        continue;
                    }
                if (commandLine.matches("list"))
                    try {
                        if (catalog.path.equals(("")))
                            throw new IllegalComponentStateException();
                        else {
                            ListCommand listCommand = new ListCommand(catalog);
                            listCommand.implementCommand();
                            continue;
                        }
                    } catch (IllegalComponentStateException e) {
                        System.out.println("You must create a catalog first!");
                    } finally {
                        continue;
                    }
                if (commandLine.matches("save .+"))
                    try {
                        if (catalog.path.equals(("")))
                            throw new IllegalComponentStateException();
                        else {
                            SaveCommand saveCommand = new SaveCommand(catalog, commandLine.split(" ")[1]);
                            saveCommand.implementCommand();
                            continue;
                        }
                    } catch (IllegalComponentStateException e) {
                        System.out.println("You must create a catalog first!");
                    } finally {
                        continue;
                    }
                if (commandLine.matches("open .+"))
                    try {
                        if (catalog.path.equals(("")))
                            throw new IllegalComponentStateException();
                        else {
                            OpenCommand openCommand = new OpenCommand(catalog);
                            openCommand.implementCommand(commandLine.split(" ")[1]);
                            continue;
                        }
                    } catch (IllegalComponentStateException e) {
                        System.out.println("You must create a catalog first!");
                    } finally {
                        continue;
                    }
                    throw new IllegalArgumentException();
            }catch (IllegalArgumentException e){
                System.out.println("Invalid command");
            }
            finally {
                continue;
            }



        }
    }
}
