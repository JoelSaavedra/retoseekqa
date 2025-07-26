package util;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class EmailReaderUtil {
    public static String obtenerCodigoDesdeCorreo(String email, String password) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.gmail.com", email, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] mensajes = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

        for (Message mensaje : mensajes) {
            String asunto = mensaje.getSubject();
            if (asunto.contains("Código de verificación")) {
                String contenido = mensaje.getContent().toString();
                String codigo = extraerCodigo(contenido);
                inbox.close(false);
                store.close();
                return codigo;
            }
        }

        inbox.close(false);
        store.close();
        return null;
    }

    private static String extraerCodigo(String contenido) {
        return contenido.replaceAll(".*(\\d{6}).*", "$1");
    }
}
