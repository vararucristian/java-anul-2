package com.company;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
     Hotel v1=new Hotel("California");
     Museum v2=new Museum("Smithsonian");
     Museum v3=new Museum("HistoryOfArt");
     v2.setPriceOfTicket(100);
     v3.setPriceOfTicket(1);

        Church v4=new Church("OrtodoxChurch");
     Church v5=new Church("ChatolicChurch");
     v5.setOpeningHour(LocalTime.of(9,31));
//         v4.setOpeningHour(new Hour(6,30));
        v4.setProgram();

        Restaurant v6=new Restaurant("NicksPhiladelphiaCheeasesAndSubs");
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addNode(v3);
        map.addNode(v4);
        map.addNode(v5);
        map.addEdge(v1, v2, 15); //two way street by default
        map.addEdge(v2, v4, 1,false); //two way street by default
        map.addEdge(v3, v2, 6, false); //one-way street
        System.out.println("The map is: \n" + map.getNodes());
        System.out.println(map.toString());
        map.display1();
        map.display2();
        System.out.println(v5.getOpeningHour());
        System.out.println(v4.getOpeningHour());
        System.out.println(Visitable.getVisitingDuration(v4));
        List<Edge> path=map.greedyPath(v3,v1,new ArrayList<Node>(),new ArrayList<Edge>());
        for(Edge edge:path)
            System.out.println(edge);



    }
}
