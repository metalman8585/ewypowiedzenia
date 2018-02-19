package pl.jcommerce.ewypowiedzenia.infrastructure;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

    private String street;
    private String postalCode;
    private String city;

}
