package comp50172023v2;

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
            for (int i = 0; i < network.getNumStations(); i++) {
                if(network.getDistance(s,i) != network.NO_LINK && !ls.contains(i)){
                    q.addToBack(s);
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
        return null;
    }

    @Override
    public ListInt aStarPath(Network network, int startIndex, int endIndex) {
        return null;
    }
}
