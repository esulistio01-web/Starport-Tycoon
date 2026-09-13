import java.util.Random;
import java.util.Scanner;

public class Game {
    private Starport starport = new Starport();
    private Scanner sc;
    private Random rand;
    private int day;
    private final int MAX_DAY = 20;
    private final int TARGET_MONEY = 3000;

    public Game() {
        this.sc = new Scanner(System.in);
        this.rand = new Random();
        this.day = 1;
    }

    public void start() {
        while(this.day <= 20) {
            System.out.print("\n=== DAY " + this.day + " ===");
            this.generateShips();
            this.dailyMenu();
            this.starport.processDockedShips();
            System.out.println("Money: " + this.starport.getMoney());
            System.out.println("Reputation: " + this.starport.getReputation());
            if (this.starport.getMoney() >= 6000) {
                System.out.println("MENANG! Target tercapai.");
                return;
            }

            if (this.starport.getReputation() <= 0) {
                System.out.println("GAME OVER! Reputasi habis.");
                return;
            }

            ++this.day;
        }

        System.out.println("Game selesai. Hari habis.");
    }

    private void generateShips() {
        int total = this.rand.nextInt(3) + 1;

        for(int i = 0; i < total; ++i) {
            boolean vip = this.rand.nextBoolean();
            boolean smuggler = this.rand.nextInt(4) == 0;
            int var10002 = this.rand.nextInt(100);
            Ship ship = new Ship("Ship-" + var10002, vip ? "VIP" : "Cargo", this.rand.nextInt(300) + 100, this.rand.nextInt(3) + 1, smuggler);
            this.starport.addShipToQueue(ship);
        }

    }

    private void dailyMenu() {
        boolean endDay = false;

        while(!endDay) {
            System.out.println(" \n=== Menu Starport Tycoon ===");
            System.out.println("1. Lihat kapal sandar");
            System.out.println("2. Lihat antrian kapal");
            System.out.println("3. Terima kapal");
            System.out.println("4. Tolak kapal");
            System.out.println("5. Set Docking Fee");
            System.out.println("6. Akhiri hari");
            System.out.print("Pilih: ");
            int choice = this.sc.nextInt();
            switch (choice) {
                case 1:
                    this.starport.showDockedShips();
                    break;
                case 2:
                    this.starport.showQueueShips();
                    break;
                case 3:
                    System.out.print("Index: ");
                    this.starport.acceptShip(this.sc.nextInt() - 1);
                    break;
                case 4:
                    System.out.print("Index: ");
                    this.starport.rejectShip(this.sc.nextInt() - 1);
                    break;
                case 5:
                    System.out.print("Fee baru: ");
                    this.starport.setDockingFee(this.sc.nextInt());
                    break;
                case 6:
                    endDay = true;
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        }

    }
}
