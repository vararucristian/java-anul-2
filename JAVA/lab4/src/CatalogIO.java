import java.io.*;

public class CatalogIO {

    public void save(String path,Catalog catalog ) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
            out.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Unexpected error reading the file!");
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();

                } catch (IOException e) {
                    System.out.println("error closing the file!");
                    e.printStackTrace();
                }
            }

        }
    }

    public Catalog load(String path,Catalog catalog) throws ClassNotFoundException {
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fis);
            Catalog catalog1 = new Catalog("E:\\JAVA\\lab 4\\src\\graphs");
            catalog1 = (Catalog) in.readObject();
            return catalog1;
        }catch (IOException e){
            System.out.println("Unexpected error creating the file!");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            System.out.println("Class wasn't found!");
            e.printStackTrace();
        }
        finally {
            return catalog;
        }

    }
}
