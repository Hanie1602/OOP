package ws01;

public class WS01 {

    public static void main(String[] args) {
        boolean result = isPrime(0);
        System.out.println("0: " + result);
        System.out.println("100: " + isPrime(100));
        System.out.println("101: " + isPrime(101));
        printPrimeList();
    }
    
    //in các số nguyên tố từ 1..1000
    public static void printPrimeList(){
        System.out.println("The list of primes from 1...1000");
        for (int i = 1; i <= 1000; i++){
            if(isPrime(i))  //if (điểu gì true thì làm tiếp trong if)
                System.out.print(i + " ");
        }
    }
    
    //n có phải là các số nguyên tố không
    public static boolean isPrime(int n) {
        if (n<2)
            return false;
        
        //else rồi đấy nếu CPU đến đây, n >= 2
        //Kiểm tra xem trong khoảng từ 2 ... căn (n)
        //lỡ tay chia hết đứa nào ko, có kết luận ngay ko nguyên tố
        if (n == 2)
            return true;
        
        //for 2...căn n, n ơi, m có chia hết đứa nào từ 2.. căn?
        for(int i = 2; i <= Math.sqrt(n); i++) 
            if(n % i == 0)
                return false;   //n, m lỡ tay chia hết trong đoạn [2...căn]
        //hết for rồi mà ko thoát sớm, đích thị ko chia hết đứa nào
        //sure nguyên tố
        return true;
    }
}


/*
    OBJECT VS. CLASS
1. Object là: gom n value phức tạp
              Là 1 vật thể, thứ gì đó, thing mà có những đặc điểm, hành vi
              Là những thứ ta có thể đếm, sờ, mô tả, phân biệt được
2. Class: sự phân nhóm, tên gọi cho 1 nhòm các đối tượng theo 1 tiêu chí nào đó
              Tiêu chí: hát --> Nhóm ca sĩ - class CaSi
              Tiêu chí: đóng phim --> Nhóm DienVien
3. Có nhiều đối tượng xuất hiện, hom nhóm được rồi thành class
   -> Làm sao lưu trữ, quản lí, xử lí các đối tượng này
4. OOP: giống y chang kĩ thuật đúc tượng
        muốn làm object nào, ta tạo khuôn cho nhóm object đó/Class khuôn đúc ra cúp, Class Cup
        Khuôn CaSi lưu được info các CaSi, Template Class Singer

        từ Object tạo ra khuôn, sau này đúc trở lại các object
*/