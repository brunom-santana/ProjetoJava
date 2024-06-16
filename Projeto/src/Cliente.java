class Cliente extends Pessoa {
    private int clienteId;
    private String email;

    public Cliente() {}

    public Cliente(String nome, int idade, int clienteId, String email) {
        super(nome, idade);
        this.clienteId = clienteId;
        this.email = email;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String informacoes() {
        return "Nome: " + getNome() + ", Idade: " + getIdade() + ", Cliente ID: " + clienteId + ", Email: " + email;
    }
}