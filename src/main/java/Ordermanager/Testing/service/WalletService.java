package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Wallet;
import Ordermanager.Testing.entities.Wallet;

import java.util.List;

public interface WalletService  {
    Wallet saveWallet(Wallet wallet);

    Wallet getWalletById(Integer id);

    List<Wallet> getAllWallets();

    Wallet updateWallet(Wallet wallet);

    void deleteAll();

    void deleteWalletById(Integer id);
}
