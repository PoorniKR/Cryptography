
# Cryptography Algorithms in Java

This repository contains implementations of various cryptography algorithms and ciphers. Each file demonstrates a different concept in cryptography.

## List of Ciphers and Algorithms

### Ciphers

1. **Caesar Cipher**
   - A simple substitution cipher where each letter in the plaintext is shifted by a fixed number of places down the alphabet.
  
2. **Hill Cipher**
   - A polygraphic substitution cipher that uses linear algebra. It encrypts groups of letters using matrix multiplication.

3. **Playfair Cipher**
   - A digraph substitution cipher that encrypts pairs of letters using a 5x5 matrix of letters.

4. **Rail Fence Cipher**
   - A transposition cipher where the plaintext is written diagonally in a zigzag pattern and then read row-by-row.

5. **Row Transposition Cipher**
    - A transposition cipher that arranges the plaintext into rows of fixed length and then reads the columns in a specified order.

6. **Substitution Cipher**
    - A basic form of encryption where each letter in the plaintext is replaced with a corresponding letter from a shifted alphabet.

7. **Vigenere Cipher**
    - A polyalphabetic cipher where each letter of the plaintext is shifted along some number of places based on a repeating keyword.
  
### Algorithms and Theorems

1. **Chinese Remainder Theorem**
   - A theorem used to solve systems of simultaneous congruences with different moduli. It's useful for operations in modular arithmetic.

2. **Euclidean Algorithm**
   - Implements the Euclidean algorithm to find the greatest common divisor (GCD) of two numbers.

3. **Extended Euclidean.java**
   - An extension of the Euclidean algorithm that finds the coefficients (Bezout coefficients) such that `ax + by = gcd(a, b)`.

4. **Euler's Theorem**
   - Euler's theorem states that for any two coprime numbers `a` and `n`, `a^(φ(n)) ≡ 1 (mod n)`, where φ is Euler's totient function.

5. **Fermat's Theorem**
   - Fermat's Little Theorem states that if `p` is a prime number, then for any integer `a`, `a^(p-1) ≡ 1 (mod p)`. It is used in primality testing and cryptographic algorithms.



## Usage

1. **Compiling the Java Files:**
   ```bash
   javac CaesarCipher.java
   ```

2. **Running a Specific File:**
   ```bash
   java CaesarCipher
   ```

3. Modify the `main` method of each file to input your own text and parameters for encryption/decryption.

## Applications

- These algorithms are fundamental concepts in cryptography and are used for secure communication.
- They are not suitable for real-world applications due to vulnerabilities but serve as educational tools to understand cryptographic principles.

