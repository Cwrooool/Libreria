package dao;

import model.Autor;
import util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO {

    public List<Autor> listar() {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Autor a = new Autor(
                    rs.getInt("id_autor"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("pais"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("correo")
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar autores: " + e.getMessage());
        }
        return lista;
    }

    public Autor buscarPorId(int idAutor) {
        Autor autor = null;
        String sql = "SELECT * FROM autor WHERE id_autor = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAutor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    autor = new Autor(
                        rs.getInt("id_autor"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("pais"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar autor: " + e.getMessage());
        }
        return autor;
    }

    public boolean insertar(Autor autor) {
        String sql = "INSERT INTO autor (nombre, apellido, pais, direccion, telefono, correo) VALUES (?,?,?,?,?,?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setString(3, autor.getPais());
            ps.setString(4, autor.getDireccion());
            ps.setString(5, autor.getTelefono());
            ps.setString(6, autor.getCorreo());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar autor: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Autor autor) {
        String sql = "UPDATE autor SET nombre=?, apellido=?, pais=?, direccion=?, telefono=?, correo=? WHERE id_autor=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setString(3, autor.getPais());
            ps.setString(4, autor.getDireccion());
            ps.setString(5, autor.getTelefono());
            ps.setString(6, autor.getCorreo());
            ps.setInt(7, autor.getIdAutor());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar autor: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idAutor) {
        String sql = "DELETE FROM autor WHERE id_autor = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idAutor);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar autor: " + e.getMessage());
            return false;
        }
    }
}