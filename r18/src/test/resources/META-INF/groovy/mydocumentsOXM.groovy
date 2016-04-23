import org.springframework.amqp.support.converter.MarshallingMessageConverter as MMC
import org.springframework.oxm.xstream.XStreamMarshaller as XM
import com.apress.isf.java.model.Document

beans {
    messageConverter(MMC, ref("xstreamMarschaller"))
    xstreamMarschaller(XM) {
        aliases = [document:Document]
        mode = 1001
    }
}