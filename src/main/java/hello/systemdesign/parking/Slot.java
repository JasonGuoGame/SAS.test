package hello.systemdesign.parking;

/**
 * Created by scnyig on 7/26/2016.
 */
public abstract class Slot {
    private boolean isOccupied;
    private int slotNumber;
    public enum SlotType{
        SMALL_SLOT,
        COMPACT_SLOT,
        LARGE_SLOT
    }

    public Slot(boolean isOccupied, int slotNumber) {
        this.isOccupied = isOccupied;
        this.slotNumber = slotNumber;
    }

    public void park() {
        this.isOccupied = true;
    }

    public void unpark() {
        this.isOccupied = false;
    }

    @Override
    public boolean equals(Object obj) {
        return isOccupied == ((Slot)obj).isOccupied() && ((Slot)obj).getSlotNumber() == slotNumber;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
