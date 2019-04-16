import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    String path;
    List<Graph> graphs;

    public Catalog(String path) {
        this.path = path;
        this.graphs=new ArrayList<Graph>();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Graph> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<Graph> graphs) {
        this.graphs = graphs;
    }
    public void add(Graph graph)
    {
        graphs.add(graph);
    }
    public void list(){
        for(Graph graph:graphs)
        {
            System.out.println(graph);
        }
    }
    public void open(String name)  {
        FileOutputStream fos = null;
        try {
            for (Graph graph : graphs) {
                if (name.equals(graph.name)) {
                    Desktop desktop = Desktop.getDesktop();
                    File file = new File(graph.imageFilePath);
                    desktop.open(file);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error creating the file!");
            e.printStackTrace();
        }
    }
    public void save(String fileName)  {
          CatalogIO catalogIO =new CatalogIO();
          catalogIO.save(path+"//"+fileName,this);
    }

    public void load(String fileName) throws IOException, ClassNotFoundException {
          CatalogIO catalogIO=new CatalogIO();
          this.graphs=catalogIO.load(path+"//"+fileName,this).graphs;
          this.path=catalogIO.load(path+"//"+fileName,this).path;
    }
}
