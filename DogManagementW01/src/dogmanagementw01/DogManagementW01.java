/*
    > public dấu +
    > private dấu -
    > protected dấu #
    > dafault dấu ~
*/
package dogmanagementw01;

import data.Dog;

public class DogManagementW01 {

    public static void main(String[] args) {
        //Lấy khuôn Dog ra để bắt đầu đổ info
        //y chang làm thẻ căn cước: lấy thông tin, in lên thẻ, đổ mực.
        //Sau khi chờ khô, ta đc object thuộc Nhóm vừa đúc.
        //Đặt tên gọi tắt cho object để dễ dàng nói chuyện, tham chiếu đến.
        
        Dog chiHu = new Dog("Chi Oa Oa", 2001, 3.2);                    //Môi lần dùng new tương đương với việc lấy ra nhân bản
    //  biến/tên tắt               object
    
        //Có object thì object sẽ biết làm gì đó
        chiHu.bark();
        
        Dog ngaoDa = new Dog("Ngao Ngao", 2010, 4.5);
        ngaoDa.bark();
        
        //bark(); ??? Đứa nào sủa vậy??? Ko biết
        //HÀNH ĐỘNG PHẢI GẮN VỚI OBJECT, THÔNG QUA CHẤM
        
        System.out.println("After overweight: ");
        chiHu.setNewWeight(5.5);
        chiHu.bark();
        
        int chYob = chiHu.getYob();
        System.out.println("Chi Hu Hu " + chYob);
        
        System.out.println("Ngáo ơi năm sinh: " + ngaoDa.getYob());
    }
    
}

//new: xin vùng RAM mới đủ chứa info của 1 bạn Dog sẽ đc đúc, đc đổ data.
//Có đến 2 vùng name dành cho 2 object.
//Do đó, ngaoDa ko đè name của chiHu.

//ENCAPSULATION: Tính đóng gói của thông tin và hành động
//Hàm và biến phải đi kèm với nhau, đại diện, mô tả cho 1 object, thực thể.