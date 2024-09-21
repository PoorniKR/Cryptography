import java.util.*;
class basic{
  String allChar="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  int indexOfChar(char c)
 {
  for(int i=0;i< allChar.length();i++)
  {
   if(allChar.charAt(i)==c)
    return i;
  }
  return -1;
 }
 
 char charAtIndex(int pos)
 {
  return allChar.charAt(pos);
 }
}
class Ceaser{
  basic b=new basic();

  String Encrypt(String plainText,int key)
  { 
   plainText=plainText.toUpperCase();
   String cipherText="";
   
   for(int i=0;i< plainText.length();i++)
   {
    int index=b.indexOfChar(plainText.charAt(i));
   
    if(index==-1)
    {
     cipherText+=plainText.charAt(i);
     continue;
    }
   
     cipherText+=b.charAtIndex((index+key)%26);

   }
   return cipherText;
  }
  
  String Decrypt(String cipherText,int key)
  {
   cipherText=cipherText.toUpperCase();
   String decryptedText="";
   
   for(int i=0;i< cipherText.length();i++)
   {
    int index=b.indexOfChar(cipherText.charAt(i));
   
    if(index==-1)
    {
     decryptedText+=cipherText.charAt(i);
     continue;
    }

     decryptedText+=b.charAtIndex((index-key+26)%26);
  
   }
   
   return decryptedText;
  }
  
  void bruteForce(String cipherText)
  {
   cipherText=cipherText.toUpperCase();
  
   for(int k=0;k< 26;k++)
   {
    String decryptedText="";
    int key=k;
    for(int i=0;i< cipherText.length();i++)
    {
     int index=b.indexOfChar(cipherText.charAt(i));
    
     if(index==-1)
     {
      decryptedText+=cipherText.charAt(i);
      continue;
     }
    
      decryptedText+=b.charAtIndex((index-key+26)%26);
    
    }
    
    System.out.println("Decrypted Text Using key"+key+":"+decryptedText);
   }
  }
}
class CaesarCipher{
 public static void main(String args[])throws Exception
 {
  Scanner scn=new Scanner(System.in);
  String plainText,cipherText;
  int key;
  
  System.out.println("Enter Plaintext message:");
  plainText=scn.nextLine();
  
  System.out.println("Enter key for Encryption:");
  key=scn.nextInt();
  
  
  Ceaser cipher=new Ceaser();
  cipherText=cipher.Encrypt(plainText,key);
  System.out.println("Encrypted Ciphertext is:"+cipherText);
  String decryptedText=cipher.Decrypt(cipherText,key);
  System.out.println("Decrypted Ciphertext is:"+decryptedText);
  
  System.out.println("Do you want to apply brute force on Ciphertext?press 1 otherwise press anykey");
  int choice=scn.nextInt();
  
   if(choice==1)
    cipher.bruteForce(cipherText);
 }
}  