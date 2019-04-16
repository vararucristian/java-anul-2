public class AddCommand extends Command {
    //public Graph(String name, String tgfFilePath, String imageFilePath)
    Graph graph;
    String description;

    public AddCommand(String name,String tgfFilePath,String imageFilePath ,String description) {
        this.graph = new Graph(name,tgfFilePath,imageFilePath);
        this.description = description;
    }

    Catalog implementCommand(Catalog catalog) {
        catalog.add(graph);
        return catalog;
    }

    @Override
    void implementCommand() {

    }

    @Override
    void help() {

    }
}
