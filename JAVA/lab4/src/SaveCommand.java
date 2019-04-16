public class SaveCommand extends Command{
    Catalog catalog;
    String filename;

    public SaveCommand(Catalog catalog,String filename) {
        this.catalog = catalog;
        this.filename=filename;
    }

    @Override
    void implementCommand() {
        catalog.save(filename);
    }

    @Override
    void help() {

    }
}
