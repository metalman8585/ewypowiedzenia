package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DismissalNoticeDto {

    private final String firstName;
    private final String lastName;
    private final AddressDto homeAddress;

    private final String companyName;
    private final AddressDto companyAddress;

    private final LocalDateTime agreementDate;

    private final LocalDateTime dismissalDate;
    private final String dismissalPlace;

}
