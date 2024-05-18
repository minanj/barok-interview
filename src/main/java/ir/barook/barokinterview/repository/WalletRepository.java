package ir.barook.barokinterview.repository;

import ir.barook.barokinterview.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
    Wallet findByUserId(Integer userId);
}
