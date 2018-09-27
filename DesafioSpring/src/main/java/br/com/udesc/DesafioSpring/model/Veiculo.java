package br.com.udesc.DesafioSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.GenericGenerator;


@Entity
public class Veiculo {
	
	public Veiculo() {
    }

    public Veiculo(Long id, String montadora, String modelo, String cor, int km, String motor, String tipo) {
        this.id = id;
        this.montadora = montadora;
        this.modelo = modelo;
        this.cor = cor;
        this.km = km;
        this.motor = motor;
        this.tipo = tipo;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

//    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    
    private String montadora;
    private String modelo;
    private String cor;
    private int km;
    private String motor;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Id: " + getId()
                + "\nMontadora: " + getMontadora()
                + "\nModelo: " + getModelo()
                + "\nCor: " + getCor()
                + "\nKM: " + getKm()
                + "\nMotor: " + getMotor()
                + "\nTipo: " + getTipo();
    }

}
