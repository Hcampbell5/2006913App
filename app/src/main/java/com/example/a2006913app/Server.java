package com.example.a2006913app;
import android.content.res.Resources;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    private Scanner mapFile;
    private ArrayList<Node> nodes;

    public Server(InputStream inpStream) throws FileNotFoundException {

        mapFile = new Scanner(inpStream);
        nodes = new ArrayList<Node>();

        while(hasAnotherLine()){  //while there are still ines in the file
            //Getting new line
            String ln = getline();
            //Splitting line on commas
            String[] lnArray = ln.split(",");

            //Converting Data
            int nodeID = Integer.parseInt(lnArray[0]);
            int yesID = Integer.parseInt(lnArray[1]);
            int noID = Integer.parseInt(lnArray[2]);
            String description = lnArray[3];
            String question = lnArray[4];


            //Building Node class
            Node nd = new Node(nodeID,yesID,noID,description,question);

            //Adding node to array
            nodes.add(nd);
        }
    }


    public int getNextNode(int yesNo, Node nd) { //Outputs next node id based off a yes/no
        if (yesNo == 0) {
            return nd.getYesID();
        }

        if (yesNo == 1) {
            return nd.getNoID();
        }
        return yesNo;
    }


    public Node getNode(int nodeID){ //Searches the nd array for the next node
        for(Node nd: nodes){
            if(nd.getNodeID()==nodeID){
                return nd;
            }
        }
        return null; //add in better method!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! this will crash
    }

    public String getline() {
        return mapFile.nextLine();
    }

    public void Close() {
        mapFile.close();
    }

    public boolean hasAnotherLine() {
        return mapFile.hasNext();
    }

    public String toString(){
        String string = "";
        for(Node nd : nodes){string += nd.toString() + "\n";}
        return string;
    }

}
