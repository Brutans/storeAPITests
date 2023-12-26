package models.responseModels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InventoryResponse {
    private long sold;
    private long string;
    private long pending;
    private long available;
    private long peric;

}
