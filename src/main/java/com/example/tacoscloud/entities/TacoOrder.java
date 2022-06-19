package com.example.tacoscloud.entities;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private UUID id = Uuids.timeBased();
    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    @Size(max=50, message = "Max size allowed is 50")
    private String deliveryName;

    @NotBlank(message = "Street is required")
    @Size(max=50, message = "Max size allowed is 50")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    @Size(max=50, message = "Max size allowed is 50")
    private String deliveryCity;

    @Size(max=2, message = "Max size allowed is 2")
    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    @Size(max=10, message = "Max size allowed is 10")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number")
    @Size(max=16, message = "Max size allowed is 16")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    @Size(max=5, message = "Max size allowed is 5")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @Column("tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco) {
        this.tacos.add(taco);
    }
}
