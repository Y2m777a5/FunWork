import java.util.Scanner;

public class Calender{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any year:"+"\033[97m");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("\033[0m"+"Enter 1st three letter of a month / press enter to get yearly calender"+"\033[97m");
        String month = sc.nextLine();
        sc.close();
        
        System.out.println();
        System.out.println("\u001B[1;96m"+""+">>>>>>>  "+"\u001B[1;106m"+"[ YEAR  "+addZero(year)+year+" ]"+"\033[0m"+"\u001B[1;96m"+"  <<<<<<<\n"+"\u001B[0m");
        YearCalender(year,month);
        printEnd();
    }

    public static String addZero(int year){
        String str="";
        int count=0;
        for(int i=year; i!=0; i/=10){
            count++;
        }
        if(count==1){
            return str+"0";
        }
        else{
            return str;
        }
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
                printMonth("January");
                day1 = dayOfMon[0];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Mar")){
                printMonth("March");
                day1 = dayOfMon[2];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("May")){
                printMonth("May");
                day1 = dayOfMon[4];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Jul")){
                printMonth("July");
                day1 = dayOfMon[6];
                date1 = 1;
            }
            else if(mon.equalsIgnoreCase("Aug")){
                printMonth("August");
                day1 = dayOfMon[7];
                date1 = 1;
            }else if(mon.equalsIgnoreCase("Oct")){
                printMonth("October");
                day1 = dayOfMon[9];
                date1 = 1;
            }else if(mon.equalsIgnoreCase("Dec")){
                printMonth("December");
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
            int day2 = dayOfMon[1];
            int date2 = 1;
                //If leap year feb==29;
                if(isLeap(y)){
                    printLeapMonth("February");
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
                    printMonth("February");
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
                printMonth("April");
                day3 = dayOfMon[3];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Jun")){
                printMonth("June");
                day3 = dayOfMon[5];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Sep")){
                printMonth("September");
                day3 = dayOfMon[8];
                date3 = 1;
            }
            else if(mon.equalsIgnoreCase("Nov")){
                printMonth("November");
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
        else if(mon.equalsIgnoreCase("")){
        //Calculate day of Jan 1;
        int day = Fday(y);
        
        //Dates of Months;
        int month = 1;
        
        while(month<13){
            int date = 1;
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                //print mentioned month and year;
                if(month==1){
                    printMonth("January");
                }
                else if(month==3){
                    printMonth("March");
                }
                else if(month==5){
                    printMonth("May");
                }
                else if(month==7){
                    printMonth("July");
                }
                else if(month==8){
                    printMonth("August");
                }
                else if(month==10){
                    printMonth("October");
                }
                else if(month==12){
                    printMonth("December");
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
                    printMonth("April");
                }
                else if(month==6){
                    printMonth("June");
                }
                else if(month==9){
                    printMonth("September");
                }
                else if(month==11){
                    printMonth("November");
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
                printLeapMonth("February");
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

    public static void printMonth(String month){
        System.out.println("\u001B[38;2;170;255;0m"+"[ "+month+" ]"+"\u001B[97m");
    }

    public static void printLeapMonth(String month){
        System.out.println("\u001B[38;2;255;20;240m"+"[ "+month+" ]"+"\u001B[97m");
    }

    public static void printEnd(){
        System.out.println("\u001B[1;96m"+"\n<<<<<<<   [ THE  END ]   >>>>>>>\n"+"\u001B[0m");
    }
}