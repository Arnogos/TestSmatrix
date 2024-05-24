package Address;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CreateAddressRequest {
    private String street;
    private String city;
    private String building;
}