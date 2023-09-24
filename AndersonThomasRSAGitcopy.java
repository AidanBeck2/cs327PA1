import java.util.Random;

/**
 * @author Xunhua Wang. All rights reserved.
 * @date 02/16/2012; revised on 09/27/2018; further refined on 09/20/2019, 09/29/2020, 10/07/2022, 03/13/2023
 *
 */

public class AndersonThomasRSA
{
    public int gcd (int inE, int inZ) {
        // TO BE FINISHED
        // Must implement Euclid's algorithm
        // NO brute-forcing; violation will lead to zero points
        // NO recursion; violation will lead to zero points
        while (inZ != 0){
            int hold = inZ;
            inZ = inE % inZ;
            inE = hold;
        }
        return inE;
        
    }

    public void testGcd () {
        int result1 = gcd (29, 288);
        int result2 = gcd (30, 288);
        int result3 = gcd (149, 288);
        int result4 = gcd (2, 4);

        System.out.println ("GCD (29, 288) = 0x" + Integer.toString(result1, 16));
        System.out.println ("GCD (30, 288) = 0x" + Integer.toString(result2, 16));
        System.out.println ("GCD (149, 288) = 0x" + Integer.toString(result3, 16));
        System.out.println ("GCD (2, 4) = 0x" + Integer.toString(result4, 16));
    }

    //
    // We assume that inE < inZ
    // This implementation follows our slides
    // Return:
    //	-1: no inverse
    //	inverse of inE mod inZ
    //
    public int xgcd (int inE, int inZ) {
        // TO BE FINISHED
        // Must implement the extended Euclidean algorithm
        // NO brute-forcing; violation will lead to zero points
        // NO recursion; violation will lead to zero points
        int c = 0;
        int d = 1;
        int e = 1;
        int f = 0;

        while (inE != 0) {
            int g = inZ / inE;
            int h = inZ % inE;
            int i = c - e * g;
            int j = d - f * g;

            inZ = inE;
            inE = h;
            c = e;
            d = f;
            e = i;
            f = j;
        }
        if (inZ != 1) {
            return -1; // There is no modular inverse
        } else {
            if (c < 0) {
                c += inZ; // Positive
            }
            return c; // Return inverse of inE mod inZ
        }
    }

    public void testXgcd () {
        int result1 = xgcd (29, 288);
        int result2 = xgcd (30, 288);
        int result3 = xgcd (149, 288);
        int result4 = xgcd (2, 4);

        System.out.println ("29^-1 mod 288 = 0x" + Integer.toString(result1, 16));
        System.out.println ("30^-1 mod 288 = 0x" + Integer.toString(result2, 16));
        System.out.println ("149^-1 mod 288 = 0x" + Integer.toString(result3, 16));
        System.out.println ("2^-1 mod 4 = 0x" + Integer.toString(result4, 16));
    }

    public int[] keygen (int inP, int inQ, int inE) {
        // TO BE FINISHED
          int[] resultKeygen = new int[3];
          // check if inE is valid
            // if it is not greater than 1, discard and generate random e that is
            // co-prime to z
         if (inE < 1) {
             
         }
//        keys[0] = inE;
//        keys[1] = inP * inQ;
//        int z = (inP - 1) * (inQ - 1);
//        keys[2]  = xgcd(inE, z);
//        return keys;
        return resultKeygen;
    }

    //
    // The following method will return an integer array, with [e, N, d] in this order
    //
    public void testKeygen () {
        int[] keypair = keygen (17, 19, 29);

        System.out.println ("e = 0x" + Integer.toString(keypair[0], 16));
        System.out.println ("N = 0x" + Integer.toString(keypair[1], 16));
        System.out.println ("d = 0x" + Integer.toString(keypair[2], 16));
    }

    //
    // Calculate c = a^b mod n, with the square-and-multiply algorithm
    //
    // The following method implements the square-and-multiply algorithm, with Java primitive types
    //
    // Note that even with primitive types, a^b may well exceed the range of Java int
    // For example, 5^20 is too big to be held by a Java primitive integer
    //
    public int modExp (int a, int b, int n) {
        // TO BE FINISHED
        return 0;
    }

    public int encrypt (int message, int inE, int inN) {
        // TO BE FINISHED
        return 0;
    }

    public int decrypt (int ciphertext, int inD, int inN) {
        // TO BE FINISHED
        return 0;
    }

    public void testRSA () {
        int[] keypair = keygen (17, 19, 29);

        int m1 = 130;
        int c1 = encrypt (m1, keypair[0], keypair[1]);
        System.out.println ("The encryption of (m1=0x" + Integer.toString(m1, 16) + ") is 0x" + Integer.toString(c1, 16));
        int cleartext1 = decrypt (c1, keypair[2], keypair[1]);
        System.out.println ("The decryption of (c=0x" + Integer.toString(c1, 16) + ") is 0x" + Integer.toString(cleartext1, 16));

        int m2 = 255;
        int c2 = encrypt (m2, keypair[0], keypair[1]);
        System.out.println ("The encryption of (m2=0x" + Integer.toString(m2, 16) + ") is 0x" + Integer.toString(c2, 16));
        int cleartext2 = decrypt (c2, keypair[2], keypair[1]);
        System.out.println ("The decryption of (c2=0x" + Integer.toString(c2, 16) + ") is 0x" + Integer.toString(cleartext2, 16));
    }

    public static void main (String[] args) {
        AndersonThomasRSA atrsa = new AndersonThomasRSA ();

        System.out.println ("********** Small RSA Project output begins ********** ");

        atrsa.testGcd ();
        atrsa.testXgcd ();
        //atrsa.testKeygen ();
        //atrsa.testRSA ();
    }
}