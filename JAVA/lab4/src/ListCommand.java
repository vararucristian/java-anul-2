public class ListCommand extends Command{
    Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    void implementCommand() {
        catalog.list();
    }

    @Override
    void help() {

    }
}
