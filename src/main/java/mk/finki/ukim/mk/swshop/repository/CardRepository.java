package mk.finki.ukim.mk.swshop.repository;

import mk.finki.ukim.mk.swshop.model.domain.Card;
import mk.finki.ukim.mk.swshop.model.domain.User;
import mk.finki.ukim.mk.swshop.model.enumerations.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByUserAndStatus(User user, CardStatus status);
}

