import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    //GenerateData : Clase encargada de generar datos (Juegos).
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
    //Clase Game
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
        
        public void mostrarDatos(){
            System.out.println(
            "Nombre: " + this.name
            + "  Categoria: " + this.category
            + "  Precio: " + this.price
            + "  Calidad " + this.quality
            );
        }
        
    }
    
    /*Clase DataSet: Contendrá a todos los videojuegos creados y tendrá algoritmos de
    búsqueda y ordenamiento */
    public static class Dataset {
        ArrayList <Game> data = new ArrayList <Game>();
        String sortedByAttribute;
        
        public Dataset(ArrayList <Game> data){
            this.data = data;
        }
        
        //Buscar juegos por precio
        public ArrayList<Game> getGameByPrice(int price){
            ArrayList <Game> lista = new ArrayList <Game>();
            
            //Búsqueda lineal
            for(int i = 0; i < data.size(); i++){
                Game elemento = this.data.get(i);
                if (elemento.price == price) {
                    elemento.mostrarDatos();
                    lista.add(elemento);
                }
            }
            if (lista.isEmpty()){ 
                System.out.println("No se encontró ningún juego con ese precio!");   
            }
            return lista;
        }
        
        //Buscar juegos por rango de precios
        public ArrayList<Game> getGamesByPriceRange(int lowerPrice, int higherPrice){
            ArrayList <Game> lista = new ArrayList <Game>();
            
            //Búsqueda lineal
            for(int i = 0; i < data.size(); i++){
                Game elemento = this.data.get(i);
                if ((elemento.price >= lowerPrice) && (elemento.price <= higherPrice)) {
                    elemento.mostrarDatos();
                    lista.add(elemento);
                }
            }
            if (lista.isEmpty()){ 
                System.out.println("No se encontró ningún juego dentro del rango!");   
            }
            return lista;          
        }
    	
    	//Buscar juegos por categoría
        public ArrayList<Game> getGamesByCategory(String category){
            ArrayList <Game> lista = new ArrayList <Game>();
            
            //Búsqueda lineal
            for(int i = 0; i < data.size(); i++){
                Game elemento = this.data.get(i);
                if (elemento.category == category) {
                    elemento.mostrarDatos();
                    lista.add(elemento);
                }
            }
            if (lista.isEmpty()){ 
                System.out.println("No se encontró ningún juego con esa categoría!");   
            }
            
            return lista;              
        }
        
        //Buscar juegos por calidad
        public ArrayList<Game> getGamesByQuality(int quality){
            ArrayList <Game> lista = new ArrayList <Game>();
            //Búsqueda lineal
            for(int i = 0; i < data.size(); i++){
                Game elemento = this.data.get(i);
                if (elemento.quality == quality) {
                    elemento.mostrarDatos();
                    lista.add(elemento);
                }
            }
            
            if (lista.isEmpty()){ 
                System.out.println("No se encontró ningún juego con esa calidad!");   
            }
            
            return lista;            
        }
        //Ordenar database por algoritmo entregado por parámetros.
        public void sortByAlgorithm(String algorithm, String attribute){
            System.out.println("Ordenar según parametros");
            switch(algorithm){
                case "bubbleSort":
                    switch(attribute){
                        case "price":
                            break;
                        case "category":
                            break;
                        case "quality":
                            break;
                        default:
                            //Ordenar por precio
                            break;
                    }
                    break;
                case "insertionSort":
                    switch(attribute){
                        case "price":
                            break;
                        case "category":
                            break;
                        case "quality":
                            break;
                        default:
                            //Ordenar por precio
                            break;
                    }
                    break;
                case "mergeSort":
                    switch(attribute){
                        case "price":
                            break;
                        case "category":
                            break;
                        case "quality":
                            break;
                        default:
                            //Ordenar por precio
                            break;
                    }
                    break;
                case "quickSort":
                    switch(attribute){
                        case "price":
                            break;
                        case "category":
                            break;
                        case "quality":
                            break;
                        default:
                            //Ordenar por precio
                            break;
                    }
                    break;
                default:
                    //Usar Collections.sort()
                    switch(attribute){
                        case "price":
                            break;
                        case "category":
                            break;
                        case "quality":
                            break;
                        default:
                            //Ordenar por precio
                            break;
                    }
                    break;
            }
        }
        
    }
    
    
    	
	public static void main(String[] args) {
		//Pruebas
		GenerateData data = new GenerateData();
		Game game = data.nuevo_juego();
		game.mostrarDatos();
		ArrayList <Game> lista = data.crearListaJuegos();
	}
}
