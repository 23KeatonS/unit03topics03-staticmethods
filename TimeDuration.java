import java.util.Scanner;

public class TimeDuration {
    private int hours;
    private int minutes;
    private int seconds;
    private static int numTimes = 0;

    public TimeDuration(int hours,int minutes,int seconds){
        this.hours=hours;
        this.minutes=minutes;
        this.seconds=seconds;
        numTimes++;


    }




    public static TimeDuration parseFromString(String str){
        

        int realHours = 0;
        int realMinutes = 0;
        int realSeconds = 0;

        if(str.indexOf("h")!=-1){
            int hoursEndIndex = str.indexOf("h");
            while(!stringIsNumber(str.substring(hoursEndIndex, hoursEndIndex+1))){
                hoursEndIndex--;
            }
            hoursEndIndex++;
            int hoursStartIndex = hoursEndIndex-1;
            while(stringIsNumber(str.substring(hoursStartIndex,hoursStartIndex+1))){
                hoursStartIndex--;
            }
            hoursStartIndex++;
            realHours = Integer.parseInt(str.substring(hoursStartIndex,hoursEndIndex));
        }

        if(str.indexOf("m")!=-1){
            int minutesEndIndex = str.indexOf("m");
            while(!stringIsNumber(str.substring(minutesEndIndex, minutesEndIndex+1))){
                minutesEndIndex--;
            }
            minutesEndIndex++;
            int minutesStartIndex = minutesEndIndex-1;
            while(stringIsNumber(str.substring(minutesStartIndex,minutesStartIndex+1))){
                minutesStartIndex--;
            }
            minutesStartIndex++;
            realMinutes = Integer.parseInt(str.substring(minutesStartIndex,minutesEndIndex));
        }


        if(str.indexOf("s")!=-1){
            int secondsEndIndex = str.indexOf("s");
            while(!stringIsNumber(str.substring(secondsEndIndex, secondsEndIndex+1))){
                secondsEndIndex--;
            }
            System.out.println(secondsEndIndex);
            secondsEndIndex++;
            int secondsStartIndex = secondsEndIndex-1;
            while(stringIsNumber(str.substring(secondsStartIndex,secondsStartIndex+1))){
                secondsStartIndex--;
            }
            System.out.println(secondsStartIndex);
            secondsStartIndex++;
            realSeconds = Integer.parseInt(str.substring(secondsStartIndex,secondsEndIndex));
            System.out.println(realSeconds);
            
        }
        
        return new TimeDuration(realHours,realMinutes,realSeconds);
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


    public int getNumTimes(){
        return numTimes;
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
