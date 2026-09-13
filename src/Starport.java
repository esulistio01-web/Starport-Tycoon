import java.util.ArrayList;

public class Starport {
    private ArrayList<Ship> dockedShips = new ArrayList();
    private ArrayList<Ship> queueShips = new ArrayList();
    private int dockingSlot = 2;
    private int dockingFee = 100;
    private int money = 0;
    private int reputation = 5;

    public void addShipToQueue(Ship ship) {
        this.queueShips.add(ship);
    }

    public void acceptShip(int index) {
        if (this.dockedShips.size() >= this.dockingSlot) {
            System.out.println("Dock penuh!");
        } else if (index >= 0 && index < this.queueShips.size()) {
            Ship ship = (Ship)this.queueShips.remove(index);
            this.dockedShips.add(ship);
            if (ship.isVIP()) {
                this.reputation += 1;
            }

            if (ship.isSmuggler()) {
                this.reputation -= 1;
            }

            System.out.println("Kapal diterima.");
        } else {
            System.out.println("Index tidak valid!");
        }
    }

    public void rejectShip(int index) {
        if (index >= 0 && index < this.queueShips.size()) {
            Ship ship = (Ship)this.queueShips.remove(index);
            if (ship.isVIP()) {
                this.reputation -= 1;
            }
            if (ship.isSmuggler()) {
                this.reputation += 1;
            }

            System.out.println("Kapal ditolak.");
        } else {
            System.out.println("Index tidak valid!");
        }
    }

    public void processDockedShips() {
        for(int i = 0; i < this.dockedShips.size(); ++i) {
            Ship ship = (Ship)this.dockedShips.get(i);
            ship.reduceDockingTime();
            if (ship.isFinished()) {
                this.money += this.dockingFee + ship.getCargoValue();
                this.dockedShips.remove(i);
                --i;
            }
        }

    }

    public void showDockedShips() {
        if (this.dockedShips.isEmpty()) {
            System.out.println("Tidak ada kapal yang sedang sandar.");
        }

        for(Ship s : this.dockedShips) {
            System.out.println(s);
        }

    }

    public void showQueueShips() {
        if (this.queueShips.isEmpty()) {
            System.out.println("Tidak ada kapal yang sedang antri.");
        }

        for(int i = 0; i < this.queueShips.size(); ++i) {
            System.out.println((i + 1) + ". " + String.valueOf(this.queueShips.get(i)));
        }

    }

    public int getMoney() {
        return this.money;
    }

    public int getReputation() {
        return this.reputation;
    }

    public void setDockingFee(int fee) {
        if (fee < 0 || fee > 500) {
            System.out.println("Biaya sandar tidak sesuai dengan ketentuan!");
        } else {
            this.dockingFee = fee;
        }
    }
}
