
	import java.util.Random;
	import java.util.Scanner;

	public class BatalhaNaval {

	    public static void main(String[] args) {
	      int [][] local = new int [10][10];	              
	             	      
	        int [][] navios = new int[3][2];
	        int [][] porta_aviao = new int [3][3];
 	        int [][] destroyer =new int [2][2];
 	        int [][] fragata = new int [3][3];
 	        int [][] torpedeiros = new int [2][2];
	        int [][] submarino = new int [1][1];
 	        int[] tiro = new int[15];
	        int tentativas=0,
	            atirar=0;
	        
	        Local(local);
	        navios(navios);
	        
	        System.out.println();
	        
	        do{
   	System.out.println("Escolha Linha(Lin )e Coluna(Col)para atirar ");
	            MostraLocal(local);
	            tiro(tiro);
	            tentativas++;
	            
	            if(acertou(tiro,navios)){
	                verif(tiro,navios,tentativas);
	                atirar++;
	            }                
	            else
	                hint(tiro,navios,tentativas);
	            
	            trocalocal(tiro,navios,local);
	            

	        }while(atirar!=3);
	        
	        System.out.println("\n\n\nBatalha Naval Finalizou! Voce tinha embarcaçoes para atirar Escore:  "+tentativas+" attempts");
	        MostraLocal(local);
	    }
	    
	    private static void trocalocal(int[] tiro, int[][] navios, int[][] local) {
			// TODO Auto-generated method stub
			
		}

		private static void verif(int[] tiro, int[][] navios, int tentativas) {
			// TODO Auto-generated method stub
			
		}

		public static void Local(int[][] board){
	        for(int linha= 1 ; linha < 10 ; linha++ )
	            for(int column= 1 ; column < 10 ; column++ )
	                board[linha][column]= -1;
	    }
	    
	    public static void MostraLocal(int[][] local){
	       
	System.out.println("\ta \tb \tc \td \te \tf \tg \th \ti \tj ");
	       
	        System.out.println();
	        
	        for(int linha=0 ; linha < 10 ; linha++ ){
	            System.out.print((linha+1)+"");
	            for(int column=0 ; column < 10 ; column++ ){
	                if(local[linha][column]==-1){
	                    System.out.print("\t"+".");
	                }else if(local[linha][column]==0){
	                    System.out.print("\t"+".");
	                }else if(local[linha][column]==1){
	                    System.out.print("\t"+"X");
	                }
	                
	            }
	            System.out.println();
	        }

	    }

	    public static void navios(int[][] navios){
	        Random random = new Random();
	        
	        for(int navio=0 ; navio < 3 ; navio++){
	            navios[navio][0]=random.nextInt(10);
	            navios[navio][1]=random.nextInt(10);
	            
	            //Verifica tiro  
	            //Gera novo valor 
	            for(int ultimo=0 ; ultimo < navio ; ultimo++){
	                if( (navios[navio][0] == navios[ultimo][0])&&(navios[navio][1] == navios[ultimo][1]) );
	                    do{
	                        navios[navio][0]=random.nextInt(10);
	                        navios[navio][1]=random.nextInt(10);
	                    }while( (navios[navio][0] == navios[ultimo][0])&&(navios[navio][1] == navios[ultimo][1]) );
	            }
	            
	        }
	    }

	    public static void tiro(int[] tiro){
	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("[Lin]: ");
	        tiro[0] = input.nextInt();
	        tiro[0]--;
	        
	        System.out.print("[Col]: ");
	        tiro[1] = input.nextInt();
	        tiro[1]--;
	        
	    }
	    
	    public static boolean acertou(int[] tiro, int[][] navios){
	        
	        for(int navio=0 ; navio < navios.length ; navio++){
	            if( tiro[0]==navios[navio][0] && tiro[1]== navios[navio][1]){
	                System.out.printf("Voce abateu um inimigo (%d,%d)\n",tiro[0]+1,tiro[1]+1);
	                return true;
	            }
	        }
	        return false;
	    }

	    public static void hint(int[] tiro, int[][] navios, int attempt){
	        int linha=0,
	            column=0;
	        
	        for(int line=0 ; line < navios.length ; line++){
	            if(navios[line][0]==tiro[0])
	                linha++;
	            if(navios[line][1]==tiro[1])
	                column++;
	        }
	        
	        System.out.printf("\nHint %d: \nlinha %d -> %d navios\n" +
	                                 "Column %d -> %d navios\n",attempt,tiro[0]+1,linha,tiro[1]+1,column);
	    }

	    public static void changeboard(int[] tiro, int[][] navios, int[][] board){
	        if(acertou(tiro,navios))
	            navios[tiro[0]][tiro[1]]=1;
	        else
	            navios[tiro[0]][tiro[1]]=0;
	    }
	}

