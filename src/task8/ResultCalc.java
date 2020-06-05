public interface ResultCalc {
   int[] numeric = new int[2];
   char[] sign = new char[]{'-'};

   static void addNumeric(String numeric){
       int intNumeric = Integer.parseInt(numeric);
        ResultCalc.numeric[0] *= 10;
        ResultCalc.numeric[0] += intNumeric;
   }

   static void clearNumeric(){
       numeric[0] = 0;
       numeric[1] = 0;
       sign[0] = '-';
   }

   static int counting(){
       switch (sign[0]){
           case '+':{
               numeric[0] = (numeric[0] + numeric[1]);
               break;
           }
           case '-':{
               numeric[0] =  (numeric[0] - numeric[1]);
               break;
           }
           case '*':{
               numeric[0] =  (numeric[0] * numeric[1]);
               break;
           }
           case '/':{
               numeric[0] =  (numeric[0] / numeric[1]);
               break;
           }

       }
       numeric[1]=0;
       sign[0] = '-';
       return numeric[0];
   }

   static String setSign(char c){
       if(numeric[1]!=0) {
           numeric[1] = counting();

       }else {
           numeric[1]=numeric[0];
       }

       numeric[0]=0;
       sign[0] = c;
       return String.valueOf(numeric[1])+c;
   }
}
