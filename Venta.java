package co.ayb.auth.model;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="ventas")
public class Venta {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private LocalDateTime fecha=LocalDateTime.now();
 @ManyToOne private Cliente cliente;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal total;
 @Column(nullable=false,length=500) private String detalle;
 public Venta(){} public Venta(Cliente c,BigDecimal t,String d){cliente=c;total=t;detalle=d;}
 public Long getId(){return id;} public LocalDateTime getFecha(){return fecha;} public Cliente getCliente(){return cliente;} public BigDecimal getTotal(){return total;} public String getDetalle(){return detalle;}
}
