package dao;

import model.Categoria;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Categoria c = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("categoria"),
                    rs.getString("descripcion")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar categorias: " + e.getMessage());
        }
        return lista;
    }

    public Categoria buscarPorId(int idCategoria) {
        Categoria categoria = null;
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("categoria"),
                        rs.getString("descripcion")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar categoria: " + e.getMessage());
        }
        return categoria;
    }

    public boolean insertar(Categoria categoria) {
        String sql = "INSERT INTO categoria (categoria, descripcion) VALUES (?,?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getCategoria());
            ps.setString(2, categoria.getDescripcion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar categoria: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET categoria=?, descripcion=? WHERE id_categoria=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getCategoria());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdCategoria());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar categoria: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idCategoria) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar categoria: " + e.getMessage());
            return false;
        }
    }
}