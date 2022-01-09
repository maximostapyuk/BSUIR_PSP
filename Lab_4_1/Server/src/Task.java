import java.util.ArrayList;

public class Task {
    private int coincidences;
    private int number;

    public Task() {
        this.coincidences = 0;
        this.number = 1;
    }

    public void findCoincidences(ArrayList<Ticket> tickets, int[] numbers){
        for (int i=0;i< tickets.size();i++){
            int coincidences=0;
            for (int j=0;j<10;j++){
                for (int m=0;m<10;m++){
                    if((tickets.get(i).getNumbers())[m]==numbers[j])
                        coincidences++;
                }
            }
            if(coincidences>this.coincidences) {
                this.coincidences = coincidences;
                this.number=i+1;
            }
        }
    }

    public int[] parsing(String message){
        String[] subStr = message.split(" ");;
        int numbers[]=new int[10];
        for (int i=0;i<10;i++){
            numbers[i]=Integer.parseInt(subStr[i]);
        }
        return numbers;
    }

    public String getInfoCoincidences(){
        String str= new String();
        if(this.coincidences!=0){
            str= "В билете №";
            str=str+this.number+" кол-во совпадений: "+ this.coincidences;
        }
        else {
            str="В билетах нет совпадений, попробуйте ещё раз.";
        }
        return str;
    }
}
