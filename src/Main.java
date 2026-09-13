public class Main {
    public static void main(String[] args) {
        System.out.println("                                      |\\\n" +
                "                            __________|_\\______  STRARTPORT TYCOON\n" +
                "  \\_.______________________| * * * * * * * * */\n" +
                " __\\____                   |=================/\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("=== Selamat Datang di Starport Tycoon! ===");
        System.out.println("  Aturan Bermain:");
        System.out.println("1.Pada Saat Awal Bermain Status Pemain Mempunyai Money 0 dan Reputation 5 ");
        System.out.println("2.Pemain Diharapkan Menambahkan Docking Fee Sesuai Aturan (Minimal 0 dan Batas Atas Fee Hanya 500), Default Fee: 100");
        System.out.println("3.Pemain Diharap Menerima Kapal Sesuai Kapasitas Docking Pelabuhan Yaitu Maksimal: 2 Kapal  ");
        System.out.println("4.Pemain Diberikan Kesempatan Batas Bermain Selama 20 Hari Dalam Game");
        System.out.println("5.Pemain Akan Diberikan +1 Point Reputation Jika Menerima Kapal VIP dan Jika Menerima Smuggler Akan Dipotong -1 Point Reputation");
        System.out.println("6.Jika Pemain Menolak Kapal VIP Akan -1 Point Reputation dan Jika Menolak Smuggler Akan Mendapatkan +1 Point Reputation ");
        System.out.println("7.Kapal smuggler tidak akan di tampilkan");
        System.out.println("8.Target Akhir Game Adalah Menerima Money Lebih Dari: 5999 ");
        System.out.println();
        System.out.println("Status Awal: ");
        System.out.println("Money: 0");
        System.out.println("Reputation: 5");
        Game game = new Game();
        game.start();
    }
}
