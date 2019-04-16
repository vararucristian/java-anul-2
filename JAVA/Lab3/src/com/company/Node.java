package com.company;

public abstract class  Node implements Comparable {
    String name;
    float longitude;
    float latitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public Node(String name) {
        this.name = name;
    }


    public int compareTo(Object other){
        if (other == null )
            throw new NullPointerException();
        if (!( other instanceof Node ))
            throw new ClassCastException ("Uncomparable objects!");
        return this.name.compareTo(((Node) other).name);

    }

}