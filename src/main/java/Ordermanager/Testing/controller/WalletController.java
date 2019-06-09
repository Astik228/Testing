package Ordermanager.Testing.controller;

import Ordermanager.Testing.entities.Wallet;
import Ordermanager.Testing.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/wallet")
public class WalletController {
    @Autowired
    WalletService walletService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWalletById(@PathVariable Integer id) {
        try {
            this.walletService.deleteWalletById(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Wallet> saveWallet(@RequestBody Wallet wallet) {
        Wallet wallet1 = this.walletService.saveWallet(wallet);
        try {
            return new ResponseEntity<>(wallet1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable Integer id) {
        Wallet wallet = this.walletService.getWalletById(id);
        try {
            return new ResponseEntity<>(wallet, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getAll")
    public List<Wallet> getWallets() {
        return this.walletService.getAllWallets();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        try {
            this.walletService.deleteAll();
            return new ResponseEntity<>("All wallets deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>("Not deleted", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Wallet> updateProduct(@RequestBody Wallet wallet) {
        Wallet wallet1 = this.walletService.updateWallet(wallet);
        try {
            return new ResponseEntity<>(wallet1, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
