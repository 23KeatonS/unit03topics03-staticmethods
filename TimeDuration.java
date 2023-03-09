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







    public static int NumBeforeLet(String str, String letter){
            int EndIndex = str.indexOf(letter);
            while(!stringIsNumber(str.substring(EndIndex,EndIndex+1))){
                EndIndex--;
            }
            int startIndex = EndIndex;
            while(stringIsNumber(str.substring(startIndex,startIndex+1))){
                if(startIndex!=0){
                    startIndex--;
                }else{
                    break;
                }
            }
            if(startIndex!=0){
                startIndex++;
            }
            return Integer.parseInt(str.substring(startIndex,EndIndex+1));
        
    }


    public static int[] NumAfterColon(String str){
        int startIndex = str.lastIndexOf(":");
        int colonIndex = startIndex;
        while(!stringIsNumber(str.substring(startIndex,startIndex+1))){
            startIndex++;
        }
        int endIndex = startIndex;
        while(stringIsNumber(str.substring(endIndex,endIndex+1))){
            if(endIndex!=str.length()-1){
                endIndex++;
        }else{
            break;
        }

    }
    if(endIndex==str.length()-1){
        endIndex++;
    }
    return new int[] {Integer.parseInt(str.substring(startIndex,endIndex)),colonIndex};
}




    public static TimeDuration parseFromString(String str){
    
        int realHours = 0;
        int realMinutes = 0;
        int realSeconds = 0;

        if(str.indexOf("h")!=-1){
            realHours = NumBeforeLet(str, "h");
        }
        if(str.indexOf("m")!=-1){
            realMinutes = NumBeforeLet(str, "m");
        }
        if(str.indexOf("s")!=-1){
            realSeconds = NumBeforeLet(str, "s");
        }

        int lastIndex = str.length()-1;
        if(str.indexOf(":")!=-1){
            int [] results = NumAfterColon(str);
            realSeconds = results[0];
            lastIndex = results[1];

        }
        if(str.indexOf(":")!=-1){
            int[] results = NumAfterColon(str.substring(0,lastIndex));
            realMinutes = results[0];
            lastIndex = results[1];
            if(stringIsNumber(str.substring(0,1))){
                realHours = Integer.parseInt(str.substring(0,lastIndex));
            }
            
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
        
        System.out.println(time1.hours);
        System.out.println(time1.minutes);
        System.out.println(time1.seconds);
        System.out.println(NumAfterColon(":1234:123:12")[0]);

        
    }
}
