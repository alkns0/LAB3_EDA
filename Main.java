import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

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

        //Comparador por precio
        public class ComparadorPorPrecio implements Comparator <Game> {
            @Override
            public int compare(Game g1, Game g2){
                return Double.compare(g1.price, g2.price);
            }
            
        }
        //Comparador por categoría
        public class ComparadorPorCategoria implements Comparator <Game> {
            @Override
            public int compare(Game g1, Game g2){
                return g1.category.compareToIgnoreCase(g2.category);
            }
        }
        //Comparador por calidad
        public class ComparadorPorCalidad implements Comparator <Game> {
            @Override
            public int compare(Game g1, Game g2){
                return Double.compare(g1.quality, g2.quality);
            }
        }
	
        //Algoritmo BubbleSort
        public class BubbleSort {
           public static ArrayList<Game> ordenar(ArrayList<Game> juegos, Comparator<Game> comparador) {
                int n = juegos.size();
                boolean swapped;
        
                for (int i = 0; i < n - 1; i++) {
                    swapped = false;
                    for (int j = 0; j < n - i - 1; j++) {
                        if (comparador.compare(juegos.get(j), juegos.get(j + 1)) > 0) {
                            // Intercambiar elementos
                            Game temp = juegos.get(j);
                            juegos.set(j, juegos.get(j + 1));
                            juegos.set(j + 1, temp);
                            swapped = true;
                        }
                    }
                    if (!swapped) break; // Si no hubo intercambios, ya está ordenado
                }
        
                return juegos;
            }            
        }
        
        //Algoritmo insertionSort
        public class insertionSort {
            public static ArrayList <Game> ordenar (ArrayList <Game> juegos, Comparator<Game> comparator){
                return juegos;
            }
        }

	//Algoritmo selectionSort
        public class selectionSort {
            public static ArrayList <Game> ordenar (ArrayList <Game> juegos, Comparator<Game> comparator){
                return juegos;
            }
        }
	//Algorirmo mergeSort
        public class mergeSort {
            public static ArrayList <Game> ordenar (ArrayList <Game> juegos, Comparator<Game> comparator){
                return juegos;
            }
        }
	//Algoritmo quickSort
        public class quickSort {
            public static ArrayList <Game> ordenar (ArrayList <Game> juegos, Comparator<Game> comparator){
                return juegos;
            }
        }
	
        ComparadorPorPrecio comp = new ComparadorPorPrecio();
        ComparadorPorCategoria comp2 = new ComparadorPorCategoria();
        ComparadorPorCalidad comp3 = new ComparadorPorCalidad();
        
        //Ordenar database por algoritmo entregado por parámetros.
        public void sortByAlgorithm(String algorithm, String attribute){
            System.out.println("Se ordenó la lista con el algritmo " + algorithm + " por el atributo " + attribute);
            switch(algorithm){
                case "bubbleSort":
                    switch(attribute){
                        case "price":
                            BubbleSort.ordenar(data, comp);
                            break;
                        case "category":
                            BubbleSort.ordenar(data, comp2);
                            break;
                        case "quality":
                            BubbleSort.ordenar(data, comp3);                           
                            break;
                        default:
                            BubbleSort.ordenar(data, comp);
                            break;
                    }
                    break;
                case "insertionSort":
                    switch(attribute){
                        case "price":
                            insertionSort.ordenar(data, comp);
                            break;
                        case "category":
                            insertionSort.ordenar(data, comp2);
                            break;
                        case "quality":
                            insertionSort.ordenar(data, comp3);
                            break;
                        default:
                            insertionSort.ordenar(data, comp);
                            break;
                    }
                    break;
                case "mergeSort":
                    switch(attribute){
                        case "price":
                            mergeSort.ordenar(data, comp);			
                            break;
                        case "category":
                            mergeSort.ordenar(data, comp2);			
                            break;
                        case "quality":
                            mergeSort.ordenar(data, comp3);	
                            break;
                        default:
                            mergeSort.ordenar(data, comp);	
                            break;
                    }
                    break;
                case "quickSort":
                    switch(attribute){
                        case "price":
                            quickSort.ordenar(data, comp);	
                            break;
                        case "category":
                            quickSort.ordenar(data, comp2);
                            break;
                        case "quality":
                            quickSort.ordenar(data, comp3);
                            break;
                        default:
                            quickSort.ordenar(data, comp);	
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
		ArrayList <Game> lista_juegos = data.crearListaJuegos();
		Dataset data_set = new Dataset(lista_juegos);
		//data_set.getGameByPrice(23041);
	    //data_set.getGamesByPriceRange(10000, 20000);
		//data_set.getGamesByCategory("Aventura");
		//data_set.getGamesByQuality(20);
		//Game game = data.nuevo_juego();
		//game.mostrarDatos();
	}
}
