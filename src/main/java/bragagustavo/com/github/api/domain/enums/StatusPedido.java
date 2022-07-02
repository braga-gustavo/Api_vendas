package bragagustavo.com.github.api.domain.enums;

public enum StatusPedido {

    ABERTO(0,"Aberto"),
    EM_ANDAMENTO(1,"Em andamento"),
    CANCELADO(2,"Cancelado"),
    FINALIZADO(3,"Finalizado");
    
    private Integer cod;
    private String descricao;

    StatusPedido(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPedido toEnum(Integer cod){

        if(cod==null){
            return null;
        }

        for (StatusPedido x : StatusPedido.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("ID inválido! " + cod);
             
    }
    

}
