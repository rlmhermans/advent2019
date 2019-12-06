import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day06 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Body> bodies = new HashMap<>();
        Scanner fileReader = new Scanner(new File("src/_inputDay6.txt"));
        while (fileReader.hasNextLine()) {
            String input = fileReader.nextLine();

            Body leftBody = new Body(input.substring(0, 3));
            Body rightBody = new Body(input.substring(4));

            bodies.putIfAbsent(leftBody.getName(), leftBody);
            bodies.putIfAbsent(rightBody.getName(), rightBody);

            if (input.contains(")")) {
                bodies.get(rightBody.getName()).setOrbit(bodies.get(leftBody.getName()));
            } else {
                bodies.get(leftBody.getName()).setOrbit(bodies.get(rightBody.getName()));
            }
        }

        Body me = bodies.get("YOU");
        Body santa = bodies.get("SAN");
        ArrayList<Body> meRoute = new ArrayList<>();
        ArrayList<Body> santaRoute = new ArrayList<>();

        me.getRouteToCore(meRoute);
        santa.getRouteToCore(santaRoute);
        meRoute.retainAll(santaRoute);

        int meJumps = me.countJumpsTo(meRoute.get(0));
        int santaJumps = santa.countJumpsTo(meRoute.get(0));

        System.out.println(meJumps + santaJumps);
    }
}

class Body {
    private Body orbits;
    private String name;

    public Body(String name) {
        this.name = name;
    }

    public void setOrbit(Body body) {
        this.orbits = body;
    }

    public ArrayList<Body> getRouteToCore(ArrayList<Body> route) {
        if (orbits != null) {
            route.add(orbits);
            return orbits.getRouteToCore(route);
        }

        return route;
    }

    public int countJumpsTo(Body body) {
        if (orbits != null && orbits != body) {
            return 1 + orbits.countJumpsTo(body);
        }

        return 0;
    }

    public String getName() {
        return name;
    }
}

