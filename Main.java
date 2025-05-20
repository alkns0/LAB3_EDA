import java.util.Arrays;
import java.util.ArrayList;

public class Main
{
    
    public class Game {
        String name;
        String category;
        int price;
        int quality;
        
        public Game(String name, String category, int price, int quality){
            this.name = name;
            this.category = category;
            this.price = price;
            this.quality = quality;
        }
    }
    
    
    public class Dataset {
        ArrayList <Game> data = new ArrayList <Game>();
        String sortedByAttribute;
        
        public Dataset(ArrayList <Game> data){
            this.data = data;
        }
        
        public ArrayList<Game> getGameByPrice(int price){
            ArrayList <Game> lista = new ArrayList <Game>();
            return lista;
        }
        
        public ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice){
            ArrayList <Game> lista = new ArrayList <Game>();
            return lista;          
        }
    
        public ArrayList<Game> getGamesByCategory(String category){
            ArrayList <Game> lista = new ArrayList <Game>();
            return lista;              
        }
        
        public ArrayList<Game> getGamesByQuality(int quality){
            ArrayList <Game> lista = new ArrayList <Game>();
            return lista;            
        }
        
        public void sortByAlgorithm(String algorithm, String attribute){
            System.out.println("Ordenar según parametros");
        }
        
    }
    
    
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
