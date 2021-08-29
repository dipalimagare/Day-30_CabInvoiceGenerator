
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RidesRepository
{

    Map<String, ArrayList<Rides>> userRides;

    public RidesRepository()
    {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Rides[] rides)
    {
        this.userRides.put(userId, new ArrayList<Rides>(Arrays.asList(rides)));
    }

    public Rides[] getRides(String userId)
    {
        return this.userRides.get(userId).toArray(new Rides[0]);
    }
}
