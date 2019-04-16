import java.io.Serializable;

public class Graph implements Serializable {
    String name;
    String tgfFilePath;
    String imageFilePath;

    public Graph(String name, String tgfFilePath, String imageFilePath) {
        this.name = name;
        this.tgfFilePath = tgfFilePath;
        this.imageFilePath = imageFilePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTgfFilePath() {
        return tgfFilePath;
    }

    public void setTgfFilePath(String tgfFilePath) {
        this.tgfFilePath = tgfFilePath;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", tgfFilePath=" + tgfFilePath +", imageFilePath=" + imageFilePath + '\n';
    }
}
