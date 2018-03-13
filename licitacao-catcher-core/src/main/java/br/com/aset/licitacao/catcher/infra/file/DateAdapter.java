package br.com.aset.licitacao.catcher.infra.file;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<Date, java.sql.Date> {

    @Override
    public java.sql.Date unmarshal(Date v) throws Exception {
        java.sql.Date dataRetorno = null;
        if (v != null) {
            dataRetorno = new java.sql.Date(v.getTime());
        }
        return dataRetorno;
    }

    @Override
    public Date marshal(java.sql.Date v) throws Exception {
        Date dataRetorno = null;
        if (v != null) {
            dataRetorno = new Date(v.getTime());
        }
        return dataRetorno;
    }

}
