import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String investorName;
        int stockChoice;
        int quantity;

        double buyPrice = 0;
        double currentPrice = 0;
        String stockName = "";

        int tradeId = 1000 + random.nextInt(9000);

        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String tradeTime = now.format(formatter);

        System.out.println("=================================================");
        System.out.println("           STOCK TRADING PLATFORM");
        System.out.println("=================================================");

        System.out.print("Enter Investor Name : ");
        investorName = sc.nextLine();

        System.out.println("\nAvailable Stocks");
        System.out.println("1. Tata Motors   (Buy: 720  Current: 760)");
        System.out.println("2. Reliance      (Buy: 1450 Current: 1520)");
        System.out.println("3. Infosys       (Buy: 1650 Current: 1700)");
        System.out.println("4. TCS           (Buy: 3800 Current: 3950)");
        System.out.println("5. HDFC Bank     (Buy: 1700 Current: 1755)");

        System.out.print("\nSelect Stock : ");
        stockChoice = sc.nextInt();

        switch (stockChoice) {

            case 1:
                stockName = "Tata Motors";
                buyPrice = 720;
                currentPrice = 760;
                break;

            case 2:
                stockName = "Reliance";
                buyPrice = 1450;
                currentPrice = 1520;
                break;

            case 3:
                stockName = "Infosys";
                buyPrice = 1650;
                currentPrice = 1700;
                break;

            case 4:
                stockName = "TCS";
                buyPrice = 3800;
                currentPrice = 3950;
                break;

            case 5:
                stockName = "HDFC Bank";
                buyPrice = 1700;
                currentPrice = 1755;
                break;

            default:
                System.out.println("Invalid Stock Choice!");
                sc.close();
                return;
        }

        System.out.print("Enter Quantity : ");
        quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Invalid Quantity!");
            sc.close();
            return;
        }

        double investment = buyPrice * quantity;
        double currentValue = currentPrice * quantity;
        double grossProfit = currentValue - investment;

        double brokerage = investment * 0.01;
        double gst = brokerage * 0.18;

        double netProfit = grossProfit - brokerage - gst;

        double profitPercentage = (netProfit / investment) * 100;

        String status;

        if (netProfit > 0) {
            status = "PROFIT";
        } else if (netProfit < 0) {
            status = "LOSS";
        } else {
            status = "NO PROFIT";
        }

        System.out.println("\n=================================================");
        System.out.println("              STOCK RECEIPT");
        System.out.println("=================================================");

        System.out.println("Trade ID          : TRD" + tradeId);
        System.out.println("Investor Name     : " + investorName);
        System.out.println("Trade Date        : " + today);
        System.out.println("Trade Time        : " + tradeTime);

        System.out.println("-------------------------------------------------");

        System.out.println("Stock Name        : " + stockName);
        System.out.println("Quantity          : " + quantity);

        System.out.println("Buy Price         : Rs." + buyPrice);
        System.out.println("Current Price     : Rs." + currentPrice);

        System.out.println("-------------------------------------------------");

        System.out.println("Investment Amount : Rs." + investment);
        System.out.println("Current Value     : Rs." + currentValue);

        System.out.println("Gross Profit      : Rs." + grossProfit);
        System.out.println("Brokerage (1%)    : Rs." + brokerage);
        System.out.println("GST (18%)         : Rs." + gst);
        System.out.println("Net Profit        : Rs." + netProfit);

        System.out.printf("Profit %%          : %.2f%%\n", profitPercentage);

        System.out.println("Trade Status      : " + status);

        System.out.println("=================================================");
        System.out.println(" THANK YOU FOR USING STOCK TRADING PLATFORM ");
        System.out.println("=================================================");

        sc.close();
    }
}