package comp50172023v2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NetworkUtils implements INetworkUtils{
    @Override
    public ListInt breadthFirstSearch(Network network, int index) {
        QueueInt q = new QueueInt(network.getNumStations());
        ListInt ls = new ListInt(network.getNumStations());
        q.addToBack(index);
        while(!(q.getSize() == 0)){
            int s = q.removefromFront();
            if(!ls.contains(s)){
                ls.append(s);
            }
            for (int i = 0; i != network.getNumStations(); i++) {
                if(network.getDistance(s,i) != network.NO_LINK && !ls.contains(i)){
                    q.addToBack(i);
                }
            }
        }
        return ls;
    }

    @Override
    public ListInt depthFirstSearch(Network network, int index) {
        StackInt s = new StackInt(network.getNumStations());
        ListInt ls = new ListInt(network.getNumStations());
        s.push(index);
        while(!(s.getSize() ==0)){
            int t = s.pop();
            if(!ls.contains(t)){
                ls.append(t);
            }
            for(int i = 0; i < network.getNumStations();i++){
                if(network.getDistance(t,i) != network.NO_LINK && !ls.contains(i)){
                    s.push(i);
                }
            }

        }
        return ls;
    }

    @Override
    public ListInt dijkstraPath(Network nt, int startIndex, int endIndex) {
        SetInt closed = new SetInt(nt.getNumStations());
        SetInt open = new SetInt(nt.getNumStations());
        double[] gValues = new double[nt.getNumStations()];
        for (int i = 0; i != nt.getNumStations(); i++) {
            open.include(i);
        }
        for (int i = 0; i != nt.getNumStations(); i++) {
            gValues[i] = nt.NO_LINK;
        }
        gValues[startIndex] = 0;
        String[] previous = new String[nt.getNumStations()];
        Arrays.fill(previous, "none");

        while (!(closed.contains(endIndex))) {
            int x = -1;

            for (int i = 0; i < gValues.length; i++) {
                if (open.contains(i) && (x == -1 || (gValues[i] != nt.NO_LINK && gValues[i] < gValues[x]))) {
                    x = i;
                }
            }
            if (x == -1) {
                break;
            }

            open.exclude(x);
            closed.include(x);

            if (x != endIndex) {
                for (int n = 0; n < nt.getNumStations(); n++) {
                    if (nt.getDistance(x, n) != nt.NO_LINK && open.contains(n)) {
                        double G = gValues[x] + nt.getDistance(x, n);
                        if (G < gValues[n]) {
                            gValues[n] = G;
                            previous[n] = String.valueOf(x);
                        }
                    }
                }
            }
        }

        ListInt path = new ListInt(previous.length);
        int current = endIndex;
        while (!previous[current].equals("none")) {
            path.append(current);
            current = Integer.parseInt(previous[current]);
        }
        path.append(startIndex);

        // Print the Dijkstra's path to the console
        System.out.print("Dijkstra's Path: ");
        for (int i = path.getSize() - 1; i >= 0; i--) {
            System.out.print(path.get(i));
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();



        return path;
    }



    @Override
    public ListInt aStarPath(Network network, int startIndex, int endIndex) {
        return null;
    }
}
