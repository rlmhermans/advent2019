package Day06;

import java.util.ArrayList;

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
