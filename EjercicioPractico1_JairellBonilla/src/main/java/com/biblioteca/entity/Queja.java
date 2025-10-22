
package com.biblioteca.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "queja")
public class Queja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_cliente;
    private String email;
    private String telefono;
    private String tipo; // QUEJA, SUGERENCIA, CONSULTA
    private String asunto;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private Boolean tratado = false;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre_cliente() { return nombre_cliente; }
    public void setNombre_cliente(String nombre_cliente) { this.nombre_cliente = nombre_cliente; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public Boolean getTratado() { return tratado; }
    public void setTratado(Boolean tratado) { this.tratado = tratado; }
}
