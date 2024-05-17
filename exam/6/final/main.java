
public class main {

  private static int[] generateCode(String str, int M, int r) {
    int j = 0;
    int q = 0;
    int arr[] = new int[M + r];

    for (int i = 0; i < arr.length; i++) {
      if (Math.pow(2, q) == i + 1) {
        arr[i] = 0;
        q++;
      } else {
        arr[i] = Integer.parseInt(String.valueOf(str.charAt(j)));
        j++;
      }
    }
    return arr;
  }

  private static int[] calculateParityBits(int arr[]) {
    int q = 0;
    for (int i = 0; i < arr.length; i++) {
      if (Math.pow(2, q) == i + 1) {
        for (int j = i; j <= arr.length; j++) {
          if (((j >> q) & 1) == 1 && j != i + 1) {
            arr[i] = arr[i] ^ arr[j - 1];
          }
        }
        q++;
      }

    }
    return arr;
  }

  public static void main(String[] args) {
    String str = "11011";
    int M = str.length();
    int r = 0;

    while (Math.pow(2, r) < M + r + 1) {
      r++;
    }
    int code[];
    code = generateCode(str, M, r);
    code = calculateParityBits(code);

    for (int i = 0; i < code.length; i++) {
      System.out.print(code[i] + " ");
    }
  }
}