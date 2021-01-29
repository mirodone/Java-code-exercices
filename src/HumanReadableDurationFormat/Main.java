package HumanReadableDurationFormat;

public class Main {

    public static void main(String[] args) {

        System.out.println(formatDuration(777777777));

    }


    public static String formatDuration(int seconds) {

        int time = seconds;
        int years = seconds/31536000;
        seconds -= years*31536000;
        int days = seconds / 86400;
        seconds -= days * 86400;
        int hours = seconds / 3600;
        seconds -= hours * 3600;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        int mySeconds = seconds;

        StringBuilder  stringBuilder = new StringBuilder();
        if ( time == 0) stringBuilder.append("now");
        time = addYears(time, years, stringBuilder);
        time = addDays(time, days, stringBuilder);
        time = addHours(time, hours, stringBuilder);
        addMinutes(time, minutes, stringBuilder);
        addSeconds(mySeconds, stringBuilder);

        if(stringBuilder.indexOf(",") >0) stringBuilder.replace(stringBuilder.lastIndexOf(","), stringBuilder.lastIndexOf(",") +1, " and");

     return stringBuilder.toString().trim();
    }

    private static void plural( int count, StringBuilder sb){
        if (count >1) sb.append("s");
    }

    private static void order( int time, StringBuilder sb){
        if(time >0 ) {
            sb.append(", ");
        }else {
            sb.append(" ");
        }
    }


    private static void addSeconds (int seconds, StringBuilder sb){
        if(seconds>0){
            sb.append(seconds).append(" second");
            plural(seconds, sb);
        }
    }

    private static void addMinutes ( int time, int minutes, StringBuilder sb){
        if( minutes >0) {
            sb.append(minutes).append(" minute");
            plural(minutes, sb);
            time -= minutes * 60;
            order(time, sb);
        }
    }

    private static int addHours ( int time, int hours, StringBuilder sb){
        if( hours >0) {
            sb.append(hours).append(" hour");
            plural(hours, sb);
            time -= hours * 3600;
            order(time, sb);
        }

        return time;
    }

    private static int addDays ( int time, int days, StringBuilder sb){
        if( days >0) {
            sb.append(days).append(" day");
            plural(days, sb);
            time -= days * 86400;
            order(time, sb);
        }

        return time;
    }

    private static int addYears ( int time, int years, StringBuilder sb){
        if( years >0) {
            sb.append(years).append(" year");
            plural(years, sb);
            time -= years * 31536000;
            order(time, sb);
        }

        return time;
    }

}
