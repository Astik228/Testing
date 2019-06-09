package Ordermanager.Testing.service;

import Ordermanager.Testing.entities.Wallet;
import Ordermanager.Testing.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class WalletServiceImpl implements WalletService {

        @Autowired
        WalletRepository walletRepository;

        @Override
        public Wallet saveWallet(Wallet wallet) {
            return walletRepository.save(wallet);
        }

        @Override
        public void deleteWalletById(Integer id) {
            walletRepository.deleteById(id);
        }

        @Override
        public Wallet getWalletById(Integer id) {
            return   walletRepository.findById(id).get();
        }
        @Override
        public List<Wallet> getAllWallets() {
            return walletRepository.findAll();
        }

        @Override
        public Wallet updateWallet(Wallet wallet) {
            return walletRepository.save(wallet);
        }
        @Override
        public void deleteAll(){
            walletRepository.deleteAll();
        }
    }

