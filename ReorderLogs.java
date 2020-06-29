/*
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.
Time Complexity: O(ALogA) a -> contents of logs
*/
import java.util.*;

class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitLogs = new ArrayList<>();
        List<String> letterLogs = new ArrayList<>();
        
        
        
        for(String log : logs)
        {
            String[] s = log.split(" ");
            if(Character.isDigit(s[1].charAt(0)))
                digitLogs.add(log);
            else
                letterLogs.add(log);
        }
        Collections.sort(letterLogs ,new Comparator<String>(){
            public int compare(String s1 , String s2)
            {
                 int i1 = s1.indexOf(" ");
                 int i2 = s2.indexOf(" ");
                 if(s1.substring(i1 + 1).equals(s2.substring(i2 + 1)))
                 {
                      return s1.substring(0,i1).compareTo(s2.substring(0,i2));
                 }
                else
                {
                    return s1.substring(i1 + 1).compareTo(s2.substring(i2 + 1));
                }
            }
        } );
        digitLogs.addAll(0,letterLogs);
        return digitLogs.toArray(new String[digitLogs.size()]);
    }
}
