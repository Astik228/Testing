package Ordermanager.Testing.repository;

import Ordermanager.Testing.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("walletRepository")
public interface WalletRepository extends JpaRepository<Wallet,Integer> {
}