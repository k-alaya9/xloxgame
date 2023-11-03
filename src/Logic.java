import java.util.*;


public class Logic {

    public void UserPlay(State state) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Enter the X and the Y to move your block:");
            int x = input.nextInt();
            int y = input.nextInt();
            state.move(x, y);
            state.printState();
        } while (!state.isFinal());
    }

    public void BFS(State state) {
        Graph graph = new Graph();
        Set<State> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        Map<State, State> path = new HashMap<>();
        graph.addNode(state);
        queue.add(state);
        visited.add(state);
        while (!queue.isEmpty()) {
            State node = queue.poll();
            if (node.isFinal()) {
                System.out.println("Graph Size:" + graph.getGraphSize());
                System.out.println("Number of visited node:" + visited.size());
                printPath(path, node);
                break;
            }
            node.getNextState(graph);
            for (State e : graph.GetNode(node)) {
                if (!visited.contains(e)) {
                    visited.add(e);
                    queue.add(e);
                    path.put(e, node);
                }
            }
        }
    }

    public void DFS(State state){
        Graph graph= new Graph();
        Set<State> visited=new HashSet<>();
        Map<State,State> path= new HashMap<>();
        graph.addNode(state);
        dfs(state,graph,visited,path);

    }
    private void dfs(State state,Graph graph,Set<State> visited,Map<State,State>path){
      visited.add(state);
        if(state.isFinal()){
            System.out.println("Graph Size:" + graph.getGraphSize());
            System.out.println("Number of visited node:" + visited.size());
            printPath(path, state);
            return;
        }
      state.getNextState(graph);
        for (State e: graph.GetNode(state)){
            if(!visited.contains(e)){
                path.put(e,state);
                dfs(e,graph,visited,path);
            }
        }
}
        private void printPath (Map < State, State > path, State node){
            List<State> p = new ArrayList<>();
            State currentState = node;
            while (currentState != null) {
                p.add(currentState);
                currentState = path.get(currentState);
            }
            System.out.println("The Path size:"+p.size());
            for (int i = p.size() - 1; i >= 0; i--) {
                p.get(i).printState();
                System.out.println();
            }
        }
    }

