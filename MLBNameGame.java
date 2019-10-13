import javax.swing.JOptionPane;

public class MLBNameGame {
   
   static final String[] TEAMS = {"Houston Astros", "Los Angeles Angels of Anaheim", "Oakland Athletics", "Seattle Mariners",
   "Texas Rangers", "Chicago White Sox", "Cleveland Indians", "Detroit Tigers", "Kansas City Royals", "Minnesota Twins",
   "Baltimore Orioles", "Boston Red Sox", "New York Yankees", "Tampa Bay Rays", "Toronto Blue Jays", "Arizona Diamondbacks",
   "Colorado Rockies", "Los Angeles Dodgers", "San Diego Padres", "San Francisco Giants", "Chicago Cubs", "Cincinnati Reds",
   "Milwaukee Brewers", "Pittsburgh Pirates", "St. Louis Cardinals", "Atlanta Braves", "Miami Marlins", "New York Mets",
   "Philadelphia Phillies", "Washington Nationals"};
   static String[] teams = new String[30];
   static String team;
   static int count = 0;
   
   static void enterTeams() {
      int strikes = 0;
      boolean firstCheck;
      
      while (count < 30) {
         
         team = JOptionPane.showInputDialog(null, "Enter an MLB team (City included) (" + count + ' ' + hasOrHave() + " been entered):");
         team = teamSynonym(team);
         
         firstCheck = true;
         if (! teamIsOnList(TEAMS, TEAMS.length, firstCheck)) {
            JOptionPane.showMessageDialog(null, "Not an MLB team! Strike " + (++strikes) + '!');
            if (strikes == 3) {
               JOptionPane.showMessageDialog(null, "You're out! :(");
               return;
            }
            continue;
         }
         
         firstCheck = false;
         if (! teamIsOnList(teams, count, firstCheck))
            teams[count++] = team;
         else
            JOptionPane.showMessageDialog(null, team + " is already on the list.");
      }
      
      JOptionPane.showMessageDialog(null, "All teams have been entered. :)");
   }
   
   static String hasOrHave() {
      if (count != 1) return "have";
      return "has";
   }
   
   static String teamSynonym(String team) {
      if (team.equalsIgnoreCase("Anaheim Angels") || team.equalsIgnoreCase("Los Angeles Angels") || team.equalsIgnoreCase("Los Angeles Angels Of Anaheim"))
         return "Los Angeles Angels of Anaheim";
      if (team.equalsIgnoreCase("Oakland A's"))
         return "Oakland Athletics";
      if (team.equalsIgnoreCase("Arizona Dbacks") || team.equalsIgnoreCase("Arizona D'backs") || team.equalsIgnoreCase("Arizona D-backs"))
         return "Arizona Diamondbacks";
      if (team.equalsIgnoreCase("Saint Louis Cardinals") || team.equalsIgnoreCase("St Louis Cardinals"))
         return "St. Louis Cardinals";
      return team;
   }
   
   static boolean teamIsOnList(String[] teams, int arySize, boolean firstCheck) {
      for (int i = 0; i < arySize; i++)
         if (teams[i].equalsIgnoreCase(team)) {
            if (firstCheck) team = teams[i];
            return true;
         }
      return false;
   }
   
   static void sort() {
      for (int i = 0; i < count - 1; i++)
         for (int j = i + 1; j < count; j++) {
            if (teams[i].compareTo(teams[j]) > 0) {
               String tmp = teams[i];
               teams[i] = teams[j];
               teams[j] = tmp;
            }
         }
   }
   
   static void print() {
      for (int i = 0; i < count; i++)
         System.out.println(teams[i]);
   }
   
   public static void main(String[] args) {
      enterTeams();
      sort();
      print();
   }
}