import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    public static class GenerateData {
        ArrayList<Game> lista = new ArrayList<Game>(); 
        String name;
        String category;
        int prince;
        int quality;

	//Crear juego con atributos aleatorios
        public Game nuevo_juego(){
            String[] palabras = {"Dragon", "Empire", "Quest", "Galaxy","Legends", "Warrior"};
            int rnd1 = new Random().nextInt(palabras.length);
            int rnd2 = new Random().nextInt(palabras.length);
            String nombre_juego = palabras[rnd1] + palabras[rnd2];
            
            String[] categorias = {"Acción", "Aventura", "Estrategia", "RPG","Deportes", "Simulación"};
            int rnd3 = new Random().nextInt(categorias.length);
            String categoria_juego = categorias[rnd3];
            
            int rnd4 = (int) (Math.random() * 70000) + 1;
            int rnd5 = (int) (Math.random() * 100) + 1;
            
            Game game = new Game(nombre_juego,categoria_juego, rnd4, rnd5);
            return game;
        }

	//Lista de N juegos
        public ArrayList <Game> crearListaJuegos(){
            ArrayList <Game> lista = new ArrayList<Game>();
            int n = 100;
            for(int i = 0; i < n; i++){
                Game game = this.nuevo_juego();
                lista.add(game);
            }
            return lista;
        }
        
    }
    
    public static class Game {
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
        
        void mostrarDatos(){
            System.out.println("Nombre: " + this.name);
            System.out.println("Categoria: " + this.category);
            System.out.println("Precio: " + this.price);
            System.out.println("Calidad: " + this.quality);
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
		GenerateData data = new GenerateData();
		Game game = data.nuevo_juego();
		game.mostrarDatos();
	}
}
