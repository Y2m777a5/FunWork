import java.util.Scanner;

public class Calender{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any year:");
        int year = sc.nextInt();
        System.out.println("Enter 1st three letter of a month / type all to get yearly calender");
        String month = sc.next();
        sc.close();
        System.out.println();
        YearCalender(year,month);
    }

    //Leap year check;
    public static boolean isLeap(int a){
        boolean flag;
        if(a%4==0){
            flag = true;
            if(a%100==0){
                if(a%400==0){
                    flag=true;
                }
                else{
                    flag=false;
                }
            }
        }
        else{
            flag = false;
        }
        return flag;
    }

    //Total numbers of leap years passed;
    public static int numLeap(int ny){
        int count = 0;
        for(int i=1;i<=ny; i++){
            if(isLeap(i)){
                count++;
            }
        }
        return count;
    }
    
    //Digit checker;
    public static int Digit(int n){
        int counter=1;
        int num=n;
        while(num!=0){
            num/=10;
            counter++;
        }
        return (counter-1);
    }
    
    //1st day of Jan;
     public static int Fday(int year){
        int Day;
        if(isLeap(year)){
            Day =((year + numLeap(year))%7)-1;
        }
        else{
            Day =(year + numLeap(year))%7;
        }
        return Day;
    }
    
    //First day of each month in an array;
    public static int [] FDayArray(int Year){
            int [] a = new int [12];
            int day = Fday(Year);
            a[0]=day;
            //Dates of Months;
            int month = 1;
            int j=1;
            while(month<13){
                int date = 1;
                
                if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                    //mentioned month and year;
                    
                    while(date<32){
                        for(int i=day; i<7; i++){
                            if(i!=6 && date<31){
                                date++;
                            }
                            else if(i!=6 && date==31){
                                date++;
                                day = i+1;
                                break;
                            }
                            else{
                                date++;
                                day = 0;
                                break;
                            }
                        }
                    }
                }
                
                //For 30 day months;
                else if(month==4 || month==6 || month==9 || month==11){
                    //print days;
                    while(date<31){
                        for(int i=day; i<7; i++){
                            if(i!=6 && date<30){
                                date++;
                            }
                            else if(i!=6 && date==30){
                                date++;
                                day = i+1;
                                break;
                            }
                            else{
                                date++;
                                day = 0;
                                break;
                            }
                        }
                    }
                }
                
                else{
                    //If leap year feb==29;
                    if(isLeap(Year)){
                        while(date<30){
                            for(int i=day; i<7; i++){
                                if(i!=6 && date<29){
                                    date++;
                                }
                                else if(i!=6 && date==29){
                                    date++;
                                    day = i+1;
                                    break;
                                }
                                else{
                                    date++;
                                    day = 0;
                                    break;
                                }
                            }
                        }
                    }
                    
                    // If not leap year feb==28;
                    else{
                        while(date<29){
                            for(int i=day; i<7; i++){
                                if(i!=6 && date<28){
                                    date++;
                                }
                                else if(i!=6 && date==28){
                                    date++;
                                    day = i+1;
                                    break;
                                }
                                else{
                                    date++;
                                    day = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                a[j]=day;
                if(j<11){
                    j++;
                }
                month++;
            }
        return a;
    }
    
    //Calender;
    public static void YearCalender(int y, String mon){
        String [] week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        int lenW = week.length;
        int dayOfMon[]=FDayArray(y);
        
        //for January/ March/ May/ July/ August/ October/ December;
        if(mon.equalsIgnoreCase("Jan") || mon.equalsIgnoreCase("Mar") || mon.equalsIgnoreCase("May") || mon.equalsIgnoreCase("Jul") || mon.equalsIgnoreCase("Aug") || mon.equalsIgnoreCase("Oct") || mon.equalsIgnoreCase("Dec")){
            int day1=1; 
            int date1=1;
            if(mon.equalsIgnoreCase("Jan")){
                System.out.println("January "+y);
                day1 = dayOfMon[0];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Mar")){
                System.out.println("March "+y);
                day1 = dayOfMon[2];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("May")){
                System.out.println("May "+y);
                day1 = dayOfMon[4];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Jul")){
                System.out.println("July "+y);
                day1 = dayOfMon[6];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Aug")){
                System.out.println("August "+y);
                day1 = dayOfMon[7];
                date1 = 1;
            }else if(mon.equalsIgnoreCase("Oct")){
                System.out.println("October "+y);
                day1 = dayOfMon[9];
                date1 = 1;
            }else if(mon.equalsIgnoreCase("Dec")){
                System.out.println("December "+y);
                day1 = dayOfMon[11];
                date1 = 1;
            }
            //print days;
            for(int i=0; i<lenW; i++){
                    if(i<(lenW-1)){
                        System.out.print(week[i]+" ");
                    }
                    else{
                        System.out.println(week[i]);
                    }
                }
                for(int sp=day1; sp>0; sp--){
                    System.out.print("    ");
                }
                while(date1<32){
                    for(int i=day1; i<7; i++){
                        if(i!=6 && date1<31){
                            if(Digit(date1)==2){
                                System.out.print(date1++ +"  ");
                            }
                            else{
                                System.out.print(date1++ +"   ");
                            }
                        }
                        else if(i!=6 && date1==31){
                            if(Digit(date1)==2){
                                System.out.println(date1++ +"  ");
                            }
                            else{
                                System.out.println(date1++ +"   ");
                            }
                            day1 = i+1;
                            break;
                        }
                        else{
                            if(Digit(date1)==2){
                                System.out.println(date1++ +"  ");
                            }
                            else{
                                System.out.println(date1++ +"   ");
                            }
                            day1 = 0;
                            break;
                        }
                    }
                }
        }
        
        //for February;
        else if(mon.equalsIgnoreCase("Feb")){
            System.out.println("February "+y);
            int day2 = dayOfMon[1];
            int date2 = 1;
                //If leap year feb==29;
                if(isLeap(y)){
                        for(int i=0; i<lenW; i++){
                        if(i<(lenW-1)){
                            System.out.print(week[i]+" ");
                        }
                        else{
                            System.out.println(week[i]);
                        }
                    }
                    for(int sp=day2; sp>0; sp--){
                        System.out.print("    ");
                    }
                    while(date2<30){
                        for(int i=day2; i<7; i++){
                            if(i!=6 && date2<29){
                                if(Digit(date2)==2){
                                    System.out.print(date2++ +"  ");
                                }
                                else{
                                    System.out.print(date2++ +"   ");
                                }
                            }
                            else if(i!=6 && date2==29){
                                if(Digit(date2)==2){
                                    System.out.println(date2++ +"  ");
                                }
                                else{
                                    System.out.println(date2++ +"   ");
                                }
                                day2 = i+1;
                                break;
                            }
                            else{
                                if(Digit(date2)==2){
                                    System.out.println(date2++ +"  ");
                                }
                                else{
                                    System.out.println(date2++ +"   ");
                                }
                                day2 = 0;
                                break;
                            }
                        }
                    }
                }
                // If not leap year feb==28;
                else{
                        for(int i=0; i<lenW; i++){
                        if(i<(lenW-1)){
                            System.out.print(week[i]+" ");
                        }
                        else{
                            System.out.println(week[i]);
                        }
                    }
                    for(int sp=day2; sp>0; sp--){
                        System.out.print("    ");
                    }
                    while(date2<29){
                        for(int i=day2; i<7; i++){
                            if(i!=6 && date2<28){
                                if(Digit(date2)==2){
                                    System.out.print(date2++ +"  ");
                                }
                                else{
                                    System.out.print(date2++ +"   ");
                                }
                            }
                            else if(i!=6 && date2==28){
                                if(Digit(date2)==2){
                                    System.out.println(date2++ +"  ");
                                }
                                else{
                                    System.out.println(date2++ +"   ");
                                }
                                day2 = i+1;
                                break;
                            }
                            else{
                                if(Digit(date2)==2){
                                    System.out.println(date2++ +"  ");
                                }
                                else{
                                    System.out.println(date2++ +"   ");
                                }
                                day2 = 0;
                                break;
                            }
                        }
                    }
                }
        }
        
        //for April/ Jun/ September/ November;
        else if(mon.equalsIgnoreCase("Apr") || mon.equalsIgnoreCase("Jun") || mon.equalsIgnoreCase("Sep") || mon.equalsIgnoreCase("Nov")){
           int day3=1; int date3=1;
            if(mon.equalsIgnoreCase("Apr")){
                System.out.println("April "+y);
                day3 = dayOfMon[3];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Jun")){
                System.out.println("June "+y);
                day3 = dayOfMon[5];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Sep")){
                System.out.println("September "+y);
                day3 = dayOfMon[8];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Nov")){
                System.out.println("November "+y);
                day3 = dayOfMon[10];
                date3 = 1;
            }
            //print days;
                for(int i=0; i<lenW; i++){
                    if(i<(lenW-1)){
                        System.out.print(week[i]+" ");
                    }
                    else{
                        System.out.println(week[i]);
                    }
                }
                for(int sp=day3; sp>0; sp--){
                    System.out.print("    ");
                }
                while(date3<31){
                    for(int i=day3; i<7; i++){
                        if(i!=6 && date3<30){
                            if(Digit(date3)==2){
                                System.out.print(date3++ +"  ");
                            }
                            else{
                                System.out.print(date3++ +"   ");
                            }
                        }
                        else if(i!=6 && date3==30){
                            if(Digit(date3)==2){
                                System.out.println(date3++ +"  ");
                            }
                            else{
                                System.out.println(date3++ +"   ");
                            }
                            day3 = i+1;
                            break;
                        }
                        else{
                            if(Digit(date3)==2){
                                System.out.println(date3++ +"  ");
                            }
                            else{
                                System.out.println(date3++ +"   ");
                            }
                            day3 = 0;
                            break;
                        }
                    }
                }
        }
        
        //for all months/ Yearly calender;
        else if(mon.equalsIgnoreCase("all")){
        //Calculate day of Jan 1;
        int day = Fday(y);
        
        //Dates of Months;
        int month = 1;
        
        while(month<13){
            int date = 1;
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                //print mentioned month and year;
                if(month==1){
                    System.out.println("January "+y);
                }
                else if(month==3){
                    System.out.println("March "+y);
                }
                else if(month==5){
                    System.out.println("May "+y);
                }
                else if(month==7){
                    System.out.println("July "+y);
                }
                else if(month==8){
                    System.out.println("August "+y);
                }
                else if(month==10){
                    System.out.println("October "+y);
                }
                else if(month==12){
                    System.out.println("December "+y);
                }
                //print days;
                for(int i=0; i<lenW; i++){
                    if(i<(lenW-1)){
                        System.out.print(week[i]+" ");
                    }
                    else{
                        System.out.println(week[i]);
                    }
                }
                for(int sp=day; sp>0; sp--){
                    System.out.print("    ");
                }
                while(date<32){
                    for(int i=day; i<7; i++){
                        if(i!=6 && date<31){
                            if(Digit(date)==2){
                                System.out.print(date++ +"  ");
                            }
                            else{
                                System.out.print(date++ +"   ");
                            }
                        }
                        else if(i!=6 && date==31){
                            if(Digit(date)==2){
                                System.out.println(date++ +"  ");
                            }
                            else{
                                System.out.println(date++ +"   ");
                            }
                            day = i+1;
                            break;
                        }
                        else{
                            if(Digit(date)==2){
                                System.out.println(date++ +"  ");
                            }
                            else{
                                System.out.println(date++ +"   ");
                            }
                            day = 0;
                            break;
                        }
                    }
                }
            }
            
            //For 30 day months;
            else if(month==4 || month==6 || month==9 || month==11){
                //print mentioned month and year;
                if(month==4){
                    System.out.println("April "+y);
                }
                else if(month==6){
                    System.out.println("June "+y);
                }
                else if(month==9){
                    System.out.println("September "+y);
                }
                else if(month==11){
                    System.out.println("November "+y);
                }
                //print days;
                for(int i=0; i<lenW; i++){
                    if(i<(lenW-1)){
                        System.out.print(week[i]+" ");
                    }
                    else{
                        System.out.println(week[i]);
                    }
                }
                for(int sp=day; sp>0; sp--){
                    System.out.print("    ");
                }
                while(date<31){
                    for(int i=day; i<7; i++){
                        if(i!=6 && date<30){
                            if(Digit(date)==2){
                                System.out.print(date++ +"  ");
                            }
                            else{
                                System.out.print(date++ +"   ");
                            }
                        }
                        else if(i!=6 && date==30){
                            if(Digit(date)==2){
                                System.out.println(date++ +"  ");
                            }
                            else{
                                System.out.println(date++ +"   ");
                            }
                            day = i+1;
                            break;
                        }
                        else{
                            if(Digit(date)==2){
                                System.out.println(date++ +"  ");
                            }
                            else{
                                System.out.println(date++ +"   ");
                            }
                            day = 0;
                            break;
                        }
                    }
                }
            }
            
            else{
                System.out.println("February "+y);
                //If leap year feb==29;
                if(isLeap(y)){
                        for(int i=0; i<lenW; i++){
                        if(i<(lenW-1)){
                            System.out.print(week[i]+" ");
                        }
                        else{
                            System.out.println(week[i]);
                        }
                    }
                    for(int sp=day; sp>0; sp--){
                        System.out.print("    ");
                    }
                    while(date<30){
                        for(int i=day; i<7; i++){
                            if(i!=6 && date<29){
                                if(Digit(date)==2){
                                    System.out.print(date++ +"  ");
                                }
                                else{
                                    System.out.print(date++ +"   ");
                                }
                            }
                            else if(i!=6 && date==29){
                                if(Digit(date)==2){
                                    System.out.println(date++ +"  ");
                                }
                                else{
                                    System.out.println(date++ +"   ");
                                }
                                day = i+1;
                                break;
                            }
                            else{
                                if(Digit(date)==2){
                                    System.out.println(date++ +"  ");
                                }
                                else{
                                    System.out.println(date++ +"   ");
                                }
                                day = 0;
                                break;
                            }
                        }
                    }
                }
                
                // If not leap year feb==28;
                else{
                        for(int i=0; i<lenW; i++){
                        if(i<(lenW-1)){
                            System.out.print(week[i]+" ");
                        }
                        else{
                            System.out.println(week[i]);
                        }
                    }
                    for(int sp=day; sp>0; sp--){
                        System.out.print("    ");
                    }
                    while(date<29){
                        for(int i=day; i<7; i++){
                            if(i!=6 && date<28){
                                if(Digit(date)==2){
                                    System.out.print(date++ +"  ");
                                }
                                else{
                                    System.out.print(date++ +"   ");
                                }
                            }
                            else if(i!=6 && date==28){
                                if(Digit(date)==2){
                                    System.out.println(date++ +"  ");
                                }
                                else{
                                    System.out.println(date++ +"   ");
                                }
                                day = i+1;
                                break;
                            }
                            else{
                                if(Digit(date)==2){
                                    System.out.println(date++ +"  ");
                                }
                                else{
                                    System.out.println(date++ +"   ");
                                }
                                day = 0;
                                break;
                            }
                        }
                    }
                }
            }
            month++;
            System.out.println();
        }
        }
    }
}