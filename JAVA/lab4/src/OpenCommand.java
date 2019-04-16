public class OpenCommand extends Command {
    Catalog catalog;

    public OpenCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    void implementCommand(String name){
        catalog.open(name);
    }
    @Override
    void implementCommand() {
        //
    }

    @Override
    void help() {

    }
}
