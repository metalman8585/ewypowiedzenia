package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class DismissalNoticeDto {

    private String firstName;
    private String lastName;
    private AddressDto homeAddress;

    private String companyName;
    private AddressDto companyAddress;

    private LocalDateTime agreementDate;

    private LocalDateTime dismissalDate;
    private String dismissalPlace;

}
