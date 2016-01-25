package pl.nkoder.katas.vendingmachine.products;

import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Product {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
            .append(name)
            .toString();
    }
}
