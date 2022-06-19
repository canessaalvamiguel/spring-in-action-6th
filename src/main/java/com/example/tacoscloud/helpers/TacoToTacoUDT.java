package com.example.tacoscloud.helpers;

import com.example.tacoscloud.entities.Taco;
import com.example.tacoscloud.entities.TacoUDT;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TacoToTacoUDT  implements Converter<Taco, TacoUDT> {

    @Override
    public TacoUDT convert(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }
}
