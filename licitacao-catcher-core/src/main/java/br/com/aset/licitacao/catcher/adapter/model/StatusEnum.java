package br.com.aset.licitacao.catcher.adapter.model;

public enum StatusEnum {
    EM_ABERTO(1, "EM ABERTO"),
    EM_ANDAMENTO(2, "EM ANDAMENTO"),
    ENCERRADA(3, "ENCERRADA");

    StatusEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private int codigo;

    private String descricao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusEnum getById(int id) {
        StatusEnum[] statusArr = StatusEnum.values();
        for (int i = 0; i < statusArr.length; i++) {
            StatusEnum status = statusArr[i];
            if (status.getCodigo() == id) {
                return status;
            }
        }
        return null;
    }

    public static StatusEnum getByDescricao(String descricao) {
        StatusEnum[] statusArr = StatusEnum.values();
        for (int i = 0; i < statusArr.length; i++) {
            StatusEnum status = statusArr[i];
            if (descricao.equals(status.getDescricao())) {
                return status;
            }
        }
        return null;
    }

}
