package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jcommerce.ewypowiedzenia.infrastructure.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@XmlRootElement(name="dismissalNotice")
@XmlAccessorType(XmlAccessType.FIELD)
public class DismissalNoticeDto {

    private String firstName;
    private String lastName;
    private AddressDto homeAddress;

    private String companyName;
    private AddressDto companyAddress;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate agreementDate;

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dismissalDate;
    private String dismissalPlace;
    private Integer dismissalPeriod;
}
