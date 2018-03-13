package br.com.aset.licitacao.catcher.infra.file;

import java.io.File;
import java.io.InputStream;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.fusesource.hawtbuf.ByteArrayInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.aset.licitacao.catcher.adapter.entity.Licitacao;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Component
public class XmlUtil {

    private static final Logger log = LoggerFactory.getLogger(XmlUtil.class);

    private static String bucketName = "aset-licitacoes";

    private static String filePathStr;

    private AmazonS3 s3;

    String data;

    public XmlUtil(S3Configuration configuration) {
        super();
        this.configuration = configuration;

        Calendar cal = Calendar.getInstance();
        int mes = (cal.get(Calendar.MONTH) + 1);
        this.data = (mes < 10 ? "0" + mes : mes) + Integer.toString(cal.get(Calendar.YEAR));
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            filePathStr = "c:" + File.separator + File.separator + "dados" + File.separator + bucketName + File.separator + data;
        } else {
            filePathStr = File.separator + "dados" + File.separator + bucketName + File.separator + data;
        }
        File filePath = new File(filePathStr);
        if (!filePath.exists())
            filePath.mkdirs();

        s3 = configuration.getCredencials();

    }

    @Autowired
    S3Configuration configuration;

    public void generateXML(Licitacao licitacao) {
        File file = createTempFile(licitacao);

        // if (!s3.doesBucketExistV2(bucketName))
        // createFolder(bucketName, data, s3);
        s3.putObject(new PutObjectRequest(
                bucketName, Integer.toString(licitacao.getId()), file));

    }

    public static void createFolder(String bucketName, String folderName, AmazonS3 client) {
        // create meta-data for your folder and set content-length to 0
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);

        // create empty content
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

        // create a PutObjectRequest passing the folder name suffixed by /
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
                folderName + "/", emptyContent, metadata);

        // send request to S3 to create folder
        client.putObject(putObjectRequest);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name").toLowerCase().contains("windows"));
    }

    private static File createTempFile(Licitacao licitacao) {
        File file = null;
        try {

            file = new File(filePathStr + File.separator + Integer.toString(licitacao.getId()) + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Licitacao.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(licitacao, file);
            jaxbMarshaller.marshal(licitacao, System.out);
        } catch (JAXBException e) {
            log.error(e.getMessage());
        }
        return file;
    }

    public Licitacao getXML(int idLicitacao) {
        Licitacao licitacao = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Licitacao.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File file = new File(filePathStr + File.separator + idLicitacao
                    + ".xml");
            if (file.exists()) {
                log.info("Arquivo " + idLicitacao
                        + ".xml encontrado");

                licitacao = (Licitacao) unmarshaller.unmarshal(file);
            } else {
                S3Object fileS3 = s3.getObject(new GetObjectRequest(bucketName, Integer.toString(licitacao.getId())));
                licitacao = (Licitacao) unmarshaller.unmarshal(fileS3.getObjectContent());
            }

        } catch (JAXBException e) {
            log.error(e.getMessage());
        }

        return licitacao;
    }
}
