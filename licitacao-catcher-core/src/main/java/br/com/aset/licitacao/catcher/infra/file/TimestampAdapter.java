package br.com.aset.licitacao.catcher.infra.file;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Timestamp> {

    @Override
    public Timestamp unmarshal(String data) throws Exception {
        Timestamp retorno = null;
        if (data != null && !"".equals(data)) {
            DateFormat formatter;
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = (Date) formatter.parse(data);
            retorno = new Timestamp(date.getTime());
        }
        return retorno;
    }

    @Override
    public String marshal(Timestamp data) throws Exception {

        String dataSTR = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data);
        return dataSTR;

    }

}
