package shopping.wishlist.infra;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shopping.member.domain.Member;
import shopping.wishlist.domain.WishProduct;

public interface WishProductJpaRepository extends JpaRepository<WishProduct, Long> {
    @Query("select w from WishProduct w join fetch w.product where w.member = :member")
    List<WishProduct> findAllByMemberWithProduct(@Param("member") Member member);
}
