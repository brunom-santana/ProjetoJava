
class Funcionario extends Pessoa {
	private int Id;
	private String cargo;
    private double salario;

    public Funcionario() {}

    public Funcionario(String nome, int idade, int Id, String cargo, double salario) {
        super(nome, idade);
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String informacoes() {
        return "Nome: " + getNome() + ", Idade: " + getIdade() + ", Cargo: " + cargo + ", Salário: " + salario;
    }
}

