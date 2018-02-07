package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private final String street;
    private final String postalCode;
    private final String city;

}
