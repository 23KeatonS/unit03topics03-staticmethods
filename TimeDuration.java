import java.util.Scanner;

public class TimeDuration {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeDuration(int hours,int minutes,int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;


    }



    public static TimeDuration parseFromString(String str){
        
        String stringHours;
        String stringMinutes;
        String stringSeconds;

        if(str.indexOf("h")!=-1){
            int hoursEndIndex = str.indexOf("h");
            while(!stringIsNumber(str.substring(hoursEndIndex, hoursEndIndex+1))){
                hoursEndIndex--;
            }
            int realHours = Integer.parseInt(str.substring(hoursEndIndex,hoursEndIndex+1));
        }

        if(str.indexOf("m")!=-1){
            int minutesEndIndex = str.indexOf("m");
            while(!stringIsNumber(str.substring(minutesEndIndex, minutesEndIndex+1))){
                minutesEndIndex--;
            }
            int minutesStartIndex = minutesEndIndex;
            while(stringIsNumber(str.substring(minutesStartIndex,minutesStartIndex))){
                minutesStartIndex--;
            }
            minutesStartIndex++;
            int realMinutes = Integer.parseInt(str.substring(minutesStartIndex,minutesEndIndex));
            System.out.println(realMinutes);
        }
        
        return new TimeDuration(3,3,3);
    }



    private static boolean stringIsNumber(String s) {
        
        if (s.equals("0") ||
        s.equals("1") ||
        s.equals("2") ||
        s.equals("3") ||
        s.equals("4") ||
        s.equals("5") ||
        s.equals("6") ||
        s.equals("7") ||
        s.equals("8") ||
        s.equals("9")) {
            return true;
        } else {
            return false;
        }
    }

    public String ToString(){
        return "";
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a time: ");
        String userInput = scanner.nextLine();
        TimeDuration time1 = parseFromString(userInput);

        
    }
}
