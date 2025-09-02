package com.ulp.trabajopractico2.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ulp.trabajopractico2.Model.LibroModel;
import com.ulp.trabajopractico2.R;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    MutableLiveData<String> muMensaje;
    MutableLiveData<LibroModel> muLibro;
    ArrayList<LibroModel> biblioteca = new ArrayList<>();


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        cargarLibros();
    }

    //Carga los libros
    private void cargarLibros() {
        biblioteca.add(new LibroModel(1, "Cien Años de Soledad", "Gabriel García Márquez", "Realismo mágico", 1967, 417,
                "Novela que narra la historia de la familia Buendía a lo largo de varias generaciones.",R.drawable.cover_cienanios ));

        biblioteca.add(new LibroModel(2, "1984", "George Orwell", "Distopía", 1949, 328,
                "Una novela sobre un futuro totalitario controlado por el Gran Hermano.", R.drawable.cover_1984));

        biblioteca.add(new LibroModel(3, "El Principito", "Antoine de Saint-Exupéry", "Fantasía", 1943, 96,
                "Historia poética y filosófica de un pequeño príncipe viajando de planeta en planeta.", R.drawable.cover_elprincipito ));

        biblioteca.add(new LibroModel(4, "Don Quijote de la Mancha", "Miguel de Cervantes", "Novela", 1605, 863,
                "Aventuras de un hidalgo que se cree caballero andante.", R.drawable.cover_donquijote));

        biblioteca.add(new LibroModel(5, "La Sombra del Viento", "Carlos Ruiz Zafón", "Misterio", 2001, 487,
                "Un joven descubre un libro olvidado y se ve envuelto en un misterio literario.", R.drawable.cover_lasombradelviento));

        biblioteca.add(new LibroModel(6, "Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasía", 1997, 223,
                "Primer libro de la saga de Harry Potter, un joven mago descubre su destino.", R.drawable.cover_harrypotterpiedrafilosofal));

        biblioteca.add(new LibroModel(7, "El Hobbit", "J.R.R. Tolkien", "Fantasía", 1937, 310,
                "Bilbo Bolsón emprende un viaje épico con un grupo de enanos.", R.drawable.cover_elhobbittolkien));

        biblioteca.add(new LibroModel(8, "Matar a un ruiseñor", "Harper Lee", "Drama", 1960, 281,
                "Historia sobre racismo e injusticia en el sur de Estados Unidos.", R.drawable.cover_mataraunruisenior));

        biblioteca.add(new LibroModel(9, "Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela", 1981, 122,
                "Una historia de crimen inevitable en un pequeño pueblo.", R.drawable.cover_cronicamuerteanunciada));

        biblioteca.add(new LibroModel(10, "Orgullo y prejuicio", "Jane Austen", "Romance", 1813, 432,
                "Las relaciones y prejuicios en la sociedad inglesa del siglo XIX.", R.drawable.cover_orgulloyperjuicio));

        biblioteca.add(new LibroModel(11, "El Código Da Vinci", "Dan Brown", "Suspense", 2003, 454,
                "Un misterioso asesinato en el Museo del Louvre desata un enigma histórico.", R.drawable.cover_codigodavinci));

        biblioteca.add(new LibroModel(12, "Los Miserables", "Victor Hugo", "Novela histórica", 1862, 1232,
                "La vida de varios personajes en la Francia del siglo XIX.", R.drawable.cover_losmiserables));

        biblioteca.add(new LibroModel(13, "La Metamorfosis", "Franz Kafka", "Ficción", 1915, 201,
                "La transformación de Gregorio Samsa en un insecto gigante.", R.drawable.cover_metamorfosis));

        biblioteca.add(new LibroModel(14, "El Señor de los Anillos: La Comunidad del Anillo", "J.R.R. Tolkien", "Fantasía", 1954, 423,
                "Frodo Bolsón inicia la misión de destruir el anillo único.", R.drawable.cover_seniordelosanilloslacomunidad));

        biblioteca.add(new LibroModel(15, "Anna Karenina", "Leo Tolstoy", "Romance", 1877, 864,
                "La historia trágica de Anna en la alta sociedad rusa.", R.drawable.cover_annakarenina));

        biblioteca.add(new LibroModel(16, "Fahrenheit 451", "Ray Bradbury", "Distopía", 1953, 249,
                "Un futuro donde los libros están prohibidos y los bomberos los queman.", R.drawable.cover_fahrenheir));

        biblioteca.add(new LibroModel(17, "Drácula", "Bram Stoker", "Terror", 1897, 418,
                "El clásico de vampiros con el conde Drácula como protagonista.", R.drawable.cover_dracula));

        biblioteca.add(new LibroModel(18, "El Alquimista", "Paulo Coelho", "Filosofía", 1988, 208,
                "Un joven pastor busca cumplir su Leyenda Personal.", R.drawable.cover_alquimista));

        biblioteca.add(new LibroModel(19, "Romeo y Julieta", "William Shakespeare", "Tragedia", 1597, 128,
                "El amor imposible de dos jóvenes de familias enfrentadas.", R.drawable.cover_romerojulieta));

        biblioteca.add(new LibroModel(20, "La Isla del Tesoro", "Robert Louis Stevenson", "Aventura", 1883, 240,
                "Jim Hawkins busca un tesoro escondido siguiendo un mapa misterioso.", R.drawable.cover_laisladeltesoro));
    }

    //Mutables - Getters
    public LiveData<String> getMensaje() {
        if(muMensaje == null)
            muMensaje = new MutableLiveData<>();

        return muMensaje;
    }

    public LiveData<LibroModel> getmLibro() {
        if(muLibro == null)
            muLibro = new MutableLiveData<>();

        return muLibro;
    }

    public void buscarLibro(String libro){
        if(libro == null || libro.trim().isEmpty()){
            muMensaje.setValue("Por favor, ingrese un nombre de libro");
            return;
        }

        //Convertir a minuscula
        String libroBuscado = libro.trim().toLowerCase();
        boolean encontrado = false;

        //Recorrer la lista
        for(LibroModel libroActual : biblioteca)
        {
            if(libroActual.getTitulo().toLowerCase().contains(libroBuscado)){
                muLibro.setValue(libroActual);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            muMensaje.setValue("No se encontraron resultados para: " + libro);
        }

    }

}
