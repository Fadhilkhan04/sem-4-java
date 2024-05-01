class HammingCode {
  // Function to print elements of array
  static void print(int ar[]) {
    for (int i = 1; i < ar.length; i++) {
      System.out.print(ar[i]);
    }
    System.out.println();
  }

  // Function to calculate value of redundant bits
  static int[] calculation(int[] ar, int r) {
    for (int i = 0; i < r; i++) {
      int x = (int) Math.pow(2, i);
      for (int j = 1; j < ar.length; j++) {
        if (((j >> i) & 1) == 1) {
          if (x != j)
            ar[x] = ar[x] ^ ar[j];
        }
      }
      System.out.println("r" + x + " = " + ar[x]);
    }
    return ar;
  }

  // Function to generate Hamming Code
  static int[] generateCode(String str, int M, int r) {
    int[] ar = new int[r + M + 1];
    int j = 0;
    for (int i = 1; i < ar.length; i++) {
      if ((Math.ceil(Math.log(i) / Math.log(2))
          - Math.floor(Math.log(i) / Math.log(2))) == 0) {
        ar[i] = 0;
      } else {
        // codeword[i] = dataword[j];
        ar[i] = (int) (str.charAt(j) - '0');
        j++;
      }
    }
    return ar;
  }

  // Driver code
  public static void main(String[] args) {
    // input message
    String str = "0101";
    int M = str.length();
    int r = 1;
    // Calculating the number of redundant bits
    while (Math.pow(2, r) < (M + r + 1)) {
      r++;
    }

    int[] ar = generateCode(str, M, r);

    // Printing the generated Hamming Code
    System.out.println("Generated Hamming Code:");
    ar = calculation(ar, r);
    print(ar);
  }
}