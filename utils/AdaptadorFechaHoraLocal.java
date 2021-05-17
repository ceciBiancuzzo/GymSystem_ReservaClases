
package gymsystem.utils;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class AdaptadorFechaHoraLocal extends XmlAdapter<String,LocalDateTime>{

    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
    
    
}
