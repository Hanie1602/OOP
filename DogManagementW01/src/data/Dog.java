
package data;

//Khuôn dùng để đúc ra các object, đối tượng cần lưu trữ imfo, thứ làm ra để bán
//Khuôn phải kín, có phễu để chế/rót/hứng/đổ vào cái data, nguyên liệu
public class Dog {
    
    //Chứa các đặc điểm, chi tiết mà cái khuôn, object tương lai sẽ có
    //Khuôn desifn ra sao, mai mốt object có thể
    private String name;
    private int yob;
    private double weight;
    
    //Có khuôn thì phải có phễu/miệng loe để hứng vật liệu đi vào
    //Phễu dùng để nhận vật liệu đúc ra, tạo ra, construct cái object
    public Dog(String iName, int iYob, double iWeight) {
        name = iName;
        yob = iYob;
        weight = iWeight;
    }
    //phễu còn gọi là constructor, hàm khởi tạo, hàm đúc, hàm tạo dựng ra object.
    //Vì thông qua nó như cái phễu, vật liệu chảy vào trong khuôn.
    //Vật liệu khô ra object/bức tượng, cmnd của ai đó, hồ sơ được tạo ra
    //CONTRUCTOR. phễu là hàm cực kì đặc biệt, vì nó dùng để tạo ra object
    //Cứ mỗi lần dùng nó, tức là phải đưa vật liệu vào, tức là có 1 object mới
    //Phễu là hàm đặc biệt, ko giá trị trở về, ko void luôn, ói về nguyên bức tượng đang đúc.
    //Tên 100% giống tên class.
    
    //Viết các hàm xử lý data, ví dụ như: giao tiếp với nhau để hỏi năm sinh --> m hỏi thì t trả lời, vì ba má đã fill yob = 2001
    //object thì gọi là hành động, behaviour, xử lý tính toán trên biến được đổ value từ lúc đúc ra
    
    //Hàm gọi n lần tương đương các hành động mà object nào đó lặp đi lặp lại
    //Hành động của obj gọi n lần trên obj đó
    public void bark() {
        //System.out.println("Gogogogo.... my name is: " + name);
        //System.out.println("Gogogogo... my yob is: " + yob);
        //System.out.println("Gogogo... my weight is: " + weight);
        //...
        System.out.printf("|%-10s|%4d|%4.1f|\n", name, yob, weight);
    }
    
    //Mình lên cân nặng, đi nhuộm tóc
    //Thay đổi info ba má đã từng cho, lúc ba má new/đúc ra mình
    public void setNewWeight(double newWeight) {
        weight = newWeight;
    }
    
    //Vì mặc định info sẽ là giấu, khi mình giao tiếp mình mới bật nó ra
    //chia sẻ info khi đc hỏi, đó chính là method hàm hành động get ()
    public int getYob() {
        return yob;
    }
}

//Code bên ngoài giống khuôn bị lủng
//Ngoài đời: bạn (yob: 2001), tui (yob: 2001)