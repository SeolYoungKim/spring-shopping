package shopping.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\w\\s가-힣()\\[\\]+\\-&/_]*$");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;
    private Integer price;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    protected Product() {
    }

    Product(final String name, final String imageUrl, final Integer price) {
        validateLength(name);
        validatePattern(name);
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public static Product from(final ProductCreate productCreate) {
        return new Product(productCreate.name(), productCreate.imageUrl(), productCreate.price());
    }

    private void validateLength(final String name) {
        if (name.length() > 15) {
            throw new InvalidProductNameLengthException();
        }
    }

    private void validatePattern(String name) {
        if (!NAME_PATTERN.matcher(name).matches()) {
            throw new InvalidProductNamePatternException();
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getPrice() {
        return price;
    }
}
