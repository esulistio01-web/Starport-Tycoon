public class Ship {
    private String name;
    private String type;
    private int cargoValue;
    private int dockingTime;
    private boolean smuggler;

    public Ship(String name, String type, int cargoValue, int dockingTime, boolean smuggler) {
        this.name = name;
        this.type = type;
        this.cargoValue = cargoValue;
        this.dockingTime = dockingTime;
        this.smuggler = smuggler;
    }

    public void reduceDockingTime() {
        --this.dockingTime;
    }

    public boolean isFinished() {
        return this.dockingTime <= 0;
    }

    public int getCargoValue() {
        return this.cargoValue;
    }

    public int getDockingTime() {
        return this.dockingTime;
    }

    public boolean isSmuggler() {
        return this.smuggler;
    }

    public boolean isVIP() {
        return this.type.equalsIgnoreCase("VIP");
    }

    public String toString() {
        return this.name + " | " + this.type + " | Cargo: " + this.cargoValue + " | Time: " + this.dockingTime;
    }
}
