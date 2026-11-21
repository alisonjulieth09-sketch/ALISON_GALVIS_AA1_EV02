package co.ayb.auth.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="clientes")
public class Cliente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Size(max=120) @Column(nullable=false,length=120) private String nombre;
 @Email @Size(max=160) @Column(unique=true,length=160) private String email;
 @Size(max=30) private String telefono;
 public Cliente(){} public Long getId(){return id;} public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getTelefono(){return telefono;} public void setTelefono(String v){telefono=v;}
}
