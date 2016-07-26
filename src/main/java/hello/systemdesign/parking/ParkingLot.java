package hello.systemdesign.parking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scnyig on 7/26/2016.
 */
public class ParkingLot {
    public Map<Long, Slot> occupiedSlots;
    private List<Slot> smallSlots;
    private List<Slot> compactSlots;
    private List<Slot> largeSlots;

    public ParkingLot(int smallCapacity, int carCapacity, int busCapacity) {
        occupiedSlots = new HashMap<>();
        smallSlots = new ArrayList<>(smallCapacity);
        compactSlots = new ArrayList<>(carCapacity);
        largeSlots = new ArrayList<>(busCapacity);
        createSlots();
    }

    private void createSlots() {
        for (int i = 0; i < smallSlots.size(); i++) {
            smallSlots.add(new SmallSlot(false,i));
        }

        for (int i = 0; i < compactSlots.size(); i++) {
            compactSlots.add(new CompactSlot(false,i));
        }

        for (int i = 0; i < largeSlots.size(); i++) {
            largeSlots.add(new LargeSlot(false,i));
        }
    }

    public long park(Vehicle vehicle) {
        //put the vehicle to respective slot and give a toke to vehicle
        return vehicle.hashCode();
    }

    public void unpark(long token) {
        //remove the vehicle from slots
    }
}
