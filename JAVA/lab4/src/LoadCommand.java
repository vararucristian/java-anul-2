import java.io.IOException;

public class LoadCommand extends Command{
    Catalog catalog;

    public LoadCommand(Catalog catalog) {
        this.catalog = catalog;
    }


    Catalog implementComand(String filename) throws IOException, ClassNotFoundException {
        CatalogIO catalogIO=new CatalogIO();
        System.out.println(catalogIO.load(filename,this.catalog).path);
        return catalogIO.load(filename,this.catalog);
    }
    @Override
    void implementCommand() {
        //
    }

    @Override
    void help() {

    }
}
