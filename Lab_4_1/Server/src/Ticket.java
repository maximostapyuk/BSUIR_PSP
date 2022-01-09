public class Ticket {
    private int numbers[]=new int[10];

    public Ticket(int[] number) {
        this.numbers = number;
    }

    public Ticket() {
        for (int i=0;i<10;i++){
            this.numbers[i]= (int)(Math.random()*(100)+1);
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void printNumbers(int num){
        System.out.println("**************************************************");
        System.out.print("*  Числа билета №"+ num + ": ");
        for (int i=0;i<10;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
        System.out.println("**************************************************");
    }
}
