import java.io.Serializable;
public class Oferta implements Serializable{
    private String description;
    private String salario;
    private String titulo;
    private String contrato; 
    private String empresa;
    
    public Oferta() {
    }
    public Oferta(String description, String salario, String titulo, String contrato, String empresa) {
        this.description = description;
        this.salario = salario;
        this.titulo = titulo;
        this.contrato = contrato;
        this.empresa = empresa;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContrato() {
        return contrato;
    }
    public void setContrato(String contrato) {
        this.contrato = contrato;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String toString(){
        return "Nombre de la empresa:" + empresa +
         "\n titulo de la oferta: " + titulo +
         "\nDescripcion de la oferta: "+ description+
         "\nSalario ofrecido: "+ salario+
         "\nTipo de contrato "+ contrato;
    }

}
