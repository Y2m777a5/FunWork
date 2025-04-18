import java.util.Scanner;

public class YearlyCalender{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any year:");
        int year = sc.nextInt();
        sc.close();
        YearCalender(year);
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

    //Numbers of leap years;
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
     
    //Calender;
    public static void YearCalender(int y){
        String [] week = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
        int lenW = week.length;

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
                    System.out.println("Julay "+y);
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
                    System.out.println("Jun "+y);
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