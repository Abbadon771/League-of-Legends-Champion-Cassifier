
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
public class Main
{
    
   public static void main(String[] args)
   {
       String ChampionNames[] = {"Malzahar", "Kha'Zix", "Galio", "Akali", "Teemo", "Leona", "Fiora", "Vayne",
        "Sona", "Caitlyn", "Talon", "Ezreal", "Katarina", "Cassiopeia", "Cho'Gath", "Vladimir", "Tahm Kench",
       "Amumu", "Azir", "Lucian", "Twitch", "Braum", "Mordekaiser", "Pantheon"};
       double WinRate[] = {55.97, 53.3, 45.06, 52.33, 54.39, 55.23, 50.39, 52.41, 56.11, 49.73, 51.5,
        56.14, 53.71, 48.55, 53.74, 52.87, 51.13, 53.1, 51.58, 49.36, 54.36, 51.96, 49.54, 55.92};
       String WinRateNB[] = {"greater than %50", "greater than %50", "less than %50", "greater than %50", "greater than %50", 
        "greater than %50", "less than %50", "greater than %50", "greater than %50", "less than %50", "greater than %50", "greater than %50", 
        "greater than %50", "less than %50", "greater than %50", "greater than %50", "greater than %50", "greater than %50", 
        "greater than %50", "less than %50", "greater than %50", "greater than %50", "less than %50", "greater than %50"};
       double PlayRate[] = {9.02, 12.39, 3.29, 3.41, 7.54, 12.15, 15.57, 27.44, 11.6, 7.53, 5.17, 22.28,
       9.38, 2.71, 5.36, 4.42, 1.26, 1.78, 6.23, 13.08, 11.09, 4.66, 0.9, 3.91};
       String PlayRateNB[] = {"greater than %5", "greater than %5", "less than %5", "less than %5", "greater than %5", "greater than %5", "greater than %5", 
       "greater than %5", "greater than %5", "greater than %5", "greater than %5", "greater than %5", "greater than %5", "less than %5", "greater than %5", 
       "less than %5", "less than %5", "less than %5", "greater than %5", "greater than %5", "greater than %5", "less than %5", "less than %5", "less than %5"};
       double BanRate[] = {22.49, 8.8, 6.26, 1.97, 13.72, 11.88, 6.91, 17.33, 9.21, 17.33, 6.68, 33.9, 21.58,
       0.94, 21.05, 9.97, 1.83, 0.39, 7.7, 1.26, 24.02, 1.85, 0.31, 10.7};
       String BanRateNB[] = {"greater than %8", "greater than %8", "less than %8", "less than %8", "greater than %8", "greater than %8", "less than %8", 
       "greater than %8", "greater than %8", "greater than %8", "less than %8", "greater than %8", "greater than %8", "less than %8", "greater than %8", 
       "greater than %8", "less than %8", "less than %8", "less than %8", "less than %8", "greater than %8", 
       "less than %8", "less than %8", "greater than %8"};
       double KDA_Average[] = {6.4, 6.93, 6.67, 6.4, 6.0, 7.43, 5.7, 6.93, 7.73, 6.63, 7.4, 7.43, 7.63, 6.36,
       6.4, 6.23, 6.73, 6.9, 6.4, 7.0, 7.63, 7.2, 5.9, 6.86};
       String KDA_AverageNB[] = {"6.5 or less", "Greater than 6.5", "Greater than 6.5", "6.5 or less", "6.5 or less", "Greater than 6.5", "6.5 or less", 
       "Greater than 6.5", "Greater than 6.5", "Greater than 6.5", "Greater than 6.5", 
       "Greater than 6.5", "Greater than 6.5", "6.5 or less", "6.5 or less", "6.5 or less", "Greater than 6.5", "Greater than 6.5", "6.5 or less", 
       "Greater than 6.5", "Greater than 6.5", "Greater than 6.5", "6.5 or less", "Greater than 6.5"};
       String Role[] = {"Middle", "Jungle", "Middle", "Top", "Top", "Support", "Top", "ADC", "Support", "ADC",
       "Middle", "ADC", "Middle", "Middle", "Jungle", "Middle", "Support", "Jungle", "Middle", "ADC", "ADC",
       "Support", "Top", "Top"};
       String isTopTier[] = {"Yes", "Yes", "No", "No", "Yes", "Yes", "No", "Yes", "Yes", "No", "No", "Yes", "Yes",
       "No", "Yes", "No", "No", "No", "No", "No", "Yes", "No", "No", "Yes"};
        NaiveBayes classifyS = new NaiveBayes(isTopTier, WinRateNB, PlayRateNB, BanRateNB, KDA_AverageNB, Role);
        String[] columnNames = {"Champion Name", "Win Rate", "Play Rate", "Ban Rate", "KDA Average", 
            "is Top Tier"};
        //System.out.println("");
        //System.out.println("");
        /*Object[][] data = {{ChampionNames[0], WinRate[0], PlayRate[0], BanRate[0], KDA_Average[0], Role[0], isTopTier[0]}, 
        {ChampionNames[1], WinRate[1], PlayRate[1], BanRate[1], KDA_Average[1], Role[1], isTopTier[1]}, 
        {ChampionNames[2], WinRate[2], PlayRate[2], BanRate[2], KDA_Average[2], Role[2], isTopTier[2]},
        {ChampionNames[3], WinRate[3], PlayRate[3], BanRate[3], KDA_Average[3], Role[3], isTopTier[3]}};*/
        Object[][] champdata = new Object[24][7];
        for(int i = 0; i < 24; i++)
        {
            champdata[i][0] = ChampionNames[i];
            champdata[i][1] = WinRate[i];
            champdata[i][2] = PlayRate[i];
            champdata[i][3] = BanRate[i];
            champdata[i][4] = KDA_Average[i];
            champdata[i][5] = Role[i];
            champdata[i][6] = isTopTier[i];
        }
        final JTable table = new JTable(champdata, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
        int columNum = 1;
        System.out.println("List of Champions ");
        System.out.println("    --------------------------------------------------");
        for (int i=0; i < numRows; i++) {
            if(columNum < 10)
            {
                System.out.print("    |" + " " + columNum + ":");
            }
            else
            {
                System.out.print("    |" + columNum + ":");
            }
            for (int j=0; j < 7; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            columNum = columNum + 1;
            System.out.println();
        }
        System.out.println("    --------------------------------------------------");
        System.out.print("Input champion name: ");
        /*Scanner user_input = new Scanner(System.in);
        String cName = user_input.nextLine();
        System.out.print("Input win Rate: ");
        Scanner sl = new Scanner(System.in);
        double sam1 = sl.nextDouble();
        System.out.print("Input Play Rate: ");
        double sam2 = sl.nextDouble();
        System.out.print("Input Ban Rate: ");
        double sam3 = sl.nextDouble();
        System.out.print("Input K/D/A Average: ");
        double sam4 = sl.nextDouble();
        System.out.print("Input champion role: ");
        Scanner role_input = new Scanner(System.in);
        String sample5 = role_input.nextLine();
        System.out.println(cName + " " + sam1 + " " + sam2 + " " + sam3 + " " + sam4 + " " + sample5);*/
        String cName = "Zed";
        String sample1, sample2, sample3, sample4;
        sample1 = "greater than %50";
        sample2 = "greater than %5";
        sample3 = "greater than %8";
        sample4 = "Greater than 6.5";
        String sample5 = "Middle";
        /*if(sam1 > 50.0)
        {
            sample1 = "greater than %50";
        }
        else
        {
            sample1 = "less than %50";
        }
        if(sam2 > 5.0)
        {
            sample2 = "greater than %5";
        }
        else
        {
            sample2 = "less than %5";
        }
        if(sam3 > 8.0)
        {
            sample3 = "greater than %8";
        }
        else
        {
            sample3 = "less than %8";
        }
        if(sam4 > 6.5)
        {
            sample4 = "greater than 6.5";
        }
        else
        {
            sample4 = "6.5 or less";
        }*/
        classifyS.acquireSample(cName, sample1, sample2, sample3, sample4, sample5);
        classifyS.classifySample();
        
   }
   
   
}
