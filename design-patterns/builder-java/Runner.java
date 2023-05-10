import car_components.*;

import java.util.ArrayList;
import java.util.List;

public class Runner {
  public static void main(String[] args) {
    final Engine engine = new Engine();
    final List<Seat> seats = new ArrayList<>();
    final Steering steering = new Steering();
    final SunRoof sunRoof = new SunRoof();
    final AirBags airBags = new AirBags();
    final MusicSystem musicSystem = new MusicSystem();
    final CentralLock centralLock = new CentralLock();

    /**
     * Using builders
     * 1. Simple construction.
     * 2. Looks clean. More Readable
     * 3. Object remains immutable once it is build.
     */

    CarWithBuilder carWithBuilder = CarWithBuilder.builder()
        .withEngine(engine)
        .withSteering(steering)
        .withSeats(ImmutableList.of())
        .withFuel(Fuel.DIESEL)
        .withSunRoof(sunRoof)
        .withMusicSystem(musicSystem).build();

    CarWithBuilder carWithBuilder1 = CarWithBuilder.builder()
        .withEngine(engine)
        .withSteering(steering)
        .withSeats(ImmutableList.of())
        .withFuel(Fuel.DIESEL)
        .withAirBags(airBags)
        .withCentralLock(centralLock)
        .withSunRoof(sunRoof)
        .withMusicSystem(musicSystem).build();
  }
}
