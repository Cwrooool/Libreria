import dao.AutorDAO;
import dao.CategoriaDAO;
import model.Autor;
import model.Categoria;
import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("===== PROBANDO AUTORES =====");
        AutorDAO autorDAO = new AutorDAO();
        List<Autor> autores = autorDAO.listar();
        for (Autor a : autores) {
            System.out.println(a);
        }

        System.out.println("===== PROBANDO CATEGORIAS =====");
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listar();
        for (Categoria c : categorias) {
            System.out.println(c);
        }
    }
}