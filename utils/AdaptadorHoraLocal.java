
package gymsystem.utils;

import java.time.LocalTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class AdaptadorHoraLocal extends XmlAdapter<String, LocalTime>{
     @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v);
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return v.toString();
    }

}
